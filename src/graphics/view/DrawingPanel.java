package graphics.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

import graphics.controller.GraphicsController;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private JButton rectangleButton;
	private JButton squareButton;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		shapePanel = new ShapePanel();
		squareButton = new JButton("add a square bruh");
		shapePanel.add(squareButton);
		
		rectangleButton = new JButton("add a rectangle up in hurr yo");
		shapePanel.add(rectangleButton);
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		
		this.setBackground(Color.CYAN);
		this.add(shapePanel);
		

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 180, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -46, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -20, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -20, SpringLayout.EAST, this);

	}

	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				shapePanel.addRect();
				
			}
		});

		
		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				
				shapePanel.addSquare();
			}
		});
	
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				
			}
			public void mouseDragged(MouseEvent dragged)
			{
				int xPos = dragged.getX();
				int yPos = dragged.getY();
			}
		});
	
	}


}
