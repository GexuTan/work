package others;

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

	public JTabbedPane tabbedPane;
	private JLabel label1, label2, label3;
	private JPanel panel1, panel2, panel3;

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
				// Help h = new Help();
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

		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // ����ѡ�������
		// ������ǩ
		label1 = new JLabel("��һ����ǩ�����", SwingConstants.CENTER);
		label2 = new JLabel("�ڶ�����ǩ�����", SwingConstants.CENTER);
		label3 = new JLabel("��������ǩ�����", SwingConstants.CENTER);
		// �������
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);

		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.blue);
		panel3.setBackground(Color.green);
		// ����ǩ�����뵽ѡ���������
		tabbedPane.addTab("��ǩ1", null, panel1, "First panel");
		tabbedPane.addTab("��ǩ2", null, panel2, "Second panel");
		tabbedPane.addTab("��ǩ3", null, panel3, "Third panel");

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void SetNet() {

	}

	public void GetCipher() {

	}

	/*
	 * public String getPath(){ return txtLocalhost.getText();
	 * 
	 * } public int getPort(){ return Integer.parseInt(textField_1.getText()); }
	 */

}
