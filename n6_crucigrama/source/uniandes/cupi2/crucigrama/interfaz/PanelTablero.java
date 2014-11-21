package uniandes.cupi2.crucigrama.interfaz;

import java.awt.Color;
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
		interfaz = pInterfaz;
		setLayout(new GridLayout(filas+1, columnas+1));
		cuadricula = new JTextField[filas][columnas];
		
		add(new JLabel());
		
		int j=0;
		for (int i = 1; i <=columnas; i++) {
			JLabel k = new JLabel(i+"", JLabel.CENTER);
			add(k);
			i++;
		}
		
		for (int j2 = 0; j2 < filas; j2++) {
			
			JLabel a = new JLabel(""+(j2+1), JLabel.CENTER);
			add(a);
			
			for (int k = 0; k < columnas; k++) {
				
				JTextField lugar = new JTextField();
				String pl = ""+interfaz.darLetra(k,j2);
				if(pl.equals("$"))
				{
					lugar.setBackground(Color.BLACK);
					lugar.setEditable(false);
					lugar.setText(" ");
				}
				add(lugar);
				cuadricula[j2][j] = lugar;
				j++;
				
			}
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public JTextField darCampo(int x, int y)
	{
		return cuadricula[y][x];
	}
	
	/**
	 * 
	 */
	public void vaciar()
	{
		int i=0;
		int j=0;
		while(i<cuadricula.length)
		{
			j=0;
			while(j<cuadricula[0].length)
			{
				if(!(cuadricula[i][j].getBackground().equals(Color.BLACK)))
				{
					cuadricula[i][j].setBackground(Color.WHITE);
				}
				j++;
			}
			i++;
		}
	}
	
	/**
	 * 
	 */
	public void limpiar()
	{
		int i=0;
		int j=0;
		while(i<cuadricula.length)
		{
			j=0;
			while(j<cuadricula[0].length)
			{
				if(!(cuadricula[i][j].getBackground().equals(Color.BLACK)))
				{
					cuadricula[i][j].setText("");
					cuadricula[i][j].setBackground(Color.WHITE);
				}
				j++;
			}
			i++;
		}
	}

}
