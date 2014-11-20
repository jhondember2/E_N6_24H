package uniandes.cupi2.crucigrama.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAcciones extends JPanel implements ActionListener {

	
	
	// ----------------------------------------------------------------
	// Constantes
	// ----------------------------------------------------------------
	
	/**
	 * Constante bot�n validar horizontales 
	 */
	public final static String V_HORIZONTALES ="Validar horizontales";
	
	/**
	 * Constante bot�n validar verticales 
	 */
	public final static String V_VERTICALES = "Validar verticales";
	
	/**
	 * Constante bot�n solucionar 
	 */
	public final static String SOLUCIONAR = "Solucionar";
	
	/**
	 * Constante bot�n limpiar 
	 */
	public final static String LIMPIAR = "Limpiar";
	
	/**
	 * Constante bot�n cargar 
	 */
	public final static String CARGAR = "Cargar";
	
	/**
	 * Constante bot�n opci�n uno 
	 */
	public final static String O_UNO = "Opcion uno";
	
	/**
	 * Constante bot�n opci�n dos 
	 */
	public final static String O_DOS = "Opcion dos";
	
	
	// ----------------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------------
	
	/**
	 * Atributo bot�n horizontales
	 */
	private JButton butVHorizontales;
	
	/**
	 * Atributo bot�n validar verticales 
	 */
	private JButton butVVerticales;
	
	/**
	 * Atributo bot�n solucionar 
	 */
	private JButton butSolucionar;
	
	/**
	 * Atributo bot�n limpiar 
	 */
	private JButton butLimpiar;
	
	/**
	 * Atributo bot�n cargar 
	 */
	private JButton butCargar;

	/**
	 * Atributo bot�n opci�n uno 
	 */
	private JButton butOUno;
	
	/**
	 * Atributo bot�n opci�n dos  
	 */
	private JButton butODos;
	
	// ----------------------------------------------------------------
	// Asociaci�n con la interfaz 
	// ----------------------------------------------------------------
	
	/**
	 * Atributo que representa la interfaz
	 */
	private InterfazCrucigrama interfaz;
	

	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
	/**
	 * Constructor de la clase 
	 * @param pInterfaz
	 */
	public PanelAcciones (InterfazCrucigrama pInterfaz)
	{
		interfaz = pInterfaz;
		
		setLayout(new GridLayout(2,4));
		TitledBorder border = BorderFactory.createTitledBorder("Opciones");
		setBorder(border);
		
		butVHorizontales = new JButton(V_HORIZONTALES);
		butVHorizontales.setActionCommand(V_HORIZONTALES);
		butVHorizontales.addActionListener(this);
		add(butVHorizontales);
		
		butVVerticales = new JButton(V_VERTICALES);
		butVVerticales.setActionCommand(V_VERTICALES);
		butVVerticales.addActionListener(this);
		add(butVVerticales);
		
		butSolucionar = new JButton (SOLUCIONAR);
		butSolucionar.setActionCommand(SOLUCIONAR);
		butSolucionar.addActionListener(this);
		add(butSolucionar);
		
		butLimpiar = new JButton (LIMPIAR);
		butLimpiar.setActionCommand(LIMPIAR);
		butLimpiar.addActionListener(this);
		add(butLimpiar);
		
		butCargar = new JButton(CARGAR);
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener(this);
		add(butCargar);
		
		butOUno = new JButton(O_UNO);
		butOUno.setActionCommand(O_UNO);
		butOUno.addActionListener(this);
		add(butOUno);
		
		butODos= new JButton(O_DOS);
		butODos.setActionCommand(O_DOS);
		butODos.addActionListener(this);
		add(butODos);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
		String comando = evento.getActionCommand();
		
		if(comando.equals(V_HORIZONTALES))
		{
			
		}
		else if (comando.equals(V_VERTICALES))
		{
			
		}
		else if (comando.equals(SOLUCIONAR)) 
		{
			
		} 
		else if (comando.equals(LIMPIAR))
		{
			
		}
		else if (comando.equals(CARGAR))
		{
			interfaz.cargarTablero();
		}
		else if (comando.equals(O_UNO)) {
			
		}
		else if (comando.equals(O_DOS))
		{
			
		}
	}
	
}
