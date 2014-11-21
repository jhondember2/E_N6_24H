package uniandes.cupi2.crucigrama.interfaz;

import java.awt.TextField;

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
	
	// ----------------------------------------------------------------
	// Atributos 
	// ---------------------------------------------------------------
		
	
	public PanelTablero()
	{
		
		
		
	}
	
	
	public void inicializar(int filas, int columnas)
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
