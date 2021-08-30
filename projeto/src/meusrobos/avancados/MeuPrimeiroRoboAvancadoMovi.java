package meusrobos.avancados;

import robocode.*;

/**
 * MeuPrimeiroRoboAvancado_Movimentacao - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboAvancadoMovi extends AdvancedRobot {

    @Override
    public void run() {

        while (true) {
//            Exemplo 1
//            setAhead(100);
//            setTurnRight(90);
//            execute();

//            Exemplo 2
//            setAhead(100);
//            setTurnLeft(90);
//            setTurnGunRight(90);
//            execute();
//            Exemplo 3 - Problemas! Executando somente as duas últimas instruções
//            setAhead(100);
//            setTurnLeft(180);
//            setBack(100);
//            setTurnRight(180);
//            execute();
//            Exemplo 4 - Mais problemas
//            setAhead(100);
//            setTurnLeft(180);
//            execute();
//            setBack(100);
//            setTurnRight(180);
//            execute();
//            Exemplo 5 - Solucionando com waitFor()
//            setAhead(100);
//            setTurnLeft(180);
//            waitFor(new TurnCompleteCondition(this));
//            setBack(100);
//            setTurnRight(180);
//            waitFor(new TurnCompleteCondition(this));

//            Exemplo 6
            setAhead(100);
            setTurnLeft(180);
            waitFor(new MoveCompleteCondition(this));
            setBack(100);
            setTurnRight(180);
            waitFor(new MoveCompleteCondition(this));            
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
}
