package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ValueGraph extends ChartPanel
{
	protected JFreeChart chart = null;
	
	public ValueGraph(JFreeChart chart) {
		super(chart);
		
		this.chart = chart;
	}
	
	public void add_value(double value)
	{
		
	}
	
	static JFreeChart get_fridge_temperature_chart()
	{
		return ChartFactory.createLineChart("Température du frigidaire par rapport au temps", "Temps (s)", "Température (°C)", new DefaultCategoryDataset(), PlotOrientation.VERTICAL, true,true,false);
	}
	
	static JFreeChart get_fridge_humidity_chart()
	{
		return ChartFactory.createLineChart("Humidité du frigidaire par rapport au temps", "Temps (s)", "Humiidité (%)", new DefaultCategoryDataset(), PlotOrientation.VERTICAL, true,true,false);
	}
}
