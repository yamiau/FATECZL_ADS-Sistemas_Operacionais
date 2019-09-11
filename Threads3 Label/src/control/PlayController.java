package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import sun.audio.AudioStream;
import view.Swamp;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayController implements ActionListener{

	private Swamp swamp;
	private JButton play; 
	private JLabel[] frogs;
	private JLabel goal;
	
	public PlayController(Swamp swamp, JButton play, JLabel[] frogs, JLabel goal) {
		this.swamp = swamp;
		this.play = play;
		this.frogs = frogs;
		this.goal = goal;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		play.setVisible(false);
		SoundController sc = new SoundController();
		sc.music2();
		for (int i = 0; i < 4; i++) {
			Thread frog = new Frog(swamp, frogs[i], goal);
			frog.start();
		}
	}

}
