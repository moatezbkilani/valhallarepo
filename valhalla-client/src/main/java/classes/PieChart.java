package classes;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * A simple demonstration application showing how to create a pie chart using
 * data from a {@link DefaultPieDataset}.
 */
public class PieChart extends ApplicationFrame {
	private static String title;
	/**
	 * Default constructor.
	 *
	 * @param title
	 *            the frame title.
	 */
	public PieChart(String title, List<Results> results) {
		super(title);
		this.title=title;
		setContentPane(createDemoPanel(results));
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

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return A chart.
	 */
	private static JFreeChart createChart(PieDataset dataset) {

		JFreeChart chart = ChartFactory.createPieChart(title, // chart
																			// title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);
		return chart;

	}

	/**
	 * Creates a panel for the demo (used by SuperDemo.java).
	 * 
	 * @return A panel.
	 */
	public JPanel createDemoPanel(List<Results> results) {
		JFreeChart chart = createChart(createDataset(results));
		return new ChartPanel(chart);
	}

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *            ignored.
	 */

}
