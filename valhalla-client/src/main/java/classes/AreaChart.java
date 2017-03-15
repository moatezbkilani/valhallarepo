package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;

/**
 * A simple demonstration application showing how to create an area chart using
 * data from a {@link CategoryDataset}.
 */
public class AreaChart extends ApplicationFrame {

	private String title;
	
	public static JFreeChart areaChart;

	/**
	 * Creates a new demo application.
	 *
	 * @param title
	 *            the frame title.
	 */
	public AreaChart(final String title, List<Long> stat) {

		super(title);
		this.title=title;
		final double[][] data = new double[3][12];
		int i = 0;
		int j = 0;
		// create a dataset...
		for (Long res : stat) {
			if (j < 3) {
				data[j][i] = res.doubleValue();
				i++;
				if (i == 12) {

					j++;
					i = 0;
				}
			}
		}
		String[] months = new String[12];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat f = new SimpleDateFormat("MMMM");
		Date date = new Date();
		int b = (date.getYear() - 3) + 1900;
		int b1 = (date.getYear() - 2) + 1900;
		int b2 = (date.getYear() - 1) + 1900;
		String a = b + "-" + b1;
		String a1 = b1 + "-" + b2;
		String a2 = b2 + "-" + date.getYear();
		System.out.println(a + "   " + a1 + "   " + a2);
		Date date2 =new Date();
		for (int e = 0; e <= 11; e++) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);
			cal.add(Calendar.MONTH, -12);
			Date datef = new Date();
			cal.add(Calendar.MONTH, (e));
			datef = cal.getTime();
			months[e] = f.format(datef);
			// System.out.println(listeretour.get(i));
		}

		String[] year = new String[] { a, a1, a2 };

		final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(year, months, data);

		// create the chart...
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		chartPanel.setEnforceFileExtensions(false);

		//setContentPane(chartPanel);
		areaChart = chart;

	}

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is available
	// *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createAreaChart(title, // chart
																			// title
				"Last Three years", // domain axis label
				"Number of comments", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
		);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

		// set the background color for the chart...
		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		// legend.setAnchor(StandardLegend.SOUTH);

		chart.setBackgroundPaint(Color.white);
		final TextTitle subtitle = new TextTitle("Number of comments per month for the last three years");
		subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
		subtitle.setPosition(RectangleEdge.TOP);
		// subtitle.setSpacer(new Spacer(Spacer.RELATIVE, 0.05, 0.05, 0.05,
		// 0.05));
		subtitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
		chart.addSubtitle(subtitle);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha(0.5f);

		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		domainAxis.setLowerMargin(0.0);
		domainAxis.setUpperMargin(0.0);
		domainAxis.addCategoryLabelToolTip("Type 1", "The first type.");
		domainAxis.addCategoryLabelToolTip("Type 2", "The second type.");
		domainAxis.addCategoryLabelToolTip("Type 3", "The third type.");

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setLabelAngle(0 * Math.PI / 2.0);
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

	}
}
