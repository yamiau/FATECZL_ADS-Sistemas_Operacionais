package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RacerController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class Track extends JFrame {

	private JPanel contentPane;
	private static boolean winner;
	private static JButton btnRace;
	private static JLabel fireworks;
	private static JLabel victory;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") +"\\img\\icon.png"));
		setTitle("THE AMAZING THREE ENVIRONMENT DRAG RACE");
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1000, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel goal = new JLabel();
		goal.setBounds(0, 0, 28, 660);
		contentPane.add(goal);
		
		victory = new JLabel("");
		victory.setIcon(new ImageIcon((System.getProperty("user.dir") + "\\img\\victory.gif")));
		victory.setBounds(220, 154, 200, 200);
		victory.setVisible(false);
		contentPane.add(victory);
		
		fireworks = new JLabel("");
		fireworks.setIcon(new ImageIcon((System.getProperty("user.dir") + "\\img\\fireworks.gif")));
		fireworks.setBounds(220, 195, 200, 200);
		fireworks.setVisible(false);
		contentPane.add(fireworks);
		
		JLabel racer0 = new JLabel("");
		racer0.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\racer0.gif"));
		racer0.setBounds(860, 0, 200, 200);
		contentPane.add(racer0);
		
		JLabel racer1 = new JLabel();
		racer1.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\img\\racer1.gif"));
		racer1.setBounds(860, 210, 200, 200);
		contentPane.add(racer1);
		
		JLabel racer2 = new JLabel();
		racer2.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\img\\racer2.gif"));
		racer2.setBounds(860, 430, 280, 200);
		contentPane.add(racer2);
			
		JLabel[] racers = {racer0, racer1, racer2};
		
		btnRace = new JButton("RACE");
		btnRace.setBounds(490, 11, 89, 23);
		RacerController rc = new RacerController(this, btnRace, racers, goal);
		btnRace.addActionListener(rc);
		contentPane.add(btnRace);
		
		JLabel BG = new JLabel("");
		BG.setBounds(0, 0, 1000, 660);
		BG.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\img\\BG.png"));
		contentPane.add(BG);
	}
	
	public boolean getWinner() {
		return winner;
	}
	
	public void setWinner(JLabel racer) {
		winner = true;
		winAnimation(racer);
	}
	
	private void winAnimation(JLabel racer) {
		Rectangle r = new Rectangle(racer.getBounds());
		int y = r.y;
		victory.setBounds(200, y, 200, 200);
		fireworks.setBounds(200, y, 200, 200);
		victory.setVisible(true);
		fireworks.setVisible(true);
	}
}
