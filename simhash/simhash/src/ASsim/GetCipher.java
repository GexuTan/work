package ASsim;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import simhash.CreateCipher;



public class GetCipher extends JFrame {

	JMenuBar mb1 = new JMenuBar();
	JMenu f = new JMenu("参数设置");
	JMenu m = new JMenu("帮助");
	JMenu e = new JMenu("退出");
	static String  projectPath=new String();
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
	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JButton button_2 = new JButton("\u4E0B\u4E00\u6B65");
	private final JTextField textField_1 = new JTextField();
	private final JButton button_3 = new JButton("\u9700\u8981\u5171\u4EAB\u7684\u6587\u4EF6");

	

	public GetCipher() {
		
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(187, 63, 223, 28);
		textField_1.setColumns(10);
		
		setTitle("主菜单");
		mb1 = new JMenuBar();

		mb1.add(f);

		f.add(mntmNewMenuItem);

		f.add(mntmNewMenuItem_1);

		f.add(separator);

		f.add(menuItem);

		f.add(menuItem_1);
		mb1.add(m);
		mb1.add(e);

		setVisible(true);
		setSize(500, 600);
		setJMenuBar(mb1);
		getContentPane().setLayout(new BorderLayout(0, 0));

		getContentPane().add(desktopPane);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		textArea.setText("\u540C\u610F");
		textArea.setLocation(54, 386);
		desktopPane.add(textArea);

		textArea.setForeground(UIManager.getColor("Focus.color"));
		textArea.setEditable(false);
		textArea.setSize(400, 34);
		textArea.setBackground(new Color(164, 205, 255));

		JPanel panel = new JPanel();
		panel.setBounds(46, 78, 416, 268);
		desktopPane.add(panel);
		panel.setLayout(null);

		JButton button_1 = new JButton("\u5F00\u59CB\u52A0\u5BC6");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String s1=textField_1.getText();
					CreateCipher ci=new CreateCipher(s1,10000);
					ci.isSuccess(s1,10000);
			}
		});
		button_1.setBounds(41, 203, 117, 29);
		panel.add(button_1);
		
		panel.add(textField_1);
		button_3.setBounds(25, 64, 117, 29);
		
		panel.add(button_3);
		button_3.addActionListener(new SharedFile());

		JLabel label = new JLabel("\u72B6\u6001\u680F");
		label.setBounds(44, 358, 39, 16);
		desktopPane.add(label);

		Label label_4 = new Label(
				"\u7B2C\u4E8C\u6B65\uFF1A\u5C06\u9700\u8981\u5171\u4EAB\u7684\u6570\u636E\u8FDB\u884C\u52A0\u5BC6");
		label_4.setBounds(49, 55, 66, 17);
		desktopPane.add(label_4);

		button_2.setBounds(148, 443, 117, 29);

		desktopPane.add(button_2);

	}

	class SharedFile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileDialog d = new FileDialog(GetCipher.this,
					"请选择文件地址");
			d.setFile("");
			d.show();
			d.setDirectory(""); // Current directory d.show();
			String yourFile = "*.txt";
			if ((yourFile = d.getFile()) != null) {
				textField_1.setText(d.getDirectory()+yourFile);
			} else {
				textField_1.setText("You pressed cancel");
			}
		}
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetCipher win = new GetCipher();
	}
}
