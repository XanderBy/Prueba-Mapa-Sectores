package v;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import m.MetodosRegilla;

public class Pantalla extends JFrame implements Runnable {
	private boolean corriendo=false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private Canvas canvas;
	
	public Pantalla() {
		configuradorPantalla();
	}
	
	public void configuradorPantalla() {
		this.setTitle("Prueba Cuadrante");
		this.setSize(800, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas=new Canvas();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		add(canvas);
	}
	public void draw() {
		bs=canvas.getBufferStrategy();
		
		if(bs==null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, 800, 800);
		System.out.println("Hola");
		
		MetodosRegilla.Regilla(g);
		
		g.dispose();
		bs.show();
		
	}
	public void update() {
		
	}
	public void run() {
		while(this.corriendo){
			System.out.println("Hola");
			update();
			draw();
		}
		stop();
	}
	public void stop() {
		try {
			thread.join();
			this.corriendo=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start() {
		thread=new Thread(this);
		thread.start();
		this.corriendo=true;
	}
	
}
