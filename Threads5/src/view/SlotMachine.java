package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SlotController;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SlotMachine extends JFrame {

	private JPanel contentPane;
	private static int[] result = new int[3];
	private static int counter;

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
		slot1.setBounds(296, 72, 100, 100);
		contentPane.add(slot1);
		
		JTextField slot2 = new JTextField();
		slot2.setEditable(false);
		slot2.setHorizontalAlignment(SwingConstants.CENTER);
		slot2.setText("X");
		slot2.setFont(new Font("Tahoma", Font.PLAIN, 60));
		slot2.setBounds(162, 72, 100, 100);
		contentPane.add(slot2);
		
		JTextField slot3 = new JTextField();
		slot3.setEditable(false);
		slot3.setFont(new Font("Tahoma", Font.PLAIN, 60));
		slot3.setHorizontalAlignment(SwingConstants.CENTER);
		slot3.setText("X");
		slot3.setBounds(30, 72, 100, 100);
		contentPane.add(slot3);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(0, 210, 434, 51);
		JTextField[] slots = {slot1, slot2, slot3};
		SlotController slotController = new SlotController(this, slots);
		btnPlay.addActionListener(slotController);
		contentPane.add(btnPlay);
		
		JLabel lblTestYourLuck = new JLabel("Test your luck!");
		lblTestYourLuck.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTestYourLuck.setBounds(112, 20, 200, 30);
		contentPane.add(lblTestYourLuck);
	}
	
	public static void result(int value) {
		result[counter] = value;
		counter++;
		if (counter == 3) {
			if ((result[0] == result[1]) & (result[0] == result[2])) {
				sound(true);
				JOptionPane.showMessageDialog(null, "You got it, lucky bastard! :D");
			} else {
				sound(false);
				JOptionPane.showMessageDialog(null, "What a loser! ;(");
			}
		}
	}
	
	public static void sound(boolean victory) {
		StringBuffer filepath = new StringBuffer(System.getProperty("user.dir"));
		System.out.println(filepath);
		if (victory) {
			filepath.append("\\sounds\\Ta Da.wav");
		} else {
			filepath.append("\\sounds\\Sad Trombone.wav");
		}
		
		InputStream is;
		try {
			is = new FileInputStream(new File(filepath.toString()));
			AudioStream as = new AudioStream(is); 
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
