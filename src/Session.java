import java.util.*;

public class Session {

	private ArrayList<? extends User> sessionList;
	private User sessionUser;
	private SessionManager sessionManager;
	private Scanner in;
	
	public Session(User user){
		this.sessionUser 	= user;
		sessionManager		= SessionManager.getInstance();
	}
	
	public void startSession(){
		sessionList = sessionManager.getSessionList();
		in			= new Scanner(System.in);
		
		while(true){
			Main.clearScreen();
			System.out.println("The following commands are available: ");
			System.out.println("\t1. check matches.");
			System.out.println("\t2. show listings");
			System.out.println("\t3. logout\n");
			
			System.out.println("Enter command: ");
			
			String cmd = in.nextLine();		
			int result = processInput(cmd);
			
			if(result == 1) return;
		}

	}
	
	private int processInput(String cmd){
		if(cmd.equals("logout")){
			return 1;
		}
		
		if(cmd.equals("check matches")){
			(new cmdCheckMatches()).equals(cmd);
		}
		
		else if (cmd.equals("show listings")){
			
		}
		
		return 0;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
}
