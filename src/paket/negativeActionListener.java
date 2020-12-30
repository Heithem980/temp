package paket;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class negativeActionListener implements ActionListener {
	
	private Container container;
	private BufferedImage image;

	public negativeActionListener(Container contentPane, BufferedImage image) {
		// TODO Auto-generated constructor stub
		this.container = contentPane;
		this.image = image;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Convert image to negative colors.
				for (int x = 0; x < image.getWidth(); x++) {
				      for (int y = 0; y < image.getHeight(); y++) {
				        int rgba = image.getRGB(x, y);
				        Color col = new Color(rgba, true);
				        col = new Color(255 - col.getRed(), 255 - col.getGreen(),
				            255 - col.getBlue());
				        image.setRGB(x, y, col.getRGB());
				      }
				    }
				
				JLabel imgLabel = (JLabel)this.container.getComponent(0);
				imgLabel.setIcon(new ImageIcon(image));
	}

}
