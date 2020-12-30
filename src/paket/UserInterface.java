package paket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserInterface {
	public JFrame frame;
	
	// creates an interface for the app "Image Manager".
	public UserInterface() {
		frame = new JFrame("Image manager");
		frame.setPreferredSize(new Dimension(400, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);	
	}
	// this method creates all the necessary components for the app.
	public void createComponents(Container contentPane) {
		contentPane.setLayout(new BorderLayout());
		try {
			BufferedImage image = ImageIO.read(new File("src/paket/koen-eijkelenboom-353684-unsplash-2-400x400.jpg"));
			JLabel imageLabel = new JLabel();
			imageLabel.setIcon(new ImageIcon(image));
			contentPane.add(imageLabel, BorderLayout.NORTH);
			
			JPanel btnPanel = new JPanel();
			btnPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
			
			JButton btnZoom = new JButton("Zoom in/out");
			JButton btnColor = new JButton("Color");
			JButton btnHide = new JButton("Hide");
			JButton btnNegativeColor = new JButton("Negative Color");
			
			btnPanel.add(btnZoom);
			btnPanel.add(btnColor);
			btnPanel.add(btnHide);
			btnPanel.add(btnNegativeColor);
			
			contentPane.add(btnPanel, BorderLayout.SOUTH);
			
			// creates an objects for each button and adds an action lisntener.
			btnZoom.addActionListener(new zoomActionListener(contentPane, image));
			btnColor.addActionListener(new colorActionListener(contentPane, image));
			btnHide.addActionListener(new hideActionListener(contentPane));
			btnNegativeColor.addActionListener(new negativeActionListener(contentPane, image));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
