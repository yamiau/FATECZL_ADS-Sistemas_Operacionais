package control;

import java.security.SecureRandom;
import javax.swing.JLabel;

public class GenerateIcon {
	public String generateIcon(JLabel label) {
		
		StringBuffer filepath = new StringBuffer(System.getProperty("user.dir") + "\\img\\car");
		SecureRandom random = new SecureRandom();
		filepath.append(random.nextInt(5)+1);
		
		if (label.getBounds().x < 250) {
			if (label.getBounds().y < 250) {
				filepath.append("ns");
			} else {
				filepath.append("we");
			}
		} else if (label.getBounds().y < 300){
			filepath.append("ew");
		} else {
			filepath.append("sn");
		}
		filepath.append(".png");
		
		return filepath.toString();
	}
}
