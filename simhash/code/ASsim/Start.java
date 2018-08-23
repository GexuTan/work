package ASsim;

//: MenuNew.java
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class Start extends JFrame {
	public Start() {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStart = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5C5E\u6027\u540D\u5171\u4EAB\u4FE1\u606F\u7CFB\u7EDF");
		lblStart.setForeground(UIManager.getColor("Focus.color"));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblStart.setBounds(30, 17, 350, 53);
		panel.add(lblStart);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u6839\u636E\u63D0\u793A\u8FDB\u884C\u64CD\u4F5C\uFF0C\u5982\u6709\u95EE\u9898\u8BF7\u67E5\u770B\u5E2E\u52A9");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		lblNewLabel.setBounds(17, 71, 415, 46);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("\u5E2E\u52A9");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Help h=new Help();
			}
		});
		button.setBounds(55, 173, 117, 29);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5F00\u59CB");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainWindow ma=new MainWindow();
				ma.setVisible(true);
			}
		});
		button_1.setBounds(277, 173, 117, 29);
		panel.add(button_1);
		setVisible(true);
		setSize(500,600);
	}	

}
