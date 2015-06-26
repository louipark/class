import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * A simple SlideShow example
 * 
 * @author angrave
 * 
 */
public class SlideShowApp {

	private SlideShowApp() {
		File[] files = { new File("sprite1.gif"), new File("sprite2.gif") };
		showFiles(files);
	}

	private void showFiles(File[] selectedFiles) {
		for (int i = 0; i < selectedFiles.length; i++) {
			File f = selectedFiles[i];
			BufferedImage image;
			try {
				image = ImageIO.read(f);
				Zen.drawImage(image, 0, 0, selectedFiles.length, selectedFiles.length);
				Zen.flipBuffer();
				Zen.sleep(1000);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new SlideShowApp();
	}

}
