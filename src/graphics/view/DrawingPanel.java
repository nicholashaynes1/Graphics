package graphics.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import graphics.controller.GraphicsController;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private JButton rectangleButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		rectangleButton = new JButton("add a rectangle up in hurr yo");
		
		rectangleList = new ArrayList<Rectangle>();
		
		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rectangleButton);
		this.setBackground(Color.CYAN);

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
				int xPos = (int)(Math.random()* getWidth());
				int yPos = (int)(Math.random()* getHeight());
				int width = (int)(Math.random()* 100);
				int height = (int)(Math.random()*100);
				
				rectangleList.add(new Rectangle(xPos, yPos, width, height));
				
				repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);

		Graphics2D mainGraphics = (Graphics2D) currentGraphics;

		mainGraphics.setStroke(new BasicStroke(10));
		mainGraphics.setColor(Color.DARK_GRAY);

		mainGraphics.drawRect(100, 300, 200, 100);
		
		
		
		for(Rectangle current: rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
		
	}
}
