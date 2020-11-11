package semana6;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;
import javax.swing.JPanel;

public class Interface {

	private JFrame frame;
	private JMapViewer mapa;  //creo esta variabe para usar JMapViewer
	private JPanel panelMapa;
//cd	private JPanel panelControles;
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
		frame.getContentPane().setLayout(null); 
		frame.setTitle("JMap Viever");
		
		
		panelMapa = new JPanel();
		panelMapa.setBounds(0, 0, 340, 217);
		frame.add(panelMapa);
		
		
		
		//Creo el JMap
		mapa = new JMapViewer();
		
		//Esto es para que no muestre la barra de zoom
		mapa.setZoomControlsVisible(false);
		
		//agrego coordenada para que el mapa aparezca ahi
		//coordenadas y zoom para que se fije en la universidad
		Coordinate coordinate = new Coordinate(-34.521,-58.719);
		mapa.setDisplayPosition(coordinate, 12);
		
		//agregamos un marcador
		MapMarker marker1 = new MapMarkerDot("Aqui",coordinate);
		marker1.getStyle().setBackColor(Color.red);
		marker1.getStyle().setBackColor(Color.orange);
		mapa.addMapMarker(marker1);
		
		//agregamos otro
		MapMarker marker2 = new MapMarkerDot(-34.546,-58.719);
		marker2.getStyle().setBackColor(Color.blue);
		marker2.getStyle().setBackColor(Color.blue	);
		mapa.addMapMarker(marker2);
		
		//para agregar una linea hay que usar un objeto tipo poligono
		//Un poligono se define con un array de coordenadas
		ArrayList<Coordinate> coordenadas = new ArrayList<Coordinate>();	
		coordenadas.add(new Coordinate(-34.521,-58.708));
		coordenadas.add(new Coordinate(-34.546,-58.702));
		coordenadas.add(new Coordinate(-34.523,-58.703));
		coordenadas.add(new Coordinate(-34.559,-58.704));
		coordenadas.add(new Coordinate(-34.522,-58.705));
		
		MapPolygon polygon = new MapPolygonImpl(coordenadas);
		mapa.addMapPolygon(polygon);
		
		//Agrego el JMap al frame
		panelMapa	.add(mapa);
		mapa.setLayout(null);
		
		
	}
}
