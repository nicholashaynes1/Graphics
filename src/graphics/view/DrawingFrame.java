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
		this.setSize(1000,1000);
		this.setTitle("HAIL SATAN!");
		this.setVisible(true);
		
	}



}
