package AS;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class MainWindow extends JFrame {

	JMenuBar mb1 = new JMenuBar();
	JMenu f = new JMenu("��������");
	JMenu m = new JMenu("����");
	JMenu e = new JMenu("�˳�");
	JMenuItem[] file;
	private JMenuBar menuBar;
	private final JMenuItem mntmNewMenuItem = new JMenuItem(
			"\u6570\u636E\u5E93\u8BBE\u7F6E");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem(
			"\u5171\u4EAB\u9608\u503C");
	private final JMenuItem menuItem = new JMenuItem("\u5BC6\u6587\u957F\u5EA6");
	private final JMenuItem menuItem_1 = new JMenuItem(
			"\u4F2A\u6570\u636E\u8BBE\u7F6E");
	private final JSeparator separator = new JSeparator();
	private final JTextPane textArea = new JTextPane();
	//�˵���
	

	public JTabbedPane tabbedPane;
	private JLabel label1, label2,label3,label4,label5;
	private JPanel panel1, panel2, panel3,panel4,panel5;
	private JTextField txtLocalhost;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button_2;
	private JTextField textField_2;
	private JButton button_3;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel label_6;
	private JButton button_4;
	private JButton button_5;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField textField_5;
	private JButton button_6;
	
	public Client cl;
	public Server se;
	private JTextField textField;
	private JLabel label_5;
	private JButton button_7;
	//ѡ�
	
	
	
	
	
	//ѡ�1
	
	
	//ѡ�2
	//ѡ�3
	//ѡ�4
	//ѡ�5
	

	public MainWindow() {

		setTitle("���˵�");

		mb1 = new JMenuBar();

		mb1.add(f);

		f.add(mntmNewMenuItem);

		f.add(mntmNewMenuItem_1);

		f.add(separator);

		f.add(menuItem);

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
		//�˵���
		
		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // ����ѡ�������
		// ������ǩ
		label1 = new JLabel("��һ����ǩ�����", SwingConstants.CENTER);
		label2 = new JLabel("��er����ǩ�����", SwingConstants.CENTER);
		label3 = new JLabel("��er����ǩ�����", SwingConstants.CENTER);
		label4 = new JLabel("��������ǩ�����", SwingConstants.CENTER);
		label5 = new JLabel("��������ǩ�����", SwingConstants.CENTER);
		
		// �������
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
		

		
		// ����ǩ�����뵽ѡ���������
		tabbedPane.addTab("����1", null, panel1, "First panel");
		
		JLabel lblNewLabel = new JLabel("\u7B2C\u4E00\u6B65\uFF1A\u7533\u8BF7\u5171\u4EAB\uFF0C\u5411\u76EE\u6807\u6570\u636E\u5E93ip\u7533\u8BF7\u5171\u4EAB");
		lblNewLabel.setBounds(20, 20, 273, 30);
		panel1.add(lblNewLabel);
		
		JLabel lblip = new JLabel("\u5BF9\u65B9IP\uFF1A");
		lblip.setBounds(47, 84, 61, 16);
		panel1.add(lblip);
		
		JLabel label = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label.setBounds(47, 134, 61, 16);
		panel1.add(label);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("120.27.107.119");
		txtLocalhost.setBounds(93, 78, 134, 28);
		panel1.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("6789");
		textField_1.setBounds(93, 128, 134, 28);
		panel1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u670D\u52A1\u7AEF");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//se=new Server(title, defaultCloseOperation);
				se.addressPath=txtLocalhost.getText();
				se.portNumber=Integer.parseInt(textField_1.getText());
				
				try {
					//String s=se.accept(se.addressPath, se.portNumber);
					//if(s=="success"){
						JOptionPane.showInternalMessageDialog(null, "information","information", JOptionPane.INFORMATION_MESSAGE);
					//}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		button.setBounds(32, 220, 117, 29);
		panel1.add(button);
		
		JButton button_1 = new JButton("\u5BA2\u6237\u7AEF");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl=new Client();
				cl.addressPath=txtLocalhost.getText();
				cl.portNumber=Integer.parseInt(textField_1.getText());
				System.out.println(cl.addressPath+":"+cl.portNumber); 
				try {
					boolean i=cl.apply(cl.addressPath, cl.portNumber);
					System.out.println("��������"); 
					if(i){
						JOptionPane.showMessageDialog(null, "�����ѷ���", "�����ѷ��ͣ��������һ��", JOptionPane.INFORMATION_MESSAGE); 
						//JOptionPane.showInternalMessageDialog(panel1, "information","�����ѷ���", JOptionPane.INFORMATION_MESSAGE); 
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button_1.setBounds(216, 220, 117, 29);
		panel1.add(button_1);
		
		
		
		
		
		
		
		tabbedPane.addTab("����2", null, panel2, "Second panel");
		
		label_1 = new JLabel("\u7B2C\u4E8C\u6B65\uFF1A\u5C06\u9700\u8981\u5171\u4EAB\u7684\u6570\u636E\u8FDB\u884C\u52A0\u5BC6");
		panel2.add(label_1);
		
		label_2 = new JLabel("\u7B2C\u4E8C\u6B65\uFF1A\u5C06\u9700\u8981\u5171\u4EAB\u7684\u6570\u636E\u8FDB\u884C\u52A0\u5BC6");
		label_2.setBounds(20, 20, 262, 30);
		panel2.add(label_2);
		
		button_2 = new JButton("\u9009\u62E9\u6587\u4EF6");
		button_2.addActionListener(new SharedFile());
	
		button_2.setBounds(45, 122, 117, 29);
		panel2.add(button_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 121, 134, 28);
		panel2.add(textField_2);
		textField_2.setColumns(10);
		
		button_3 = new JButton("\u5F00\u59CB\u52A0\u5BC6");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int nu=Integer.parseInt(textField.getText());
				
				String s=textField_2.getText();
				System.out.println(s);
				CreateCipher ci=new CreateCipher(s,nu);
				System.out.println(s);
				//boolean b=ci.isSuccess(s,380);
				//if(b){
					JOptionPane.showMessageDialog(null, "�������һ��", "���ܳɹ�", JOptionPane.INFORMATION_MESSAGE); 
				//}
			}
		});
		button_3.setBounds(45, 222, 117, 29);
		panel2.add(button_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(191, 157, 134, 28);
		panel2.add(textField);
		
		label_5 = new JLabel("\u5BC6\u6587\u957F\u5EA6\uFF1A");
		label_5.setBounds(69, 163, 73, 16);
		panel2.add(label_5);
		
		
		
		panel3.add(label3);
		
		panel3.setLayout(null);
		tabbedPane.addTab("����3", null, panel3, "Third panel");
		
		label_3 = new JLabel("\u7B2C\u4E09\u6B65\uFF1A\u8BF7\u9009\u62E9\u52A0\u5165\u4F2A\u6570\u636E\u7684\u4E2A\u6570\u548C\u957F\u5EA6");
		label_3.setBounds(20, 20, 251, 30);
		panel3.add(label_3);
		
		label_4 = new JLabel("\u4E2A\u6570\uFF1A");
		label_4.setBounds(68, 89, 61, 16);
		panel3.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 83, 134, 28);
		panel3.add(textField_3);
		textField_3.setColumns(10);
		
		button_7 = new JButton("\u52A0\u5165\u4F2A\u5BC6\u6587");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int falseNumber=Integer.parseInt(textField_3.getText());//����
				int falseLength=Integer.parseInt(textField.getText());//����
				AddFalseHash ad=new AddFalseHash(falseNumber,falseLength);
				//boolean b=ad.AddValue();
				//if(b){
					JOptionPane.showMessageDialog(null, "�������һ��", "������ӳɹ�", JOptionPane.INFORMATION_MESSAGE); 
				//}
				
			}
		});
		button_7.setBounds(68, 214, 117, 29);
		panel3.add(button_7);
		
		
		
		
		
		
		
		
		
		
		tabbedPane.addTab("����4", null, panel4, "Third panel");
		
		label_6 = new JLabel("\u7B2C\u56DB\u6B65\uFF1A\u53CC\u65B9\u4EA4\u6362\u5BC6\u6587");
		label_6.setBounds(20, 20, 200, 30);
		panel4.add(label_6);
		
		button_4 = new JButton("\u53D1\u9001\u5BC6\u6587");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
	
				cl=new Client();
				cl.addressPath=txtLocalhost.getText();
				cl.portNumber=Integer.parseInt(textField_1.getText());
				
				
			
				System.out.println(cl.addressPath+":"+cl.portNumber); 
				try {
					boolean i=cl.apply(cl.addressPath, cl.portNumber);
					System.out.println("��������"); 
					if(i){
						JOptionPane.showMessageDialog(null, "�����ѷ���", "�����ѷ��ͣ��������һ��", JOptionPane.INFORMATION_MESSAGE); 
						//JOptionPane.showInternalMessageDialog(panel1, "information","�����ѷ���", JOptionPane.INFORMATION_MESSAGE); 
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "��ȴ��Է�����", "���ķ��ͳɹ�", JOptionPane.INFORMATION_MESSAGE);
				
				//
			}
		});
		
		
		button_4.setBounds(67, 144, 117, 29);
		panel4.add(button_4);
		
		button_5 = new JButton("\u63A5\u6536\u5BC6\u6587");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "�������һ��", "���Ľ��ճɹ�", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_5.setBounds(220, 144, 117, 29);
		panel4.add(button_5);
		tabbedPane.addTab("����5", null, panel5, "Third panel");
		
		label_7 = new JLabel("\u7B2C\u4E94\u6B65\uFF1A\u606D\u559C\u4F60\uFF0C\u5230\u4E86\u6700\u540E\u4E00\u6B65");
		label_7.setBounds(20, 20, 200, 30);
		panel5.add(label_7);
		
		label_8 = new JLabel("\u8BBE\u7F6E\u9608\u503C\uFF1A");
		label_8.setBounds(47, 123, 93, 16);
		panel5.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(152, 117, 134, 28);
		panel5.add(textField_5);
		textField_5.setColumns(10);
		
		button_6 = new JButton("\u83B7\u5F97\u7ED3\u679C\uFF1A");
		button_6.setBounds(36, 160, 117, 29);
		panel5.add(button_6);

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		//ѡ�1
		
		
		
		
		//ѡ�2
		//ѡ�3
		//ѡ�4
		//ѡ�5
		
		
	}

	class SharedFile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileDialog d = new FileDialog(MainWindow.this,"��ѡ���ļ���ַ");
			
			d.setFile("");
			d.show();
			d.setDirectory(""); // Current directory d.show();
			String yourFile = "*.txt";
			System.out.println("1"+yourFile);  
			if ((yourFile = d.getFile()) != null) {
				//System.out.println("2"+yourFile);
				textField_2.setText(yourFile);
				
				//System.out.println("3"+yourFile+textField_2.getText()); 
			} else {
				textField_2.setText("You pressed cancel");
				System.out.println("4"+yourFile); 
			}
		}
		
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

}
