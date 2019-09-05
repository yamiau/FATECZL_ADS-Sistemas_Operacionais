package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class BrowseController implements ActionListener {

	private JFrame frame;
	private JTextField input;
	
	public BrowseController(JFrame frame, JTextField input) {
		this.frame = frame;
		this.input = input;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		browse();
	}
	
	private void browse() {
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("Executable files (.exe)", "exe");
		String baseDir = (System.getProperty("user.home") + "/Desktop");
		File directory = new File(baseDir);
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(directory);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(extFilter);
		StringBuffer filePath = new StringBuffer();
		int action = chooser.showOpenDialog(null);
		if (action == JFileChooser.APPROVE_OPTION) {
			filePath.append(chooser.getSelectedFile().getAbsolutePath());
			input.setText(filePath.toString());
		}
	}

}
