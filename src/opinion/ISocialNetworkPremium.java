package opinion;

import exceptions.AlreadyAnOpinionException;
import exceptions.BadEntryException;
import exceptions.NotItemException;
import exceptions.NotMemberException;

public interface ISocialNetworkPremium extends ISocialNetwork{
	
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
			NotMemberException, NotItemException, AlreadyAnOpinionException;

}
