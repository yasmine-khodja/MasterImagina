import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				int x = 10, y = 10, w = 800, h = 600;
				String fileName = "data/Trioker/test.csv";
				JFrame frame = new JFrame("Transformations dans le plan");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Vue v1, v2;
				v1 = new Vue(w, h, fileName, false);
				v1.setBorder(BorderFactory.createLineBorder(Couleur.fg) );
				v2 = new Vue(w, h, fileName, true);
				v2.setBorder(BorderFactory.createLineBorder(Couleur.fg) );
				frame.add(v1);
				frame.add(v2, BorderLayout.EAST);
				frame.pack();
				frame.setLocation(x, y);
				frame.setVisible(true);
			}});

	}

}
