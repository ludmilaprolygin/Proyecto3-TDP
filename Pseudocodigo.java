//Pseudocodigo Generacion del mapa
Generar_mapa{
	contador_infectado=0;
	cargar_fondo(imagen);
	cargar_player(imagen);
	Set_posicion_jugador(Centro_abajo);
	mientras que (contador_infectado < cantidad_infectados_tanda){
		esperar(5000); // espera 5 segundos para agregar otro infectado
		agregar_infectado(imagen,posicion_random_inicial);
		contador_infectado ++;
	}  
}

//Pseudocodigo de Movimiento del jugador e infectados
movimiento_jugador{
	mientras que(no_este_muerto && no_gano){
		en caso de(apretar_tecla){
			apretar izquierda: mover_hacia_izquierda(jugador);
			apretar derecha: mover_hacia_derecha(jugador);
			apretar arriba: disparar_proyectil();
		}
	}
}
movimiento_infectados{
	mientras que (posicion!=fin){
		mover_hacia_abajo;
		if(jugador(perdio))
			detener_infectados;
		if(efecto_cuarentena){
			detener_infectados;
			esperar(10000); // espera 10 segundos y vuelve a mover hacia abajo
			efecto_cuarentena = desactivado;
		}
	}
	if(posicion==fin && esta_infectado) 
		set_posicion_infectado(posicion_random_inicial);
}