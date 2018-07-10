package AS;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.JFrame.*;

public class ConnectDB extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public  ConnectDB() {
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStart = new JLabel("\u8BF7\u8FDB\u884C\u6570\u636E\u5E93\u8FDE\u63A5\u64CD\u4F5C");
		lblStart.setForeground(UIManager.getColor("Focus.color"));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblStart.setBounds(30, 17, 350, 53);
		panel.add(lblStart);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u5B8C\u6574\u586B\u5165\u6570\u636E\uFF0C\u5982\u9700\u6DFB\u52A0\u591A\u5F20\u8868\uFF0C\u53EF\u4EE5\u91CD\u590D\u8FDB\u884C\u672C\u64CD\u4F5C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		lblNewLabel.setBounds(17, 71, 457, 46);
		panel.add(lblNewLabel);
		
		JLabel lblip = new JLabel("\u6570\u636E\u5E93IP\u5730\u5740\uFF1A");
		lblip.setBounds(92, 149, 104, 16);
		panel.add(lblip);
		
		textField = new JTextField();
		textField.setBounds(224, 143, 134, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7AEF\u53E3\u53F7");
		lblNewLabel_1.setBounds(92, 189, 61, 16);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 183, 134, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(92, 231, 61, 16);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(224, 225, 134, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(92, 274, 61, 16);
		panel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(224, 265, 134, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u5F00\u59CB");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "数据读取成功", "成功", JOptionPane.INFORMATION_MESSAGE); 
				//Database se=;
				/*String dbIP=textField.getText();
				int dbPort=Integer.parseInt(textField_1.getText());
				String userName=textField_2.getText();
				String passname=textField_3.getText();
				String tableName=textField_4.getText();
				extractTable ex=new extractTable(dbIP,dbPort,userName,passname,tableName);
				*/
				
				
			}
		});
		button.setBounds(125, 444, 117, 29);
		panel.add(button);
		
		JLabel label_2 = new JLabel("\u6570\u636E\u8868\u540D");
		label_2.setBounds(92, 313, 61, 16);
		panel.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(224, 307, 134, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8BF7\u4F9D\u6B21\u586B\u5165\u8981\u5171\u4EAB\u7684\u5C5E\u6027\u540D");
		label_3.setBounds(92, 357, 170, 16);
		panel.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(92, 385, 256, 47);
		panel.add(textField_5);
		setVisible(true);
		setSize(500,600);
	}	
	public static void main(String[] args) throws IOException {
		ConnectDB cl=new ConnectDB();
		
	}
}
