package meusrobos;
import robocode.*;
/**
 * MeuPrimeiroRoboEventos - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboEventos extends Robot
{
	int tirosFalhos = 0;
	
	public void run() {
		while(true) {
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
			
			// Colidir com a parede
			//ahead(400);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
		//fire(2);
		//fire(3);
	}
/*	
	public void onHitWall(HitWallEvent e) {
		back(10);
		turnLeft(10);
		ahead(10);
	}
	
	public void onHitRobot (HitRobotEvent event){
		ahead(100);	
	}
	
	public void	onHitByBullet (HitByBulletEvent event)  {
		stop();
		turnGunRight(360);
		turnLeft(90);
		ahead(100);
		turnRight(10);
		back(200);
	}
	*/
	public void onBulletMissed (BulletMissedEvent event){   
		System.out.println("Errou o tiro :(");
		tirosFalhos++;
	}
	
	public void onBulletHit(BulletHitEvent event){ 
		out.println("Acertei o robô " + event.getName());
	}
	
	public void onRobotDeath(RobotDeathEvent event) {
		out.println("Mais um pro caixão B)");
	}
	
	public void onWin(WinEvent event) {
		out.println("Build the best! Destroy the rest!");
		out.println("Tiros falhos: " + tirosFalhos);
	}
	
	public void	onDeath(DeathEvent event) {
		out.println("Faleci :(");
	}

}
