package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import data.MyQueue;
import data.Sound;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.InputEvent;

public class FrmMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAnounce;
	private JTextField txtNumber1;
	private JTextField txtNumber2;
	
	private MyQueue Queue;
	private int count = 0;
	
	private void CallNext(int i) {
		
		if (Queue.getSize() > 0) {
			int temp = Queue.deMyQueue();
			String Str = "XIN MỜI QUÝ KHÁCH SỐ " + temp + " ĐẾN QUẦY THỨ " + i;
			txtAnounce.setText(Str);
			Sound sound = new Sound();
			try {
				sound.readInvite(temp, i);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			txtAnounce.setText("MỜI QUÝ KHÁCH LẤY SỐ");
		}
		
	}
	
	private int GetNumber() {
		int temp = ++count;
		Queue.enMyQueue(temp);
		return temp;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMain() {
		
		Queue = new MyQueue();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 444);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAction = new JMenu("Thao tác");
		menuBar.add(mnAction);
		
		JMenuItem mntmtReset = new JMenuItem("Đặt lại");
		mntmtReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
			}
		});
		mntmtReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnAction.add(mntmtReset);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelStaff1 = new JPanel();
		panelStaff1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelStaff1.setBounds(10, 20, 230, 80);
		contentPane.add(panelStaff1);
		panelStaff1.setLayout(null);
		
		JButton btnNextCutomer1 = new JButton("Mời");
		btnNextCutomer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallNext(1);
			}
			
		});
		btnNextCutomer1.setBounds(145, 5, 80, 60);
		panelStaff1.add(btnNextCutomer1);
		
		JLabel lbl1 = new JLabel("1");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(97, 0, 46, 65);
		panelStaff1.add(lbl1);
		
		JPanel panelStaff2 = new JPanel();
		panelStaff2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelStaff2.setBounds(280, 20, 230, 80);
		contentPane.add(panelStaff2);
		panelStaff2.setLayout(null);
		
		JButton btnnextCustomer2 = new JButton("Mời");
		btnnextCustomer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallNext(2);
			}
		});
		btnnextCustomer2.setBounds(145, 5, 80, 60);
		panelStaff2.add(btnnextCustomer2);
		
		JLabel lbl2 = new JLabel("2");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl2.setBounds(97, 0, 46, 65);
		panelStaff2.add(lbl2);
		
		JPanel panelStaff3 = new JPanel();
		panelStaff3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelStaff3.setBounds(530, 20, 230, 80);
		contentPane.add(panelStaff3);
		panelStaff3.setLayout(null);
		
		JButton btnNextCustomer3 = new JButton("Mời");
		btnNextCustomer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallNext(3);
			}
		});
		btnNextCustomer3.setBounds(145, 5, 80, 60);
		panelStaff3.add(btnNextCustomer3);
		
		JLabel lbl3 = new JLabel("3");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl3.setBounds(97, 0, 46, 65);
		panelStaff3.add(lbl3);
		
		txtAnounce = new JTextField();
		txtAnounce.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnounce.setEditable(false);
		txtAnounce.setBounds(43, 124, 648, 33);
		contentPane.add(txtAnounce);
		txtAnounce.setColumns(10);
		
		JPanel panelMachine1 = new JPanel();
		panelMachine1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelMachine1.setBounds(43, 217, 197, 105);
		contentPane.add(panelMachine1);
		panelMachine1.setLayout(null);
		
		JButton btnGetNumber1 = new JButton("Lấy số");
		btnGetNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumber1.setText("Số " + GetNumber());
			}
		});
		btnGetNumber1.setBounds(50, 11, 89, 23);
		panelMachine1.add(btnGetNumber1);
		
		txtNumber1 = new JTextField();
		txtNumber1.setEditable(false);
		txtNumber1.setBounds(10, 62, 177, 20);
		panelMachine1.add(txtNumber1);
		txtNumber1.setColumns(10);
		
		JPanel panelMachine2 = new JPanel();
		panelMachine2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelMachine2.setBounds(304, 217, 217, 105);
		contentPane.add(panelMachine2);
		panelMachine2.setLayout(null);
		
		JButton btnGetNumber2 = new JButton("Lấy số");
		btnGetNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumber2.setText("Số " + GetNumber());
			}
		});
		btnGetNumber2.setBounds(64, 11, 89, 23);
		panelMachine2.add(btnGetNumber2);
		
		txtNumber2 = new JTextField();
		txtNumber2.setEditable(false);
		txtNumber2.setColumns(10);
		txtNumber2.setBounds(30, 61, 177, 20);
		panelMachine2.add(txtNumber2);
	}
}
