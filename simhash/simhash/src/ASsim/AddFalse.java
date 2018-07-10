package ASsim;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import simhash.AddFalseHash;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class AddFalse  extends JFrame{

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
		private final JButton button_2 = new JButton("\u4E0B\u4E00\u6B65");
		private final JLabel label_1 = new JLabel("\u4E2A\u6570\uFF1A");
		private final JLabel label_2 = new JLabel("\u957F\u5EA6\uFF1A");
		private final JTextField textField = new JTextField();
		private final JTextField textField_1 = new JTextField();
		private final JButton button = new JButton("\u52A0\u5165\u6570\u636E");

		public AddFalse() {
			textField_1.setText("256");
			textField_1.setBounds(123, 96, 134, 28);
			textField_1.setColumns(10);
			textField.setBounds(123, 62, 134, 28);
			textField.setColumns(10);
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
			textArea.setSize(400,34);
			textArea.setBackground(new Color(164, 205, 255));
			
			JPanel panel = new JPanel();
			panel.setBounds(46, 78, 416, 268);
			desktopPane.add(panel);
			panel.setLayout(null);
			label_1.setBounds(79, 68, 61, 16);
			
			panel.add(label_1);
			label_2.setBounds(79, 102, 61, 16);
			
			panel.add(label_2);
			
			panel.add(textField);
			
			panel.add(textField_1);
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String s1=textField.getText().toString();
					String s2=textField_1.getText().toString();
					int falseNumber=0;
					//字符串转为数字,全局变量String projectPath的修改
					int falseLength = 0;
					AddFalseHash ad=new AddFalseHash(falseNumber,falseLength);
					ad.AddValue();
					
				}
			});
			button.setBounds(83, 182, 117, 29);
			
			panel.add(button);
			
			JLabel label = new JLabel("\u72B6\u6001\u680F");
			label.setBounds(44, 358, 39, 16);
			desktopPane.add(label);
			
			Label label_4 = new Label("\u7B2C\u4E09\u6B65\uFF1A\u8BF7\u9009\u62E9\u52A0\u5165\u4F2A\u6570\u636E\u7684\u4E2A\u6570\u548C\u957F\u5EA6");
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
			AddFalse win = new AddFalse();
		}
}
