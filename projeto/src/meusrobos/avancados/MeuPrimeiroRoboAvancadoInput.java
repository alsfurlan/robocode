package meusrobos.avancados;

import robocode.*;

/**
 * MeuPrimeiroRoboAvancado - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboAvancadoInput extends AdvancedRobot {

    @Override
    public void run() {
        while (true) {
            
            setAhead(1);
            execute();
        }
    }

    @Override
    public void onKeyPressed(java.awt.event.KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'w':
                setAhead(10);
                break;
            case 's':
                setBack(10);
                break;
            case 'a':
                setTurnLeft(10);
                break;
            case 'd':
                setTurnRight(10);
                break;
        }
        execute();
    }

    @Override
    public void onMouseClicked(java.awt.event.MouseEvent e) {
        setFire(1);
        execute();
    }

}
