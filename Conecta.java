package Mochila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conecta {
	 static   Connection con;
	 static   Statement st;
	 
	 public static int inserta(int id,String nombre){
		 try{
		      Class.forName("org.postgresql.Driver");
		    }
		    catch(Exception ex){    
		    	System.out.println("<H3>Error ejecutando forName...</H3>");
		    }
		    
		    try{
		    	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/escuela", "postgres", "kissbelly");
		        st=con.createStatement();
		String sql="insert into maestro values("+ id+",'"+ nombre+"')";
		 st.executeUpdate(sql);
		  st.close();
	      con.close();
	      System.out.println("Registro insertado");
	    }
	    catch(Exception e){
	      System.out.println("Error al acceder a la base de datos");
	    }
		 
		return 1;
		}
	 
	 public static int eliminar(String nombre){
		 try{
		      Class.forName("org.postgresql.Driver");
		    }
		    catch(Exception ex){    
		    	System.out.println("<H3>Error ejecutando forName...</H3>");
		    }
		    
		    try{
		    	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/escuela", "postgres", "kissbelly");
		        st=con.createStatement();
		String sql="delete from maestro where nombre='"+nombre+"'";
		 st.executeUpdate(sql);
		  st.close();
	      con.close();
	      System.out.println("Registro eliminado");
	    }
	    catch(Exception e){
	      System.out.println("Error al acceder a la base de datos");
	    }
		 
		return 1;
		}

	 
	 public static void actualizar(String anterior, String nuevo){
		 try{
		      Class.forName("org.postgresql.Driver");
		    }
		    catch(Exception ex){    
		    	System.out.println("<H3>Error ejecutando forName...</H3>");
		    }
		    try{
		    	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/escuela", "postgres", "kissbelly");
		    	st=con.createStatement();
	  	  String sql="update maestro set nombre='"+nuevo+"' where nombre='"+anterior+"'";
		  st.executeUpdate(sql);
		  st.close();
	      con.close();
	      System.out.println("Registro actualizado");
	    }
	    catch(Exception e){
	      System.out.println("Error al acceder a la base de datos");
	    }
		 
		
		}
	 
	
	 
}
