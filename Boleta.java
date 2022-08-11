package Mochila;

public class Boleta {
	String NombreAlumno;
	 int [] arregloCalificaciones;
	 String TipoCurso;
	
	 Boleta(String nombre, int numeroCalificaciones)
{
NombreAlumno=nombre;
arregloCalificaciones =new int[numeroCalificaciones];

		 }
	  void AnotarCalificacion(int indice, int calificacion)
	  {
		  arregloCalificaciones[indice]=calificacion;
		  
	  }
	  void ModificarCalificacion(int indice, int calificacion)
	  {
		  arregloCalificaciones[indice]=calificacion;
	  }
	  void EliminarCalificacion(int indice)
	  {
		  arregloCalificaciones[indice]=0;
	  }


}
