package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CancelController;
import controller.RunController;
import controller.BrowseController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField TextInput;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertAnExecutable = new JLabel("Insert an executable command to be run");
		lblInsertAnExecutable.setBounds(100, 20, 200, 40);
		contentPane.add(lblInsertAnExecutable);
		
		JTextField TextInput = new JTextField();
		TextInput.setBounds(15, 80, 355, 20);
		contentPane.add(TextInput);
		TextInput.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(15, 120, 90, 25);
		RunController rc = new RunController(TextInput);
		btnRun.addActionListener(rc);
		TextInput.addActionListener(rc);
		contentPane.add(btnRun);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(150, 120, 90, 25);
		CancelController cc = new CancelController(this);
		btnCancel.addActionListener(cc);
		contentPane.add(btnCancel);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(280, 120, 90, 25);
		BrowseController bc = new BrowseController(this, TextInput);
		btnBrowse.addActionListener(bc);
		contentPane.add(btnBrowse);
	}
}
