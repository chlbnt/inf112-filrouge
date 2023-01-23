package tests;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/**
 * Tests for the SocialNetwork.<i>ReviewItemFilm()</i> method.
 * 
 * @author BENOIT & DERRIEN
 * @version  MAY 2022
 */

public class ReviewItemFilmTest {
	/**
	 * Check that trying to add this new Review iTemFilm  (title, mark, comment) 
	 * raises a  BadEntry exception and does not change content of the 
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. 
	 *  If not OK,  displays an error message and returns 1.
	 *  
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login adding the review
	 * @param pwd
	 *            - member's pwd adding the review
	 @param title
	 *            - Film's title
	 * @param mark
	 * 			  - Film's mark
	 * @param comment
	 * 			  - Review's comment 
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	private static int reviewItemFilmBadEntryTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage){
		float initalMark=-1;
		
		
		try {
			initalMark=sn.reviewItemFilm(login, password, title, mark, comment);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (BadEntryException e) {

			
			
			if (initalMark == mark) { // The number of marks has
				// changed : this is an error
				// case.
				System.out
				.println("Err "
				+ testId
				+ " : BadEntry was thrown but the number of marks was changed"); // Display
																					// a
																					// specific
																					// error
																					// message
				return 1; // return "error" value
			} else
			// The number of marks hasn't changed, which is considered a
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
		 * Check that this new review Film (title, mark, comment)  can be added
		 * to the <i>ISocialNetwork</i>.  If OK, the method just returns 0.
		 * If not OK, an error message is displayed and 1 is returned, 
		 * the new member was not correctly added
		 *  
		 * @param sn
		 *            - the <i>ISocialNetwork</i>
		 * @param login
		 *            - member's login adding the review
		 * @param pwd
		 *            - member's pwd adding the review
		 * @param title
		 *            - Film's title
		 * @param mark
		 * 			  - Film's mark
		 * @param comment
		 * 			  - Review's comment 
		 * @param testId
		 *            - the test ID that will prefix any error message displayed by
		 *            this method
		 * @param errorMessage
		 *            - the error message that will be displayed if no exception is
		 *            thrown when adding this member
		 * @return 0 if the test is OK, 1 if not
		 */	
	private static int reviewItemFilmOKTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment, float expectedMark,
			String testId) {
		
		
		float meanMarks=-1f;
		try {
			meanMarks=sn.reviewItemFilm(login, password, title, mark, comment); //return the average mark of the item
			
			
			
			if (meanMarks != expectedMark) { // But the number of marks
				// hasn't changed
				// accordingly
				System.out.println("Err " + testId
				+ " : the mark (" + mark
				+ ") was not change"); // Error message displayed
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
	 * Check that trying to add this new Review iTemFilm  (title, mark, comment) 
	 * raises a  NotMemberException and does not change content of the 
	 * <i>ISocialNetwork</i>.  If OK, the method just returns 0.
	 * If not OK, an error message is displayed and 1 is returned, 
	 *  
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login adding the review
	 * @param pwd
	 *            - member's pwd adding the review
	 * @param title
	 *            - Film's title
	 * @param mark
	 * 			  - Film's mark
	 * @param comment
	 * 			  - Review's comment 
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */	
	private static int reviewItemFilmNotMemberTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage) {
		float initalMark=-1;
		
	
		
		try {
			initalMark=sn.reviewItemFilm(login, password, title, mark, comment);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotMemberException e) {
			if (initalMark == mark) { // The number of marks has
				// changed : this is an error
				// case.
				System.out
				.println("Err "
				+ testId
				+ " : NotMember was thrown but the number of marks was changed"); // Display
																					// a
																					// specific
																					// error
																					// message
				return 1; // return "error" value
			} else
			// The number of marks hasn't changed, which is considered a
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
	 * Check that trying to add this new Review iTemFilm  (title, mark, comment) 
	 * raises a  NotItemException and does not change content of the 
	 * <i>ISocialNetwork</i>.  If OK, the method just returns 0.
	 * If not OK, an error message is displayed and 1 is returned, 
	 *  
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param login
	 *            - member's login adding the review
	 * @param pwd
	 *            - member's pwd adding the review
	 * @param title
	 *            - Film's title
	 * @param mark
	 * 			  - Film's mark
	 * @param comment
	 * 			  - Review's comment 
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */	
	
	private static int reviewItemFilmNotItemTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage) {
		
		
		float initalMark=-1;

		
			
		try {
			initalMark=sn.reviewItemFilm(login, password, title, mark, comment);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotItemException e) {
			if (initalMark == mark) { // The number of marks has
				// changed : this is an error
				// case.
				System.out
				.println("Err "
				+ testId
				+ " : NotItemTest was thrown but the number of marks was changed"); // Display
																					// a
																					// specific
																					// error
																					// message
				return 1; // return "error" value
			} else
			// The number of marks hasn't changed, which is considered a
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
	
	public static TestReport test(){

		ISocialNetwork sn = new SocialNetwork();
		try {
			sn.addMember("Chloé","chloé","Mon profile");
			sn.addMember("Alex","alex","Mon profile");
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		try {
			sn.addItemFilm("Chloé", "chloé", "Avatar", "Pierre","Paul","Jac",200);
		} catch (Exception e) {
			System.out.println("Err " + "ItemFilm creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		
		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 0
		// here)
		int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 1
		// here)
		int nbMembers=sn.nbMembers(); // number of nbMembers in 'sn' (should be 2
		// here)
		
		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing reviewItemFilm()");
		
		
		// <=> test n°1
		
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, null, "chloé", "Avatar",1f,"",
				"1.1","reviewItemFilmBadEntry() doesn't reject null logins");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, " ", "chloé", "Avatar",1f,"",
				"1.2","reviewItemFilmBadEntry() doesn't reject logins that don't contain at least one character other than space");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", null, "Avatar",1f,"",
				"1.3","reviewItemFilmBadEntry() doesn't reject null passwords");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", " pwd ", "Avatar",1f,"",
				"1.4","reviewItemFilmBadEntry() doesn't reject passwords that don't contain at least 4 characters (not taking into account leading or trailing blanks)");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", "chloé", null,1f,"",
				"1.5","reviewItemFilmBadEntry() title is not instantiated");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", "chloé", "   ",1f,"",
				"1.6","reviewItemFilmBadEntry() title contains less than one non-space character");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", "chloé", "Avatar",-0.5f,"",
				"1.7","reviewItemFilmBadEntry() mark is not greater or equals to 0.0");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", "chloé", "Avatar",5.5f,"",
				"1.8","reviewItemFilmBadEntry() mark is not lesser or equals to 5.0");
		nbTests++;
		nbErrors += reviewItemFilmBadEntryTest(
				sn, "Chloé", "chloé", "Avatar",1f,null,
				"1.9","reviewItemFilmBadEntry() comment is not instantiated");
		
		
		
		// <=> test n°2

		nbTests++;
		nbErrors += reviewItemFilmOKTest(sn, "Chloé", "chloé", "Avatar",1f,"cool film",1f,// 1
				"2.1a");
		nbTests++;
		nbErrors += reviewItemFilmOKTest(sn, "Chloé", "chloé", "Avatar",0f,"cool film",0f,// 0
				"2.1b");
		nbTests++;
		nbErrors += reviewItemFilmOKTest(sn, "Chloé", "chloé", "Avatar",3f,"cool film",3f,// 3
				"2.1c");
		nbTests++;
		nbErrors += reviewItemFilmOKTest(sn, "Alex", "alex", "Avatar",5f,"cool film",4f,// (3+5)/2=4
				"2.1d");
		nbTests++;
		nbErrors += reviewItemFilmOKTest(sn, "Alex", "alex", "Avatar",0f,"cool film",1.5f,// (3+0)/2=1.5
				"2.1e");


		
		
		nbTests++;
		nbErrors += reviewItemFilmNotItemTest(sn,
				"Chloé", "chloé",
				"Ava",1f,"cool film",
				"2.2","reviewItemFilmNotItem() title is not registered as a film's title");
		
		
		
		
		// <=> test n3
		nbTests++;
		nbErrors += reviewItemFilmNotMemberTest(sn,
				"Chlo", "chloé",
				"Avatar",1f,"cool film",
				"3.1","reviewItemFilmNotMember() login does not match with the login of a registered member");
		nbTests++;
		nbErrors += reviewItemFilmNotMemberTest(sn,
				"Chloé", "chlo",
				"Avatar",1f,"cool film",
				"3.2","reviewItemFilmNotMember() password does not correspond to his registered password");
		
		
		
		
		
		nbTests++;
		// check that 'sn' was not modified
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Error : the number of Members was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("reviewItemFilm : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in ReviewItemFilmTest test code - Can't return valuable test results");
			return null;
			}
		
	}
	
	

	public static void main(String[] args) {
		test();

	}

}

