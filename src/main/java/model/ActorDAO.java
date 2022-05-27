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

		String sql = "insert into actor (first_name, last_name) values ('" + a.getFirst_name() + "', '" + a.getLast_name() + "')";
		
		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error en metodo create()");
			e.printStackTrace();
		}
		

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

			// creo o llamo la conexión
			Connection c = Conexion.getCon();

			// creo un objeto tipo Statement
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

		String sql = "update actor set first_name = '" + a.getFirst_name() + "', last_name = '" + a.getLast_name()
				+ "' where actor_id = " + a.getId();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error en metodo update()");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Actor a) {
		delete(a.getId());

	}

	@Override
	public void delete(int id) {
		String sql = "delete from actor where actor_id = " + id;

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error en metodo delete()");
			e.printStackTrace();
		}

	}

}
