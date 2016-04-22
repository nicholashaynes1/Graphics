package graphics.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import graphics.controller.GraphicsController;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private JButton rectangleButton;
	private SpringLayout baseLayout;
	
	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		rectangleButton = new JButton();
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rectangleButton);
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 180, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -46, SpringLayout.SOUTH, this);
		
	}

	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				
			}
		});
		
	}

}
