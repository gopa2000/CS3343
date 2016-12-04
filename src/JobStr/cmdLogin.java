package JobStr;
import java.util.*;

public class cmdLogin implements Command{

	private ArrayList<User> users;
	private SessionManager sessionManager;
	private Scanner in;

	
	@Override
	public void execute(String[] cmdParts) throws Exception {
		
		sessionManager = SessionManager.getInstance();
		in = new Scanner(System.in);
		
		System.out.println("Enter email: ");
		String email = in.nextLine();
	
		System.out.println("Enter password: ");
		String password = in.nextLine();
		
		boolean result = sessionManager.checkLogin(email, password);
		
		if(result){
			System.out.println("Logged in!");
			System.out.println("Press any key to continue.");
			// save session and start mainscreen display
			
			Session session = new Session(sessionManager.getSessionUser());
			session.startSession();
			
		} else {
			// throw invalid auth exception
		}		
	}	
}
