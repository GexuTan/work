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
	        super("ѡ�����"); setSize(400,300);  
	  
	        Container c = getContentPane();  
	        tabbedPane=new JTabbedPane();   //����ѡ�������  
	        //������ǩ  
	        label1=new JLabel("��һ����ǩ�����",SwingConstants.CENTER);  
	        label2=new JLabel("�ڶ�����ǩ�����",SwingConstants.CENTER);  
	        label3=new JLabel("��������ǩ�����",SwingConstants.CENTER);  
	        //�������  
	        panel1=new JPanel();  
	        panel2=new JPanel();  
	        panel3=new JPanel();  
	  
	        panel1.add(label1);  
	        panel2.add(label2);  
	        panel3.add(label3);  
	  
	        panel1.setBackground(Color.yellow);  
	        panel2.setBackground(Color.blue);  
	        panel3.setBackground(Color.green);  
	        //����ǩ�����뵽ѡ���������  
	        tabbedPane.addTab("��ǩ1",null,panel1,"First panel");  
	        tabbedPane.addTab("��ǩ2",null,panel2,"Second panel");  
	        tabbedPane.addTab("��ǩ3",null,panel3,"Third panel");  
	  
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

	private JTabbedPane jTabbedpane = new JTabbedPane();// ���ѡ������
	private String[] tabNames = { "ѡ��1", "ѡ��2" };
	ImageIcon icon = createImageIcon("images/middle.gif");

	public TabComponentsDemo() {
		layoutComponents();
		incident();
	}

	private void layoutComponents() {
		int i = 0;
		// ��һ����ǩ�µ�JPanel
		JPanel jpanelFirst = new JPanel();
		// jTabbedpane.addTab(tabNames[i++],icon,creatComponent(),"first");//�����һ��ҳ��
		jTabbedpane.addTab(tabNames[i++], icon, jpanelFirst, "first");// �����һ��ҳ��
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_F);// ���õ�һ��λ�õĿ�ݼ�Ϊf

		// �ڶ�����ǩ�µ�JPanel
		JPanel jpanelSecond = new JPanel();
		jTabbedpane.addTab(tabNames[i++], icon, jpanelSecond, "second");// �����һ��ҳ��
		jTabbedpane.setMnemonicAt(1, KeyEvent.VK_S);// ���ÿ�ݼ�Ϊs

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
				JFrame.setDefaultLookAndFeelDecorated(true);// ���齨�������ΪJava���
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
