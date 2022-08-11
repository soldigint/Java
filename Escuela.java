package Mochila;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


import java.awt.Shape; 

import java.awt.geom.RoundRectangle2D; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.awt.*;
import java.awt.event.*;




public class Escuela extends JFrame{
	static Maestro [] maestros;
	static Alumno [] alumnos;
	static String [] inmobiliario;
	static int ContadorAlumnos=0;
	static int ContadorMaestros=0;
	static int ContadorMuebles=0;
	
	 static   Connection con;
	 static   Statement st;
	 
	
	static private JPanel contenidoPrincipal,contenidoAM,contenidoEM,contenidoMM,contenidoMod;
	static private JTextArea areaDeTexto;
	static private JTextField nombreMaestro,nombreAlumno,mueble,nombreanterior,nombrenuevo;
	static private JLabel etiquetanombreMaestro,etiquetanombreAlumno,etiquetamueble,Borrador;
	static private JButton botonAM,botonEM,botonMM,botonMod,botonmodificarMaestro,botonmostrarMaestro,botonagregarMaestro,botoneliminarMaestro,botonagregarAlumno,botonagregarMueble;
	static private Escuela frame;
	static private JButton cobrar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{   public void run() 
            {      
			
			        frame = new Escuela();
                    frame.setTitle(" Escuela las Rocas Perpetuas");
                    frame.setVisible(true);
                    maestros = new Maestro[10];
                	alumnos = new Alumno[10];
                	inmobiliario= new String[10];
            }
        });
	}
	
	public Escuela()
	{       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 800);
	        
	    	
	    	
	        setBackground(new Color(134, 137, 93));
	        contenidoPrincipal = new JPanel();
	        contenidoPrincipal.setLayout(null);
	        setContentPane(  contenidoPrincipal);
	
	        botonAM = new JButton("Agregar Nuevo Maestro");
	        botonAM.setLocation(150, 100);
	        botonAM.setBounds(150, 100, 160, 40);
	        AccionaAgregarMaestro listener = new AccionaAgregarMaestro();
	        botonAM.addActionListener(listener);
	        botonAM.setForeground(new Color(255, 0, 120));
	        
	        botonEM = new JButton("Eliminar Nuevo Maestro");
	        botonEM.setLocation(150, 150);
	        botonEM.setBounds(150, 150, 160, 40);
	        AccionaEliminarMaestro eliminalo = new AccionaEliminarMaestro();
	        botonEM.addActionListener(eliminalo);
	        botonEM.setForeground(new Color(255, 0, 120)); 
	        
	        botonMM = new JButton("Mostrar Maestros");
	        botonMM.setLocation(150, 200);
	        botonMM.setBounds(150, 200, 160, 40);
	        AccionaMostrarMaestro mostrar = new AccionaMostrarMaestro();
	        botonMM.addActionListener(mostrar);
	        botonMM.setForeground(new Color(255, 0, 120));
	        
	        botonMod = new JButton("Modificar Maestros");
	        botonMod.setLocation(150, 250);
	        botonMod.setBounds(150, 250, 160, 40);
	        AccionaModificarMaestro modificar = new AccionaModificarMaestro();
	        botonMod.addActionListener(modificar);
	        botonMod.setForeground(new Color(255, 0, 120));
	        
	       cobrar = new JButton("cobrar a alumnos");
	       cobrar.setLocation(150, 350);
	       cobrar.setBounds(150, 350, 160, 40);
	        AccionaCobrara cobrara = new AccionaCobrara();
	        cobrar.addActionListener(cobrara);
	        cobrar.setForeground(new Color(255, 0, 120));
	        
	        contenidoPrincipal.add(botonAM); 	
	        contenidoPrincipal.add(botonEM); 
	        contenidoPrincipal.add(botonMM); 
	        contenidoPrincipal.add(botonMod); 
	        contenidoPrincipal.add(cobrar); 
	}
	
	
	private static class AccionaCobrara implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	Avisos hilo1 = new Avisos("Juan");
	    	Avisos hilo2 = new Avisos("Pedro");
	  		
	  		
	  		hilo1.setMensaje("Favor de pagar");		
	  		hilo2.setMensaje("Favor de pagar");		
	  		        hilo1.start();		
	  		        hilo2.start();
	    	  
	    	 // JOptionPane.showMessageDialog(null,"Registro actualizado"); 
	      }
	   }
	private static class AccionaAgregarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	    contenidoAM = new JPanel();
	    	    contenidoAM.setLayout(null);
		       
	    	    botonagregarMaestro = new JButton("Agregar Maestro");
		        botonagregarMaestro.setLocation(50, 160);
		        botonagregarMaestro.setBounds(50, 160, 160, 40);
		        EjecutaAgregarMaestro listener = new EjecutaAgregarMaestro();
		        botonagregarMaestro.addActionListener(listener);
		        contenidoAM.add(botonagregarMaestro); 
		        
		        etiquetanombreMaestro =new JLabel();
		        etiquetanombreMaestro.setText("Nombre del Maestro");
		        etiquetanombreMaestro.setLocation(50, 50);
		        etiquetanombreMaestro.setBounds(50, 50, 160, 40);
		        contenidoAM.add(etiquetanombreMaestro);
		        
		        nombreMaestro = new JTextField();
		        nombreMaestro.setLocation(50, 100);
		        nombreMaestro.setBounds(50, 100, 160, 40);
		        contenidoAM.add(nombreMaestro);
		    
	    	JFrame ventana = new JFrame("Agregar Maestro");
	  		ventana.setContentPane(contenidoAM);
	  		ventana. setBounds(50, 50, 500, 500);
	  		ventana.setLocation(50,50);
	  		ventana.setVisible(true);
	  		ventana.setBackground(new Color(18, 10, 143));
	  		
	  		
	        
	  	 		
	      }
	   }
	
	
	private static class AccionaMostrarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	    contenidoMM = new JPanel();
	    	    contenidoMM.setLayout(null);
		       
	    	    JLabel etiqueta =new JLabel();
		        etiqueta.setText("Los nombres de los maestros son: ");
		        etiqueta.setLocation(150, 50);
		        etiqueta.setBounds(150, 50, 360, 40);
		        contenidoMM.add(etiqueta);
		        
		        areaDeTexto = new JTextArea();
		        areaDeTexto.setLocation(50, 100);
		        areaDeTexto.setBounds(50, 100, 260, 140);
		        contenidoMM.add(areaDeTexto);
		    
	    	JFrame ventana = new JFrame("Mostrar Maestro");
	  		ventana.setContentPane(contenidoMM);
	  		ventana. setBounds(50, 50, 500, 500);
	  		ventana.setLocation(50,50);
	  		ventana.setVisible(true);
	  		ventana.setBackground(new Color(18, 100, 43));
	  		
	  		  mostrar();
	       
	  	 		
	      }
	   }
	
	
	private static class AccionaModificarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	    contenidoMod = new JPanel();
	    	    contenidoMod.setLayout(null);
		       
	    	    JLabel etiqueta =new JLabel();
		        etiqueta.setText(" Dame el nombre anterior ");
		        etiqueta.setLocation(150, 50);
		        etiqueta.setBounds(150, 50, 360, 40);
		        contenidoMod.add(etiqueta);
		        
		        nombreanterior = new JTextField();
		        nombreanterior.setLocation(150, 100);
		        nombreanterior.setBounds(150, 100, 160, 40);
		        contenidoMod.add(nombreanterior);
		        
		        JLabel etiqueta1 =new JLabel();
		        etiqueta1.setText(" Dame el nombre siguiente ");
		        etiqueta1.setLocation(150, 150);
		        etiqueta1.setBounds(150, 150, 360, 40);
		        contenidoMod.add(etiqueta1);
		        
		         nombrenuevo = new JTextField();
		        nombrenuevo.setLocation(150, 200);
		        nombrenuevo.setBounds(150, 200, 160, 40);
		        contenidoMod.add(nombrenuevo);
		        
		        JButton botonMos = new JButton("Actualizar");
		        botonMos.setLocation(150, 250);
		        botonMos.setBounds(150, 250, 160, 40);
		        EjecutaModificarMaestro modificarMaestro = new EjecutaModificarMaestro();
		        botonMos.addActionListener(modificarMaestro);
		        contenidoMod.add(botonMos); 
		        
		        Borrador =new JLabel();
		        Borrador.setText(" ");
		        Borrador.setLocation(150, 300);
		        Borrador.setBounds(150, 300, 360, 40);
		        contenidoMod.add(Borrador);

		        
		        
		        JFrame ventana = new JFrame("Modificar Maestro");
	  		ventana.setContentPane(contenidoMod);
	  		ventana. setBounds(50, 50, 500, 500);
	  		ventana.setLocation(50,50);
	  		ventana.setVisible(true);
	  		ventana.setBackground(new Color(18, 100, 43));
	  		
	  		  
	        
	  	 		
	      }
	   }
	
	
	private static class AccionaEliminarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	    contenidoEM = new JPanel();
	    	    contenidoEM.setLayout(null);
		       
	    	    botoneliminarMaestro = new JButton("Eliminar Maestro");
		        botoneliminarMaestro.setLocation(50, 160);
		        botoneliminarMaestro.setBounds(50, 160, 160, 40);
		        EjecutaEliminarMaestro listener = new EjecutaEliminarMaestro();
		        botoneliminarMaestro.addActionListener(listener);
		        contenidoEM.add(botoneliminarMaestro); 
		        
		        etiquetanombreMaestro =new JLabel();
		        etiquetanombreMaestro.setText("Nombre del Maestro");
		        etiquetanombreMaestro.setLocation(50, 50);
		        etiquetanombreMaestro.setBounds(50, 50, 160, 40);
		        contenidoEM.add(etiquetanombreMaestro);
		        
		        nombreMaestro = new JTextField();
		        nombreMaestro.setLocation(50, 100);
		        nombreMaestro.setBounds(50, 100, 160, 40);
		        contenidoEM.add(nombreMaestro);
		    
	    	JFrame ventana = new JFrame(" Eliminar Maestro");
	  		ventana.setContentPane(contenidoEM);
	  		ventana. setBounds(50, 50, 500, 500);
	  		ventana.setLocation(50,50);
	  		ventana.setVisible(true);
	  		ventana.setBackground(new Color(18, 10, 143));
	  		
	  		
	        
	  	 		
	      }
	   }
	
	
	private static class EjecutaModificarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	   Conecta conexion=new Conecta();
	    	  conexion.actualizar(nombreanterior.getText(),nombrenuevo.getText());
	    	  
	    	  nombreanterior.setText("");
	    	  nombrenuevo.setText("");
	    	  Borrador.setText(" Registro actualizado");
	    	  
	    	  JOptionPane.showMessageDialog(null,"Registro actualizado"); 
	      }
	   }
	
	private static class EjecutaEliminarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	   Conecta conexion=new Conecta();
	    	  conexion.eliminar(nombreMaestro.getText());
	    	  ContadorMaestros--;
	    	  nombreMaestro.setText("");
	    	  JOptionPane.showMessageDialog(null,"Registro eliminado"); 
	    	  
	      }
	   }
	
	private static class EjecutaAgregarMaestro implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  Conecta conexion=new Conecta();
	    	  conexion.inserta(ContadorMaestros,nombreMaestro.getText());
	    	  ContadorMaestros++;
	    	  nombreMaestro.setText("");
	    	  JOptionPane.showMessageDialog(null,"Registro insertado"); 
	      }
	   }
	
	/*static void MostrarProfesor()
	 {
		 for(int i=0;i<ContadorMaestros;i++)
		 {
			 System.out.println("El profesor se llama "+ maestros[i].DaNombre());
		 }
		 ContadorMaestros--;
		 
	 }

	
	static void EliminarMaestro(int indice)
	 {
		 for(int i=indice;i<ContadorMaestros;i++)
		 {
			 maestros[i-1]=maestros[i];
		 }
		 ContadorMaestros--;
		 
	 }

	 static void EliminarAlumno(int indice)
	 {
		 for(int i=indice;i<ContadorAlumnos;i++)
		 {
			 alumnos[i-1]=alumnos[i];
		 }
		 ContadorAlumnos--;
		 
	 }
	 
	 static void EliminarMuebles(int indice)
	 {
		 for(int i=indice;i<ContadorMuebles;i++)
		 {
			 inmobiliario[i-1]=inmobiliario[i];
		 }
		 ContadorMuebles--;
		 
	 }

	static  void AgregarProfesor(String n)
	 {
		 
		 Maestro profesor;
		 profesor=new Maestro(n);
		 maestros[ContadorMaestros]=profesor;
		 ContadorMaestros=ContadorMaestros+1;
	 }
	 static void ModificarMaestro(String nombre,int indice)
	 {
		 Maestro profesor=new Maestro(nombre);
		 
		 maestros[indice]=profesor;
		 
	 }
	 
	 static  void AgregarAlumno(String nombre) 
	 {
		 
		 Alumno alumno=new Alumno(nombre);
		 alumnos[ContadorAlumnos]=alumno;
		 ContadorAlumnos=ContadorAlumnos+1;
	 }
	 static void ModificarAlumno(String nombre,int indice)
	 {
		 Alumno alumno=new Alumno(nombre);
		 alumnos[indice]=alumno;
		 
	 }
	  static void AgregarMueble(String nombre)
	 {
		 
		 inmobiliario[ContadorMuebles]=nombre;
		 ContadorMuebles=ContadorMuebles+1;
	 }
	 static void ModificarMueble (String nombre,int indice)
	 {
		 inmobiliario[indice]=nombre;
	 }
	 */
	 public static  void mostrar(){
		 try{
		      Class.forName("org.postgresql.Driver");
		    }
		    catch(Exception ex){    
		    	System.out.println("<H3>Error ejecutando forName...</H3>");
		    }
		    
		    try{
		    	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/escuela", "postgres", "kissbelly");
		        st=con.createStatement();
		String sql="select * from  maestro";
		ResultSet rs = st.executeQuery(sql);
		int aux1=0;
		String aux2=null;
		 
		 while (rs.next()) {
	       aux1=rs.getInt(1);
	        aux2=rs.getString(2);
	        areaDeTexto.append(aux1+" "+aux2+"\n");
	        
		 }
		  st.close();
	      con.close();
	      
	    }
	    catch(Exception e){
	      System.out.println("Error al acceder a la base de datos");
	    }
		}
}
