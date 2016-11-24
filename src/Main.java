import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		SessionManager.getInstance().init();
		
		try {
			Scanner in = new Scanner(System.in);
						
			boolean first = true;
			while(true){
				clearScreen();
				
				if(first){first = false;}
				else { System.out.println(); }
				
				System.out.println("Hi, there!");
				System.out.println("Here you find jobs and people to do them.");
				System.out.println();
				
				System.out.println("Available commands: ");
				System.out.println("\t1. signup <employer|seeker>");
				System.out.println("\t2. login");
				System.out.println("\t3. bye");
				
				System.out.print("Enter command: ");
				
				String cmd = in.nextLine();
				String[] cmdParts = cmd.split(" ");
				
				processInput(cmdParts);
			}			
		} catch (Exception e){
			
		}
	}
	
	private static void processInput(String cmdParts[]) { //throws InvalidCommandException {
		
		if(cmdParts[0].equals("bye")) System.exit(0);
		
		/****************** debug *******************************/
		if(cmdParts[0].equals("dbg")){
			System.out.println(System.getProperty("user.dir"));
			
			SessionManager sm 				= SessionManager.getInstance();
			ArrayList<Seeker> seekers 		= sm.getSeekers();
			ArrayList<Listing> listings 	= sm.getListings();
			
			System.out.println("Seekers: ");
			for(Seeker s:seekers){
				System.out.println(s.toString());
			}
			
			System.out.println("Listings: ");
			for(Listing l:listings){
				System.out.println(l.toString());
			}
			
			// wait for input
			try{System.in.read();} catch(Exception e){}
		}
		/*********************************************************/
		
		if(cmdParts[0].equals("fo")){
			String chatroom = "seeker@urmum.comemployer@urgrandmum.com";
			chatroom = chatroom.replaceAll("[^a-zA-Z0-9]+","");
			
	        String newRoom = "";

	        for(int i=0; i<chatroom.length(); i+=2){
	            newRoom += chatroom.charAt(i);
	        }
			
			System.out.println(newRoom);
			
			// wait for input
			try{System.in.read();} catch(Exception e){}
			
		};
		
		int argCount = cmdParts.length;
		
		if(argCount < 1 || argCount > 3); // throw new InvalidCommandException();
			
		if(cmdParts[0].equals("signup")){
			(new cmdSignup()).execute(cmdParts);
		}
		
		else if(cmdParts[0].equals("login")){
			(new cmdLogin()).execute(cmdParts);
		}
		
		else {
			// throw new InvalidCommandException();
		}
	}
	
	public static void clearScreen() {  
	    for(int i=0; i<100; i++)
	    	System.out.println();  
	}  

}
