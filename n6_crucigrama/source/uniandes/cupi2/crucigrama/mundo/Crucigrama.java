package uniandes.cupi2.crucigrama.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




/**
 * Clase principal del mundo
 * @author pa.parra12
 *
 */
public class Crucigrama {
	
	public static final String VACIO = "";
	
	// ----------------------------------------------------------------
	// Atributos 
	// ----------------------------------------------------------------
	
	private int columnas;
	
	private int filas;
	
	private String[][] tablero;
	
	private String[] palabras;
	
	
	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
	public Crucigrama(File arch) throws Exception
	{
		
		Properties datos = cargarInfoCampeonato(arch);
		
		inicializarPalabras(datos);
		
		inicializarTablero();
		
	}
	
	private Properties cargarInfoCampeonato( File arch) throws Exception
	{
		
		Properties datos = new Properties();
		
		FileInputStream in = new FileInputStream ( arch);
		
		try {
			
			datos.load(in);
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new Exception ("Formato invalido");
		}
		
		return datos;
	}
	
	/**
	 * Inicializa el arreglo de palabras con base en la información leída.
	 * @param datos
	 */
	private void inicializarPalabras( Properties datos)
	{
		String strNumeroFilas = datos.getProperty("crucigrama.filas");
		filas = Integer.parseInt(strNumeroFilas);
		
		palabras = new String [filas];
		
		for (int i = 0; i < filas; i++) {
			
			String palabrasCrucigrama = datos.getProperty("crucigrama.fila" + i);
			
			palabras [i] = new String ( palabrasCrucigrama);
		}
		
	}
	
	/**
	 * Inicializar la matriz que representa el tablero del crucigrama
	 */
	private void inicializarTablero()
	{
		tablero = new String[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
			
				tablero[i][j] = VACIO;
				
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
