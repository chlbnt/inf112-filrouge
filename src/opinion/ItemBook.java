package opinion;

import java.util.LinkedList;
/**
 * The ItemBook class allows to define a book object
 * @author BENOIT & DERRIEN
 * @version  APRIL 2022
 * 
 */

public class ItemBook extends Item{

	private String author;
	private int nbPages;
	
	/**
	 * Define an ItemBook
	 * @param title - book's title
	 * @param kind - kind's book
	 * @param author - author's scenarist
	 * @param nbPages - nbPages's duration
	 */
	
	public ItemBook(String title, String kind, String author, int nbPages) {
		this.title=title;
		this.kind=kind;
		this.author=author;
		this.nbPages=nbPages;
	}
	

	//Return the a String with the characteristics of the ItemBook
	public String toString(){
		
		return "ItemBook [title=" + title + ", kind=" + kind + ", author=" + author + ", nbPages=" + nbPages
		+ ", averageMark=" + averageMark() + "]";

	}	
}
