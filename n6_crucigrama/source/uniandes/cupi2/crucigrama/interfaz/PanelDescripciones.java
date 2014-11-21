package uniandes.cupi2.crucigrama.interfaz;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDescripciones extends JPanel {

	
	// ----------------------------------------------------------------
	// Atributos de la interfaz 
	// ----------------------------------------------------------------
	
	/**
	 * Etiqueta para mostrar las descripciones verticales
	 */
	private JLabel etiquetaV;
	
	/**
	 * Panel para las decripciones horizontales
	 */
	private JPanel horizontales;
	
	/**
	 * Panel para las descripciones verticales
	 */
	private JPanel verticales;
	

	// ----------------------------------------------------------------
	// Constructor 
	// ----------------------------------------------------------------
	public PanelDescripciones(String[] palH, String[] palV)
	{
		setLayout(new GridLayout(2,1));
		
		// Configura el panel horizontales
		TitledBorder tituloH = BorderFactory.createTitledBorder("Horizontales");
		horizontales.setBorder(tituloH);
		horizontales.setLayout(new GridLayout(palH.length,1));
		
		for (int i = 0; i < palH.length; i++) {
			
			JLabel etiquetaH = new JLabel(palH[i]);
			horizontales.add(etiquetaH);	
		}
		
		// Configura el panel verticales 
		TitledBorder tituloV = BorderFactory.createTitledBorder("Verticales");
		verticales.setBorder(tituloV);
		verticales.setLayout(new GridLayout(palV.length,1));
		
		for (int j = 0; j < palV.length; j++) {
			
			JLabel etiquetaH = new JLabel(palH[j]);
			verticales.add(etiquetaH);	
		}
		
	}
	
	
}
