package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmActorDAO implements IFilmActorDAO {

	@Override
	public List<FilmActor> read(int idActor) {
		
		List<FilmActor> lista = new ArrayList<FilmActor>();
		
		String sql = "select f.film_id, title, description, la.name, release_year, rating, special_features "
				+ "from film as f inner join film_actor as fa on (f.film_id = fa.film_id) inner join language as la on (f.language_id = la.language_id)"
				+ "where fa.actor_id = " + idActor;
		
		System.out.println(sql);
		
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			
			while (rs.next()) {
				lista.add(new FilmActor( 
							rs.getInt("film_id"),
							rs.getString("title"),
							rs.getString("description"),
							rs.getString("name"),
							rs.getInt("release_year"),
							rs.getString("rating"),
							rs.getString("special_features")));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al leer las películas del actor " + idActor);
			e.printStackTrace();
		}
		
		return lista;
		
	}

}
