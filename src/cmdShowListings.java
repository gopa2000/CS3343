import java.util.ArrayList;
import java.util.Scanner;

public class cmdShowListings implements Command {

	private ArrayList<? extends User> sessionList;
	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner in;
	
	@Override
	public void execute(String[] cmdParts) {
		// TODO Auto-generated method stub
		
		sessionManager		= SessionManager.getInstance();
		sessionUser		 	= sessionManager.getSessionUser();
		
		System.out.println("There are " + sessionList.size() + " listings to display.");
		System.out.println("Enter y or n depending on your preference.");
		
		
		for(User u:sessionList){
			// display function
						
			System.out.println("Enter preference (y/n):");
			String pref = in.nextLine();
			
			if(pref.equals("y")){
				// add to like table
				sessionManager.addToLikeTable(new Like(sessionUser, u));
				sessionManager.checkMatch();
			}
		}	
	}
}
