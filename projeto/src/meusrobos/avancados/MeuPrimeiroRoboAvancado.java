package meusrobos.avancados;

import robocode.*;

/**
 * MeuPrimeiroRoboAvancado - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboAvancado extends AdvancedRobot {

    @Override
    public void run() {
        while (true) {
            setAhead(100);
            setTurnRight(90);
            execute();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        setFire(1);
        execute();
    }

    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        setBack(10);
        execute();
    }

    @Override
    public void onHitWall(HitWallEvent e) {
        setBack(20);
        execute();
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        out.println("O robô bateu em: " + event.getName());
    }
    
    
}
