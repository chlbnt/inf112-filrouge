package opinion;

/**
 * The member class is used to represent the users of the system to authenticate them in a unique way 
 * 
 * @author BENOIT & DERRIEN
 * @version  MAY 2021
 */


public class Member {
	
	//private attributes 
		private String login;
		private String password;
		private String profile;
		private int karma=101;// between 1 and 201, its initial value is 101 it is incremented / decremented by + -5
		
		/**
		 * Define a Member
		 * @param login - the new member's login
		 * @param password - the new member's password
		 * @param profile - a free String describing the new member's profile
		 */
		
		public Member(String login, String password, String profile) {
			this.login=login;
			this.password=password;
			this.profile=profile;
			this.karma = 101;
		}

		/**
		 * /Return true if the login equals to the login passed in parameter 
		 * insensitive to case and blanks
		 * @param login - member's login
		 */
		public boolean isCalled(String login) {
			
			return this.login.toLowerCase().trim().equals(login.toLowerCase().trim());  
		}									
		
		/**
		 * Return true if the login equals to the login passed in parameter
		 * and the password equals to password passed in parameter 
		 * @param login - member's login
		 * @param password - member's password
		 */
		public boolean isCalled(String login, String password) {
			
			return this.login.toLowerCase().trim().equals(login.toLowerCase().trim()) && this.password.equals(password);   
		}
		
		/**
		*Return the karma of a Member
		*/
		
		
		public int getKarma() {
			return this.karma;
			
		}
		
		/**
		 * This method increase or decrease the karma  
		 * @param opinionMark - The mark assigned to an opinion
		 */
		
		public void increaseOrDecreaseKarma (int opinionMark) {
			if(opinionMark==1 && karma<201) karma+=5;
			else if (opinionMark==-1 && karma>1) karma-=5;
		}
	

		@Override
		public String toString() {
			return "Member [login=" + login + ", password=" + password + ", profile=" + profile + ", karma=" + karma +"]";
		}
		
		/*protected void addReview(ItemReview aReview) {
			this.theReviews.add(aReview); //Add a review to a member
		}*/



	}

