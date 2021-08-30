package meusrobos.avancados;

import robocode.AdvancedRobot;
import robocode.Condition;
import robocode.CustomEvent;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 *
 * @author Anderson
 */
public class MeuPrimeiroRoboAvancadoCust extends AdvancedRobot {

    boolean inverteDirecao;
    boolean foiAtingido;
    boolean bateuNaParede;

    @Override
    public void run() {
        while (true) {
            if (inverteDirecao) {
                setAhead(100);
                setTurnRight(90);
                setTurnGunLeft(90);
                execute();
            } else {
                setBack(100);
                setTurnLeft(90);
                setTurnGunRight(90);
                execute();
            }
            
            addCustomEvent(new Condition("bateuNaParedeEFoiAtingido") {
                @Override
                public boolean test() {
                    if (bateuNaParede && foiAtingido) {
                        bateuNaParede = false;
                        foiAtingido = false;
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        setFire(2);
        execute();
    }

    @Override
    public void onCustomEvent(CustomEvent event) {
        if (event.getCondition().getName().equals("bateuNaParedeEFoiAtingido")) {
            onBateuNaParedeEFoiAtingido();
        }
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        bateuNaParede = true;
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        foiAtingido = true;
    }

    private void onBateuNaParedeEFoiAtingido() {
        inverteDirecao = !inverteDirecao;
    }

}
