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
			System.out.println("MAIN MENU\n");
			System.out.println("The following commands are available: ");
			System.out.println("\t1. view matches.");
			System.out.println("\t2. show listings");
			System.out.println("\t3. logout\n");
			
			System.out.println("Enter command: ");
			
			String cmd = in.nextLine();
			String[] cmdParts = cmd.split(" ");
			int result = processInput(cmdParts);
			
			if(result == 1) return;
		}

	}
	
	private int processInput(String cmd[]){
		
		if(cmd[0].equals("logout")){
			System.out.println("\nGoodbye, see you soon!");
			return 1;
		}
		
		if(cmd[0].equals("view")){
			(new cmdCheckMatches()).execute(cmd);
		}
		
		else if (cmd[0].equals("show")){
			(new cmdShowListings()).execute(cmd);
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
