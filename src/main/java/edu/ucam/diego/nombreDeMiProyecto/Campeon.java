package edu.ucam.diego.nombreDeMiProyecto;

import java.util.LinkedList;

public class Campeon {
	private String nombre;
	private Rol rol;
	private int puntosVida;
	private int danoAtaque;
	private int defensa;
	private LinkedList<Habilidad> listaHabilidades ;
	
    //Constructor de copia con todos los atributos
	public Campeon(String nombre, Rol rol, int puntosVida, int danoAtaque, int defensa, LinkedList listaHabilidades) {
	this.nombre = nombre;
	this.rol = rol;
	this.puntosVida = puntosVida;
	this.danoAtaque = danoAtaque;
	this.defensa = defensa;
	this.listaHabilidades = listaHabilidades;
	}
	
	//Constructor de copia a partir del rol del Campeon que queremos crear
	public Campeon(String nombre, Rol rol,LinkedList listaHabilidades) {
	this.nombre = nombre;
	this.rol = rol;
	this.listaHabilidades = listaHabilidades;
	
	switch (rol) {
    case ASESINO:
    	 this.puntosVida = 100;
    	 this.danoAtaque = 20;
    	 this.defensa = 1;
    	 System.out.println("Creando un asesino");
        break;
    case MAGO:
    	 this.puntosVida = 100;
    	 this.danoAtaque = 16;
    	 this.defensa = 2;
    	 System.out.println("Creando un mago");
        break;
    case TANQUE:
    	 this.puntosVida = 100;
    	 this.danoAtaque = 18;
    	 this.defensa = 2;
    	 System.out.println("Creando un tanque");
        break;
    default:
        System.out.println("Tipo rol desconocida.");
	
	}
	
  }
	//Método que devuelve el rol del Campeon
	public Rol getTipoRoll() {
		
		return rol;
	}
	
	//método utilizado para que un campeón ataque a otro campeon mediante ataque básico
	public void atacar (Campeon otroCampeon) {
		otroCampeon.recibirDano(this.danoAtaque);
	}
	
	//método utilizado para que un campeon use una hablilidad contra su oponente
	public void usarHabilidad(Habilidad habilidad, Campeon otroCampeon) {
		switch (habilidad.getTipoHabilidad()) {
	    case DAÑO:
	    	System.out.println("Aplicando habilidad DAÑO ");
	    	habilidad.aplicar(otroCampeon);	
	        break;
	    case CURA:
	        System.out.println("Aplicando habilidad CURA ");
	    	this.aumentarVida(habilidad.getDano());
	    	break;
	    case BUFF:
	    	System.out.println("Aplicando habilidad BUFF ");
	    	this.aumentarDefensa();
	        break;
	    default:
	        System.out.println("Tipo Habilidad desconocida.");
	  }	
	}
	
	//Este método se encarga de sertar puntos de vida al campeón que recibe el ataque
	public void recibirDano (int dano) {
		System.out.println("Puntos antes de recibir daño " + puntosVida);
		System.out.println("Recibiendo Daño " + dano);
		System.out.println("Defensa " + defensa);
		puntosVida = puntosVida-(dano/defensa);
		System.out.println("Puntos que quedan " + puntosVida);
		
	}
	
	//método que se utiliza para aumentar los puntos de vida de un campeon
	public void aumentarVida (int vida) {
		puntosVida = puntosVida+vida;
		if(puntosVida >100) puntosVida= 100;
		System.out.println("Puntos de Vida tras su aumento "+ puntosVida);
	}
	
	//método que se utiliza para aumentar la defensa de un campeon
	public void aumentarDefensa() {
		if(defensa<3)
		defensa = defensa+1;	
	}
	
	//método que comprueba si un campeon está vivo, es decir, tiene puntos de vida.
	public boolean estaVivo() {
		if (puntosVida >0) return true;
		else return false;
	}
	
	//método que calcula el total de habilidades que tiene un campeon
	public int totalListaHabilidades() {
		return listaHabilidades.size();
	}
	
	//método que devuelve la habilidad que se encuentra en una posición dad de la lista de habilidades
	public Habilidad getHabilidad(int posicion) {
		return listaHabilidades.get(posicion);
	}
	
	//método que devuelve el nombre del campeon
	public String getNombre(){
		return nombre;
	}
	
	//método que devuelve los puntos de vida del campeon
	public int getPuntosVida(){
		return puntosVida;
	}
	
	//método que inicializa los puntos de vida de un campeon.
	//Lo usamos solo para las pruebas de test.
	public void setPuntosVida(int puntos){
		puntosVida=puntos;
	}
	
	//método que devuelve la potencia de ataque de un campeon
	public int getDanoAtaque(){
		return danoAtaque;
	}
	
	//método que devuelve la cantidad de defensa de un campeon
	public int getDefensa(){
		return defensa;
	}
	
}
