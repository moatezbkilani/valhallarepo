package classes;

import java.text.DecimalFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.Rotation;

public class PieChart3D extends ApplicationFrame {

	private static String title;
	
	public static JFreeChart pie3d;

	/**
	 * Creates a new demo.
	 *
	 * @param title
	 *            the frame title.
	 */
	
	public PieChart3D(final String title, List<Results> results) {

		super(title);
		this.title = title;
		// create a dataset...
		final PieDataset dataset = createDataset(results);

		// create the chart...
		final JFreeChart chart = createChart(dataset);

		// add the chart to a panel...
		final ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		//setContentPane(chartPanel);
		PieChart3D.pie3d = chart;

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return A sample dataset.
	 */
	private static PieDataset createDataset(List<Results> results) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		DecimalFormat df = new DecimalFormat("########.0");
		for (Results result : results) {
			dataset.setValue(result.getStat1() + "=" + df.format((result.getStat2() * 100)) + "%", result.getStat2());
		}
		return dataset;
	}

	private JFreeChart createChart(final PieDataset dataset) {

		final JFreeChart chart = ChartFactory.createPieChart3D(title, // chart
																		// title
				dataset, // data
				true, // include legend
				true, false);

		final PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setNoDataMessage("No data to display");
		return chart;

	}
	
	public JFreeChart commentsChart(final String title, List<Results> results) {

		this.title = title;
		// create a dataset...
		final PieDataset dataset = createDataset(results);

		// create the chart...
		final JFreeChart chart = createChart(dataset);

		// add the chart to a panel...
		final ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		//setContentPane(chartPanel);
		return chart;

	}
	
	public JFreeChart subjectsChart(final String title, List<Results> results) {

		this.title = title;
		// create a dataset...
		final PieDataset dataset = createDataset(results);

		// create the chart...
		final JFreeChart chart = createChart(dataset);

		// add the chart to a panel...
		final ChartPanel chartPanel = new ChartPanel(chart);
		//chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		//setContentPane(chartPanel);
		return chart;

	}
}
