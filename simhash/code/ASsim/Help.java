package ASsim;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JFrame.*;

public class Help extends JFrame {
	public Help() {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStart = new JLabel("\u7CFB\u7EDF\u5E2E\u52A9");
		lblStart.setForeground(UIManager.getColor("Focus.color"));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblStart.setBounds(30, 17, 350, 53);
		panel.add(lblStart);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setText("���ȣ��û���Ҫѡ���Լ�Ϊ�û��˻�������ˡ�\r\n"
				+ "��һ�������빲����Ŀ�����ݿ�ip���빲��\r\n�ڶ���������Ҫ��������ݽ��м���\r\n����������ѡ�����α���ݵĸ����ͳ���\r\n���Ĳ���˫����������\r\n���岽�����빲����ֵ���õ������");
		textArea.setBounds(40, 89, 316, 95);
		panel.add(textArea);
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainWindow tr=new MainWindow();
			}
		});
		button.setBounds(136, 207, 117, 29);
		panel.add(button);
		setVisible(true);
		setSize(500,600);
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Help win = new Help();
	}

}
