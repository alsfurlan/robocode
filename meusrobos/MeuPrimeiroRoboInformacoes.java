package meusrobos;
import robocode.*;
/**
 * MeuPrimeiroRoboInformacoes - a robot by Anderson Luís Furlan
 */
public class MeuPrimeiroRoboInformacoes extends Robot
{
	public void run() {
		while(true) {
			ahead(400);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	public void onHitWall(HitWallEvent e) {
		double x = this.getX(),
			   y = this.getY(),
			   larguraRobo = this.getWidth(),
			   alturaRobo  = this.getHeight(),
			   larguraArena = this.getBattleFieldWidth(),
			   alturaArena  = this.getBattleFieldHeight();

		out.println("X: " + x);		
		out.println("Y: " + y);	
		out.println("Largura Robô: " + larguraRobo);
		out.println("Altura Robô: " + alturaRobo);
		out.println("Largura Arena: " + larguraArena);		
		out.println("Altura Arena: " + alturaArena);
		out.println("====================");
		/*
		if(larguraArena == (larguraRobo/2 + x)) {
			out.println("Robô bateu na borda direita da Arena");
		}
		
		if(alturaArena == (alturaRobo/2 + y)) {
			out.println("Robô bateu na borda superior da Arena");
		}
		
		if(x == (larguraRobo/2)) {
			out.println("Robô bateu na borda direita da Arena");	
		}	
		
		if(y == (alturaRobo/2)) {
			out.println("Robô bateu na borda inferior da Arena");	
		}
		*/
		/*
		if(larguraArena == (larguraRobo/2 + x)) {
			out.println("Robô bateu na borda direita da Arena");
			turnLeft(90);
			ahead(50);
			turnLeft(90);
		}
		
		if(alturaArena == (alturaRobo/2 + y)) {
			out.println("Robô bateu na borda superior da Arena");
			turnLeft(90);
			ahead(50);
			turnLeft(90);
		}
		
		if(x == (larguraRobo/2)) {
			out.println("Robô bateu na borda direita da Arena");			
			turnLeft(90);
			ahead(50);
			turnLeft(90);
		}	
		
		if(y == (alturaRobo/2)) {
			out.println("Robô bateu na borda inferior da Arena");			
			turnLeft(90);
			ahead(50);
			turnLeft(90);
		}*/
		
		/*
		if(larguraArena == (larguraRobo/2 + x)  ||
		   alturaArena == (alturaRobo/2 + y)	||
		   x == (larguraRobo/2) ||
		   y == (alturaRobo/2)    	
		) {
			turnLeft(45);
			ahead(100);
		}*/	
		
		if(larguraArena == (larguraRobo/2 + x)  ||
		   alturaArena == (alturaRobo/2 + y)	||
		   x == (larguraRobo/2) ||
		   y == (alturaRobo/2)    	
		) {
			sairColisaoParede();
		}
	}
	
	private void sairColisaoParede() {
		turnLeft(45);
		ahead(100);
	}
	

}
