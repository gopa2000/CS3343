/* Singleton class to hold all session data
 * 
 */

import java.util.*;
import java.io.*;

public class SessionManager implements Serializable {
	
	private static SessionManager instance = new SessionManager();
	
	private ArrayList<? extends User> sessionList;
	private ArrayList<Like> likeTable;
	private ArrayList<Match> matchTable;
	private ArrayList<Listing> listings;
	private ArrayList<Seeker> seekers;
	private User sessionUser;
	
	public static SessionManager getInstance(){
		if(instance == null)
			return new SessionManager();
		else
			return instance;
	}
	
	private SessionManager(){
		this.sessionList 	= new ArrayList<>();
		this.likeTable 		= new ArrayList<>();
		this.listings		= new ArrayList<>();
		this.seekers		= new ArrayList<>();
		this.matchTable		= new ArrayList<>();
		this.sessionUser	= null;

		readListingsDb();
		readSeekersDb();
	}
	
	public void init(){

	}
	
	public void addUser(Listing user){
		listings.add((Listing)user);
		writeListingDb();
	}
	
	public void addUser(Seeker user){
		seekers.add((Seeker) user);
		writeSeekerDb();	
	}
	
	public void writeSeekerDb(){
		try {
			File seekerDb 			= new File("seekers.db");
			
			seekerDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileOutputStream fos 	= new FileOutputStream("seekers.db");
			ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			
			oos.writeObject(seekers);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void writeListingDb(){
		try {
			File listingDb 			= new File("listings.db");
			listingDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileOutputStream fos 	= new FileOutputStream("listings.db");
			ObjectOutputStream oos 	= new ObjectOutputStream(fos);
			
			oos.writeObject(listings);
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readSeekersDb(){

		try {
			File seekerDb 				= new File("seekers.db");
			seekerDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileInputStream fis			= new FileInputStream("seekers.db");
			ObjectInputStream ois 		= new ObjectInputStream(fis);
			
			ArrayList<Seeker> readcase	= (ArrayList<Seeker>) ois.readObject();
			
			this.seekers = readcase;
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void readListingsDb(){

		try {
			File listingDb 			= new File("listings.db");
			listingDb.createNewFile(); // creates new file if doesn't exist, does nothing otherwise
			
			FileInputStream fis		= new FileInputStream("listings.db");
			ObjectInputStream ois 	= new ObjectInputStream(fis);
			
			this.listings			= (ArrayList<Listing>) ois.readObject();
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public ArrayList<Like> getLikeTable() {
		return likeTable;
	}

	public void setLikeTable(ArrayList<Like> likeTable) {
		this.likeTable = likeTable;
	}

	public ArrayList<Listing> getListings() {
		return listings;
	}

	public void setListings(ArrayList<Listing> listings) {
		this.listings = listings;
	}

	public ArrayList<Seeker> getSeekers() {
		return seekers;
	}

	public void setSeekers(ArrayList<Seeker> seekers) {
		this.seekers = seekers;
	}
	
	
	public ArrayList<? extends User> getSessionList() {
		return sessionList;
	}

	public void setSessionList(ArrayList<User> sessionList) {
		this.sessionList = sessionList;
	}

	public ArrayList<Match> getMatchTable() {
		return matchTable;
	}

	public void setMatchTable(ArrayList<Match> matchTable) {
		this.matchTable = matchTable;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public static void setInstance(SessionManager instance) {
		SessionManager.instance = instance;
	}

	public boolean checkLogin(String email, String password){
		for(Seeker s:seekers){
			if(s.getEmail().equals(email) && s.getPassword().equals(password)){
				this.sessionUser = s;
				this.sessionList = listings;
				return true;
			}				
		}
		
		for(Listing l:listings){
			if(l.getEmail().equals(email) && l.getPassword().equals(password)){
				this.sessionUser = l;
				this.sessionList = seekers;
				return true;
			}
		}
		
		return false;
	}
	
	public void addToLikeTable(Like like){
		likeTable.add(like);
	}
	
	public void checkMatch(){};
	
}
