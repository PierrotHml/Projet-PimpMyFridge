package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
	}
	
	public void add_value(double value, int time)
	{
		time /= 1000;
		
		values_number += time;
		
		if (chart.getTitle().getText() == "Temp�rature du frigidaire par rapport au temps")
		{
			fridge_temperature_dataset.addValue(value, "Temp�rature", Integer.toString((int) time));
			
			if (values_number > 30)
			{
				fridge_temperature_dataset.removeValue("Temp�rature", Integer.toString((int) time - 30));
			}
		}
		else
		{
			fridge_humidity_dataset.addValue(value, "Humidit�", Integer.toString((int) time));
			
			if (values_number > 30)
			{
				fridge_humidity_dataset.removeValue("Humidit�", Integer.toString((int) time - 30));
			}
		}
	}
	
	static JFreeChart get_fridge_temperature_chart()
	{
		return ChartFactory.createLineChart("Temp�rature du frigidaire par rapport au temps", "Temps (s)", "Temp�rature (�C)", fridge_temperature_dataset, PlotOrientation.VERTICAL, true,true,false);
	}
	
	static JFreeChart get_fridge_humidity_chart()
	{
		return ChartFactory.createLineChart("Humidit� du frigidaire par rapport au temps", "Temps (s)", "Humidit� (%)", fridge_humidity_dataset, PlotOrientation.VERTICAL, true,true,false);
	}
}
