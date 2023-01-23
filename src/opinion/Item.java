package opinion;

import java.util.LinkedList;

import exceptions.NotItemException;

/*
* The Item class is an abstract class whose goal is to factorize functions of ItemFilm and ItemBook 
* @author BENOIT & DERRIEN
* @version  MAY 2022
*/

public abstract class Item {
	protected String title;
	protected String kind;
	protected LinkedList<ItemReview> theReviews=new LinkedList<ItemReview>();
	
	/**
	 * /Return true if the title equals to the title passed in parameter 
	 * insensitive to case and blanks
	 * @param title - title of the item
	 */
	protected boolean isCalled(String title) {
		return this.title.toLowerCase().trim().equals(title.toLowerCase().trim());		
	}
	
	/**
	 * Add a review to the list theReviews
	 * @param aReview - item review
	 * @param aMember - Item Member
	 */
	protected void addReview(ItemReview aReview, Member aMember) {
		int i=0;
		while(i<theReviews.size() && !theReviews.get(i).isCalled(aMember)){
			i+=1;
		}
		if(i==theReviews.size()) this.theReviews.add(aReview);
		else {
			this.theReviews.remove(i);
			this.theReviews.add(aReview);
		}
	}
	
	/*
	 * Return the AverageMark 
	 */

	protected float averageMark() {
		float sumOfMarkMultiplyByTheirWeighting=0;
		float sumKarma=0;
		
		for(ItemReview theReview : this.theReviews) {
			sumOfMarkMultiplyByTheirWeighting+=theReview.getMark()*theReview.getWeighting();
			sumKarma+=theReview.getWeighting();
		}
		
		return sumOfMarkMultiplyByTheirWeighting/sumKarma;
	}
	
	/**
	 * Find the reviewer in the list of reviews. Return true if if the review if the right person 
	 * False if it's not the writer of the review
	 * @param reviewer - Item Member 
	 * OrThrowNotItemException
	 */
	protected ItemReview findTheReviewOfTheReviewerMemberOrThrowNotItemException(Member reviewer) throws NotItemException {
		
		int positionIndexOfTheItemReviw=0;
		while(positionIndexOfTheItemReviw<theReviews.size() && !theReviews.get(positionIndexOfTheItemReviw).isCalled(reviewer)){
			positionIndexOfTheItemReviw+=1;
		}
		if(positionIndexOfTheItemReviw==theReviews.size())throw new NotItemException("for this speciefied title, no match with the reviewer");
		return theReviews.get(positionIndexOfTheItemReviw);
	}
	
	@Override
	public abstract String toString();
	
	
}