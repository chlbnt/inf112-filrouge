package tests;

import opinion.ISocialNetwork;
import opinion.SocialNetwork;

public class PerformanceTests {
	
	public static void main(String[] args) throws Exception {
		
		int nbBooks = 2000;
		int nbMembers = 500;
		int nbFilms = 3000;
		int nbReviews = 0;
		
		long totalperf = 0;
		long memberperf = 0;
		
		ISocialNetwork sn = new SocialNetwork();
		Tools.populate(sn,nbMembers,nbBooks,nbFilms,nbReviews);
		int totalMember = 500;
		
		for (int i=1; i<11; i++) {
			try {
                totalMember += nbMembers;
                long perf = Tools.populate(sn, nbMembers*i, 0, 0, 0);
                System.out.println("Nb members : "+totalMember);
                System.out.println(perf);
                totalperf += perf;

            } catch (Exception e) {
                System.out.println("Err " + "performance test failed" + " : unexpected exception. "
                        + e); // Display a specific error message
                e.printStackTrace(); // Display contextual info about what happened
            }
        }
        System.out.println("Temps moyen : "+totalperf/10);
			
		}
	}
		
