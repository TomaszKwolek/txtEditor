package handlingExceptions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ExceptionFrame extends JFrame{
	
	private JLabel label = new JLabel("");
	private JButton button = new JButton("OK");
	
	public ExceptionFrame(String message){
		super("txtEditor");
		setDefaultCloseOperation(ExceptionFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(new Dimension(250, 100));
		setLocationRelativeTo(null);
		
		
		setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		label.setAlignmentX(CENTER_ALIGNMENT);
		button.setAlignmentX(CENTER_ALIGNMENT);
		add(label);
		add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setMessage(message);
	}
	
	private void setMessage(String message) {
		label.setText(message);
		label.setForeground(Color.BLACK);
	}
	
	
}
