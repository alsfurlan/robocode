package meusrobos.basicos;
import robocode.*;
import java.awt.Color;

/**
 * MeuPrimeiroRobo_Aparencia - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboAparencia extends Robot
{
	public void run() {
		//setBodyColor(Color.BLACK);
 	    //setGunColor(Color.YELLOW);
		//setRadarColor(Color.GREEN);
		//setBulletColor(Color.CYAN);
		//setScanColor(Color.RED);
		
		//setAllColors(Color.CYAN);
		//setColors(Color.BLUE, Color.ORANGE, Color.MAGENTA);
		setColors(Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.PINK, Color.GRAY);			 
		
		while(true) {
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
