package edu.ucam.diego.nombreDeMiProyecto;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	//Método utilizado para leer entrada de una línea por teclado
	public static String leerEntrada(){
	     String entradaTeclado = "";
	     Scanner entradaEscaner = new Scanner (System.in); 
	        entradaTeclado = entradaEscaner.nextLine ();
	        return(entradaTeclado);
	    }
	
	//Método que se utiliza para saber el Rol de un Jugador
	public static boolean comprobarRolJugador(String rolJugador){		
		 switch(rolJugador){
         case "ASESINO":                       
         case "MAGO": 
         case "TANQUE": return true;
       
         default: return false;
        }	
	}
	
	public static void main(String[] args) {
	try {	
    //Iniciamos partida
		System.out.println("INICIANDO PARTIDA.....");
    Thread.sleep(1000);
    //Creamos las habilidades para los campeones. Lo suyo hubiera sido que se generen también por entradas de 
    //teclado, pero por simplidficar las crearemos nosotros.
    //En una lista se guardan todas las habilidades creadas.
    //Por simplificar todos los personajes van a tener la misma lista de habilidades peero lo suyo sería que cada tipo de 
    //personaje campeon tuviera una lista de habilidades diferente
    LinkedList<Habilidad> listaHabilidades = new LinkedList();
    Habilidad habilidad1 = new Habilidad("Patada Cruzada", 20 ,TipoHabilidad.DAÑO);
    listaHabilidades.add(habilidad1);
    Habilidad habilidad2 = new Habilidad("Puño Cerrado", 30 ,TipoHabilidad.DAÑO);
    listaHabilidades.add(habilidad2);
    Habilidad habilidad3 = new Habilidad("Golpe Final", 40 ,TipoHabilidad.DAÑO);
    listaHabilidades.add(habilidad3);
    Habilidad habilidad4 = new Habilidad("Pócima", 20 ,TipoHabilidad.CURA);
    listaHabilidades.add(habilidad4);
    Habilidad habilidad5 = new Habilidad("Escudo", 1 ,TipoHabilidad.BUFF);
    listaHabilidades.add(habilidad5);
    boolean continuar1 = false;
    boolean continuar2 = false;
    String nombreJugador1="";
    String rolJugador1="";
    String nombreJugador2="";
    String rolJugador2="";
    
    //Lo primero que hacemos es mostrar por pantalla el formulario de creación de campeones
    // y rol de cada uno para configurarlo antes de iniciarse la partida.
	while((continuar1==false)|| (continuar2==false) ){
	   System.out.println("BIENVENIDO AL JUEGO DE LUCHA DE CAMPEONES");
	   System.out.println("--------------------------------");
	   System.out.println("Introduce nombre para Jugador 1:");
	   nombreJugador1 = leerEntrada();
	   System.out.println("Introduce rol para Jugador 1[ASESINO - MAGO - TANQUE]:");
	   rolJugador1 = leerEntrada();
	   System.out.println("Introduce nombre para Jugador 2:");
	   nombreJugador2 = leerEntrada();
	   System.out.println("Introduce rol para Jugador 2[ASESINO - MAGO - TANQUE]");
	   rolJugador2 = leerEntrada();
	   continuar1 = comprobarRolJugador(rolJugador1);
	   continuar2 = comprobarRolJugador(rolJugador2);
	   if( (continuar1==false)|| (continuar2==false) ) {
		   System.out.println("Debes introducir un rol de los disponibles para los jugadores");
		   System.out.println("Vuelve a introducir los datos");
	   }
    }
	
	//Una vez tenemos los datos correctos de entrada creamos los 2 jugadores.
	//Cada uno con el rol que ha elegigo el usuario introduciendo los datos por pantalla
	Rol rol1 = Rol.valueOf(rolJugador1);
	Campeon campeon1 = new Campeon(nombreJugador1, rol1,listaHabilidades);
	
	Rol rol2 = Rol.valueOf(rolJugador2);
	Campeon campeon2 = new Campeon(nombreJugador2, rol2,listaHabilidades);
	
	//Creamos un combate con ambos juagadores y lo iniciamos.
	//Al finalizar nos mostrará quien es el ganador,
	//Hemos puesto en diferentes métodos muchas salidas por consola con el fin de poder ir viendo
	//que todo se ejecuta correctamente.
	Combate combate = new Combate(campeon1,campeon2);
	combate.iniciar();
    int a = 2;
	}catch(Exception e) {
		System.out.println("Error en la ejecución de la partida");
	}
			
	}

}
