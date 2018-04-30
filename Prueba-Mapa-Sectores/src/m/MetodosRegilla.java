package m;

import java.awt.Color;
import java.awt.Graphics;

public class MetodosRegilla {
	
	public static void Regilla(Graphics g) {
		int matriz[][]=new int [10][10];
		int cont = 0,contY=0;
		for (int i = 0; i < matriz.length; i++) {
			
			for (int j = 0; j < matriz.length; j++) {
				g.setColor(Color.red);
				g.drawRect(cont, contY, 80, 80);
				cont=cont+80;
				if(j==9) {
					contY=contY+80;
					cont=0;
				}
				System.out.println("Hola1");
			}
		}
	}
}
