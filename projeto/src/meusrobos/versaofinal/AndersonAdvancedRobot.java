package meusrobos.versaofinal;

import java.awt.Color;
import robocode.*;

/**
 *
 * @author Anderson
 */
public class AndersonAdvancedRobot extends AdvancedRobot {

    boolean inverteDirecao;

    @Override
    public void run() {
        setColors(Color.BLACK, Color.YELLOW, Color.RED, Color.YELLOW, Color.BLACK);

        // Movimento
        while (true) {
            if (inverteDirecao) {
                setAhead(100);
                setTurnRight(90);
                setTurnGunLeft(90);
            } else {
                setBack(100);
                setTurnLeft(90);
                setTurnGunRight(90);
            }
            execute();
        }
    }

    // Meus métodos    
    private void atirar() {
        if (getEnergy() > 50) {
            setFire(3);
        } else if (getEnergy() > 25 && getEnergy() <= 50) {
            setFire(2);
        } else if (getEnergy() < 25) {
            setFire(1);
        }
        execute();
    }

    private void inverterDirecao() {
        inverteDirecao = !inverteDirecao;
    }

    private void log(String s) {
        out.println(s);
    }

    private void sairColisaoParede(Double bearing) {
        double x = this.getX(),
                y = this.getY(),
                larguraRobo = this.getWidth(),
                alturaRobo = this.getHeight(),
                larguraArena = this.getBattleFieldWidth(),
                alturaArena = this.getBattleFieldHeight();

        if (x == (larguraRobo / 2)
                || (y == (alturaRobo / 2))
                || (alturaArena == (alturaRobo / 2 + y))
                || (larguraArena == (larguraRobo / 2 + x))) {
            double novaPosicao = bearing + bearing;
            setTurnLeft(novaPosicao);
            setAhead(100);
            execute();
        }
    }

    // Eventos
    @Override
    public void onBulletHit(BulletHitEvent event) {
        log("Você atingiu o robô " + event.getName() + " ele possuí " + event.getEnergy() + " restante.");
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        Bullet b = event.getHitBullet();
        log("Colisão da bala do robô " + b.getName() + " com a sua bala na posição (" + b.getX() + ", " + b.getY() + ")");
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        Bullet b = event.getBullet();
        log("Sua bala não acertou nenhum oponente e bateu em (" + b.getX() + ", " + b.getY() + ").");
    }

    @Override
    public void onDeath(DeathEvent event) {
        log("Você morreu.");
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        log("O robô " + event.getName() + " atingiu você em " + event.getBearing() + " com poder de " + event.getPower() + " e velocidade de " + event.getVelocity() + ".");
        inverterDirecao();
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        log("O seu robô colidiu com " + event.getName() + " em " + event.getBearing() + " deixando-o com " + event.getEnergy());

        // Se estiver na nossa frente
        if (event.getBearing() > -90 && event.getBearing() < 90) {
            back(100);
        } else {
            ahead(100);
        }
        inverterDirecao();
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        log("O robô colidiu na parede em " + event.getBearing() + " na posição (" + this.getX() + "," + this.getY() + ").");
        sairColisaoParede(event.getBearing());
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        log("O robô " + event.getName() + " morreu.");
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        log("O scanner encontrou o robô " + event.getName() + " a uma distância de " + event.getDistance() + " pixels, velocidade de " + event.getVelocity() + " na direção " + event.getBearing());
        atirar();
    }

    @Override
    public void onWin(WinEvent event) {
        log("Venci a batalha!");
        for (int i = 0; i < 50; i++) {
            turnRight(45);
            turnLeft(45);
        }
    }

    @Override
    public void onBattleEnded(BattleEndedEvent event) {
        log("PosiÃ§Ã£o do ranking: " + event.getResults().getRank());
    }

    @Override
    public void onRoundEnded(RoundEndedEvent event) {
        log(" O round terminou " + event.getRound());
    }

}
