package uniandes.cupi2.crucigrama.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;


/**
 * Clase principal del mundo
 * @author pa.parra12
 *
 */
public class Crucigrama 
{
	
	public static final String VACIO = "";
	
	// ----------------------------------------------------------------
	// Atributos 
	// ----------------------------------------------------------------
	
	/**
	 * Atributo que define el numero de columnas del crucigrama
	 */
	private int columnas;
	
	/**
	 * Atributo que define el numero de filas del crucigrama
	 */
	private int filas;
	
	/**
	 * Matriz del tablero del crucigrama 
	 */
	private String[][] tablero;
	
	/**
	 * Arreglo que almacena las descripciones horizontales del archivo de propiedades
	 */
	private String[] palabraH;
	
	/**
	 * Arreglo que almacena las descripciones verticales del archivo de propiedades
	 */
	private String[] palabraV;
	
	
	// Atributo que representa el mundo del programa
	
	private Crucigrama mundo;
	
	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
	/**
	 * Constructor de la clase 
	 * @param arch
	 * @throws Exception
	 */
	public Crucigrama(File arch) throws Exception
	{
		
		Properties datos = cargarInfoCrucigrama(arch);
		
		inicializarPalabras(datos);
		
		inicializarTablero();
		
	}
	
	/**
	 * Cargar la información del archivo del archivo en un objeto properties
	 * @param arch
	 * @return
	 * @throws Exception
	 */
	public Properties cargarInfoCrucigrama( File arch) throws Exception
	{
		
		Properties datos = new Properties();
		datos.load(new FileReader(arch));
		
		filas = Integer.parseInt(datos.getProperty("crucigrama.filas"));
		columnas = Integer.parseInt(datos.getProperty("crucigrama.columnas"));
		
		tablero = new String[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			
			String fila = datos.getProperty("crucigrama.fila"+(i+1));
			
			for (int j = 0; j < columnas; j++) {
				
				String letra = fila.charAt(j)+"";
				
				tablero[i][j] = new String(letra);	
			}
		}
		
				
		int numHorizontales = Integer.parseInt(datos.getProperty("crucigrama.palabrasHorizontales"));
		palabraH = new String[numHorizontales];
				
		for (int i = 0; i < numHorizontales; i++) {
					
			String descripcion =  datos.getProperty("crucigrama.Hdescripcion"+(i+1));
					
			String[] inicio =  datos.getProperty("crucigrama.Hpalabra"+(i+1)).trim().split(";");
					
			int filaInicial = Integer.parseInt(inicio[0]) -1;
			int columnaInicial = Integer.parseInt(inicio[1]) -1;
			int longitud = 0;
		
			boolean terminar = false;
			
			for (int j = columnaInicial; j < columnas && terminar == false; j++) {
				String actual = tablero[filaInicial][j];
				if(actual.equalsIgnoreCase("$"))
				{
					terminar = true;
				}
				else
				{
					longitud++;
				}
			}
					
			palabraH[i] = new String(descripcion, filaInicial, columnaInicial, longitud );
		}
				

		int numVerticales = Integer.parseInt(datos.getProperty("crucigrama.palabrasVerticales"));
		
		palabraV = new String[numVerticales];
		
		for (int i = 0; i < numVerticales; i++) {
			
			String descripcion =  datos.getProperty("crucigrama.Vdescripcion"+(i+1));
			
			String[] inicio =  datos.getProperty("crucigrama.Vpalabra"+(i+1)).trim().split(";");
			
			int filaInicial = Integer.parseInt(inicio[0]) -1;
			int columnaInicial = Integer.parseInt(inicio[1]) -1;
			int longitud = 0;
			boolean terminar = false;
			
			for (int j = filaInicial; j < filas && terminar == false; j++) {
				String actual = tablero[j][columnaInicial];
				if(actual.equals("$"))
				{
					terminar = true;
				}
				else
				{
					longitud++;
				}
			}
			
			palabraV[i] = new String(descripcion, filaInicial, columnaInicial, longitud );
		}
		

		FileInputStream in = new FileInputStream ( arch);
		
		try {
			
			datos.load(in);
			in.close();
			
		} catch (Exception e) {
			
			throw new Exception ("Formato invalido");
		}
		
		return datos;
	}
	
	/**
	 * Inicializa el arreglo de palabras con base en la información leída.
	 * @param datos
	 */
	public void inicializarPalabras( Properties datos)
	{
		String strNumeroFilas = datos.getProperty("crucigrama.filas");
		filas = Integer.parseInt(strNumeroFilas);
		
		palabraH = new String [filas];
		
		for (int i = 0; i < filas; i++) {
			
			String palabrasCrucigrama = datos.getProperty("crucigrama.fila" + i);
			
			palabraH [i] = new String ( palabrasCrucigrama);
		}
		
	}
	
	/**
	 * Inicializar la matriz que representa el tablero del crucigrama
	 */
	public void inicializarTablero()
	{
		tablero = new String[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
			
				tablero[i][j] = VACIO;
				
				
			}
		}
	}
	
	/**
	 * Devuelve el numero de filas del crucigrama
	 * @return numero de filas
	 */
	public int darFilas()
	{
		return filas;
	}
	
	/**
	 * Devuelve el numero de columas del crucigrama
	 * @return numero de columnas
	 */
	public int darColumnas()
	{
		return columnas;
	}
	
	/**
	 * Devuelve un arreglo con las descripciones horizontales
	 * @return descripciones horizontales
	 */
	public String[] darpalabraH()
	{
		return palabraH;
	}
	
	/**
	 * Devuelve un arreglo con las descripciones verticales
	 * @return descripciones verticales
	 */
	public String[] darpalabraV()
	{
		return palabraV;
	}
	
	/**
	 * Devuelve la cadena de caracteres del metodo 1
	 * @return respuesta 1
	 */
	public String darMetodo1()
	{
		return "Respuesta 1";
		
	}
	
	public String darMetodo2()
	{
		
		return "Respuesta 2";
	}
	
	}
	

