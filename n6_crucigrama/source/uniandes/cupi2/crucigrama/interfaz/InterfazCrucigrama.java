package uniandes.cupi2.crucigrama.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
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
				descripciones = new PanelDescripciones(mundo.dardescripH(), mundo.dardescripV());
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

			try
			{
			tablero.vaciar();
			int i=0;
			int j=0;
			int z=0;
			String st = "";
			String[][] s = null;
			boolean ya=false;
			
			s = new String[mundo.darFilas()][mundo.darColumnas()];
			
			while(i<mundo.darFilas())
			{
				st="";
				while(j<mundo.darColumnas()&&!ya)
				{
					s[i][j] = tablero.darCampo(j, i).getText();
					if(tablero.darCampo(j, i).getBackground().equals(Color.BLACK))
					{
						ya = true;
						j--;
					}
					else
					{
						st+= tablero.darCampo(j, i).getText();
					}
					j++;
				}
				if(mundo.buscarPHorizontal(st))
				{
					z = j-st.length();
					while(z<j)
					{
						tablero.darCampo(z, i).setBackground(Color.GREEN);
						z++;
					}
				}
				if(j==mundo.darColumnas())
				{
					j=0;
					i++;
				}
				else
				{
					s[i][j] = tablero.darCampo(j, i).getText();
					j++;
				}
				ya = false;
			}
			if(mundo.solucionar(s))
				{
					JOptionPane.showMessageDialog(this, "Has completado el crucigrama", "¡Eureka!", JOptionPane.INFORMATION_MESSAGE);
				}
			else
			{
				JOptionPane.showMessageDialog(this, "Hay errores en el crucigrama o esta incompleto.\n Las palabras correctas se muestran en verde", "Errores", JOptionPane.INFORMATION_MESSAGE);
			}
			}
			catch(Exception e)
			{
			JOptionPane.showMessageDialog(this, "Debe cargar el juego antes de validar.", "Error al validar", JOptionPane.ERROR_MESSAGE);
			}
			
	
		
	}
	/**
	 * Metodo para validar las palabras verticales
	 */
	public void validarVerticales()
	{
		try
		{
		tablero.vaciar();
		int i=0;
		int j=0;
		int z=0;
		String st = "";
		String[][] s = null;
		boolean ya=false;
		
		s = new String[mundo.darFilas()][mundo.darColumnas()];
		
		while(i<mundo.darColumnas())
		{
			st="";
			while(j<mundo.darFilas()&&!ya)
			{
				s[j][i] = tablero.darCampo(i, j).getText();
				if(tablero.darCampo(i, j).getBackground().equals(Color.BLACK))
				{
					ya = true;
					j--;
				}
				else
				{
					st+= tablero.darCampo(i, j).getText();
				}
				j++;
			}
			if(mundo.buscarPVertical(st))
			{
				z = j-st.length();
				while(z<j)
				{
					tablero.darCampo(i, z).setBackground(Color.GREEN);
					z++;
				}
			}
			if(j==mundo.darFilas())
			{
				j=0;
				i++;
			}
			else
			{
				s[j][i] = tablero.darCampo(i, j).getText();
				j++;
			}
			ya = false;
		}
		if(mundo.solucionar(s))
			{
				JOptionPane.showMessageDialog(this, "Has completado el crucigrama", "¡Eureka!", JOptionPane.INFORMATION_MESSAGE);
			}
		else
		{
			JOptionPane.showMessageDialog(this, "Hay errores en el crucigrama o esta incompleto.\n Las palabras correctas se muestran en verde", "Errores", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Debe cargar el juego antes de validar.", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Soluciona el crucigrama
	 */
	public void solucinar()
	{
		
		try
		{
		tablero.vaciar();
		int i=0;
		int j=0;
		while(i<mundo.darFilas())
		{
			j=0;
			while(j<mundo.darColumnas())
			{
				if(tablero.darCampo(j, i).getBackground().equals(Color.BLACK))
				{
					
				}
				else if(tablero.darCampo(j, i).getText().equals(""))
				{
					tablero.darCampo(j, i).setText(mundo.darL(j, i)+"");
				}
				else if((mundo.darL(j, i)+"").equals(tablero.darCampo(j, i).getText()))
				{
					tablero.darCampo(j, i).setText(mundo.darL(j, i)+"");
					tablero.darCampo(j, i).setBackground(Color.GREEN);
				}
				else
				{
					tablero.darCampo(j, i).setBackground(Color.RED);
					tablero.darCampo(j, i).setText(mundo.darL(j, i)+"");
				}
				j++;
			}
			i++;
		}
		JOptionPane.showMessageDialog(this, "Se pintan de verde las casillas correctas, de rojo las erroneas y de blanco las casillas vacias.", "Solucion crucigrama", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Debe cargar el juego antes de validar.", "Error al validar", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Limpia las letras existentes en el crucigrama
	 */
	public void limpiar()
	{
		try
		{
			tablero.limpiar();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Debe cargar el juego antes de limpiar.", "Error al limpiar", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public char darLetra(int x, int y)
	{
		return mundo.darL(x, y);
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
