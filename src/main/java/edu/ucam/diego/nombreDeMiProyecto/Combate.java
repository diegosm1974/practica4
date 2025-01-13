package edu.ucam.diego.nombreDeMiProyecto;

import java.util.Random;

public class Combate {

	private Campeon campeon1;
	private Campeon campeon2;
	
//Constructor de copia
public Combate ( Campeon campeon1, Campeon campeon2) {
	
	this.campeon1 = campeon1;
	this.campeon2 = campeon2;
}
	
//método para iniciar combate. Primero juega campeon1 y luego lo hará campeon2
//Usamos la clase Ramdom para que de forma aleatoria el campeon utilice un ataque básico o una hailidad de su
//lista de habilidades. Y todo ello se hará mientras que a un campeon le queden puntos de visa.
public void iniciar() {
	Random random = new Random();
	Habilidad habilidad;
	int tipoAccion;
	int queHabilidad;
	int ronda = 1;
	while(campeon1.estaVivo() && campeon2.estaVivo()) {
		//Ataque Campeon1 a Campeon2
		tipoAccion = random.nextInt(2);
		if(tipoAccion==0) {//aplicar ataque básico
			System.out.println("Jugador 1 hace ataque básico ");
			campeon1.atacar(campeon2);
		}
		else {//aplicar habilidad
			queHabilidad = random.nextInt(campeon1.totalListaHabilidades());
			habilidad = campeon1.getHabilidad(queHabilidad);
			System.out.println("Jugador 1 usa habilidad " + habilidad.getNombre());
			campeon1.usarHabilidad(habilidad, campeon2);
		}
		if(campeon2.estaVivo()) {
		//Ataque Campeon2 a Campeon1
		tipoAccion = random.nextInt(2);
		if(tipoAccion==0) {//aplicar ataque básico
			System.out.println("Jugador 2 hace ataque básico ");
			campeon2.atacar(campeon1);
		}
		else {//aplicar habilidad
			queHabilidad = random.nextInt(campeon2.totalListaHabilidades());
			habilidad = campeon2.getHabilidad(queHabilidad);
			System.out.println("Jugador 2 usa habilidad " + habilidad.getNombre());
			campeon2.usarHabilidad(habilidad, campeon1);
		 }
		}	
		System.out.println("Finalizada la ronda " + ronda);
		System.out.println("Datos Jugadores");
		System.out.println("Puntos de Vida Jugador1 " + campeon1.getNombre() + " " + campeon1.getPuntosVida());
		System.out.println("Puntos de Vida Jugador2 " + campeon2.getNombre() + " " + campeon2.getPuntosVida());
		ronda=ronda+1;
		/*try {
		Thread.sleep(500);
		}catch(Exception e) {
			System.out.println("Error en partida");	
		}*/
		
	}
	
	detener();
	mostrarGanador();
}

//método que detiene la partida
public void detener() {
	System.out.println("COMBATE FINALIZADO");
}

//método que muestra los datos del campeon de lapartida
public void mostrarGanador() {
	if(campeon1.estaVivo()) System.out.println("El campeón ha sido " + campeon1.getNombre());
	else System.out.println("El campeón ha sido " + campeon2.getNombre());
}
	

}
