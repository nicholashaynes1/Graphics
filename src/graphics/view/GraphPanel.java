package graphics.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private ArrayList<Rectangle> rectList;
	private int[] valuesToGraph;

	public GraphPanel()
	{
		valuesToGraph = new int [4];

	}

	public void createGraph()
	{

		for(int index = 0; index < valuesToGraph.length; index++)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			
			int xPos = (int) (0 * getWidth());
			int yPos = (int) (index * getHeight());
			int width = (int) (index);
			int height = (int) (30);
			
		}
		
	}
}


