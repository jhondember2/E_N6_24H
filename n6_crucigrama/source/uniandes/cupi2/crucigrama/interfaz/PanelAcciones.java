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
	 * Constante botón validar horizontales 
	 */
	public final static String V_HORIZONTALES ="Validar horizontales";
	
	/**
	 * Constante botón validar verticales 
	 */
	public final static String V_VERTICALES = "Validar verticales";
	
	/**
	 * Constante botón solucionar 
	 */
	public final static String SOLUCIONAR = "Solucionar";
	
	/**
	 * Constante botón limpiar 
	 */
	public final static String LIMPIAR = "Limpiar";
	
	/**
	 * Constante botón cargar 
	 */
	public final static String CARGAR = "Cargar";
	
	/**
	 * Constante botón opción uno 
	 */
	public final static String O_UNO = "Opcion uno";
	
	/**
	 * Constante botón opción dos 
	 */
	public final static String O_DOS = "Opcion dos";
	
	
	// ----------------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------------
	
	/**
	 * Atributo botón horizontales
	 */
	private JButton butVHorizontales;
	
	/**
	 * Atributo botón validar verticales 
	 */
	private JButton butVVerticales;
	
	/**
	 * Atributo botón solucionar 
	 */
	private JButton butSolucionar;
	
	/**
	 * Atributo botón limpiar 
	 */
	private JButton butLimpiar;
	
	/**
	 * Atributo botón cargar 
	 */
	private JButton butCargar;

	/**
	 * Atributo botón opción uno 
	 */
	private JButton butOUno;
	
	/**
	 * Atributo botón opción dos  
	 */
	private JButton butODos;
	
	/**
	 * Atributo que representa la interfaz
	 */
	private InterfazCrucigrama interfaz;
	

	// ----------------------------------------------------------------
	// Constructores
	// ----------------------------------------------------------------
	
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	// ----------------------------------------------------------------
	// Contructores
	// ----------------------------------------------------------------
	
	
	
}
