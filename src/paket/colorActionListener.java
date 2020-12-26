package paket;
//import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class colorActionListener implements ActionListener {

	private BufferedImage image;
	private Container container;
	private boolean changeColor = false;
	
	// constructor to class colorActionPerformed.
	public colorActionListener(Container container, BufferedImage image) {
		this.image = image;
		this.container = container;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeColor = !changeColor;
		
		// (onclick) Changes from color to grayscale or vice versa.
		
		if(changeColor) {
		 int width = image.getWidth();
	        int height = image.getHeight();
	        for (int y = 0; y < height; y++)
	          {
	             for (int x = 0; x < width; x++)
	              {
	                  int p = image.getRGB(x,y);
	                  int a = (p>>24)&0xff;
	                  int r = (p>>16)&0xff;
	                  int g = (p>>8)&0xff;
	                  int b = p&0xff;
	                  int avg = (r+g+b)/3;
	                  p = (a<<24) | (avg<<16) | (avg<<8) | avg;
	                  image.setRGB(x, y, p);
	              }
	          }
		}else {
			
			try {
				image = ImageIO.read(new File("src/paket/koen-eijkelenboom-353684-unsplash-2-400x400.jpg"));
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
	        JLabel imgLabel = (JLabel)this.container.getComponent(0);
			imgLabel.setIcon(new ImageIcon(image));
	 }
		
			
   }
		


