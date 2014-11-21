package uniandes.cupi2.crucigrama.interfaz;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.crucigrama.mundo.Crucigrama;

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
	
	// Asociación con el mundo 
	
	private Crucigrama mundo;
	
	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
	public InterfazCrucigrama() throws Exception
	{
		
		
		
		/*JFileChooser fc = new JFileChooser("./data");
		fc.setDialogTitle("Abrir el archivo de crucigrama");
		fc.showOpenDialog(this);
		File archivoCrucigrama = fc.getSelectedFile();
		
		if( archivoCrucigrama != null)
		{
			
			try {
				
				mundo = new Crucigrama(archivoCrucigrama);
				
			} catch (Exception e) {
				// TODO: handle exception
				
				JOptionPane.showMessageDialog(this, "Error al cargar el archivo", "Error", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				
				
			}
			*/
			// Configura la informacion de la ventana 
			setTitle("Crucigrama");
			setSize(775,700);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout( new BorderLayout());
			setLocationRelativeTo(null);
			
			// Crea los paneles de acciones e imagen
			acciones = new PanelAcciones(this);

			imagen = new PanelImagen();
			
			
			// Adiciona los componentes graficos al panel 
			add(acciones, BorderLayout.SOUTH);
			
			add(imagen, BorderLayout.NORTH);
			
		


	}
	
	public void cargarTablero()
	{
		try {
			
			JFileChooser fc = new JFileChooser("./data");
			fc.setDialogTitle("Abrir el archivo de crucigrama");
			
			File archivoCrucigrama = null;
			int resultado = fc.showOpenDialog(this);
			
			if ( resultado == JFileChooser.APPROVE_OPTION) {
				
				archivoCrucigrama = fc.getSelectedFile();
				
				mundo = new Crucigrama(archivoCrucigrama);
				
				// Crea los paneles que contiene tablero y las descripciones
				descripciones = new PanelDescripciones(mundo.darDescripH(), mundo.darDescripV());
				tablero = new PanelTablero(this,mundo.darColumnas(),mundo.darFilas());
				
				// Agrega los componentes graficos 
				add(descripciones, BorderLayout.WEST);
				add(tablero, BorderLayout.EAST);
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, "Error al cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Metodo para validar las palabras horizontales
	 */
	public void validarHorizontales()
	{
	
		try {
			
			mundo.actualizarLetras(panelCrucigrama.darLetras());
			mundo.validarHorizontales();
			Palabra[] palabras = mundo.darPalabrasHorizontales();
			for (int i = 0; i < palabras.length; i++) {
				Palabra actual = palabras[i];
				PanelTablero.pintarPalabraHorizontal(actual);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this,"Debe cargar el juego antes de validar", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Metodo para validar las palabras verticales
	 */
	public void validarVerticales()
	{
		try {
			mundo.actualizarLetras(PanelTablero.darLetras());
			mundo.validarverticales();
			Palabra[] palabras = mundo.darPalabrasVerticales();
			for (int i = 0; i < palabras.length; i++) {
				Palabra actual = palabras[i];
				PanelTablero.pintarPalabraVertical(actual);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this,"Debe cargar el juego antes de validar", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Soluciona el crucigrama
	 */
	public void solucinar()
	{
		
		try {
			
			mundo.actualizarLetras(PanelTablero.darLetras());
			PanelTablero.solucionar(mundo.darTablero());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this,"Debe cargar el juego antes de solucionar", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Limpia las letras existentes en el crucigrama
	 */
	public void limpiar()
	{
		try {
			
			mundo.limpiar();
			PanelTablero.inicializar(mundo.darFilas(), mundo.darColumnas(), mundo.darTablero());
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(this,"Debe cargar el juego antes de limpiar", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Metodo vacio para la opción uno
	 */
	public void opcionUno()
	{
		
		JOptionPane.showMessageDialog(this, mundo.darMetodo1(), "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metodo vacio para la opción dos
	 */
	public void opcionDos()
	{
		JOptionPane.showMessageDialog(this, mundo.darMetodo2(), "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metodo para configura esta clase como la principal 
	 * @param args
	 */

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
