package uniandes.cupi2.crucigrama.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
	
	// ----------------------------------------------------------------
	// Atributos de la interfaz 
	// ----------------------------------------------------------------
	
	/**
	 * Atributo de la etiqueta que contiene la imagen
	 */
	private JLabel imagen;
	
	// ----------------------------------------------------------------
	// Constructores  
	// ----------------------------------------------------------------
	
	/**
	 * Constructor de la clase
	 */
	public PanelImagen()
	{
		setLayout( new GridLayout(1,1));
		
		imagen = new JLabel( new ImageIcon("../n6_crucigrama/data/imagenes/banner.jpg"));
		add(imagen);
		
	}
	
	


}
