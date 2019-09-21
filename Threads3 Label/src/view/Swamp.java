package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.PlayController;
import control.SoundController;

public class Swamp extends JFrame {

	private static JPanel contentPane;
	private static boolean winner;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swamp frame = new Swamp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Swamp() {
		setTitle("Frog race");
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\img\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 681, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SoundController sc = new SoundController();
		sc.music1();
		
		JLabel frog1 = new JLabel("");
		frog1.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\my_frog.gif"));
		frog1.setBounds(40, 260, 49, 40);
		contentPane.add(frog1);
		
		JLabel lblBG1 = new JLabel("");
		lblBG1.setIcon(new ImageIcon(System.getProperty("user.dir") +"\\img\\swamp3tree.png"));
		lblBG1.setBounds(0, 0, 684, 421);
		contentPane.add(lblBG1);
		
		JLabel frog0 = new JLabel("");
		frog0.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\my_frog.gif"));
		frog0.setBounds(40, 330, 49, 40);
		contentPane.add(frog0);
		
		JLabel frog2 = new JLabel("");
		frog2.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\my_frog.gif"));
		frog2.setBounds(40, 190, 49, 40);
		contentPane.add(frog2);
		
		JLabel frog3 = new JLabel("");
		frog3.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\my_frog.gif"));
		frog3.setBounds(40, 120, 49, 40);
		contentPane.add(frog3);
		
		JLabel goal = new JLabel("");
		goal.setBounds(586, 71, 46, 299);
		contentPane.add(goal);
		
		JButton play = new JButton("");
		play.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\play.png"));
		play.setBounds(20, 10, 625, 50);
		JLabel[] frogs = {frog0, frog1, frog2, frog3};
		PlayController pc = new PlayController(this, play, frogs, goal);
		play.addActionListener(pc);
		contentPane.add(play);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\swamp3.png"));
		lblBG.setBounds(0, 0, 684, 421);
		contentPane.add(lblBG);
	}
	
	public boolean getWinner(){
		return winner;
	}
	
	public void setWinner() {
		winner = true;
	}
}
