import java.util.*;

public class Session {

	private ArrayList<? extends User> sessionList;
	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner scanner;
	
	public Session(User user){
		this.sessionUser 	= user;
		sessionManager		= SessionManager.getInstance();
	}
	
	public void startSession(){
		sessionList = sessionManager.getSessionList();
		scanner		= new Scanner(System.in);
		
		System.out.println("There are " + sessionList.size() + " listings to display.");
		System.out.println("Enter y or n depending on your preference.");
		
		for(User u:sessionList){
			// display function
						
			System.out.println("Enter preference (y/n):");
			String pref = scanner.nextLine();
			
			if(pref.equals("y")){
				// add to like table
				sessionManager.addToLikeTable(new Like(sessionUser, u));
				sessionManager.checkMatch();
			}
		}
	}
}
