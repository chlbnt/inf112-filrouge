package tests;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.BadEntryException;
import exceptions.ItemBookAlreadyExistsException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
/**
 * 
 * @author BENOIT & DERRIEN
 * @version  APRIL 2022
 * 
 */



public class AddItemBookTest {
	/**
	 * Check that trying to add this new Book (title, kind, author) raises a
	 * BadEntry exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login - login of the member adding the book
	 * 
	 * @param password - password of the member adding the book
	 * 
	 * @param title - the new book's title
	 * 
	 * @param kind - the new book's kind (adventure, thriller, etc.)
	 *           
	 * @param author - the new book's author
	 *   
	 * @param nbPages - number of pages of the new book's
     *
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this book
	 **/
	
	
	private static int addItemBookBadEntryTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String author, 
			int nbPages, String testId, String errorMessage){
		
		
		int nbBooks = sn.nbBooks();

		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (BadEntryException e) { // BadEntry exception was thrown by
			// addItemBook() : this is a good start!
			// Let's now check if 'sn' was not
			// impacted
			if (sn.nbBooks() != nbBooks) { // The number of Books has
									// changed : this is an error
									// case.
				System.out
				.println("Err "
					+ testId
					+ " : BadEntry was thrown but the number of Books was changed"); // Display
																						// a
																						// specific
																						// error
																						// message
				return 1; // return "error" value
			} else
			// The number of Books hasn't changed, which is considered a
			// good indicator that 'sn' was not modified
			return 0; // return success value : everything seems OK, nothing
			// to display
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
	}
	
	/**
	 * Check that this new ItemBook (title, kind, author) can be
	 * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
	 * : the new member was added.</br> If not OK, an error message is displayed
	 * and 1 is returned ; the new member was not correctly added.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login - login of the member adding the book
	 * 
	 * @param password - password of the member adding the book
	 * 
	 * @param title - the new book's title
	 * 
	 * @param kind - the new book's kind (adventure, thriller, etc.)
	 *           
	 * @param author - the new book's author
	 *   
	 * @param nbPages - number of pages of the new book's
     *
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this book
	 **/
	private static int addItemBookOKTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String author,int nbPages, String testId) {
		
		int nbBooks=sn.nbBooks();
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			if (sn.nbBooks() != nbBooks + 1) { // But the number of Books
				// hasn't changed
				// accordingly
				System.out.println("Err " + testId
				+ " : the number of Books (" + nbBooks
				+ ") was not incremented"); // Error message displayed
				return 1; // return error code
			} else return 0; // return success code : everything is OK, nothing to
			// display
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception " + e); // Error
																		// message
																		// displayed
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}
	
	/**
	 * Check that trying to add this new ItemBook (title, kind, author) raises an
	 * ItemBookAlreadyExistsException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login - login of the member adding the book
	 * 
	 * @param password - password of the member adding the book
	 * 
	 * @param title - the new book's title
	 * 
	 * @param kind - the new book's kind (adventure, thriller, etc.)
	 *           
	 * @param author - the new book's author
	 *   
	 * @param nbPages - number of pages of the new book's
     *
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this book
	 **/
	private static int addItemBookAlreadyExistsTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String author,int nbPages, String testId, String errorMessage) {			
		
		int nbBooks=sn.nbBooks();
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
			
		} catch (ItemBookAlreadyExistsException e) {
			if (sn.nbBooks() != nbBooks) {
				System.out
						.println("Err "
								+ testId
								+ " : ItemBookAlreadyExistsException was thrown, but the number of Books was changed"); // Display
																												// a
																												// specific
																												// error
																												// message
				return 1;// and return the "error" value
			} else
				return 0; // return success value : everything is OK, nothing to
							// display
			
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}
	
	/**
	 * Check that trying to add this new Book (title, kind, author) raises a
	 * NotMemberException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login - login of the member adding the book
	 * 
	 * @param password - password of the member adding the book
	 * 
	 * @param title - the new book's title
	 * 
	 * @param kind - the new book's kind (adventure, thriller, etc.)
	 *           
	 * @param author - the new book's author
	 *   
	 * @param nbPages - number of pages of the new book's
     *
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this book
	 **/
	
	private static int addItemBookNotMemberTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String author,int nbPages, String testId, String errorMessage) {		
		
		int nbBooks=sn.nbBooks();
		
		try {
			sn.addItemBook(login, password, title, kind, author, nbPages);
			
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotMemberException e) {
			
			if (sn.nbBooks() != nbBooks) {
				System.out
						.println("Err "
								+ testId
								+ " : ItemBookAlreadyExistsException was thrown, but the number of Books was changed"); // Display
																												// a
																												// specific
																												// error
																												// message
				return 1;// and return the "error" value
			} else
				return 0; // return success value : everything is OK, nothing to
							// display
			
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}
	
	
	public static TestReport test(){

		ISocialNetwork sn = new SocialNetwork();
		try {
			sn.addMember("Chloe","password","Mon profile");
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		

		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
									// here)

		int nbMembers=sn.nbMembers(); // number of nbMembers in 'sn' (should be 1
		// here)*

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing addItemBook()");
		
		
		
		
		

		// <=> test n°1

		nbTests++;
		nbErrors += addItemBookBadEntryTest(sn, null, "password", "Game of throne","Fantastique","Georges R.R Martin",100,
				"1.1","addItemBookbadEntry() doesn't reject null logins");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, " ", "password", "Game of throne","Fantastique","Georges R.R Martin",100,
				"1.2","addItemBookbadEntry() doesn't reject logins that don't contain at least one character other than space");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", null, "Game of throne","Fantastique","Georges R.R Martin",100,
				"1.3","addItemBookbadEntry() doesn't reject null passwords");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", " pwd ", "Game of throne","Fantastique","Georges R.R Martin",100,
				"1.4","addItemBookbadEntry() doesn't reject passwords that don't contain at least 4 characters (not taking into account leading or trailing blanks)");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", "password", null,"Fantastique","Georges R.R Martin",100,
				"1.5","addItemBookbadEntry() title is not instantiated");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", "password", " ","Fantastique","Georges R.R Martin",100,
				"1.6","addItemBookbadEntry() title contains less than one non-space character");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of thrones",null,"Georges R.R Martin",100,
				"1.7","addItemBookbadEntry() kind is not instanciated");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of thrones","Fantastique",null,100,
				"1.8","addItemBookbadEntry() author is not instanciated");
		nbTests++;
		nbErrors += addItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of thrones","Fantastique","Georges R.R Martin",0,
				"1.10","addItemBookbadEntry() nbPages is not stricly positive ");
		
		
		
		
		// <=> test n°2

		nbTests++;
		nbErrors += addItemBookOKTest(sn, "Chloe", "password", "Harry Potter et les Reliques de la Mort","Fantastique","Paul",200,
				"2.1a");
		nbTests++;
		nbErrors += addItemBookOKTest(sn, "Chloe", "password", "Les Miserables","Pierre","Paul",200,
				"2.1b");	
		nbTests++;
		nbErrors += addItemBookOKTest(sn, "Chloe", "password", "Le traite de la tolerance","Pierre","Paul",200,
				"2.1c");
		
		
		
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "Chloe", "password",
				"Harry Potter et les Reliques de la Mort","Pierre","Paul",200,
				"2.2",
				"addItemBookAlreadyExists() The title of the first Book was accepted as title for a new Book");
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "Chloe", "password", new String("Le traite de la tolerance"),"Pierre","Paul",200,
				"2.3",
				"addItemBookAlreadyExists() The title of the last Book was accepted as login for a new member");
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "Chloe", "password",
				"HARRY POTTER ET LES RELIQUES DE LA MORT","Pierre","Paul",200,
				"2.4",
				"addItemBookAlreadyExists() An already registered Book, but with different case, was accepted as title for a new Book");
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "Chloe", "password",
				" Harry Potter et les Reliques de la Mort ","Pierre","Paul",200,
				"2.5",
				"addItemBookAlreadyExists() An already registered Book, surrounded by leading/trailing blanks, was accepted as title for a new Book");
		nbTests++;
		nbErrors += addItemBookAlreadyExistsTest(sn, "Chloe", "password",
				"Harry " + "Pott" + "er " + "et les Reliques de la Mort","Pierre","Paul",200,
				"2.6",
				"addItemBookAlreadyExists() A String concatenation building an already registered Book was accepted as title for a new Book");
		
		
		
		// <=> test n3
		nbTests++;
		nbErrors += addItemBookNotMemberTest(sn,
				"toto", "password",
				"Tony le cheval","Livre pour enfant","Damien Jouannet",100,
				"3.1",
				"addItemBookNotMember() login does not match with the login of a registered member");
		nbTests++;
		nbErrors += addItemBookNotMemberTest(sn,
				"Chloe", "jojolepassword",
				"Tony la licorne","Livre pour enfant","Damien Jouannet",100,
				"3.2",
				"addItemBookNotMember() password does not correspond to his registered password");
					
		
		// check that 'sn' was not modified
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Error : the number of Members was unexepectedly changed by addItemBook()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("addItemBookTest : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in AddItemBookTest test code - Can't return valuable test results");
			return null;
			}
		}
	


	public static void main(String[] args) {
		test();
	}

}
