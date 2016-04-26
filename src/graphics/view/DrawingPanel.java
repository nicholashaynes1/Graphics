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
	private ArrayList<Rectangle> rectList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();

		shapePanel = new ShapePanel();
		squareButton = new JButton("add a square bruh");
		shapePanel.add(squareButton);

		rectangleButton = new JButton("add a rectangle up in hurr yo");
		shapePanel.add(rectangleButton);

		rectList = new ArrayList<Rectangle>();

		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);

		this.setBackground(Color.CYAN);
//		this.add(shapePanel);

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

				int width = (int) (Math.random() * 100);
				int height = (int) (Math.random() * 100);

				rectList.add(new Rectangle(xPos, yPos, width, height));
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

		for (Rectangle current : rectList)
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.fill(current);
		}

	}

}
