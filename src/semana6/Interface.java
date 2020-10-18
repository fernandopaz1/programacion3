package semana6;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class Interface {

	private JFrame frame;
	private JMapViewer mapa;  //creo esta variabe para usar JMapViewer
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JMap Viever");
		
		mapa = new JMapViewer();
		
		frame.getContentPane().add(mapa);
	}

}
