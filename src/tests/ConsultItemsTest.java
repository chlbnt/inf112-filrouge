package tests;

import java.util.LinkedList;

import exceptions.BadEntryException;
import exceptions.NotTestReportException;
import opinion.ISocialNetwork;
import opinion.SocialNetwork;

public class ConsultItemsTest {
	
	/**
	 * Check that trying to add this new ConsultItem (title) 
	 * raises a  BadEntry exception.
	 *  
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 *            - title's Item
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int consultItemsBadEntryTest(ISocialNetwork sn, String title,String testId, String errorMessage){
		
		try {
			sn.consultItems(title);// display
			// the error message
			System.out.println("Err " + testId + " : " + errorMessage);
			return 1; // and return the "error" value
		} catch (BadEntryException e) {
			
			return 0;

		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}
	
	/**
	 *
	 *  
	 * @param sn
	 *            - the <i>ISocialNetwork</i>
	 * @param title
	 *            - title's Item
	 * @param testId
	 *            - the test ID that will prefix any error message displayed by
	 *            this method
	 * @param errorMessage
	 *            - the error message that will be displayed if no exception is
	 *            thrown when adding this member
	 * @return 0 if the test is OK, 1 if not
	 */
	
	private static int consultItemsOKTest(ISocialNetwork sn,String title, int nbItems,String testId) {
		
		LinkedList<String> listItems=null;
		
		try {
			listItems=sn.consultItems(title);
			
			if(listItems.size()==2 && nbItems==2) return 0;
			else if(listItems.size()==1 && nbItems==1)	return 0;
			else if(listItems.size()==0 && nbItems==0)	return 0;
			else {
				System.out.println("Err " + testId
				+ " : the title (" + title
				+ ") does not contain " + nbItems+" strings."); // Error message displayed
				return 1; // return error code
			}
			
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception " + e); // Error
																		// message
																		// displayed
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}
	
	

	public static TestReport test(){

		ISocialNetwork sn = new SocialNetwork();
		
		try {
			sn.addMember("Chloe","chloe","Mon profile");
			sn.addMember("Alex","alex","Mon profile");
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		
		try {
			sn.addItemBook("Chloe", "chloe", "livre1","cool","Jhonny",200);
			sn.addItemBook("Alex", "alex", "livre2","cool","Terry",200);
			sn.addItemBook("Chloe", "chloe", "livre3","pas cool","Phil",200);
		} catch (Exception e) {
			System.out.println("Err " + "ItemBook creation failed" + " : unexpected exception. " + e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}

		
		try {
			sn.reviewItemBook("Chloe", "chloe", "livre1", 1, "nul");
			sn.reviewItemBook("Alex", "alex", "livre2", 2, "nul ce livre");
			sn.reviewItemBook("Chloe", "chloe", "livre3", 3, "Superbe");
			sn.reviewItemBook("Alex", "alex", "livre3", 4, "Superbe livre");
		} catch (Exception e) {
			System.out.println("Err " + "reviewItemBook failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		
		
		int nbBooks = sn.nbBooks(); // number of books in 'sn' (should be 2
		// here)

		int nbMembers=sn.nbMembers(); // number of nbMembers in 'sn' (should be 1
		// here)
		
		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing consultItems()");
		
		
		// <=> test n�1
		
		nbTests++;
		nbErrors += consultItemsBadEntryTest(
				sn, null,
				"1.1","consultItemsBadEntry() title is not instantiated");
		nbTests++;
		nbErrors += consultItemsBadEntryTest(
				sn, "   ",
				"1.2","consultItemsBadEntry() title contains less than one non-space character");
		
		nbTests++;
		nbErrors += consultItemsOKTest(sn,"livre1",
				1,
				"2.1c");
		nbTests++;
		nbErrors += consultItemsOKTest(sn,"livre2",
				1,
				"2.1d");
		nbTests++;
		nbErrors += consultItemsOKTest(sn,"notATitle",
				0,
				"2.1f");
		
		
		
		
		
		
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
