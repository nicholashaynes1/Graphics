package graphics.view;

import graphics.controller.GraphicsController;

import javax.swing.JFrame;

public class DrawingFrame extends JFrame
{
	private GraphicsController baseController;
	private DrawingPanel basePanel;
	
	public DrawingFrame(GraphicsController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		
		setupFrame();
	
	}


	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(800,800);
		this.setVisible(true);
		
	}



}
