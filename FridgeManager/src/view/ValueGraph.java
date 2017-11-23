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
		return ChartFactory.createLineChart("Temp�rature du frigidaire par rapport au temps", "Temps (s)", "Temp�rature (�C)", new DefaultCategoryDataset(), PlotOrientation.VERTICAL, true,true,false);
	}
	
	static JFreeChart get_fridge_humidity_chart()
	{
		return ChartFactory.createLineChart("Humidit� du frigidaire par rapport au temps", "Temps (s)", "Humiidit� (%)", new DefaultCategoryDataset(), PlotOrientation.VERTICAL, true,true,false);
	}
}
