package algoGeo;

import java.awt.Graphics2D;

import affichage.VisiblePoint;

import java.math.*;

public class Triangle {
	VisiblePoint sommets[];
	String label;
	
	public Triangle() {
		sommets = new VisiblePoint[3];
	}

	public Triangle(VisiblePoint p1, VisiblePoint p2, VisiblePoint p3, String l) {
		sommets = new VisiblePoint[3];
		sommets[0] = p1;
		sommets[1] = p2;
		sommets[2] = p3;
		label = l;
	}
	
	public void add(VisiblePoint p) {
		int j= 0;
		for (int i = 0; i<sommets.length; i++)
			if (sommets[i]!= null) j++;
		if (j< 3) sommets[j] = p;
	}
	
	public void dessine(Graphics2D g) {
		g.drawLine((int) sommets[0].x , (int) sommets[0].y , (int) sommets[1].x, (int) sommets[1].y);
		g.drawLine((int) sommets[0].x , (int) sommets[0].y , (int) sommets[2].x, (int) sommets[2].y);
		g.drawLine((int) sommets[2].x , (int) sommets[2].y , (int) sommets[1].x, (int) sommets[1].y);
		for (int i = 0; i<sommets.length; i++)
			sommets[i].dessine(g);
	}
	
	public double aire() {
		double a, b, c, a;
		
		a = Math.sqrt(Math.pow(sommets[1].x - sommets[0].x,2) + Math.pow(sommets[1].y - sommets[0].y,2));
		b = Math.sqrt(Math.pow(sommets[2].x - sommets[1].x,2) + Math.pow(sommets[2].y - sommets[1].y,2));
		c = Math.sqrt(Math.pow(sommets[2].x - sommets[0].x,2) + Math.pow(sommets[2].y - sommets[0].y,2));
		
		
		
		
		
		return a;
	}
	
	public VisiblePoint centreCirconscrit() {
		double a, b, c;
		VisiblePoint p = new VisiblePoint(0,0);
		
		a = Math.sqrt(Math.pow(sommets[1].x - sommets[0].x,2) + Math.pow(sommets[1].y - sommets[0].y,2));
		b = Math.sqrt(Math.pow(sommets[2].x - sommets[1].x,2) + Math.pow(sommets[2].y - sommets[1].y,2));
		c = Math.sqrt(Math.pow(sommets[2].x - sommets[0].x,2) + Math.pow(sommets[2].y - sommets[0].y,2));
		
		
		
		
		
		return p;
	}
}

