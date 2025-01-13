package edu.ucam.diego.nombreDeMiProyecto;

public class Habilidad {
	//Atributos de la clade Habilidad
	private String nombre;
	private int dano;
	//Destacamos el enumerado tipo Habilidad como atributo de la clase Habilidad
	private TipoHabilidad tipoHabilidad;


	//Constructor de copia
	public Habilidad (String nombre, int dano,TipoHabilidad tipoHabilidad){
		this.nombre = nombre;
		this.dano = dano;
		this.tipoHabilidad = tipoHabilidad;
	}
	
	//Aplica la habilidad de un campeon  sobre otro campeon
	public void aplicar( Campeon otroCampeon) {	

	        otroCampeon.recibirDano(this.dano);
	}
	
	//método que devuelve el tipo de habilidad que contiene la Habilidad
	public TipoHabilidad getTipoHabilidad() {
		
		return tipoHabilidad;
	}
	
	//método que devuelve la cantidad de daño que ingringe a su oponente una habilidad
	public int getDano() {
		return dano;
	}
	
	//método que devuelve el nombre de una actividad
	public String getNombre() {
		return nombre;
	}
		
}

