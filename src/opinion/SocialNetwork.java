package opinion;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.MemberAlreadyExistsException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

/**
 * System for collecting opinions on items from various areas (literature,
 * cinema, art, gastronomy, etc.). 
 * 
 * @author BENOIT & DERRIEN
 * @version  APRIL 2022
 * 
 */
public class SocialNetwork implements ISocialNetwork {
	private int nbMembers;
	protected LinkedList<Member> listMember = new LinkedList<Member>();
	private LinkedList<ItemBook> listItemBooks = new LinkedList<ItemBook>();
	protected LinkedList<ItemFilm> theItemFilms = new LinkedList<ItemFilm>();
	
	/**
	 * Get the number of members registered in the SocialNetwork
	 * @return number of members
	 */

	
	public int nbMembers() {
		return nbMembers;
	}

	/**
	 * Get the number of films registered in the <i>SocialNetwork</i>
	 * 
	 * @return number of films
	 */
	
	public int nbFilms() {
			return this.theItemFilms.size();
		}

	/**
	 * Get the number of books registered in the <i>SocialNetwork</i>
	 * 
	 * @return number of books
	 */
	public int nbBooks() {
		return this.listItemBooks.size();
	}

	/**
	 * Add a new member to the <i>SocialNetwork</i>
	 * 
	 * @param login
	 *            the new member's login
	 * @param password
	 *            the new member's password
	 * @param profile
	 *            a free String describing the new member's profile
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if profile is not instantiated</li>
	 *             </ul>
	 * <br>
	 * 
	 * @throws MemberAlreadyExistsException
	 *             if a member with the same login is already registered in the
	 *             <i>SocialNetwork</i> (same login : not case-sensitive and
	 *             leadings/trailings blanks are not taken into account)
	 * 
	 */
	public void addMember(String login, String password, String profile)
			throws BadEntryException, MemberAlreadyExistsException {
		/**
		 * BadEntryException Test
		 */
			if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
			if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
			if(profile==null) throw new BadEntryException("if profile is not instantiated");
		/**
		 * MemberAlreadyExistsException test
		 */
			for(Member theMember : listMember) {
			if(theMember.isCalled(login)) throw new MemberAlreadyExistsException();
		}
		/**
		 * creation and addition of new member to the list of this.theMembers
		 */
		Member theMember=new Member(login,password,profile);
		listMember.add(theMember);
		nbMembers++;

	}
	
	/**
	 * Find a member in the list of Member
	 * otherwise, raise the exception NotMemberException
	 * 
	 * @param login's Member
	 * @param password's Member
	 * @return Member
	 * @throws NotMemberException
	 */
	public Member findAMemberOrThrowNotMemberException(String login,String password) throws NotMemberException {
		int positionIndexOfTheLogin=0;
		while(positionIndexOfTheLogin<nbMembers() && !listMember.get(positionIndexOfTheLogin).isCalled(login,password)){ 
			positionIndexOfTheLogin+=1;
		}
		if(positionIndexOfTheLogin==nbMembers())throw new NotMemberException("login does not match with the login of a registered member in SocialNetwork or if password does not correspond to his registered password.");
		return listMember.get(positionIndexOfTheLogin);
	}

	/**
	 * Find a Book in the list of Film
	 * otherwise, raise the exception ThrowNotItemException
	 * @param title
	 * @return ItemBook
	 * @throws NotItemException
	 */
	public ItemBook findABookOrThrowNotItemException(String title) throws NotItemException{
		int positionIndexOfTheItemBook=0;
		while(positionIndexOfTheItemBook<nbBooks() && !listItemBooks.get(positionIndexOfTheItemBook).isCalled(title)){
			positionIndexOfTheItemBook+=1;
		}
		if(positionIndexOfTheItemBook==nbBooks())throw new NotItemException("title is not registered as a book's title in the SocialNetwork");
		return listItemBooks.get(positionIndexOfTheItemBook);
	}
	
	/**
	 * Find a Film in the list of Film
	 * otherwise, raise the exception ThrowNotItemException
	 * 
	 * @param title
	 * @return ItemFilm
	 * @throws NotItemException
	 */

	public Item findAFilmOrThrowNotItemException(String title) throws NotItemException{
		int positionIndexOfTheItemFilm=0;
		while(positionIndexOfTheItemFilm<nbFilms() && !theItemFilms.get(positionIndexOfTheItemFilm).isCalled(title)){
			positionIndexOfTheItemFilm+=1;
		}
		if(positionIndexOfTheItemFilm==nbFilms())throw new NotItemException("title is not registered as a film's title in the SocialNetwork");
		return theItemFilms.get(positionIndexOfTheItemFilm);
	}

	/**
	 * Add a new film to the <i>SocialNetwork</i>
	 * 
	 * @param login
	 *            login of the member adding the film
	 * @param password
	 *            password of the member adding the film
	 * @param title
	 *            the new film's title
	 * @param kind
	 *            the new film's kind (adventure, thriller, etc.)
	 * @param director
	 *            the new film's director
	 * @param scenarist
	 *            the new film's scenarist
	 * @param duration
	 *            the new film's duration (in minutes)
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if title is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if kind is not instanciated</li>
	 *             <li>if director is not instanciated</li>
	 *             <li>if scenarist is not instanciated</li>
	 *             <li>if duration is not stricly positive
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 * @throws ItemFilmAlreadyExistsException
	 *             : a film with the same title is already registered in the
	 *             <i>SocialNetwork</i> (same title : not case-sensitive and
	 *             leadings/trailings blanks are not taken into account)
	 * 
	 */
	public void addItemFilm(String login, String password, String title,
			String kind, String director, String scenarist, int duration)
			throws BadEntryException, NotMemberException,
			ItemFilmAlreadyExistsException {
		/**
		 * BadEntryException test
		 */
		if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
		if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		if(kind==null) throw new BadEntryException("kind is not instantiated");
		if(director==null) throw new BadEntryException("director is not instantiated");
		if(scenarist==null) throw new BadEntryException("scenarist is not instantiated");
		if(duration<=0) throw new BadEntryException("duration is not strictly positive");
		/**
		 * NotMemberException test
		 */
		findAMemberOrThrowNotMemberException(login,password);
		/**
		 * ItemFilmAlreadyExistsException test
		 */
		for(ItemFilm theItemFilm : this.theItemFilms) {
			if(theItemFilm.isCalled(title)) throw new ItemFilmAlreadyExistsException();
		}
		/**
		 * creation and addition of the new film to the list of this.theItemFilms
		 */
		ItemFilm theFilm= new ItemFilm(title, kind, director, scenarist, duration);
		theItemFilms.add(theFilm);
		
	}



	/**
	 * Add a new book to the <i>SocialNetwork</i>
	 * 
	 * @param login
	 *            login of the member adding the book
	 * @param password
	 *            password of the member adding the book
	 * @param title
	 *            the new book's title
	 * @param kind
	 *            the new book's kind (adventure, thriller, etc.)
	 * @param author
	 *            the new book's author
	 * @param nbPages
	 *            number of pages of the new book's
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if title is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if kind is not instanciated</li>
	 *             <li>if author is not instanciated</li>
	 *             <li>if nbPages is not stricly positive
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 * @throws ItemBookAlreadyExistsException
	 *             a book with the same title is already registered in the
	 *             <i>SocialNetwork</i> (same title : not case-sensitive and
	 *             leadings/trailings blanks are not taken into account)
	 * 
	 */
	public void addItemBook(String login, String password, String title,
			String kind, String author, int nbPages) throws BadEntryException,
			NotMemberException, ItemBookAlreadyExistsException {
		/**
		 * BadEntryException test
		 */
		if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
		if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		if(kind==null) throw new BadEntryException("kind is not instanciated ");
		if(author==null) throw new BadEntryException("author is not instanciated");
		if(nbPages<=0) throw new BadEntryException("nbPages is not stricly positive");
		/**
		 * NotMemberException test
		 */
		findAMemberOrThrowNotMemberException(login,password);
		/**
		 * ItemBookAlreadyExistsException test
		 */
		for(ItemBook theItemBook : this.listItemBooks) {
			if(theItemBook.isCalled(title)) throw new ItemBookAlreadyExistsException();
		}
		/**
		 * creation and addition of the new book to the list of this.theItemBooks
		 */
		ItemBook theBook= new ItemBook(title, kind, author, nbPages);
		listItemBooks.add(theBook);

	}

	/**
	 * Add in the <i>SocialNetwork</i> a new review for a film on behalf of a
	 * specific member.</br> If this member has already given a review for this
	 * same film before, the new review replaces the previous one.
	 * 
	 * @param login
	 *            login of the member adding the review
	 * @param password
	 *            password of the member adding the review
	 * @param title
	 *            the reviewed film's title
	 * @param mark
	 *            the mark given by the member for this film
	 * @param comment
	 *            the comment given by the member for this film
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if title is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if mark is not greater or equals to 0.0 and lesser or
	 *             equals to 5.0.</li>
	 *             <li>if comment is not instantiated</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 * @throws NotItemException
	 *             if title is not registered as a film's title in the
	 *             <i>SocialNetwork</i>
	 * 
	 * @return mean of the marks for this film
	 */
	public float reviewItemFilm(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		/**
		 * BadEntryException test
		 */
		if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
		if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		if(mark<0 || mark>5) throw new BadEntryException("mark is not greater or equals to 0.0 and lesser or equals to 5.0");
		if(comment==null) throw new BadEntryException("comment is not instantiated");
		/**
		 * NotMemberException test and retrieve the login&password as Member
		 */
		Member theMember = findAMemberOrThrowNotMemberException(login,password);
		/*
		 * NotItemException test and retrieve the title as theItemFilm
		 */
		Item theItemFilm = findAFilmOrThrowNotItemException(title);	
		/**
		 * creation and addition of the new review to the theItemFilm
		 */
		ItemReview theReview = new ItemReview(mark,comment,theMember);
		theItemFilm.addReview(theReview,theMember); 
		/**
		 * return the average mark of the item
		 */
		return theItemFilm.averageMark();
	}


	/**
	 * Add in the <i>SocialNetwork</i> a new review for a book on behalf of a
	 * specific member.</br> If this member has already given a review for this
	 * same book before, the new review replaces the previous one.
	 * 
	 * @param login
	 *            login of the member adding the review
	 * @param password
	 *            password of the member adding the review
	 * @param title
	 *            the reviewed book's title
	 * @param mark
	 *            the mark given by the member for this book
	 * @param comment
	 *            the comment given by the member for this book
	 * 
	 * @throws BadEntryException
	 *             <ul>
	 *             <li>if login is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if password is not instantiated or contains less than
	 *             four characters (not taking into account leading or trailing
	 *             blanks)</li>
	 *             <li>if title is not instantiated or contains less than one
	 *             non-space character</li>
	 *             <li>if mark is not greater or equals to 0.0 and lesser or
	 *             equals to 5.0.</li>
	 *             <li>if comment is not instantiated</li>
	 *             </ul>
	 * <br>
	 * @throws NotMemberException
	 *             if login does not match with the login of a registered member
	 *             in <i>SocialNetwork</i> or if password does not correspond to
	 *             his registered password.
	 * @throws NotItemException
	 *             if title is not registered as a book's title in the
	 *             <i>SocialNetwork</i>
	 * 
	 * @return mean of the marks for this book
	 */
	public float reviewItemBook(String login, String password, String title,
			float mark, String comment) throws BadEntryException,
			NotMemberException, NotItemException {
		/**
		 * BadEntryException test
		 */
		if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
		if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		if(mark<0 || mark>5) throw new BadEntryException("mark is not greater or equals to 0.0 and lesser or equals to 5.0");
		if(comment==null) throw new BadEntryException("comment is not instantiated");
		/**
		 * NotMemberException test and retrieve the login&password as Member
		 */
		Member theMember = findAMemberOrThrowNotMemberException(login,password);
		/*
		 * NotItemException test and retrieve the title as theItemBook
		 */
		ItemBook theItemBook = findABookOrThrowNotItemException(title);	
		/**
		 * creation and addition of the new review to the theItemBook
		 */
		ItemReview theReview = new ItemReview(mark,comment,theMember);
		theItemBook.addReview(theReview,theMember);
		/**
		 * return the average mark of the item
		 */
		return theItemBook.averageMark(); //renvoi la note moyenne du livre
	}
	
	

	/**
	 * Search for items in the <i>SocialNetwork</i>.
	 * 
	 * @param title
	 *            title of searched item(s)
	 * 
	 * @throws BadEntryException
	 *             if title is not instantiated or contains less than one
	 *             non-space character
	 * 
	 * @return LinkedList <String> a list of String representing all items (book
	 *         and/or film) matching the searched name.</br> Each String will
	 *         contain at least the score of the corresponding item.
	 */
	public LinkedList<String> consultItems(String title) 
			throws BadEntryException {
		/**
		 * BadEntryException test
		 */
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		/**
		 * initializes different variables
		 */
		LinkedList<String> result=new LinkedList<String>();
		int positionIndexOfTheItemBook=0;
		int positionIndexOfTheItemFilm=0;
		/**
		 * retrieve the title as theItemBook 
		 * and add the representation of the found item to result
		 */
		while(positionIndexOfTheItemBook<nbBooks() && !listItemBooks.get(positionIndexOfTheItemBook).isCalled(title) ) {
			positionIndexOfTheItemBook+=1;
		}
		if(positionIndexOfTheItemBook!=nbBooks()) result.add(listItemBooks.get(positionIndexOfTheItemBook).toString());
		/**
		 * retrieve the title as theItemFilm 
		 * and add the representation of the found item to result
		 */
		while(positionIndexOfTheItemFilm<nbFilms() && !theItemFilms.get(positionIndexOfTheItemFilm).isCalled(title) ) {
			positionIndexOfTheItemFilm+=1;
		}
		if(positionIndexOfTheItemFilm!=nbFilms()) result.add(theItemFilms.get(positionIndexOfTheItemFilm).toString()); 
		/**
		 * return either,
		 * an empty list if it has not found any object corresponding to the title,
		 * or, a list with a string if it has found an object(film or book) corresponding to the title
		 * or, a list with 2 strings if it has found two object(film AND book) corresponding to the title
		 */
		return result;
	}

	public String toString() {
		return "SocialNetwork [member=" + listMember + ", listItemBooks=" + listItemBooks + ", theItemFilms=" + theItemFilms +"]";
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
