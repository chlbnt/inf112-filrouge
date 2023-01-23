package tests;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;


import exceptions.BadEntryException;
import exceptions.ItemFilmAlreadyExistsException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;

/**
 * Tests for the SocialNetwork.<i>addItemFilmTest()</i> method.
 * 
 * @author BENOIT & DERRIEN
 * @version  MAY 2022
 */

public class AddItemFilmTest {

	/**
	 * Check that trying to add this new film (title, kind, director, scenariste, duration) raises a
	 * BadEntry exception and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            -member's login adding the film
	 * @param password
	 *            - member's password adding the film
	 * @param title
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 *            - new film's director
	 * @param scenariste
	 *            - new film's scenarist
	 * @param duration
	 *            - new film's duration       
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 **/
	
	private static int addItemFilmBadEntryTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String director, 
			String scenariste,int duration, String testId, String errorMessage){
		
		
		int nbFilms = sn.nbFilms();

		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenariste, duration);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (BadEntryException e) { // BadEntry exception was thrown by
			// addItemFilm() : this is a good start!
			// Let's now check if 'sn' was not
			// impacted
			if (sn.nbFilms() != nbFilms) { // The number of films has
									// changed : this is an error
									// case.
				System.out
				.println("Err "
					+ testId
					+ " : BadEntry was thrown but the number of films was changed"); // Display
																						// a
																						// specific
																						// error
																						// message
				return 1; // return "error" value
			} else
			// The number of films hasn't changed, which is considered a
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
	 * Check that this new ItemFilm (title, kind, director, scenariste, duration) can be
	 * added to the <i>ISocialNetwork</i>.</br> If OK, the method just returns 0
	 * : the new member was added.</br> If not OK, an error message is displayed
	 * and 1 is returned ; the new member was not correctly added.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            -member's login adding the film
	 * @param password
	 *            - member's password adding the film
	 * @param title
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 *            - new film's director
	 * @param scenariste
	 *            - new film's scenariste
	 * @param duration
	 *            - new film's duration       
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 **/
	
	private static int addItemFilmOKTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String director, 
			String scenariste,int duration, String testId) {
		
		int nbFilms=sn.nbFilms();
		try {
			sn.addItemFilm(login, password, title, kind, director, scenariste, duration);
			if (sn.nbFilms() != nbFilms + 1) { // But the number of Films
				// hasn't changed
				// accordingly
				System.out.println("Err " + testId
				+ " : the number of Films (" + nbFilms
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
	 * Check that trying to add this new ItemBook (title, kind, director, scenariste, duration) raises an
	 * ItemFilmAlreadyExistsException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	* @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            -member's login adding the film
	 * @param password
	 *            - member's password adding the film
	 * @param title
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 *            - new film's director
	 * @param scenariste
	 *            - new film's scenariste
	 * @param duration
	 *            - new film's duration       
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 **/
	
	private static int addItemFilmAlreadyExistsTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String director, 
			String scenarist,int duration, String testId, String errorMessage) {
			
		
		int nbFilms=sn.nbFilms();
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
			
		} catch (ItemFilmAlreadyExistsException e) {
			if (sn.nbFilms() != nbFilms) {
				System.out
						.println("Err "
								+ testId
								+ " : ItemFilmAlreadyExistsException was thrown, but the number of films was changed"); // Display
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
	 * Check that trying to add this new Film (title, kind, director, scenarist, duration) raises a
	 * NotMemberException and does not change content of the
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. If not OK,
	 * displays an error message and returns 1.
	 * 
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            -member's login adding the film
	 * @param password
	 *            - member's password adding the film
	 * @param title
	 *            - new film's title
	 * @param kind
	 *            - new film's kind
	 * @param director
	 *            - new film's director
	 * @param scenariste
	 *            - new film's scenarist
	 * @param duration
	 *            - new film's duration       
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this film
	 **/
	
	private static int addItemFilmNotMemberTest(ISocialNetwork sn, String login,
			String password, String title, String kind,String director, 
			String scenarist,int duration, String testId, String errorMessage) {
		
		
		int nbFilms=sn.nbFilms();
		
		try {
			sn.addItemFilm(login, password, title, kind, director, scenarist, duration);
			
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotMemberException e) {
			
			if (sn.nbFilms() != nbFilms) {
				System.out
						.println("Err "
								+ testId
								+ " : ItemFilmAlreadyExistsException was thrown, but the number of films was changed"); // Display
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
			sn.addMember("Chloe","chloe","Mon profile");
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		

		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
									// here)
//		int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
//									// here)*
		int nbMembers=sn.nbMembers(); // number of nbMembers in 'sn' (should be 1
		// here)*

		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing addItemFilm()");
		
		
		
		

		// <=> test n°1

		nbTests++;
		nbErrors += addItemFilmBadEntryTest(sn, null, "chloe", "qsdfgh","","","",1,
				"1.1","addItemFilmbadEntry() doesn't reject null logins");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, " ", "chloe", "qsdfgh","","","",1,
				"1.2","addItemFilmbadEntry() doesn't reject logins that don't contain at least one character other than space");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", null, "qsdfgh","","","",1,
				"1.3","addItemFilmbadEntry() doesn't reject null passwords");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", " pwd ", "qsdfgh","","","",1,
				"1.4","addItemFilmbadEntry() doesn't reject passwords that don't contain at least 4 characters (not taking into account leading or trailing blanks)");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", null,"","","",1,
				"1.5","addItemFilmbadEntry() title is not instantiated");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", "   ","","","",1,
				"1.6","addItemFilmbadEntry() title contains less than one non-space character");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", "qsdfgh",null,"","",1,
				"1.7","addItemFilmbadEntry() kind is not instanciated");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", "qsdfgh","",null,"",1,
				"1.8","addItemFilmbadEntry() director is not instanciated");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", "qsdfgh","","",null,1,
				"1.9","addItemFilmbadEntry() scenarist is not instanciated");
		nbTests++;
		nbErrors += addItemFilmBadEntryTest(
				sn, "Chloe", "chloe", "qsdfgh","","","",0,
				"1.10","addItemFilmbadEntry() duration is not stricly positive ");
		
		
		
		
		// <=> test n°2

		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "Chloe", "chloe", "Avatar","Pierre","Paul","Jac",200,
				"2.1a");
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "Chloe", "chloe", "transformer","Pierre","Paul","Jac",200,
				"2.1b");	
		nbTests++;
		nbErrors += addItemFilmOKTest(sn, "Chloe", "chloe", "espace","Pierre","Paul","Jac",200,
				"2.1c");
		
		
		
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "Chloe", "chloe",
				new String("Avatar"),"Pierre","Paul","Jac",200,
				"2.2",
				"addItemFilmAlreadyExists() The title of the first film was accepted as title for a new film");
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "Chloe", "chloe", new String("espace"),"Pierre","Paul","Jac",200,
				"2.3",
				"addItemFilmAlreadyExists() The title of the last film was accepted as login for a new member");
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "Chloe", "chloe", new String("AVATAR"),"Pierre","Paul","Jac",200,
				"2.4",
				"addItemFilmAlreadyExists() An already registered film, but with different case, was accepted as title for a new film");
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "Chloe", "chloe",new String(" Avatar "),"Pierre","Paul","Jac",200,
				"2.5",
				"addItemFilmAlreadyExists() An already registered film, surrounded by leading/trailing blanks, was accepted as title for a new film");
		nbTests++;
		nbErrors += addItemFilmAlreadyExistsTest(sn, "Chloe", "chloe",
				"Ava" + "t" + "ar","Pierre","Paul","Jac",200,
				"2.6",
				"addItemFilmAlreadyExists() A String concatenation building an already registered film was accepted as title for a new film");
		
		
		
		// <=> test n3
		nbTests++;
		nbErrors += addItemFilmNotMemberTest(sn,
				"Chlo", "chloe",
				"qsdfgh","","","",1,
				"3.1",
				"addItemFilmNotMember() login does not match with the login of a registered member");
		nbTests++;
		nbErrors += addItemFilmNotMemberTest(sn,
				"Chloe", "chlo",
				"qsdfgh","","","",1,
				"3.2",
				"addItemFilmNotMember()password does not correspond to his registered password");
					
		
		nbTests++;
		// check that 'sn' was not modified
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Error : the number of Members was unexepectedly changed by addItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by addItemFilm()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("addItemFilmTest : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in AddItemFilmTest test code - Can't return valuable test results");
			return null;
			}
		}
	


	public static void main(String[] args) {
		test();
	}

}