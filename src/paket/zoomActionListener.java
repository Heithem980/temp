package paket;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class zoomActionListener implements ActionListener {

	private BufferedImage image;
	private Container container;
	private boolean zoom = false;
	
	// constructor to class zoomActionListener.
	public zoomActionListener(Container container, BufferedImage image) {
		this.image = image;
		this.container = container;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// change scale of image once zoom button clicked.
		Image result;
		zoom = !zoom;
		if(zoom) result = this.image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		else result = this.image;
		JLabel imgLabel = (JLabel)this.container.getComponent(0);
		imgLabel.setIcon(new ImageIcon(result));
	}

}
