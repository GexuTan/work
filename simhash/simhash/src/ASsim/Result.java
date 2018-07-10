package ASsim;
import java.awt.*;
import java.awt.TextArea;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class Result extends JFrame {
	


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
			private final JTextArea textArea = new JTextArea();
			private final JDesktopPane desktopPane = new JDesktopPane();
			private JTextField textField;

			public Result() {
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
				textArea.setLineWrap(true);        //激活自动换行功能 
				textArea.setWrapStyleWord(true); 
				
				JPanel panel = new JPanel();
				panel.setBounds(46, 78, 416, 268);
				desktopPane.add(panel);
				panel.setLayout(null);
				
				JLabel label_1 = new JLabel("\u8BF7\u8BBE\u7F6E\u9608\u503C\uFF1A");
				label_1.setBounds(54, 18, 89, 16);
				panel.add(label_1);
				
				textField = new JTextField();
				textField.setBounds(132, 12, 134, 28);
				panel.add(textField);
				textField.setColumns(10);
				
				JButton button = new JButton("\u5F00\u59CB");
				button.setBounds(142, 48, 117, 29);
				panel.add(button);
				
				JLabel label_2 = new JLabel("\u7ED3\u679C");
				label_2.setBounds(82, 128, 61, 16);
				panel.add(label_2);
				
				JLabel label = new JLabel("\u72B6\u6001\u680F");
				label.setBounds(44, 358, 39, 16);
				desktopPane.add(label);
				
				Label label_4 = new Label("\u7B2C\u4E94\u6B65\uFF1A\u606D\u559C\u4F60\uFF0C\u5230\u4E86\u6700\u540E\u4E00\u6B65");
				label_4.setBounds(49, 55, 66, 17);
				desktopPane.add(label_4);

			}

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				 Result  win = new  Result();
			}
}
