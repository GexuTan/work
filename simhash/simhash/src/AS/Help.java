package AS;

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
		textArea.setText("首先，用户需要选择自己为用户端或服务器端。\r\n"
				+"第一步：申请共享，向目标数据库ip申请共享\r\n第二步：将需要共享的数据进行加密\r\n第三步：请选择加入伪数据的个数和长度\r\n第四步：双方交换密文\r\n第五步：输入共享阈值，得到最后结果");
		textArea.setBounds(40, 89, 316, 95);
		panel.add(textArea);
		
		/*JButton button = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button.setBounds(136, 207, 117, 29);
		panel.add(button);*/ 
		setVisible(true);
		setSize(500,600);
	}	
	
}
