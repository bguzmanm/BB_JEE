package model;

public class FilmActor {

	private int id;
	private String title;
	private String description;
	private String language;
	private int release_year;
	private String rating;
	private String special_features;
	
	public FilmActor() {
		super();
	}
	

	public FilmActor(int id, String title, String description, String language, int release_year, String rating,
			String special_features) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.release_year = release_year;
		this.rating = rating;
		this.special_features = special_features;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	

	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "FilmActor [id=" + id + ", title=" + title + ", description=" + description + ", release_year="
				+ release_year + ", rating=" + rating + ", special_features=" + special_features + "]";
	}
	
	
}
