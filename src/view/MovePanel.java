package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import global.Constants.EMovePanel;

public class MovePanel extends JPanel {
	private static final long serialVersionUID = EMovePanel.serialVersionUID.getInt();
	private JButton leftButton;
	private JButton rightButton;
	private JButton skiptLeftButton;
	private JButton skipRightButton;
	
	
	//ActionHandler getSource()
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}
	
	public JButton getskiptLeftButton() {
		return skiptLeftButton;
	}

	public JButton getskipRightButton() {
		return skipRightButton;
	}

	public MovePanel(ActionListener actionHandler) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(Box.createVerticalStrut(100)); 
		
		skiptLeftButton = new JButton(EMovePanel.skipLeft.getString());
		skiptLeftButton.setActionCommand(EMovePanel.skipLeftBtn.getString());
		skiptLeftButton.addActionListener(actionHandler);
		panel.add(skiptLeftButton);
		
		panel.add(Box.createVerticalStrut(5)); 

		leftButton = new JButton(EMovePanel.left.getString());
		leftButton.setActionCommand(EMovePanel.leftBtn.getString());
		leftButton.addActionListener(actionHandler);
		panel.add(leftButton);
		
		panel.add(Box.createVerticalStrut(60)); 
		
	
		rightButton = new JButton(EMovePanel.right.getString());
		rightButton.setActionCommand(EMovePanel.rightBtn.getString());
		rightButton.addActionListener(actionHandler);
		panel.add(rightButton);
		
		panel.add(Box.createVerticalStrut(5)); 

		skipRightButton = new JButton(EMovePanel.skipRight.getString());
		skipRightButton.setActionCommand(EMovePanel.skipRightBtn.getString());
		skipRightButton.addActionListener(actionHandler);
		panel.add(skipRightButton);
		
		this.add(panel);
		this.setVisible(true); 	
	}
	
	public void initialize() {
	}
}
