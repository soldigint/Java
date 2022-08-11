package Mochila;

public class Maestro {
	String Nombre;
String Horarios;
Alumno [] Alumnos;

Maestro (String n)
{
Nombre=n;	
}

String DaNombre()
{
	return Nombre;
	}
void DarClase()
{
	}
int AsignarCalificacion(int calificacion)
{
	return calificacion;
	}
boolean EntregarBoleta( boolean acuse)
{
	return acuse;
	}
boolean Cobrar(boolean acuse)
{
	return acuse;
	}

}
