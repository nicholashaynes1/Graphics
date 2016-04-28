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
	private ShapePanel shapePanel;
	private GraphPanel graphPanel;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private SpringLayout baseLayout;

	private ArrayList<Rectangle> rectList;

	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();

		shapePanel = new ShapePanel();
		graphPanel = new GraphPanel();
		
		

		squareButton = new JButton("add a square bruh");
		rectangleButton = new JButton("add a rectangle up in hurr yo");

		triangleButton = new JButton("TRRIIIIIIIANGLE");
		polygonButton = new JButton("Polygons bruh");
		
		circleButton = new JButton("it must be circ de sol eh with all the circles up in the shiz");
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		ellipseButton = new JButton("freaking ellipses sooooonnnnnnnn!!!!!!!!");

		rectList = new ArrayList<Rectangle>();

		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setBackground(Color.CYAN);
		graphPanel.setBackground(Color.ORANGE);
		this.add(shapePanel);
		this.add(graphPanel);
		this.add(squareButton);
		this.add(rectangleButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(circleButton);
		this.add(ellipseButton);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 700, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -400, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -100, SpringLayout.EAST, polygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -890, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -400, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, polygonButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, squareButton, 0, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, squareButton, 6, SpringLayout.EAST, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 0, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 158, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 6, SpringLayout.SOUTH, squareButton);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 129, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, rectangleButton, -116, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 93, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, circleButton, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -9, SpringLayout.NORTH, circleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -6, SpringLayout.NORTH, squareButton);
		baseLayout.putConstraint(SpringLayout.EAST, ellipseButton, -65, SpringLayout.EAST, this);
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

		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addTriangle();
			}
		});

		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addPolygon();
			}
		});

		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addCircle();
			}
		});

		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addEllipse();
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
