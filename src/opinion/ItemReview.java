package opinion;

import java.util.LinkedList;

/**
 * The ItemReview class allows to give an opinion with a comment and a rating on a book or a movie 
 * 
 * @author DERRIEN & BENOIT
 * @version  MAY 2022
 */

public class ItemReview {
	private float mark;
	private String comment;
	private Member theMember;
	private LinkedList<Member> theListOfMemberWhoChangedTheKarma = new LinkedList<Member>();

	
	/**
	 * Define a ItemReview
	 * @param mark - new item rating 
	 * @param comment - new item comment 
	 * @param Member - member submitting a review 
	 */
	public ItemReview(float mark, String comment,Member Members) {
		this.mark=mark;
		this.comment=comment;
		this.theMember=Members;
		
	}

	/**
	 * Returns the mark of the review
	 */
	public float getMark() {
		return mark;
	}
	

	/**
	 * Returns true if the current member is equal to the member passed in parameter 
	 */
	public boolean isCalled(Member aMember) {
		return this.theMember.equals(aMember);
	}

	protected int getWeighting() {
		return theMember.getKarma();
	}

	
	protected void addAKarmaChanger(Member aKarmaChanger) {
		theListOfMemberWhoChangedTheKarma.add(aKarmaChanger);
	}
	protected boolean checkThatTheKarmaChangerHasNotAlreadyModifiedTheKarma(Member theKarmaChanger) {
		for(Member aKarmaChanger : this.theListOfMemberWhoChangedTheKarma) {
			if(theKarmaChanger.equals(aKarmaChanger)) return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "ItemReview [mark=" + mark + ", comment=" + comment + ", theMember=" + theMember
				+ "]";
	}
	
}
