package interfaz;

import java.awt.*;

import javax.swing.*;

import negocio.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidades.Colorido;
import entidades.Consumo;
import entidades.Lavarropas;
import entidades.Television;

public class In extends JApplet implements ActionListener {
	public In() {
	}
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitulo,lblId,lblColor,lblConsumo,lblPeso,lblPrecio,lblCarga,lblResol,lblTdt;
	private JButton btnAlta, btnBaja, btnModificar,btnListar,btnLava,btnTele,btnCancelar,btnGuardar,btnModif;
	private JComboBox cboColor,cboConsumo,cboTdt;
	private JTextField txfId,txfPeso,txfPrecio,txfCarga,txfResol;
	private JPanel panel1,panel2,panel3,subPanel1,subPanel2,subPanel3;
	
	String iden,color,consumo,peso,precio;
	Boolean flag1=null,flag2=false,flag5=null;
	int idModif2=0;
	String[] combo={"Si","No"};
	
	ArrayList<entidades.Lavarropas> arrayLavarropas=new ArrayList<entidades.Lavarropas>();
	ArrayList<entidades.Television> arrayTelevisores=new ArrayList<entidades.Television>();

	private negocio.Test negocioTest;
	public negocio.Test getNegocioTest()
	{
		return negocioTest;
	}
	public void setNegocioTest(negocio.Test negocioTest)
	{
		this.negocioTest=negocioTest; 
	}

	/**
	 * Create the applet.
	 */
	public void init() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim);
		
		negocioTest=new Test();
		Container contenedor= getContentPane();
		contenedor.setLayout(new GridLayout(3,1));
		
		//Pantalla Principal
		lblTitulo = new JLabel("ABM y Listado de Electrodomesticos:", SwingConstants.CENTER);
		
		btnAlta =new JButton("Alta Electrodomestico");
		btnAlta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				altaElec();

				}
		});
		
		btnBaja =new JButton("Baja Electrodomestico");
		btnBaja.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				bajaElec();

				}
		});
		
		btnModificar =new JButton("Modificar Electrodomestico");
		btnModificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				modifElec();

				}
		});
		
		btnListar =new JButton("Listar Electrodomesticos");
		btnListar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				mostrarElec();

				}
		});
		
		//Pantalla cuando se selecciona "Alta..."
		btnLava =new JButton("Lavarropas");
		btnLava.setVisible(false);
		btnLava.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				altaLavarropa();

				}
		});
		
		btnTele =new JButton("Televisor");
		btnTele.setVisible(false);
		btnTele.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			
				altaTelevisor();

				}
		});
		
		//Pantalla cuando se selecciona "Lavarropas" u/o "Television"
		lblId = new JLabel("Id:");
		lblId.setVisible(false);
		
		txfId=new JTextField(10);
		txfId.setVisible(false);
		
		lblColor = new JLabel("Color:");
		lblColor.setVisible(false);
		
		cboColor=new JComboBox();																		
	    cboColor.setModel(new DefaultComboBoxModel(this.getListaColores()));
	    cboColor.setVisible(false);
		
		lblConsumo = new JLabel("Consumo:");
		lblConsumo.setVisible(false);
		
		cboConsumo=new JComboBox();																		
		cboConsumo.setModel(new DefaultComboBoxModel(this.getListaConsumos()));
		cboConsumo.setVisible(false);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setVisible(false);
		
		txfPeso=new JTextField(10);
		txfPeso.setVisible(false);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setVisible(false);
		
		txfPrecio=new JTextField(10);
		txfPrecio.setVisible(false);
		
		lblCarga = new JLabel("Carga:");
		lblCarga.setVisible(false);
		
		txfCarga=new JTextField(10);
		txfCarga.setVisible(false);
		
		lblResol = new JLabel("Resolucion:");
		lblResol.setVisible(false);
		
		txfResol=new JTextField(10);
		txfResol.setVisible(false);
		
		lblTdt = new JLabel("Tdt:");
		lblTdt.setVisible(false);
		
		cboTdt=new JComboBox(combo);																		
		cboTdt.setVisible(false);
		
		//Configurar botones
		btnGuardar =new JButton("Guardar");
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(this);
		
		btnModif =new JButton("Modificar");
		btnModif.setVisible(false);
		btnModif.addActionListener(this);
		
		btnCancelar =new JButton("Cancelar");
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(this);
		
		/*JScrollPane scroll = new JScrollPane();
	    scroll.setViewportView(areaTexto);
		areaTexto.setEditable(false);*/
		
		//Configurar paneles
		panel1= new JPanel ();
		panel1.add(lblTitulo);
		panel1.setOpaque(false);
		
		panel2= new JPanel ();
			subPanel1=new JPanel();
			subPanel1.setOpaque(false);
			subPanel1.add(btnLava);
			subPanel1.add(btnTele);
			subPanel2=new JPanel();
			subPanel2.setOpaque(false);
			subPanel2.add(btnAlta);
			subPanel2.add(btnBaja);
			subPanel2.add(btnModificar);
			subPanel2.add(btnListar);
			subPanel3=new JPanel();
			subPanel3.setOpaque(false);
			subPanel3.add(lblId);
			subPanel3.add(txfId);
			subPanel3.add(lblColor);
			subPanel3.add(cboColor);
			subPanel3.add(lblConsumo);
			subPanel3.add(cboConsumo);
			subPanel3.add(lblPeso);
			subPanel3.add(txfPeso);
			subPanel3.add(lblPrecio);
			subPanel3.add(txfPrecio);
			subPanel3.add(lblCarga);
			subPanel3.add(txfCarga);
			subPanel3.add(lblResol);
			subPanel3.add(txfResol);
			subPanel3.add(lblTdt);
			subPanel3.add(cboTdt);
		panel2.add(subPanel1);
		panel2.add(subPanel2);
		panel2.add(subPanel3);
		/*panel2.add(scroll);*/
		panel2.setOpaque(false);
		
		panel3= new JPanel ();
		panel3.add(btnGuardar);
		panel3.add(btnModif);
		panel3.add(btnCancelar);
		panel3.setOpaque(false);
		
		
		contenedor.add(panel1);
		contenedor.add(panel2);
		contenedor.add(panel3);
		pantallaInicio();
		
	}
	
	private entidades.Colorido[] getListaColores()
	{
		return getNegocioTest().getAllColores();
	}
	
	private entidades.Consumo[] getListaConsumos()
	{
		return getNegocioTest().getAllConsumos();
	}
	
	private ArrayList<Lavarropas> getListaLavarropas()
	{
		return getNegocioTest().getAllLavarropas();
	}
	
	private ArrayList<Television> getListaTelevisores()
	{
		return getNegocioTest().getAllTelevisores();
	}
	
	private void pantallaInicio()
	{	
		if(flag2==false){
		panel1.setVisible(true);
		panel2.setVisible(true);
		panel3.setVisible(true);
		subPanel2.removeAll();
		subPanel2.add(btnAlta);
		subPanel2.add(btnBaja);
		subPanel2.add(btnModificar);
		subPanel2.add(btnListar);
		}
		else{
			panel1.setVisible(true);
			panel2.setVisible(true);
			panel3.setVisible(true);
			 lblId.setVisible(false);
			 txfId.setVisible(false);
			 lblColor.setVisible(false);
			 cboColor.setVisible(false);
			 lblConsumo.setVisible(false);
			 cboConsumo.setVisible(false);
			 lblPeso.setVisible(false);
			 txfPeso.setVisible(false);
			 lblPrecio.setVisible(false);
			 txfPrecio.setVisible(false);
			 lblCarga.setVisible(false);
			 txfCarga.setVisible(false);
			 lblResol.setVisible(false);
			 txfResol.setVisible(false);
			 lblTdt.setVisible(false);
			 cboTdt.setVisible(false);
			 btnLava.setVisible(false);
			 btnTele.setVisible(false);
			 btnGuardar.setVisible(false);
			 btnModif.setVisible(false);
			 btnCancelar.setVisible(false);
			 btnAlta.setVisible(true);
			 btnBaja.setVisible(true);
			 btnModificar.setVisible(true);
			 btnListar.setVisible(true);
				
			
		}
	}
	
	private boolean validar(int idIgual){
		boolean rta=false;
		for (int i=0; i<arrayLavarropas.size();i++)
		{		
			if(arrayLavarropas.get(i).getId()==idIgual)
			{
				rta=true;
			}
		}
		for (int i=0; i<arrayTelevisores.size();i++)
		{
		if(arrayTelevisores.get(i).getId()==idIgual)
				  {
					rta=true;
				  }
				
		}
		return rta;
	}
	
	private void altaElec() {
		//ocultar-mostrar paneles 
		btnLava.setVisible(true);
		btnTele.setVisible(true);
		btnAlta.setVisible(false);
		btnBaja.setVisible(false);
		btnModificar.setVisible(false);
		btnListar.setVisible(false);
		
	}
	
	private void altaLavarropa() {
		 //ocultar-mostrar paneles
		 flag1=true;
		 lblId.setVisible(true);
		 txfId.setVisible(true);
		 lblColor.setVisible(true);
		 cboColor.setVisible(true);
		 lblConsumo.setVisible(true);
		 cboConsumo.setVisible(true);
		 lblPeso.setVisible(true);
		 txfPeso.setVisible(true);
		 lblPrecio.setVisible(true);
		 txfPrecio.setVisible(true);
		 lblCarga.setVisible(true);
		 txfCarga.setVisible(true);
		 btnLava.setVisible(false);
		 btnTele.setVisible(false);
		 btnGuardar.setVisible(true);
		 btnCancelar.setVisible(true);
		 
		 txfId.setText("");
		 txfPeso.setText("");
		 txfPrecio.setText("");
		 txfCarga.setText("");
		 
		 cboColor.setSelectedItem(getListaColores()[0]);
		 cboConsumo.setSelectedItem(getListaConsumos()[0]);
		 
		 flag1=true;
		
		
	}
	
	private void altaTelevisor() {
		 //ocultar-mostrar paneles
		 flag1=false;
		 lblId.setVisible(true);
		 txfId.setVisible(true);
		 lblColor.setVisible(true);
		 cboColor.setVisible(true);
		 lblConsumo.setVisible(true);
		 cboConsumo.setVisible(true);
		 lblPeso.setVisible(true);
		 txfPeso.setVisible(true);
		 lblPrecio.setVisible(true);
		 txfPrecio.setVisible(true);
		 lblResol.setVisible(true);
		 txfResol.setVisible(true);
		 lblTdt.setVisible(true);
		 cboTdt.setVisible(true);
		 btnLava.setVisible(false);
		 btnTele.setVisible(false);
		 btnGuardar.setVisible(true);
		 btnCancelar.setVisible(true);
		 
		 txfId.setText("");
		 txfPeso.setText("");
		 txfPrecio.setText("");
		 txfResol.setText("");
		 
		 cboColor.setSelectedItem(getListaColores()[0]);
		 cboConsumo.setSelectedItem(getListaConsumos()[0]);
		 cboColor.setSelectedItem("Si");
		
		
	}
	
	private void bajaElec() { 
		try
		{
		Boolean flag3=false;
		int idBaja=0;
		iden=JOptionPane.showInputDialog(null, "Ingrese Id de Electrodomestico a Eliminar");
		idBaja=Integer.parseInt(iden);
		for (int i=0; i<arrayLavarropas.size();i++)
		{		
			if(arrayLavarropas.get(i).getId()==idBaja)
			{
				arrayLavarropas.remove(i);
				JOptionPane.showMessageDialog(null,"Electrodomestico Eliminado");
				flag3=true;
			}
		}
		for (int i=0; i<arrayTelevisores.size();i++)
		{
		if(arrayTelevisores.get(i).getId()==idBaja)
				  {
					arrayTelevisores.remove(i);
					JOptionPane.showMessageDialog(null,"Electrodomestico Eliminado");
					flag3=true;
				  }
				
		}
		if(flag3==false){JOptionPane.showMessageDialog(null,"Electrodomestico no Encontrado");}
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Ingrese solo numeros","ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void modifElec() {
		try
		{
		Boolean flag4=false;
		int idModif=0;
		iden=JOptionPane.showInputDialog(null, "Ingrese Id del Electrodomestico a modificar");
		idModif=Integer.parseInt(iden);
		
		for (int i=0; i<arrayLavarropas.size();i++)
		{	
			if(arrayLavarropas.get(i).getId()==idModif)
			{	 idModif2=i;
				 lblId.setVisible(true);
			 	 txfId.setVisible(true);
				 lblColor.setVisible(true);
				 cboColor.setVisible(true);
				 lblConsumo.setVisible(true);
				 cboConsumo.setVisible(true);
				 lblPeso.setVisible(true);
				 txfPeso.setVisible(true);
				 lblPrecio.setVisible(true);
				 txfPrecio.setVisible(true);
				 lblCarga.setVisible(true);
				 txfCarga.setVisible(true);
				 btnLava.setVisible(false);
				 btnTele.setVisible(false);
				 btnModif.setVisible(true);
				 btnCancelar.setVisible(true);
				 btnAlta.setVisible(false);
				 btnBaja.setVisible(false);
				 btnModificar.setVisible(false);
				 btnListar.setVisible(false);
				 
				 txfId.setText("");
				 txfPeso.setText("");
				 txfPrecio.setText("");
				 txfCarga.setText("");
			 
			     cboColor.setSelectedItem(getListaColores()[0]);
			     cboConsumo.setSelectedItem(getListaConsumos()[0]);
			     
				 flag4=true;
				 flag5=true;
			}
		}
		
		for (int i=0; i<arrayTelevisores.size();i++){
			
		if(arrayTelevisores.get(i).getId()==idModif)
		{	 idModif2=i;
			 lblId.setVisible(true);
			 txfId.setVisible(true);
			 lblColor.setVisible(true);
			 cboColor.setVisible(true);
			 lblConsumo.setVisible(true);
			 cboConsumo.setVisible(true);
			 lblPeso.setVisible(true);
			 txfPeso.setVisible(true);
			 lblPrecio.setVisible(true);
			 txfPrecio.setVisible(true);
			 lblResol.setVisible(true);
			 txfResol.setVisible(true);
			 lblTdt.setVisible(true);
			 cboTdt.setVisible(true);
			 btnLava.setVisible(false);
			 btnTele.setVisible(false);
			 btnModif.setVisible(true);
			 btnCancelar.setVisible(true);
			 btnAlta.setVisible(false);
			 btnBaja.setVisible(false);
			 btnModificar.setVisible(false);
			 btnListar.setVisible(false);
			 
			 txfId.setText("");
			 txfPeso.setText("");
			 txfPrecio.setText("");
			 txfResol.setText("");
			 
			 cboColor.setSelectedItem(getListaColores()[0]);
			 cboConsumo.setSelectedItem(getListaConsumos()[0]);
			 cboColor.setSelectedItem("Si");
		
			 flag4=true;
			 flag5=false;
			 /*break*/;
		}
		
		}
		if(flag4==false){JOptionPane.showMessageDialog(null,"Electrodomestico no encotrado","ERROR", JOptionPane.ERROR_MESSAGE);}
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Ingrese solo numeros","ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	private void mostrarElec() { 
		JTextArea listado1=new JTextArea();
		arrayLavarropas=getNegocioTest().getAllLavarropas();
		arrayTelevisores=getNegocioTest().getAllTelevisores();
		listado1.append("LAVARROPAS\n");
		listado1.append("ID\tPRECIO\tCOLOR\tCONSUMO\tPESO\tCARGA\n\n");
		for(int i=0;i<arrayLavarropas.size();i++)
		{
			if(getListaLavarropas().get(i)!=null)
		listado1.append(getListaLavarropas().get(i).toString()+"\n");										
		}
		listado1.append("TELEVISORES\n");
		listado1.append("ID\tPRECIO\tCOLOR\tCONSUMO\tPESO\tRESOLUCION\tTDT\n\n");
		for(int i=0;i<arrayTelevisores.size();i++)
		{
			if(getListaTelevisores().get(i)!=null)
		listado1.append(getListaTelevisores().get(i).toString()+"\n");										
		}
	JOptionPane.showMessageDialog(null, listado1);
	}
	
	
	
	public void actionPerformed (ActionEvent actionEvent){
		
		Object control=actionEvent.getSource();
		try 
		{
		if(control.equals(btnGuardar)){
			 
			 if(flag1==true){
				 			
							 if ( txfPeso.getText().equals("") || txfPrecio.getText().equals("")
									 || txfCarga.getText().equals("")) 
								 
										JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
								else
								{
								int id=Integer.parseInt(txfId.getText());
								String color=cboColor.getSelectedItem().toString();
								String con=cboConsumo.getSelectedItem().toString();
								char consumo=con.charAt(0);
								double peso= Double.parseDouble(txfPeso.getText());
								double precio= Double.parseDouble(txfPrecio.getText());
								double carga= Double.parseDouble(txfCarga.getText());
								
								if(validar(id)){
									JOptionPane.showMessageDialog( this, "El id ya existe" );
									
								}
								else {getNegocioTest().crearLavarropa(id,precio, color, consumo, peso, carga);
								
									  JOptionPane.showMessageDialog( this, "Se ha Guardado Correctamente" );
								
									  flag2=true;
								
									  pantallaInicio();
									}
								}
			 			    }
			 else if(flag1==false){
				 
								 if ( txfPeso.getText().equals("") || txfPrecio.getText().equals("")|| txfResol.getText().equals("")
										 || cboTdt.equals("")) 
									 
											JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
									else
									{
									int id=Integer.parseInt(txfId.getText());
									String color=cboColor.getSelectedItem().toString();
									String con=cboConsumo.getSelectedItem().toString();
									char consumo=con.charAt(0);
									double peso= Double.parseDouble(txfPeso.getText());
									double precio= Double.parseDouble(txfPrecio.getText());
									String t=cboTdt.getSelectedItem().toString();
									boolean tdt=true;
									if(t=="Si"){
										tdt=true;
										
									}
									else if(t=="No"){
										tdt=false;
									}
									double resol= Double.parseDouble(txfResol.getText());
									
									if(validar(id)){
										
										JOptionPane.showMessageDialog( this, "El id ya existe" );
										
									}
									else{	
											getNegocioTest().crearTelevisor(id,precio, color, consumo, peso, resol, tdt);
											
											JOptionPane.showMessageDialog( this, "Se ha Guardado Correctamente" );
									
											flag2=true;
									
											pantallaInicio();
										}
									}
			 }
		 }
		 else if(control.equals(btnCancelar)){
			 flag2=true;
			 pantallaInicio(); 
		 }
		
		 else if(control.equals(btnModif)){
			 if(flag5==true){
				 if ( txfPeso.getText().equals("") || txfPrecio.getText().equals("")
						 || txfCarga.getText().equals("")) 
					 
							JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
				 else
					{
					 int newId=Integer.parseInt(txfId.getText());
				     String newColor=cboColor.getSelectedItem().toString();
					 String con=cboConsumo.getSelectedItem().toString();
					 char newConsumo=con.charAt(0);
					 double newPeso= Double.parseDouble(txfPeso.getText());
					 double newPrecio= Double.parseDouble(txfPrecio.getText());
					 double newCarga= Double.parseDouble(txfCarga.getText());
					 
					 if(validar(newId)){
							JOptionPane.showMessageDialog( this, "El id ya existe" );
							
						}
					 else
						 {
						 arrayLavarropas.get(idModif2).setId(newId);
						 arrayLavarropas.get(idModif2).setColor(newColor);
						 arrayLavarropas.get(idModif2).setConsumo_ener(newConsumo);
						 arrayLavarropas.get(idModif2).setPeso(newPeso);
						 arrayLavarropas.get(idModif2).setPrecio_base(newPrecio);
						 arrayLavarropas.get(idModif2).setCarga(newCarga);
						 arrayLavarropas.get(idModif2).precioFinal();
						 JOptionPane.showMessageDialog( this ,"El Electrodomestico ha Sido Modificado");
						 
						 flag2=true;
						 
						 pantallaInicio();
						 }
	
					}
			 }
			 else if(flag5==false){
				 if ( txfPeso.getText().equals("") || txfPrecio.getText().equals("")|| txfResol.getText().equals("")
						 || cboTdt.equals("")) 
					 
							JOptionPane.showMessageDialog( null , "Por favor llene todos los campos" );
					else
					{
						 int newId=Integer.parseInt(txfId.getText());
					     String newColor=cboColor.getSelectedItem().toString();
						 String con=cboConsumo.getSelectedItem().toString();
						 char newConsumo=con.charAt(0);
						 double newPeso= Double.parseDouble(txfPeso.getText());
						 double newPrecio= Double.parseDouble(txfPrecio.getText());
						 String t=cboTdt.getSelectedItem().toString();
						 boolean newTdt=Boolean.parseBoolean(t);
						 double newResol= Double.parseDouble(txfResol.getText());
						 if(validar(newId)){
								JOptionPane.showMessageDialog( this, "El id ya existe" );
								
							}
						 else 
							 {
							 arrayTelevisores.get(idModif2).setId(newId);
							 arrayTelevisores.get(idModif2).setColor(newColor);
							 arrayTelevisores.get(idModif2).setConsumo_ener(newConsumo);
							 arrayTelevisores.get(idModif2).setPeso(newPeso);
							 arrayTelevisores.get(idModif2).setPrecio_base(newPrecio);
							 arrayTelevisores.get(idModif2).setTdt(newTdt);
							 arrayTelevisores.get(idModif2).setResolucion(newResol);
							 arrayTelevisores.get(idModif2).precioFinal();
							 JOptionPane.showMessageDialog( null ,"El Electrodomestico ha Sido Modificado");
							 
							 flag2=true;
							 
							 pantallaInicio();
							 }
					}
				 
			 }
			 
		 }
		}
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null,"Ha ingresado letras en vez de numeros","ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		}
	}
}
