package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Track extends JFrame {

	private JPanel contentPane;
	private static boolean winner;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Track frame = new Track();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Track() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel goal = new JLabel("");
		goal.setBounds(10, 11, 46, 539);
		contentPane.add(goal);
		
		JLabel racer1 = new JLabel("");
		racer1.setIcon(new ImageIcon("C:\\Users\\Yami\\Documents\\GitHub\\FATECZL_ADS-Sistemas_Operacionais\\Threads4\\img\\racer1.gif"));
		racer1.setBounds(800, 66, 200, 200);
		contentPane.add(racer1);
		
		JLabel racer2 = new JLabel("");
		racer2.setIcon(new ImageIcon("C:\\Users\\Yami\\Documents\\GitHub\\FATECZL_ADS-Sistemas_Operacionais\\Threads4\\img\\racer2.gif"));
		racer2.setBounds(802, 343, 200, 200);
		contentPane.add(racer2);
		
		JButton race = new JButton("RACE");
		race.setBounds(490, 11, 89, 23);
		contentPane.add(race);
		
		JLabel BG = new JLabel("New label");
		BG.setBounds(379, 93, 46, 14);
		contentPane.add(BG);
	}
	
	public boolean getWinner() {
		return winner;
	}
	
	public void setWinner(int id) {
		winner = true;
		String filepath = (System.getProperty("user.dir") + "\\img\\winner" + id + ".png");
		JLabel winner = new JLabel("");
		winner.setBounds();
		winner.setIcon(new ImageIcon(filepath));
		contentPane.addComponent(winner);
	}
}
