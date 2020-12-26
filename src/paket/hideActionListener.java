package paket;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class hideActionListener implements ActionListener {

	private Container container;
	// constructor to class hideActionListener.
	public hideActionListener(Container container) {
		this.container = container;
	}
	// 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Image hide / show button.
		JLabel imgLabel = (JLabel)this.container.getComponent(0);
		imgLabel.setVisible(!imgLabel.isVisible());
		
		JPanel panel = (JPanel)this.container.getComponent(1);
		JButton btn = (JButton)panel.getComponent(2);
		btn.setText(imgLabel.isVisible() ? "Hide" : "Show");
	}
}
