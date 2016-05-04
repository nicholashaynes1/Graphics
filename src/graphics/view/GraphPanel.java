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
		valuesToGraph = new int []{100,5,6,7};
		setupPanel();

	}

	private void setupPanel()
	{
	
		
		
	}

		
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;

		for(int index = 0; index < valuesToGraph.length; index++)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int windowHeight = this.getHeight();
			int windowWidth = this.getWidth();
			int xPos = 0;
			int height = (int) (windowHeight/valuesToGraph.length);
			int yPos = (int) (index * height);
			int width = (int) valuesToGraph[index];
			
			
			mainGraphics.setColor(new Color(red, green, blue));
			
			mainGraphics.fill(new Rectangle(xPos,yPos,width,height));
		}
		
	}
}


