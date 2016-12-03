
import java.util.ArrayList;
import java.util.Scanner;

public class cmdShowSuggestions implements Command{

	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner in;
	
	
	@Override
	public void execute(String[] cmdParts) {
		// TODO Auto-generated method stub
		
		Main.clearScreen();
		
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
		
		SuggestionsManager suggestionsmanager = new SuggestionsManager();
		
		if(sessionUser instanceof Seeker){
			ArrayList<Listing> suggestions = suggestionsmanager.rankSuggestions((Seeker)sessionUser);
			for(Listing l:suggestions){
				l.outputSuggestions();
			}
		}else{
			ArrayList<Seeker> suggestions = suggestionsmanager.rankSuggestions((Listing)sessionUser);
			for(Seeker s:suggestions){
				s.outputSuggestions();
			}
		}
	}
}

