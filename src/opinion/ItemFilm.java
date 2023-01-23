package opinion;
	
/*
 * The ItemFilm class allows to define a film object
 * @author BENOIT & DERRIEN
 * @version  MAY 2022
 */

public class ItemFilm extends Item {
	
	private String director;
	private String scenarist;
	private int duration;
	
	/**
	 * Define an ItemReview
	 * @param director - film's director
	 * @param scenarist - film's scenarist
	 * @param duration - films's duration
	 */
	
	public ItemFilm(String title, String kind, String director, String scenarist, int duration) {
		this.title=title;
		this.kind=kind;
		this.director=director;
		this.duration=duration;
		this.scenarist=scenarist;
	}
	
	//Return the a String with the characteristics of the ItemFilm
	public String toString(){
		return "ItemFilm [title=" + title + ", kind=" + kind + ", director=" + director + ", scenarist=" + scenarist
				+ ", duration=" + duration + ", averageMark=" + averageMark() + "]";

	}
}

