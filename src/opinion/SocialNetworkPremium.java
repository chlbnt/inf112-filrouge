package opinion;

import exceptions.AlreadyAnOpinionException;
import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

public class SocialNetworkPremium extends SocialNetwork implements ISocialNetworkPremium  {
	
	/**
	 * Allows to note the opinion of a member which generates a modification of the karma of this member 
	 * 
	 * A KarmaChanger is a Member who has rated another member's review 
	 * 
	 * @param login's KarmaChanger
	 * @param password KarmaChanger
	 * @param title's Item
	 * @param type of the Item
	 * @param reviewer 
	 * @param opinion 
	 * @return AverageMark of the Item
	 * @throws BadEntryException
	 * @throws NotMemberException
	 * @throws NotItemException
	 * @throws AlreadyAnOpinionException
	 */
	public float reviewOpinion(String login, String password, String title, String type,
			String reviewer, int opinion) throws BadEntryException,
			NotMemberException, NotItemException,  AlreadyAnOpinionException{
		/*
		 * BadEntryException test
		 */
		if(login==null || login.isBlank()) throw new BadEntryException("login is not instantiated or contains less than one non-space character");
		if(password==null || password.trim().length()<4)throw new BadEntryException("password is not instantiated or contains less than four characters (not taking into account leading or trailing blanks");
		if(title==null || title.isBlank()) throw new BadEntryException("title is not instantiated or contains less than one non-space character");
		if(!(type.equals("film") || type.equals("book"))) throw new BadEntryException("type is not equals to \"film\" or \"book\"");
		if(reviewer==null || reviewer.isBlank()) throw new BadEntryException("reviewer is not instantiated or contains less than one non-space character");
		if(!(opinion==-1 || opinion==1)) throw new BadEntryException("opinion is not equals to -1 or 1");
		if(login.equals(reviewer)) throw new BadEntryException("a member tries to evaluate himself ("+login+" == "+reviewer+")");
		/*
		 * NotMemberException test
		 */
		Member theKarmaChanger = findAMemberOrThrowNotMemberException(login,password);
		/*
		 * find a reviewer or throw NotMemberException
		 * same as findAMemberOrThrowNotMemberException but without password for the member 
		 */
		int positionIndexOfTheReviewer=0;
		while(positionIndexOfTheReviewer<nbMembers() && !listMember.get(positionIndexOfTheReviewer).isCalled(reviewer)){
			positionIndexOfTheReviewer+=1;
		}
		if(positionIndexOfTheReviewer==nbMembers())throw new NotMemberException("reviewer does not match with the login of a registered member in SocialNetwork.");
		Member theReviewerMember = listMember.get(positionIndexOfTheReviewer);
		/**
		 * findAFilmOrThrowNotItemException if the type is film
		 * or findABookOrThrowNotItemException if the type is book
		 * the item found(film or book) is stored in TheItem
		 */
		Item theItem = null;
		switch(type) {
		case "film":
			theItem=findAFilmOrThrowNotItemException(title);
			break;
		case "book":
			theItem=findABookOrThrowNotItemException(title);
			break;
		}
		/*
		 * Searches for the Review that was written by TheReviewerMember on the given movie or book "title". 
		 * If he does not find it he triggers the exception : NotItemException("for this speciefied title, no match with the reviewer");
		 */	
		ItemReview theReview = theItem.findTheReviewOfTheReviewerMemberOrThrowNotItemException(theReviewerMember);
		/*
		 * check theKarmaChanger hasn't already put an opinion on the Review written by TheReviewerMember.
		 * This is to avoid the case where one person changes the karma of another ad infinitum
		 */
		if(theReview.checkThatTheKarmaChangerHasNotAlreadyModifiedTheKarma(theKarmaChanger))throw new AlreadyAnOpinionException("theKarmaChanger ("+login+") has already put an opinion on "+title+" by "+ reviewer);
		/*
		 * adds theKarmaChanger to the list of people who have posted an opinion to theReview
		 * theKarmaChanger ne pourra donc plus ajouter une nouvelle opinion
		 */
		theReview.addAKarmaChanger(theKarmaChanger);
		/*
		 * Change the karma of the reviewer corresponding to the opinion
		 * theKarmaChanger will no longer be able to add a new opinion
		 */
		theReviewerMember.increaseOrDecreaseKarma(opinion);
		/**
		 * return either,
		 * the average rating of the film
		 * or, the average rating of the book
		 */
		return theItem.averageMark();
	}
	
	
	
	public static void main(String[] args) {
		
	}

}