package edu.ucam.diego.nombreDeMiProyecto;



import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class CampeonTest {

	@Test
	void test() {
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
		Campeon campeon1 = new Campeon("DIEGO", Rol.ASESINO, listaHabilidades);
		assertAll(
				()->assertEquals(100, campeon1.getPuntosVida()),
				()->assertEquals(20, campeon1.getDanoAtaque()),
				()->assertEquals(1, campeon1.getDefensa())
				);
		Campeon campeon2 = new Campeon("LUIS", Rol.MAGO, listaHabilidades);
		assertAll(
				()->assertEquals(100, campeon2.getPuntosVida()),
				()->assertEquals(16, campeon2.getDanoAtaque()),
				()->assertEquals(2, campeon2.getDefensa())
				);
		campeon1.atacar(campeon2);
		assertAll(
				()->assertEquals(90, campeon2.getPuntosVida())
				);
		campeon1.setPuntosVida(0);
		assertAll(
				()->assertEquals(0, campeon1.getPuntosVida()),
				()->assertEquals(false, campeon1.estaVivo())
				);
		campeon1.setPuntosVida(100);
		campeon1.usarHabilidad(habilidad2, campeon2);
		assertAll(
				()->assertEquals(75, campeon2.getPuntosVida())
				);
		campeon2.usarHabilidad(habilidad4, campeon1);
		assertAll(
				()->assertEquals(95, campeon2.getPuntosVida())
				);
		campeon2.usarHabilidad(habilidad4, campeon1);
		assertAll(
				()->assertEquals(100, campeon2.getPuntosVida())
				);
		campeon1.usarHabilidad(habilidad5, campeon2);
		campeon2.atacar(campeon1);
		assertAll(
				()->assertEquals(92, campeon1.getPuntosVida())
				);
		Combate combate = new Combate(campeon1,campeon2);
		combate.iniciar();
		combate.mostrarGanador();
		
	}


}
