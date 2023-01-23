package tests;

import java.text.DecimalFormat;

import exceptions.AlreadyAnOpinionException;
import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;
import exceptions.NotTestReportException;
import opinion.ISocialNetworkPremium;
import opinion.SocialNetworkPremium;




public class ReviewOpinionTest {


	/**
	 * 	 * Check that trying to add this new reviewOpinion 
	 * raises a  BadEntry exception and does not change content of the 
	 * <i>ISocialNetwork</i>. If OK, the method just returns 0. 
	 *  If not OK,  displays an error message and returns 1.
	 * 
	 * @param snp - the <i>ISocialNetwork</i>
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer
	 * @param opinion
	 * @param testId
	 * @param errorMessage
	 * @return
	 */
	private static int reviewOpinionBadEntryTest(ISocialNetworkPremium snp, 
			String login, String password, String title, String type,String reviewer, int opinion, 
			String testId, String errorMessage) {
		try {
			snp.reviewOpinion(login, password, title, type, reviewer, opinion);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
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
	 Check that this new reviewOpinion  can be added 
	 * to the <i>ISocialNetwork</i>.  If OK, the method just returns 0.
     * If not OK, an error message is displayed and 1 is returned, 
     * 
	 * @param snp - the <i>ISocialNetwork</i>
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer
	 * @param opinion
	 * @param expectedMark
	 * @param testId
	 * @return
	 */
	private static int reviewOpinionOKTest(ISocialNetworkPremium snp, 
			String login, String password, String title, String type,String reviewer, int opinion, float expectedMark,
			String testId) {
		float meanMarks=-1f;
		try {
			meanMarks=snp.reviewOpinion(login,password,title,type,reviewer,opinion);
			
			DecimalFormat dmeanMarks = new DecimalFormat("#.###");
			DecimalFormat dexpectedMark = new DecimalFormat("#.###");
			if (!(dmeanMarks.format(meanMarks).equals(dexpectedMark.format(expectedMark)))) {
				System.out.println("Err " + testId
						+ " : the mark (" + meanMarks
						+ ") was not change"); // Error message displayed
						return 1;
			}else return 0; // return success code : everything is OK, nothing to
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception " + e); // Error
																		// message
																		// displayed
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
	}
	
	/**
	 * 	 * Check that trying to add this new ReviewOpinion
	 * raises a  NotMemberException If OK, the method just returns.
	 * If not OK, an error message is displayed and 1 is returned, 
	 * 
	 * @param snp - the <i>ISocialNetwork</i>
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer
	 * @param opinion
	 * @param testId
	 * @param errorMessage
	 * @return
	 */
	private static int reviewOpinionNotMemberTest(ISocialNetworkPremium snp, 
			String login, String password, String title, String type,String reviewer, int opinion,
			String testId, String errorMessage) {
		try {
			snp.reviewOpinion(login, password, title, type, reviewer, opinion);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotMemberException e) {
			return 0;
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
	}

	/**
	 * Check that trying to add this new ReviewOpinion 
	 * raises a  NotItemException.  If OK, the method just returns 0.
	 * If not OK, an error message is displayed and 1 is returned, 
	 *  
	 * 
	 * @param snp - the <i>ISocialNetwork</i>
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer
	 * @param opinion
	 * @param testId
	 * @param errorMessage
	 * @return
	 */
	private static int reviewOpinionNotItemTest(ISocialNetworkPremium snp, 
			String login, String password, String title, String type,String reviewer, int opinion,
			String testId, String errorMessage) {
		try {
			snp.reviewOpinion(login, password, title, type, reviewer, opinion);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (NotItemException e) {
			return 0;
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
		
	}

	/**
	 * Check that trying to add this new ReviewOpinion 
	 * raises a  AlreadyAnOpinionException.  
	 * If OK, the method just returns 0. 
	 * If not OK, an error message is displayed and 1 is returned,
	 * 
	 * @param snp - the <i>ISocialNetwork</i>
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer
	 * @param opinion
	 * @param testId
	 * @param errorMessage
	 * @return
	 */
	private static int reviewOpinionAlreadyAnOpinionTest(ISocialNetworkPremium snp, 
			String login, String password, String title, String type,String reviewer, int opinion,
			String testId, String errorMessage) {
		try {
			snp.reviewOpinion(login, password, title, type, reviewer, opinion);
			System.out.println("Err " + testId + " : " + errorMessage); // display
			// the
			// error
			// message
			return 1; // and return the "error" value
		} catch (AlreadyAnOpinionException e) {
			return 0;
		} catch (Exception e) {
			System.out.println("Err " + testId + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
			return 1;
		}
	}
	
	public static TestReport test(){

		ISocialNetworkPremium snp = new SocialNetworkPremium();
		try {
			snp.addMember("Alexandre","alexandre","Mon profile");
			snp.addMember("Chloe","chloe","Mon profile");
			snp.addMember("Derrien","derrien","Mon profile");
			snp.addMember("Benoit","benoit","Mon profile");
		} catch (Exception e) {
			System.out.println("Err " + "member creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		try {
			snp.addItemFilm("Alexandre", "alexandre", "Avatar1", "Pierre","Paul","Jac",200);
			snp.addItemFilm("Alexandre", "alexandre", "Avatar2", "Pierre","Paul","Jac",200);
			snp.addItemFilm("Alexandre", "alexandre", "sameTitle", "Pierre","Paul","Jac",200);
		} catch (Exception e) {
			System.out.println("Err " + "ItemFilm creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		try {
			snp.addItemBook("Alexandre", "alexandre", "Potter1","Pierre","Paul",200);
			snp.addItemBook("Alexandre", "alexandre", "Potter2","Pierre","Paul",200);
			snp.addItemBook("Alexandre", "alexandre", "sameTitle","Pierre","Paul",200);
		} catch (Exception e) {
			System.out.println("Err " + "ItemBook creation failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		try {
			snp.reviewItemFilm("Alexandre", "alexandre", "Avatar2", 1, "nul film");
			snp.reviewItemFilm("Chloe", "chloe", "Avatar2", 3, "nul film");
			snp.reviewItemFilm("Alexandre", "alexandre", "sameTitle", 3, "mega film");
			snp.reviewItemFilm("Chloe", "chloe", "sameTitle", 5, "mega film");
		} catch (Exception e) {
			System.out.println("Err " + "reviewItemFilm failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		try {
			snp.reviewItemBook("Alexandre", "alexandre", "Potter2", 1, "nul book");
			snp.reviewItemBook("Chloe", "chloe", "Potter2", 3, "nul book");
			snp.reviewItemBook("Alexandre", "alexandre", "sameTitle", 2, "mega book");
			snp.reviewItemBook("Chloe", "chloe", "sameTitle", 4, "mega book");
		} catch (Exception e) {
			System.out.println("Err " + "reviewItemBook failed" + " : unexpected exception. "
					+ e); // Display a specific error message
			e.printStackTrace(); // Display contextual info about what happened
		}
		
		
		int nbBooks = snp.nbBooks(); // number of books in 'sn' (should be 3
		// here)
		int nbFilms = snp.nbFilms(); // number of films in 'sn' (should be 3
		// here)
		int nbMembers=snp.nbMembers(); // number of nbMembers in 'sn' (should be 2
		// here)
		
		int nbTests = 0; // total number of performed tests
		int nbErrors = 0; // total number of failed tests

		System.out.println("Testing reviewOpinion()");
		
		
		// <=> test n°1
		
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, null, "alexandre", "Avatar2","film","Chloe",1,
				"1.1","reviewOpinionBadEntry() doesn't reject null logins");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, " ", "alexandre", "Avatar2","film","Chloe",1,
				"1.2","reviewOpinionBadEntry() doesn't reject logins that don't contain at least one character other than space");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", null, "Avatar2","film","Chloe",1,
				"1.3","reviewOpinionBadEntry() doesn't reject null passwords");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", " pwd ", "Avatar2","film","Chloe",1,
				"1.4","reviewOpinionBadEntry() doesn't reject passwords that don't contain at least 4 characters (not taking into account leading or trailing blanks)");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", null,"film","Chloe",1,
				"1.5","reviewOpinionBadEntry() title is not instantiated");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "   ","film","Chloe",1,
				"1.6","reviewOpinionBadEntry() title contains less than one non-space character");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "Avatar2","film",null,1,
				"1.7","reviewOpinionBadEntry() doesn't reject null reviewer");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "Avatar2","film"," ",1,
				"1.8","reviewOpinionBadEntry() doesn't reject reviewer that don't contain at least one character other than space");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "Avatar2","toto","Chloe",1,
				"1.9","reviewOpinionBadEntry() type is not equals to \"film\" or \"book\"");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "Avatar2","film","Chloe",0,
				"1.10","reviewOpinionBadEntry() opinion is not equals to -1 or 1");
		nbTests++;
		nbErrors += reviewOpinionBadEntryTest(
				snp, "Alexandre", "alexandre", "Avatar2","film","Alexandre",1,
				"1.11","reviewOpinionBadEntry() a member tries to evaluate himself (login = reviewer)");
		
		
		
		// <=> test n°2a
		//reviewOpinion(String login, String password, String title, String type,
		//String reviewer, int opinion)
		System.out.println(snp);

		
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Alexandre", "alexandre", "Avatar2","film","Chloe",1,2.0241547f,
				"2.1a");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Alexandre", "alexandre", "Potter2","book","Chloe",1,2.04717f,
				"2.1b");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Alexandre", "alexandre", "sameTitle","film","Chloe",1,4.069124f,
				"2.1c");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Alexandre", "alexandre", "sameTitle","book","Chloe",1,3.09009f,
				"2.1d");
		System.out.println(snp);

		
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Derrien", "derrien", "Avatar2","film","Chloe",1,2.1101322f,
				"2.1e");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Derrien", "derrien", "Potter2","book","Chloe",1,2.1293104f,
				"2.1f");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Derrien", "derrien", "sameTitle","film","Chloe",1,4.1476793f,
				"2.1g");
		nbTests++;
		nbErrors += reviewOpinionOKTest(snp, "Derrien", "derrien", "sameTitle","book","Chloe",1,3.1652892f,

				"2.1h");
		System.out.println(snp);

		
		// <=> test n2b
		nbTests++;
		nbErrors += reviewOpinionAlreadyAnOpinionTest(
				snp, "Alexandre", "alexandre", "Avatar2","film","Chloe",1,
				"2.2","reviewOpinionAlreadyAnOpinion() theKarmaChanger (login) has already put an opinion on the review of the 'title' by 'reviewer'), film, unique titile");
		nbTests++;
		nbErrors += reviewOpinionAlreadyAnOpinionTest(
				snp, "Alexandre", "alexandre", "Potter2","book","Chloe",1,
				"2.3","reviewOpinionAlreadyAnOpinion() theKarmaChanger (login) has already put an opinion on the review of the 'title' by 'reviewer'), book, unique titile");
		nbTests++;
		nbErrors += reviewOpinionAlreadyAnOpinionTest(
				snp, "Alexandre", "alexandre", "sameTitle","film","Chloe",1,
				"2.4","reviewOpinionAlreadyAnOpinion() theKarmaChanger (login) has already put an opinion on the review of the 'title' by 'reviewer'), film, same titile");
		nbTests++;
		nbErrors += reviewOpinionAlreadyAnOpinionTest(
				snp, "Alexandre", "alexandre", "sameTitle","book","Chloe",1,
				"2.5","reviewOpinionAlreadyAnOpinion() theKarmaChanger (login) has already put an opinion on the review of the 'title' by 'reviewer'), book, same titile");
 
		 
		 
		 
		// <=> test n3
		nbTests++;
		nbErrors += reviewOpinionNotMemberTest(snp,
				"Alex", "alexandre",
				"Avatar2","film","Chloe",1,
				"3.1","reviewOpinionNotMember() login does not match with the login of a registered member");
		nbTests++;
		nbErrors += reviewOpinionNotMemberTest(snp,
				"Alexandre", "alex",
				"Avatar2","film","Chloe",1,
				"3.2","reviewOpinionNotMember() password does not correspond to his registered password");
		nbTests++;
		nbErrors += reviewOpinionNotMemberTest(snp,
				"Alexandre", "alexandre","Avatar2","film",
				"Max",
				1,
				"3.3","reviewOpinionNotMember() reviewer does not match with the login of a registered member");
		
		// <=> test n4
		
		nbTests++;
		nbErrors += reviewOpinionNotItemTest(snp, "Alexandre", "alexandre", "Ava","film","Chloe",1,
				"4.1","reviewOpinionNotItem() title is not registered as a film's title");
		nbTests++;
		nbErrors += reviewOpinionNotItemTest(snp, "Alexandre", "alexandre", "Ava","book","Chloe",1,
				"4.2","reviewOpinionNotItem() title is not registered as a book's title");
		nbTests++;
		nbErrors += reviewOpinionNotItemTest(snp, "Alexandre", "alexandre", "Avatar1","film","Chloe",1,
				"4.3","reviewOpinionNotItem() checks that the reviewer has already put a review on the chosen item");
		nbTests++;
		nbErrors += reviewOpinionNotItemTest(snp, "Alexandre", "alexandre", "Potter1","book","Chloe",1,
				"4.4","reviewOpinionNotItem() checks that the reviewer has already put a review on the chosen item");
		

	
		nbTests++;
		// check that 'snp' was not modified
		if (nbMembers != snp.nbMembers()) {
			System.out
					.println("Error : the number of Members was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbBooks != snp.nbBooks()) {
			System.out
					.println("Error : the number of books was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}
		nbTests++;
		if (nbFilms != snp.nbFilms()) {
			System.out
					.println("Error : the number of films was unexepectedly changed by reviewItemFilm()");
			nbErrors++;
		}

		// Display final state of 'sn'
		System.out.println("Final state of the social network : " + snp);

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
