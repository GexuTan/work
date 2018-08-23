package others;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.*;
import javax.swing.*;



public class TabComponentsDemo extends JFrame{
		public JTabbedPane tabbedPane;  
	    private JLabel label1,label2,label3;  
	    private JPanel panel1,panel2,panel3;  
	  
	    public TabComponentsDemo()  
	    {  
	        super("选项卡窗口"); setSize(400,300);  
	  
	        Container c = getContentPane();  
	        tabbedPane=new JTabbedPane();   //创建选项卡面板对象  
	        //创建标签  
	        label1=new JLabel("第一个标签的面板",SwingConstants.CENTER);  
	        label2=new JLabel("第二个标签的面板",SwingConstants.CENTER);  
	        label3=new JLabel("第三个标签的面板",SwingConstants.CENTER);  
	        //创建面板  
	        panel1=new JPanel();  
	        panel2=new JPanel();  
	        panel3=new JPanel();  
	  
	        panel1.add(label1);  
	        panel2.add(label2);  
	        panel3.add(label3);  
	  
	        panel1.setBackground(Color.yellow);  
	        panel2.setBackground(Color.blue);  
	        panel3.setBackground(Color.green);  
	        //将标签面板加入到选项卡面板对象上  
	        tabbedPane.addTab("标签1",null,panel1,"First panel");  
	        tabbedPane.addTab("标签2",null,panel2,"Second panel");  
	        tabbedPane.addTab("标签3",null,panel3,"Third panel");  
	  
	        c.add(tabbedPane);  
	        c.setBackground(Color.white);  
	  
	        setVisible(true);  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    }  
	      
	    public static void main(String args[])  
	    {  
	    	TabComponentsDemo d = new TabComponentsDemo();  
	    }  
	/*

	private JTabbedPane jTabbedpane = new JTabbedPane();// 存放选项卡的组件
	private String[] tabNames = { "选项1", "选项2" };
	ImageIcon icon = createImageIcon("images/middle.gif");

	public TabComponentsDemo() {
		layoutComponents();
		incident();
	}

	private void layoutComponents() {
		int i = 0;
		// 第一个标签下的JPanel
		JPanel jpanelFirst = new JPanel();
		// jTabbedpane.addTab(tabNames[i++],icon,creatComponent(),"first");//加入第一个页面
		jTabbedpane.addTab(tabNames[i++], icon, jpanelFirst, "first");// 加入第一个页面
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_F);// 设置第一个位置的快捷键为f

		// 第二个标签下的JPanel
		JPanel jpanelSecond = new JPanel();
		jTabbedpane.addTab(tabNames[i++], icon, jpanelSecond, "second");// 加入第一个页面
		jTabbedpane.setMnemonicAt(1, KeyEvent.VK_S);// 设置快捷键为s

		//setLayout(new GridLayout(1, 1));
		//add(jTabbedpane);

	}



	private ImageIcon createImageIcon(String path) {

		URL url = TabComponentsDemo.class.getResource(path);
		if (url == null) {
			System.out.println("the image " + path + " is not exist!");

			return null;

		}
		return new ImageIcon(url);
	}

	private void incident() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);// 将组建外观设置为Java外观
				JFrame frame = new JFrame();
				frame.setLayout(null);
				//frame.setContentPane(new TabComponentsDemo());
				frame.setSize(400, 600);
				frame.setVisible(true);
				// new TabComponentsDemo().runTest();

			}

		});

	}*/

}
