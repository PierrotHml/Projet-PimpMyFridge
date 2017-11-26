package view.components;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ValueGraph extends ChartPanel
{
	private static final long serialVersionUID = 1L;

	protected JFreeChart chart = null;
	
	private int values_number = 0;
	
	private static DefaultCategoryDataset fridge_temperature_dataset = new DefaultCategoryDataset();
	private static DefaultCategoryDataset fridge_humidity_dataset = new DefaultCategoryDataset();
	
	public ValueGraph(JFreeChart chart)
	{
		super(chart);
		this.chart = chart;

		CategoryPlot plot = (CategoryPlot) chart.getPlot();  
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();   
		
		plot.getRenderer().setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(0, Color.red);
		plot.setRenderer(0, renderer);		
		
		setFontColor(Color.white);
		
		this.chart.removeLegend();
		plot.setBackgroundPaint(new Color(104, 135, 140));
		this.chart.setBackgroundPaint(new Color(30, 30, 30));
		chart.getTitle().setPaint(Color.WHITE);
		chart.getTitle().setFont(new Font("Arial", 0, 20));
	}
	
	public void add_value(double value, int time)
	{
		time /= 1000;
		
		values_number += time;
		
		if (chart.getTitle().getText() == "Température du frigidaire par rapport au temps")
		{
			fridge_temperature_dataset.addValue(value, "Température", Integer.toString((int) time));
			
			if (values_number > 60)
			{
				fridge_temperature_dataset.removeValue("Température", Integer.toString((int) time - 60));
			}
		}
		else
		{
			fridge_humidity_dataset.addValue(value, "Humidité", Integer.toString((int) time));
			
			if (values_number > 60)
			{
				fridge_humidity_dataset.removeValue("Humidité", Integer.toString((int) time - 60));
			}
		}
	}
	
	public static JFreeChart get_fridge_temperature_chart()
	{
		JFreeChart chart = ChartFactory.createLineChart("Température du frigidaire par rapport au temps", "Temps (s)", "Température (°C)", fridge_temperature_dataset, PlotOrientation.VERTICAL, true,true,false);
	
		return chart;
	}
	
	public static JFreeChart get_fridge_humidity_chart()
	{
		JFreeChart chart = ChartFactory.createLineChart("Humidité du frigidaire par rapport au temps", "Temps (s)", "Humidité (%)", fridge_humidity_dataset, PlotOrientation.VERTICAL, true,true,false);
	
		return chart;
	}
	
	
	
	private void setFontColor(Color fontColor) {
	    JFreeChart chart = getChart();
	    chart.getTitle().setPaint(fontColor);
	    Plot plot = chart.getPlot();
	    if (plot instanceof CategoryPlot) {
	        setAxisFontColor(((CategoryPlot) plot).getDomainAxis(), fontColor);
	        setAxisFontColor(((CategoryPlot) plot).getRangeAxis(), fontColor);
	    } else if (plot instanceof XYPlot) {
	        setAxisFontColor(((XYPlot) plot).getDomainAxis(), fontColor);
	        setAxisFontColor(((XYPlot) plot).getRangeAxis(), fontColor);
	    }
	}

	private void setAxisFontColor(Axis axis, Color fontColor) {
	    if (!fontColor.equals(axis.getLabelPaint()))
	        axis.setLabelPaint(fontColor);
	    if (!fontColor.equals(axis.getTickLabelPaint()))
	        axis.setTickLabelPaint(fontColor);
	}
}
