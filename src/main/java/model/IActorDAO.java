package model;

import java.util.List;

public interface IActorDAO {

	/*
	 * C = create - crear
	 * R = read - leer
	 * U = update - actualizar
	 * D = delete - borrar
	 */
	
	public void create(Actor a);
	public Actor read(int id);
	public List<Actor> read();
	public void update(Actor a);
	public void delete(Actor a);
	public void delete(int id);
	
	
	
		
}
