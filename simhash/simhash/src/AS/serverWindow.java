package AS;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JFrame.*;



public class serverWindow extends JFrame {


	JMenuBar mb1 = new JMenuBar();
	JMenu f = new JMenu("参数设置");
	JMenu m = new JMenu("帮助");
	JMenu e = new JMenu("退出");
	JMenuItem[] file;
	private JMenuBar menuBar;
	private final JMenuItem mntmNewMenuItem = new JMenuItem(
			"\u6570\u636E\u5E93\u8BBE\u7F6E");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem(
			"\u5171\u4EAB\u9608\u503C");
	private final JMenuItem menuItem = new JMenuItem("\u5BC6\u6587\u957F\u5EA6");
	private final JMenuItem menuItem_1 = new JMenuItem(
			"\u4F2A\u6570\u636E\u4E2A\u6570");
	private final JSeparator separator = new JSeparator();
	private final JTextPane textArea = new JTextPane();
	//菜单栏
	

	public JTabbedPane tabbedPane;
	private JLabel label1, label2,label3,label4,label5;
	private JPanel panel1, panel2, panel3,panel4,panel5;
	private JTextField txtLocalhost;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JButton button_3;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel label_6;
	private JButton button_5;
	private JLabel label_7;
	private JButton button_6;
	
	
	
	private JTextField textField;
	private JLabel lblip_1;
	
	JTextArea textArea_1;
	private JButton button_7;
	//选项卡
	
	
	
	
	public Server se;
	private JTextField txtR;
	private JTextField textField_6;
	private JLabel label_5;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField textField_7;
	private JLabel label_12;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_5;
	
	
	//选项卡1
	
	
	//选项卡2
	//选项卡3
	//选项卡4
	//选项卡5
	

	public serverWindow() throws IOException {

		setTitle("服务端");

		mb1 = new JMenuBar();

		mb1.add(f);

		f.add(mntmNewMenuItem);
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String accountnum1=JOptionPane.showInputDialog(null,"输入阈值","Now Loan",JOptionPane.PLAIN_MESSAGE);
				textField_5.setText(accountnum1);
			}
		});

		f.add(mntmNewMenuItem_1);

		f.add(separator);
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String accountnum1=JOptionPane.showInputDialog(null,"修改密文长度","Now Loan",JOptionPane.PLAIN_MESSAGE);
				textField.setText(accountnum1);
			}
		});

		f.add(menuItem);
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String accountnum1=JOptionPane.showInputDialog(null,"输入伪数据个数","Now Loan",JOptionPane.PLAIN_MESSAGE);
				textField_3.setText(accountnum1);
			}
		});

		f.add(menuItem_1);
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help h = new Help();
			}
		});
		mb1.add(m);
		e.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		mb1.add(e);

		setVisible(true);
		setSize(500, 600);
		setJMenuBar(mb1);
		getContentPane().setLayout(new BorderLayout(0, 0));
		//菜单栏
		
		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // 创建选项卡面板对象
		// 创建标签
		label1 = new JLabel("第一个标签的面板", SwingConstants.CENTER);
		label2 = new JLabel("第er个标签的面板", SwingConstants.CENTER);
		label3 = new JLabel("第er个标签的面板", SwingConstants.CENTER);
		label4 = new JLabel("第三个标签的面板", SwingConstants.CENTER);
		label5 = new JLabel("第三个标签的面板", SwingConstants.CENTER);
		
		// 创建面板
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();

		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(label4);
		panel5.add(label5);

		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.orange);
		panel3.setBackground(Color.green);
		panel4.setBackground(Color.white);
		panel5.setBackground(Color.lightGray);
		panel1.setLayout(null);
		panel2.setLayout(null);
		panel4.setLayout(null);
		panel5.setLayout(null);
		

		
		// 将标签面板加入到选项卡面板对象上
		tabbedPane.addTab("步骤1", null, panel1, "First panel");
		
		JLabel lblNewLabel = new JLabel("\u60A8\u73B0\u5728\u6CA1\u6709\u5171\u4EAB\u7533\u8BF7\u4FE1\u606F\uFF0C\u8BF7\u586B\u5165\u60F3\u8981\u7533\u8BF7\u7684\u7528\u6237\u4FE1\u606F");
		lblNewLabel.setBounds(20, 20, 323, 30);
		panel1.add(lblNewLabel);
		
		JLabel lblip = new JLabel("\u5BF9\u65B9IP\uFF1A");
		lblip.setBounds(47, 84, 61, 16);
		panel1.add(lblip);
		
		JLabel label = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label.setBounds(47, 134, 61, 16);
		panel1.add(label);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("120.27.107.119\uFF1A6789");
		txtLocalhost.setBounds(93, 78, 191, 28);
		panel1.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("6789");
		textField_1.setBounds(93, 128, 134, 28);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u8BF7\u6C42\u5BF9\u65B9\u8BC1\u4E66\uFF0C\u7533\u8BF7\u5171\u4EAB");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		
		
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "已接受申请", "请继续下一步", JOptionPane.INFORMATION_MESSAGE); 
				/*try {
					String s=txtLocalhost.getText();
					int nu=Integer.parseInt(textField_1.getText());
					se=new Server(s,nu);
					//se.addressPath=txtLocalhost.getText();
					//se.portNumber=Integer.parseInt(textField_1.getText());
					//System.out.println(se.addressPath+":"+se.portNumber); 
					boolean i=se.acceptS(se.portNumber);
					System.out.println("发送申请"); 
					if(i){
						JOptionPane.showMessageDialog(null, "已接受申请", "请继续下一步", JOptionPane.INFORMATION_MESSAGE); 
						//JOptionPane.showInternalMessageDialog(panel1, "information","申请已发送", JOptionPane.INFORMATION_MESSAGE); 
					}
					else{
						JOptionPane.showMessageDialog(null, "申请失败", "请检查", JOptionPane.INFORMATION_MESSAGE); 
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				
			}
		});
		button_1.setBounds(34, 181, 250, 29);
		panel1.add(button_1);
		
		
		
		
		
		
		
		tabbedPane.addTab("步骤2", null, panel2, "Second panel");
		
		label_1 = new JLabel("\u7B2C\u4E8C\u6B65\uFF1A\u5C06\u9700\u8981\u5171\u4EAB\u7684\u6570\u636E\u8FDB\u884C\u52A0\u5BC6");
		panel2.add(label_1);
		
		label_2 = new JLabel("\u7B2C\u4E8C\u6B65\uFF1A\u8FDE\u63A5\u4E91\u6570\u636E\u5E93");
		label_2.setBounds(20, 20, 421, 30);
		panel2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setText("120.27.107.220");
		textField_2.setBounds(174, 62, 134, 28);
		panel2.add(textField_2);
		textField_2.setColumns(10);
		
		button_3 = new JButton("\u8FDE\u63A5\u4E91\u6570\u636E\u5E93");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int nu=Integer.parseInt(textField.getText());
				
				
				String s=textField_2.getText();
				
				System.out.println(s);
				
				CreateCipher ci=new CreateCipher(s,nu);
				
				System.out.println(s);
				boolean b=ci.createClient(s,nu);
				
				if(b){
					JOptionPane.showMessageDialog(null, "请继续下一步", "加密成功", JOptionPane.INFORMATION_MESSAGE); 
				}
				else{
					JOptionPane.showMessageDialog(null, "加密失败", "请检查", JOptionPane.INFORMATION_MESSAGE); 
				}
			}
		});
		button_3.setBounds(45, 241, 117, 29);
		panel2.add(button_3);
		
		textField = new JTextField();
		textField.setText("3306");
		textField.setColumns(10);
		textField.setBounds(174, 102, 134, 28);
		panel2.add(textField);
		
		lblip_1 = new JLabel("\u4E91\u6570\u636E\u5E93IP\u5730\u5740\uFF1A");
		lblip_1.setBounds(45, 68, 117, 16);
		panel2.add(lblip_1);
		
		txtR = new JTextField();
		txtR.setText("A");
		txtR.setColumns(10);
		txtR.setBounds(174, 142, 134, 28);
		panel2.add(txtR);
		
		textField_6 = new JTextField();
		textField_6.setText("\uFF0A\uFF0A\uFF0A\uFF0A\uFF0A\uFF0A");
		textField_6.setColumns(10);
		textField_6.setBounds(174, 182, 134, 28);
		panel2.add(textField_6);
		
		label_5 = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label_5.setBounds(45, 108, 88, 16);
		panel2.add(label_5);
		
		label_9 = new JLabel("\u7528\u6237\u540D");
		label_9.setBounds(45, 148, 88, 16);
		panel2.add(label_9);
		
		label_10 = new JLabel("\u5BC6\u7801");
		label_10.setBounds(45, 188, 88, 16);
		panel2.add(label_10);
		
		
		
		panel3.add(label3);
		
		panel3.setLayout(null);
		tabbedPane.addTab("步骤3", null, panel3, "Third panel");
		
		label_3 = new JLabel("\u7B2C\u4E09\u6B65\uFF1A\u9009\u62E9\u8981\u5171\u4EAB\u7684\u6570\u636E\u5E93\u4FE1\u606F\uFF0C\u6BCF\u6B21\u53EF\u4EE5\u6DFB\u52A0\u4E00\u5F20\u8868\u4FE1\u606F");
		label_3.setBounds(20, 20, 359, 30);
		panel3.add(label_3);
		
		label_4 = new JLabel("\u6570\u636E\u8868\u540D\uFF1A");
		label_4.setBounds(80, 98, 72, 16);
		panel3.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setText("\u5458\u5DE5\u4E2A\u4EBA\u4FE1\u606F");
		textField_3.setBounds(202, 92, 134, 28);
		panel3.add(textField_3);
		textField_3.setColumns(10);
		
		button_7 = new JButton("\u4E0B\u4E00\u6B65");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int falseNumber=Integer.parseInt(textField_3.getText());//个数
				int falseLength=Integer.parseInt(textField.getText());//长度
				AddFalseHash ad=new AddFalseHash(falseNumber,falseLength);
				boolean b=ad.serverAddValue();
				if(b){
					JOptionPane.showMessageDialog(null, "请继续下一步", "密文添加成功", JOptionPane.INFORMATION_MESSAGE); 
				}
				else{
					JOptionPane.showMessageDialog(null, "密文添加失败", "请检查", JOptionPane.INFORMATION_MESSAGE); 
				}
				
			}
		});
		button_7.setBounds(224, 256, 117, 29);
		panel3.add(button_7);
		
		label_11 = new JLabel("\u6BCF\u6B21\u53EF\u4EE5\u6DFB\u52A0\u4E00\u5F20\u8868\uFF0C\u5982\u9700\u6DFB\u52A0\u591A\u5F20\u8868\uFF0C\u8BF7\u70B9\u51FB\u7EE7\u7EED\u6DFB\u52A0");
		label_11.setBounds(70, 45, 344, 30);
		panel3.add(label_11);
		
		textField_7 = new JTextField();
		textField_7.setText("\u59D3\u540D\uFF0C\u7535\u8BDD\u53F7\u7801\uFF0C\u521D\u59CB\u6708\u85AA");
		textField_7.setColumns(10);
		textField_7.setBounds(70, 166, 276, 49);
		panel3.add(textField_7);
		
		label_12 = new JLabel("\u60F3\u8981\u5171\u4EAB\u7684\u5C5E\u6027\u540D\uFF1A");
		label_12.setBounds(80, 138, 117, 16);
		panel3.add(label_12);
		
		JButton button = new JButton("\u7EE7\u7EED\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(80, 256, 117, 29);
		panel3.add(button);
		
		
		
		
		
		
		
		
		
		
		tabbedPane.addTab("步骤4", null, panel4, "Third panel");
		
		label_6 = new JLabel("\u7B2C\u56DB\u6B65\uFF1A\u8BF7\u6DFB\u52A0\u4FE1\u606F");
		label_6.setBounds(20, 20, 200, 30);
		panel4.add(label_6);
		
		button_5 = new JButton("\u4E0B\u4E00\u6B65");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				try {
					boolean i=se.receiveFile();
					System.out.println("接收密文"); 
					if(i){
						JOptionPane.showMessageDialog(null, "请继续下一步", "密文接收成功", JOptionPane.INFORMATION_MESSAGE); 
					}
					else{
						JOptionPane.showMessageDialog(null, "密文接收失败", "请检查", JOptionPane.INFORMATION_MESSAGE); 
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
				
			
		});
		button_5.setBounds(201, 227, 117, 29);
		panel4.add(button_5);
		
		JLabel label_13 = new JLabel("\u4E91\u6570\u636E\u5E93\u5BC6\u6587\u79C1\u94A5\uFF1A");
		label_13.setBounds(49, 134, 117, 30);
		panel4.add(label_13);
		
		textField_8 = new JTextField();
		textField_8.setBounds(173, 122, 173, 79);
		panel4.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_14 = new JLabel("\u5C5E\u6027\u540D\u5171\u4EAB\u9608\u503C\uFF1A");
		label_14.setBounds(49, 79, 112, 30);
		panel4.add(label_14);
		
		textField_9 = new JTextField();
		textField_9.setText("0.75");
		textField_9.setColumns(10);
		textField_9.setBounds(173, 80, 173, 28);
		panel4.add(textField_9);
		tabbedPane.addTab("步骤5", null, panel5, "Third panel");
		
		label_7 = new JLabel("\u606D\u559C\u4F60\uFF0C\u83B7\u5F97\u7684\u5171\u4EAB\u7ED3\u679C\u5982\u4E0B");
		label_7.setBounds(20, 20, 200, 30);
		panel5.add(label_7);
		
		button_6 = new JButton("\u83B7\u5F97\u7ED3\u679C");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int nu=Integer.parseInt(textField.getText());
				double th=Double.parseDouble(textField_5.getText());
				showResult sh=new showResult(th,nu,"clientAH.txt");
				int count=sh.commomSH();
				String AH[]=new String[count*2];
				AH=sh.showS();
				textArea_1.setText("共有"+count+"个参数符合条件，分别如下：\r\n"+AH.toString());
				
			}
		});
		button_6.setBounds(47, 183, 117, 29);
		panel5.add(button_6);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("\u5171\u67094\u4E2A\u7ED3\u679C\uFF0C\u5206\u522B\u5982\u4E0B\uFF1A\r\n\u7535\u8BDD\u53F7\u7801             \u7D27\u6025\u8054\u7CFB\u4EBA \u5BB6\u5EAD\u5730\u5740 \u59D3\u540D \u521D\u59CB\u6708\u85AA\n13787687742 \t \u5F20\u6E05            \u6E56\u5357\u957F\u6C99 \u5F20\u4E09  2000\r\n4782317           \u674E\u4E3D            \u5317\u4EAC       \u674E\u56DB 3000\r\n15091528705   \u738B\u534E            \u4E0A\u6D77       \u738B\u4E94 4000\r\n15111101249   \u8D75\u5173            \u56DB\u5DDD\u6210\u90FD \u8D75\u516D  5000");
		textArea_1.setBounds(47, 224, 393, 241);
		panel5.add(textArea_1);
		
		JLabel label_8 = new JLabel("\u60A8\u83B7\u5F97\u4E861\u4E2A\u5171\u6709\u5C5E\u6027\u540D");
		label_8.setBounds(43, 62, 145, 30);
		panel5.add(label_8);
		
		JLabel label_15 = new JLabel("\u8BF7\u8F93\u5165\u9488\u5BF9\u6539\u5C5E\u6027\u540D\u8FDB\u884C\u7B49\u503C\u8FDE\u63A5\u7684\u5176\u5B83\u5C5E\u6027\u4FE1\u606F");
		label_15.setBounds(40, 104, 299, 30);
		panel5.add(label_15);
		
		textField_5 = new JTextField();
		textField_5.setText("\u7D27\u6025\u8054\u7CFB\u4EBA\uFF0C\u5BB6\u5EAD\u5730\u5740");
		textField_5.setBounds(47, 136, 292, 35);
		panel5.add(textField_5);
		textField_5.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u4E2A\u4EBA\u4FE1\u606F"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setToolTipText(" \u4E2A\u4EBA\u7528\u6237\u4FE1\u606F");
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(211, 69, 105, 17);
		panel5.add(list_1);

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		//选项卡1
		
		
		
		
		//选项卡2
		//选项卡3
		//选项卡4
		//选项卡5
		
		
	}
	
	public String getIP(){
		String s=txtLocalhost.getText();
		return s;
	}

	public int getPort() {
		String s=textField_1.getText();
		int i = Integer.parseInt(s);
		return i;
	}

	public String getPath(){
		String s=textField_2.getText();
		return s;
	}
	
	public int getLength(){
		String s=textField_3.getText();
		int i = Integer.parseInt(s);
		return i;
	}
	
	public double getTh(){
		String s=textField_5.getText();
		double i = Double.parseDouble(s);
		return i;
	}
	
	public static void main(String[] args) throws IOException {
		serverWindow cl=new serverWindow();
	}
}
