package meusrobos;
import robocode.*;
import java.awt.Color;

/**
 * MeuPrimeiroRoboMovimentacao - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboMovimentacao extends Robot
{
	public void run() {
		setScanColor(Color.YELLOW);
		
		while(true) {
			//ahead(100);
			//back(100);
			//fire(1);
			
			//ahead(100);
			//turnLeft(90);
			//ahead(100);
			//turnRight(100);

			//ahead(100);
			//turnRadarLeft(180);
			//back(100);
			//turnRadarRight(180);
			
			//ahead(100);
			//turnGunLeft(360);
			//back(100);
			//turnGunRight(360);
			
			//setAdjustGunForRobotTurn(true);
			//setAdjustGunForRobotTurn(false);
			//setAdjustRadarForRobotTurn(true);
			//setAdjustRadarForRobotTurn(false);
			//ahead(100);
			//turnLeft(90);
			//back(100);
			//fire(1);

			//setAdjustRadarForGunTurn(true);
			setAdjustRadarForGunTurn(false);
			ahead(100);
			turnGunLeft(90);
			fire(1);
			back(100);
			turnGunRight(90);
			fire(1);			
		}
	}

}
