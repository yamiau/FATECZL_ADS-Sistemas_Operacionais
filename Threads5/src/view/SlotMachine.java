package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SlotController;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SlotMachine extends JFrame {

	private JPanel contentPane;
	private ArrayList<Integer> result;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotMachine frame = new SlotMachine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SlotMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField slot1 = new JTextField();
		slot1.setEditable(false);
		slot1.setHorizontalAlignment(SwingConstants.CENTER);
		slot1.setFont(new Font("Tahoma", Font.PLAIN, 60));
		slot1.setText("X");
		slot1.setBounds(296, 60, 100, 100);
		contentPane.add(slot1);
		
		JTextField slot2 = new JTextField();
		slot2.setEditable(false);
		slot2.setHorizontalAlignment(SwingConstants.CENTER);
		slot2.setText("X");
		slot2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		slot2.setBounds(162, 60, 100, 100);
		contentPane.add(slot2);
		
		JTextField slot3 = new JTextField();
		slot3.setEditable(false);
		slot3.setFont(new Font("Tahoma", Font.PLAIN, 60));
		slot3.setHorizontalAlignment(SwingConstants.CENTER);
		slot3.setText("X");
		slot3.setBounds(30, 60, 100, 100);
		contentPane.add(slot3);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(0, 210, 434, 51);
		SlotController slotController = new SlotController(this, slot1, slot2, slot3);
		btnPlay.addActionListener(slotController);
		contentPane.add(btnPlay);
	}
	
	public void result(int value) {
		result.add(value);
		if (result.size() == 3) {
			if (result.get(0) == result.get(1) & result.get(0) == result.get(2)) {
				JOptionPane.showMessageDialog(null, "You got it, lucky bastard! :D");
			} else {
				JOptionPane.showMessageDialog(null, "What a loser! ;(");
			}
		}
	}
}
