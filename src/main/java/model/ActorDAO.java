package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO implements IActorDAO {

	@Override
	public void create(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actor read(int id) {

		Actor a = null;
		
		
		try {
			
			Connection c = Conexion.getCon();			
			Statement s = c.createStatement();
			
			String sql = "select actor_id, first_name, last_name from actor where actor_id = " + id;
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				
				a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
				System.out.println(rs.getString("first_name"));
				
			}
			
		} catch (SQLException e) {
		
			System.out.println("Error al leer un actor");
			e.printStackTrace();
			
		}
		
		return a;
	}

	@Override
	public List<Actor> read() {
		List<Actor> lista = new ArrayList<Actor>();
		
		try {
			
			//creo o llamo la conexión
			Connection c = Conexion.getCon();
			
			//creo un objeto tipo Statement
			Statement s = c.createStatement();
			String sql = "select actor_id, first_name, last_name from actor";
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Actor a = new Actor();
				
				a.setId(rs.getInt("actor_id"));
				a.setFirst_name(rs.getString("first_name"));
				a.setLast_name(rs.getString("last_name"));
				
				lista.add(a);
				
			}

			
		} catch (SQLException e) {
			System.out.println("Error en el metodo read()");
			e.printStackTrace();
		}
			
		return lista;
	}

	@Override
	public void update(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Actor a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
