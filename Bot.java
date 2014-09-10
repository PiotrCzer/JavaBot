
/*Robot class pixel search
 *Author@Piotr Cz.
 *Date - 08/10/12
 *Bot.java
 *A WIP Java bot with the purpose of searching pixel color location on screen
 *and scanning after finding them if they moved
 */

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Bot{
	public static void main ( String[] args ) throws Exception{

		//Object
		Robot robot = new Robot();

		/*
		robot.mouseMove(1366, 768);
		robot.mousePress();
		robot.delay(1000);
		*/

		//Capture area of the screen
		Rectangle rectangle = new Rectangle( Toolkit.getDefaultToolkit().getScreenSize() );

  		//Take the screenshot
		BufferedImage img = robot.createScreenCapture( rectangle );

		//Specify pixel color
		Color target = new Color(0, 255, 0);//Placeholder

		//Variables and constructor
		int originalX, originalY;

		originalX = 0;
		originalY = 0;


		//Search for the pixel's location
		search: for(int x = 0; x < rectangle.getWidth(); x++ )
		        {
		            for(int y = 0; y < rectangle.getHeight(); y++ )
		            {
		                if(img.getRGB(x, y) == target.getRGB() )
		                {
		                originalX = x;
		                originalY = y;
                    		break search;
				}
			     }
			}

		//Search for a change in the pixel's location
		change: for(int x = 0; x < rectangle.getWidth(); x++ )
		        {
		            for(int y = 0; y < rectangle.getHeight(); y++ )
		            {
		                if(img.getRGB(x, y) == target.getRGB() )
		                {
					if(originalX != x && originalY != y)
						{
						robot.mouseMove(x, y);
						break change;
						}
					}
				}
			}

		//Command the robot to do the job(Placeholder)

	}
}
