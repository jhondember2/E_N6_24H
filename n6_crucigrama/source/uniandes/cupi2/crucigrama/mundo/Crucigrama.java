package uniandes.cupi2.crucigrama.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;


/**
 * Clase principal del mundo
 * @author pa.parra12
 *
 */
public class Crucigrama 
{
	

	
	// ----------------------------------------------------------------
	// Atributos 
	// ----------------------------------------------------------------
	
	/**
	 * Contenedor de las palabras horizontales del crucigrama.
	 */
	private ArrayList<String> palabras;
	
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
	private char[][] tablero;
	
	/**
	 * Arreglo que almacena las descripciones horizontales del archivo de propiedades
	 */
	private String[] descripH;
	
	/**
	 * Arreglo que almacena las descripciones verticales del archivo de propiedades
	 */
	private String[] descripV;
	
	
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
		
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(arch);
		try
		{
			datos.load(in);
			in.close();
		}
		catch(Exception e)
		{
			throw new Exception("Formato invalido");
		}
		
		int i =0;
		String[] c = null;
		descripH = new String[Integer.parseInt(datos.getProperty("crucigrama.palabrasHorizontales"))];
		while(i<descripH.length)
		{
			c = datos.getProperty("crucigrama.Hpalabra" + (i+1)).split(";");
			descripH[i] = c[0] + ":" + c[1] + " - " + datos.getProperty("crucigrama.Hdescripcion" + (i+1));
			i++;
		}
		
		i =0;
		descripV = new String[Integer.parseInt(datos.getProperty("crucigrama.palabrasVerticales"))];
		while(i<descripV.length)
		{
			c = datos.getProperty("crucigrama.Vpalabra" + (i+1)).split(";");
			descripV[i] = c[0] + ":" + c[1] + " - " + datos.getProperty("crucigrama.Vdescripcion" + (i+1));
			i++;
		}
		
		columnas = Integer.parseInt(datos.getProperty("crucigrama.filas"));
		filas = Integer.parseInt(datos.getProperty("crucigrama.columnas"));
		tablero = new char[filas][columnas];
		i =0;
		int j =0;
		String st="";
		palabras = new ArrayList<String>();
		while(i<filas)
		{
			j=0;
			while(j<columnas)
			{
				tablero[i][j] = datos.getProperty("crucigrama.fila" + (i+1)).charAt(j);
				
				if(!((""+tablero[i][j]).equals("$")))
				{
					st+= tablero[i][j];
				}
				else
				{
					palabras.add(st);
					st = "";
				}
				j++;
			}
			if(st!="")
			{
			palabras.add(st);
			st="";
			}
			i++;
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean solucionar(String[][] s)
	{
		int i =0;
		int j =0;
		while(i<s.length)
		{
			j=0;
			while(j<s[0].length)
			{
				if(s[i][j].equals(" "))
				{
					j++;
				}
				else if(!(s[i][j].equalsIgnoreCase(""+tablero[i][j])))
				{
					return false;
				}
			j++;
			}
			i++;
		}
		return true;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean buscarPHorizontal(String s)
	{
		int i =0;
		while(i<palabras.size())
		{
			if(palabras.get(i).equalsIgnoreCase(s))
			{
				return true;
			}
			i++;
		}
		return false;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean buscarPVertical(String s)
	{
		int i=0;
		int j=0;
		String st="";
		boolean ya=false;
		while(i<tablero[0].length)
		{
			while(j<tablero.length&&!ya)
			{
				if((tablero[j][i]+"").equals("$"))
				{
					ya=true;
				}
				else
				{
					st+=tablero[j][i];
					j++;
				}
			}
			if(st.equalsIgnoreCase(s))
			{
				return true;
			}
			if(j==filas)
			{
				j=0;
				i++;
			}
			else
			{
				j++;
			}
			st="";
			ya=false;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public char darL(int filas, int columnas)
	{
		return tablero[filas][columnas];
	}
	
	/**
	 * Devuelve la matriz cargada del archivo
	 * @return matriz con el crucigrama
	 */
	public char[][] darTablero()
	{
		return tablero;
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
	public String[] dardescripH()
	{
		return descripH;
	}
	
	/**
	 * Devuelve un arreglo con las descripciones verticales
	 * @return descripciones verticales
	 */
	public String[] dardescripV()
	{
		return descripV;
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
	

