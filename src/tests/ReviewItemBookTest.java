package tests;

import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

/*
 * The ReviewItemBookTest class allows to verify that the errors are detected and the exceptions raised 
 * @author DERRIEN & BENOIT
 * @version  MAY 2022
 */

public class ReviewItemBookTest {
	
	/**
	 * Check that trying to add this new Review iTemBook (title, mark, comment) 
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
	
	private static int reviewItemBookBadEntryTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage){
		float initalMark=-1;  
		
		
		//If the value of login, passwork, title, mark or comment is null, the "try" stops
		// and the program goes directly to the catch.
		try {
			initalMark=sn.reviewItemBook(login, password, title, mark, comment); //returns the average note in initial Mark
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
	 * Check that this new review Book (title, mark, comment)  can be added
	 * to the <i>ISocialNetwork</i>.  If OK, the method just returns 0 : 
	 * the new review was added.
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
	
	private static int reviewItemBookOKTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment, float expectedMark,
			String testId) {
		
		
		float meanMarks=-4f;
		try {
			meanMarks=sn.reviewItemBook(login, password, title, mark, comment);
					
			if (meanMarks != expectedMark) { // But the number of marks
				// hasn't changed
				// accordingly
				System.out.println("Err " + testId
				+ " : the mark (" + mark
				+ ") was not change"); // Error message displayed
				return 1; // return error code
			} 
			
			// return success code : everything is OK, nothing to display
			else return 0; 
			
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception " + e); // Error
																		// message
																		// displayed
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}

	}
	
	/**
	 * Check that trying to add this new Review iTemBook  (title, mark, comment) 
	 * raises a  NotMemberException and does not change content of the 
	 * <i>ISocialNetwork</i>.  If OK, the method just returns 0 : 
	 * the new review was added.
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
	private static int reviewItemBookNotMemberTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage) {
		float initalMark=-1;
		
	
		//If  the login or the password are incorrect, the program catch the exception.
		try {
			initalMark=sn.reviewItemBook(login, password, title, mark, comment);
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
	 * Check that trying to add this new Review iTemBook  (title, mark, comment) 
	 * raises a  NotItemException and does not change content of the 
	 * <i>ISocialNetwork</i>.  If OK, the method just returns 0 : 
	 * the new review was added.
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
	private static int reviewItemBookNotItemTest(ISocialNetwork sn, String login,
			String password, String title, float mark, String comment,
			String testId, String errorMessage) {
		
		
		float initalMark=-1;

		
			
		try {
			initalMark=sn.reviewItemBook(login, password, title, mark, comment);
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
			sn.addMember("Chloe","password","Mon profile"); //Adding a first member to test
			sn.addMember("Alex","alexa","Mon profile"); //Adding a second member to test
			
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		try {
			sn.addItemBook("Chloe", "password", "Game of throne","Pierre","Paul",200);
		} catch (Exception e) {
			System.out.println("Err " + "ItemBook creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		
		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 1
		// here)
		int nbFilms = sn.nbFilms(); // number of films in 'sn' (should be 0
		// here)
		int nbMembers=sn.nbMembers(); // number of nbMembers in 'sn' (should be 2
		// here)
		
		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing reviewItemBook()");
		
		
		// <=> test n°1
			
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, null, "password", "Game of throne",4f,"Superbe série",
				"1.1","reviewItemBookBadEntryTest() doesn't reject null logins");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, " ", "password", "Game of throne",4f,"Superbe série",
				"1.2","reviewItemBookBadEntryTest() doesn't reject logins that don't contain at least one character other than space");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", null, "Game of throne",4f,"Superbe série",
				"1.3","reviewItemBookBadEntryTest() doesn't reject null passwords");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", " pwd ", "Game of throne",4f,"Superbe série",
				"1.4f","reviewItemBookBadEntryTest() doesn't reject passwords that don't contain at least 4f characters (not taking into account leading or trailing blanks)");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", "password", null,4f,"Superbe série",
				"1.4f","reviewItemBookBadEntryTest() title is not instantiated");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", "password", "   ",4f,"Superbe série",
				"1.6","reviewItemBookBadEntryTest() title contains less than one non-space character");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of throne",-0.5f,"Superbe série",
				"1.7","reviewItemBookBadEntryTest() mark is not greater or equals to 0.0");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of throne",5.5f,"",
				"1.8","reviewItemBookBadEntryTest() mark is not lesser or equals to 5.0");
		nbTests++;
		nbErrors += reviewItemBookBadEntryTest(
				sn, "Chloe", "password", "Game of throne",4f,null,
				"1.9","reviewItemBookBadEntryTest() comment is not instantiated");
		
		
		
		// <=> test nÂ°2

		nbTests++;
		nbErrors += reviewItemBookOKTest(sn, "Chloe", "password", "Game of throne",4f,"cool Book",4f,// 1
				"2.1a");
		nbTests++;
		nbErrors += reviewItemBookOKTest(sn, "Chloe", "password", "Game of throne",0f,"cool Book",0f,// 0
				"2.1b");
		nbTests++;
		nbErrors += reviewItemBookOKTest(sn, "Chloe", "password", "Game of throne",3f,"cool Book",3f,// 3
				"2.1c");
		nbTests++;
		nbErrors += reviewItemBookOKTest(sn, "Alex", "alexa", "Game of throne",5f,"cool Book",4f,// 3+5f/2=4f
				"2.1d");
		nbTests++;
		nbErrors += reviewItemBookOKTest(sn, "Alex", "alexa", "Game of throne",0f,"cool Book",1.5f,// 3+0/2=1.5f
				"2.1e");


		
		
		nbTests++;
		nbErrors += reviewItemBookNotItemTest(sn,
				"Chloe", "password",
				"Pot",4f,"cool Book",
				"2.2","reviewItemBookNotItemTest() title is not registered as a Book's title");
		
		
		
		
		// <=> test n3
		nbTests++;
		nbErrors += reviewItemBookNotMemberTest(sn,
				"Benj", "password",
				"Avatar",4f,"cool Book",
				"3.1","reviewItemBookNotMemberTest() login does not match with the login of a registered member");
		nbTests++;
		nbErrors += reviewItemBookNotMemberTest(sn,
				"Chloe", "benj",
				"Avatar",4f,"cool Book",
				"3.2","reviewItemBookNotMemberTest() password does not correspond to his registered password");
		
		
		
		
		
		nbTests++;
		// check that 'sn' was not modified
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Error : the number of Members was unexepectedly changed by reviewItemBook()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != sn.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by reviewItemBook()");
			nbErrors++;
		}
		nbTests++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by reviewItemBook()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + sn);

		// Print a summary of the tests and return test results
		try{
			TestReport tr = new TestReport(nbTests, nbErrors);	
			System.out.println("reviewItemBook : " + tr);
			return tr;	
		}
		catch (NotTestReportException e){ //This shouldn't happen
			System.out.println("Unexpected error in ReviewItemBookTest test code - Can't return valuable test results");
			return null;
			}
		
	}
	
	

	public static void main(String[] args) {
		test();

	}

}
