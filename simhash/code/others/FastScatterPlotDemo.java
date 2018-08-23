package others;

/*
 * 绘图程序，没有用处
 * */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class FastScatterPlotDemo extends ApplicationFrame {

    /** A constant for the number of items in the sample dataset. */
    private static final int COUNT = 500000;

    /** The data. */
    private float[][] data = new float[2][COUNT];

   
    public FastScatterPlotDemo(final String title) {

        super(title);
        populateData();
        final NumberAxis domainAxis = new NumberAxis("X=属性条数");
        domainAxis.setAutoRangeIncludesZero(false);
        final NumberAxis rangeAxis = new NumberAxis("Y＝相似度");
        rangeAxis.setAutoRangeIncludesZero(false);
        final FastScatterPlot plot = new FastScatterPlot(this.data, domainAxis, rangeAxis);
        final JFreeChart chart = new JFreeChart("不同属性集对应的相似度", plot);
        /*
        chart.getRenderingHints().put
            (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
*/

        final ChartPanel panel = new ChartPanel(chart, true);
        panel.setPreferredSize(new java.awt.Dimension(600, 470));
 
        panel.setMinimumDrawHeight(10);
        panel.setMaximumDrawHeight(2000);
        panel.setMinimumDrawWidth(20);
        panel.setMaximumDrawWidth(2000);
        
        setContentPane(panel);

    }

    /**
     * Populates the data array with random values.
     * 导入数据，从文件中直接导入
     */
    private void populateData() {
    	try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resultsDots.txt"), "UTF-8"));
    		int len = 0;
    		String ins[] = new String[10000];
    		String s3 = "";
    		// 在读到末尾之前
    		while ((s3 = br.readLine()) != null) {
    			if (((s3 != "\r") && ((s3) != "\n") && ((s3) != "\t"))) {
    				String n = s3;
    				ins[len] = n;
    				System.out.println("读取第" + len + "个对应值 " + ins[len]);	
    				len++;
    			}
    		}
    		br.close();
    		len=(len+1)/2;
    		for (int i = 0; i <len; i++) {
                data[0][i] = Float.parseFloat(ins[2*i]);
                System.out.println("读取" + i + "个对应值 " + data[0][i]);	
                data[1][i] = Float.parseFloat(ins[2*i+1]);
                System.out.println("读取" + i + "个对应值 " + data[1][i]);	
            }
    		
    		
    		for(int i=0;i<len;i++){
    			System.out.println(data[0][i]+"对应"+data[1][i]);	
    		}
    		
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
		System.out.println("结束了");

    }

    public static void main(final String[] args) {

        final FastScatterPlotDemo demo = new FastScatterPlotDemo("Fast Scatter Plot Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);    	
    }

}
