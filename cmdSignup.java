import java.util.*;
public class cmdSignup implements Command {

	private SessionManager sessionManager = SessionManager.getInstance();

	
	private Scanner in;
	
	@Override
	public void execute(String[] cmdParts) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		
		if(cmdParts[1].equals("employer")){
			sessionManager.addUser(signupListing());
		} else {
			sessionManager.addUser(signupSeeker());
		}
	}
	
	private Seeker signupSeeker(){
		String name;
		String education;
		int workExp;
		String skills;
		String email;
		String password;
		
		System.out.println("Enter name: ");
		name = in.nextLine();
		
		System.out.println("Enter education: ");
		education = in.nextLine();
		
		System.out.println("Enter work experience: ");
		workExp = in.nextInt();
		
		System.out.println("Enter skills: ");
		skills = in.nextLine();
		
		System.out.println("Enter email: ");
		email = in.nextLine();
		
		System.out.println("Enter password: ");
		password = in.nextLine();
		
		return new Seeker(name, education, workExp, skills, email, password);
	}
	
	private Listing signupListing(){
		String name;
		String jobDescription;
		String skillsRequired;
		String jobTitle;
		int expRequired;
		String email;
		String password;
		
		System.out.println("Enter name: ");
		name = in.nextLine();
		
		System.out.println("Enter job title");
		jobTitle = in.nextLine();
		
		System.out.println("Enter job description: ");
		jobDescription = in.nextLine();
		
		System.out.println("Enter skills required: ");
		skillsRequired = in.nextLine();
		
		System.out.println("Enter experience required: ");
		expRequired = in.nextInt();
		
		System.out.println("Enter email: ");
		email = in.nextLine();
		
		System.out.println("Enter password: ");
		password = in.nextLine();
		
		return new Listing(name, jobDescription, skillsRequired, jobTitle, expRequired, email, password);
	}
}
