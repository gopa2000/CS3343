import java.util.ArrayList;

public class SuggestionsManager {

	private User sessionUser;
	private SessionManager sessionManager;
	
	public SuggestionsManager(){
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
	}
	
	//Here user is seeker
	public ArrayList<Listing> rankSuggestions(Seeker seeker){
		ArrayList<Listing> listings = sessionManager.getListings();
		
	}
	
	//Here user is employer
	public ArrayList<Seeker> rankSuggestions(Listing listing){
		ArrayList<Seeker> seekers = sessionManager.getSeekers();
		
	}
	
	public int getWorkExperienceScore(Seeker seeker, Listing listing){
		int score = 0;
		int workExpSeeker = seeker.getWorkExp();
		int workExpReqListing = listing.getExpRequired();
		int difference = workExpReqListing - workExpSeeker;
		if(difference < 2){
			return 20;
		}else if(difference >= 2 && difference < 4){
			return 15;
		}else if(difference >= 4 && difference < 8){
			return 5;
		}
		return 0;
	}
	
	public int getWorkExperienceScore(Listing listing, Seeker seeker){
		int score = 0;
		int workExpSeeker = seeker.getWorkExp();
		int workExpReqListing = listing.getExpRequired();
		int difference = workExpReqListing - workExpSeeker;
		if(difference < 2){
			return 20;
		}else if(difference >= 2 && difference < 4){
			return 15;
		}else if(difference >= 4 && difference < 8){
			return 5;
		}
		return 0;
	}
	
	public int getEducationScore(Seeker seeker){
		
	}
	
	public int getEducationScore(Listing listing){
		
	}
	
	public int getSkillsScore(Seeker seeker){
		
	}
	
	public int getSkillsScore(Listing listing){
		
	}
}
