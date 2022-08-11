package Mochila;

public class Avisos extends Thread{
	    String mensaje;
	    public Avisos(String msg)
	    {
	        super(msg);
	    }

	    public void run()

	    {
	    	System.out.println("Debe pagar:"+this.getName());
	    	System.out.println(mensaje);
	        
	    }

	    public void setMensaje(String msj)
	    {
	        this.mensaje = msj;
	    }
} 


