package view;

import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ValueGraph extends ChartPanel
{
	private static final long serialVersionUID = 1L;

	protected JFreeChart chart = null;
	
	Map<Integer, Double> values = new HashMap<Integer, Double>();
	
	private static DefaultCategoryDataset fridge_temperature_dataset = new DefaultCategoryDataset();
	private static DefaultCategoryDataset fridge_humidity_dataset = new DefaultCategoryDataset();
	
	public ValueGraph(JFreeChart chart) {
		super(chart);
		
		this.chart = chart;
	}
	
	public void add_value(double value, int time)
	{
		values.put(time, value);
		
		if (chart.getTitle().getText() == "Temp�rature du frigidaire par rapport au temps")
		{
			fridge_temperature_dataset.addValue(value, "Temp�rature (�C)", Integer.toString((int) time / 1000));
		}
		else
		{
			fridge_humidity_dataset.addValue(value, "Humidit� (%)", Integer.toString((int) time / 1000));
		}
	}
	
	static JFreeChart get_fridge_temperature_chart()
	{
		return ChartFactory.createLineChart("Temp�rature du frigidaire par rapport au temps", "Temps", "Temp�rature", fridge_temperature_dataset, PlotOrientation.VERTICAL, true,true,false);
	}
	
	static JFreeChart get_fridge_humidity_chart()
	{
		return ChartFactory.createLineChart("Humidit� du frigidaire par rapport au temps", "Temps", "Humidit�", fridge_humidity_dataset, PlotOrientation.VERTICAL, true,true,false);
	}
}
