package uniandes.cupi2.crucigrama.interfaz;

import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTablero extends JPanel {
	
	// ----------------------------------------------------------------
	// Atributos 
	// ----------------------------------------------------------------
	
	/**
	 * Variable de la matriz que se va a mostrar en la interfaz 
	 */
	private JTextField[][] cuadricula;
	
	//-----------------------------------------------------------------
	// Asociación con la interfaz
	// ----------------------------------------------------------------
	/**
	 * Atributo que representa la interfaz
	 */
	private InterfazCrucigrama interfaz;
	
	
	// ----------------------------------------------------------------
	// Constructor
	// ---------------------------------------------------------------
	public PanelTablero(InterfazCrucigrama pInterfaz, int columnas, int filas)
	{
		
		removeAll();
		setLayout(new GridLayout (filas+1, columnas+1));
		cuadricula = new JTextField[filas][columnas];
		add(new JLabel());
		
		for (int i = 1; i <= filas; i++) {
			
			JLabel numeroH = new JLabel(i+"", JLabel.CENTER);
			
		}
		
	}
	
	
	public void inicializar(int filas, int columnas, String[][] pCuadricula )
	{
		
		cuadricula = new JTextField[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				if (i==0) {
					cuadricula[i][j]= new JTextField(j);
					
				}else if(j==0){
					cuadricula[i][j]= new JTextField(i);
					
				}else{
					
					cuadricula [i][j]= new JTextField("");
				}
			}
		}
		
	}

}
