package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundController {
	private static InputStream is;
	private static AudioStream as;
	
	public void music1() {
		try {
			is = new FileInputStream(new File(System.getProperty("user.dir") + "\\snd\\bgmusic.wav"));
			try {
				as = new AudioStream(is);
				AudioPlayer.player.start(as);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void music2() {
		AudioPlayer.player.stop(as);
		try {
			is = new FileInputStream(new File(System.getProperty("user.dir") + "\\snd\\racemusic.wav"));
			try {
				as = new AudioStream(is);
				AudioPlayer.player.start(as);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void music3() {
		AudioPlayer.player.stop(as);
		try {
			is = new FileInputStream(new File(System.getProperty("user.dir") + "\\snd\\winmusic.wav"));
			try {
				as = new AudioStream(is);
				AudioPlayer.player.start(as);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
