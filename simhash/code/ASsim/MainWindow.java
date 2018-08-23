package ASsim;

//: MenuNew.java
//Menus in Java 1.1 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class MainWindow extends JFrame {

	JMenuBar mb1 = new JMenuBar();
	JMenu f = new JMenu("参数设置");
	JMenu m = new JMenu("帮助");
	JMenu e = new JMenu("退出");
	JMenuItem[] file;
	private JMenuBar menuBar;
	private final JMenuItem mntmNewMenuItem = new JMenuItem("\u6570\u636E\u5E93\u8BBE\u7F6E");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5171\u4EAB\u9608\u503C");
	private final JMenuItem menuItem = new JMenuItem("\u5BC6\u6587\u957F\u5EA6");
	private final JMenuItem menuItem_1 = new JMenuItem("\u4F2A\u6570\u636E\u8BBE\u7F6E");
	private final JSeparator separator = new JSeparator();
	private final JTextPane textArea = new JTextPane();
	private final JDesktopPane desktopPane = new JDesktopPane();
	private JTextField txtLocalhost;
	private JTextField textField_1;
	private final JButton button_2 = new JButton("\u4E0B\u4E00\u6B65");
	private final JButton button_3 = new JButton("\u670D\u52A1\u7AEF");

	public MainWindow() {
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
		setSize(500,600);
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
		//textArea.setLocation(900,20);
		textArea.setSize(400,34);
		textArea.setBackground(new Color(164, 205, 255));
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 78, 416, 268);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("\u5BF9\u65B9IP\uFF1A");
		lblIp.setBounds(51, 110, 61, 16);
		panel.add(lblIp);
		
		JLabel label_3 = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label_3.setBounds(51, 138, 61, 16);
		panel.add(label_3);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setHorizontalAlignment(SwingConstants.LEFT);
		txtLocalhost.setText("localhost");
		txtLocalhost.setBounds(118, 104, 134, 28);
		panel.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("3306");
		textField_1.setBounds(118, 132, 134, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u5BA2\u6237\u7AEF");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s=txtLocalhost.getText();
				String s1=textField_1.getText();
				int i = Integer.parseInt(s1);
				Server cl=new Server();
				try {
					cl.accept(s, i);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(221, 179, 117, 29);
		panel.add(button_1);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s=txtLocalhost.getText();
				String s1=textField_1.getText();
				int i = Integer.parseInt(s1);
				Client cl=new Client();
				try {
					if(cl.apply(s, i))
						JOptionPane.showMessageDialog(null, "成功", "申请已发送", JOptionPane.NO_OPTION); 
					else
						JOptionPane.showMessageDialog(null, "错误", "连接失败，请检查设置", JOptionPane.ERROR_MESSAGE); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_3.setBounds(41, 179, 117, 29);
		
		panel.add(button_3);
		
		JLabel label = new JLabel("\u72B6\u6001\u680F");
		label.setBounds(44, 358, 39, 16);
		desktopPane.add(label);
		
		Label label_4 = new Label("\u7B2C\u4E00\u6B65\uFF1A\u7533\u8BF7\u5171\u4EAB\uFF0C\u5411\u76EE\u6807\u6570\u636E\u5E93ip\u7533\u8BF7\u5171\u4EAB");
		label_4.setBounds(49, 55, 66, 17);
		desktopPane.add(label_4);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetCipher ci=new GetCipher();
			}
		});
		button_2.setBounds(148, 443, 117, 29);
		
		desktopPane.add(button_2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow win = new MainWindow();
	}
}
