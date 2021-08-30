package meusrobos.avancados;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import robocode.*;

/**
 * MeuPrimeiroRoboAvancado - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboAvancadoArq extends AdvancedRobot {

    EstatisticasTiro estatisticasTiro;

    @Override
    public void run() {
        estatisticasTiro = new EstatisticasTiro();

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
    public void onBulletHit(BulletHitEvent event) {
        estatisticasTiro.acertos++;
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        estatisticasTiro.erros++;

    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        estatisticasTiro.colisoes++;
    }

    @Override
    public void onBattleEnded(BattleEndedEvent event) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new RobocodeFileOutputStream(getDataFile("estatisticas.dat")));
            printStream.println("Estatísticas de Tiro");
            printStream.println("====================");
            printStream.println("Acertos: " + estatisticasTiro.getAcertos());
            printStream.println("Erros: " + estatisticasTiro.getErros());
            printStream.println("Colisões de tiro: " + estatisticasTiro.getColisoes());
        } catch (IOException ex) {
            Logger.getLogger(MeuPrimeiroRoboAvancadoArq.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(printStream != null)
                printStream.close();
        }
    }

    class EstatisticasTiro {

        private int acertos;
        private int erros;
        private int colisoes;

        public int getAcertos() {
            return acertos;
        }

        public void setAcertos(int acertos) {
            this.acertos = acertos;
        }

        public int getErros() {
            return erros;
        }

        public void setErros(int erros) {
            this.erros = erros;
        }

        public int getColisoes() {
            return colisoes;
        }

        public void setColisoes(int colisoes) {
            this.colisoes = colisoes;
        }

    }
}
