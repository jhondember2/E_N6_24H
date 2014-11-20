package uniandes.cupi2.crucigrama.interfaz;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

/**
 * Interfaz crucigrama
 * @author Alejandro Parra 
 *
 */
public class InterfazCrucigrama extends JFrame  {
	

	// ----------------------------------------------------------------
	// Atributos de la interfaz
	// ----------------------------------------------------------------
	
	/**
	 * Panel con las acciones
	 */
	private PanelAcciones acciones;
	
	/**
	 * Panel con las descripciones
	 */
	private PanelDescripciones descripciones;
	
	/**
	 * Panel con la imagen del banner
	 */
	private PanelImagen imagen;
	
	/**
	 * Panel con el tablero
	 */
	private PanelTablero tablero;
	
	
	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
	public InterfazCrucigrama() throws Exception
	{
		
		
		// Configura la informacion de la ventana 
		setTitle("Crucigrama");
		setSize(775,775);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		
		
		// Crea los paneles
		acciones = new PanelAcciones(this);
		descripciones = new PanelDescripciones();
		imagen = new PanelImagen();
		tablero = new PanelTablero();
		
		// Adiciona los componentes graficos al panel 
		add(acciones, BorderLayout.SOUTH);
		add(descripciones, BorderLayout.WEST);
		add(imagen, BorderLayout.NORTH);
		add(tablero, BorderLayout.EAST);
	
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			InterfazCrucigrama interfaz = new InterfazCrucigrama();
			interfaz.setVisible(true);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
