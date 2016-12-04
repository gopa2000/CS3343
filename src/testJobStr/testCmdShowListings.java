package testJobStr;

import static org.junit.Assert.*;

import JobStr.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class testCmdShowListings {

private SessionManager sessionManager;

Like like1;
Like like2;


Listing employer1;
Listing employer2;


Seeker employee1;
Seeker employee2;
	
	@Before
	public void setup(){
		sessionManager = SessionManager.getInstance();
	}
	
	@Test
    public void testCmdShowListings_1(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"incorrect", "fvkkit"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
	@Test
    public void testCmdShowListings_2(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"gibberish", "plswork"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
	@Test
    public void testCmdShowListings_3(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"nkccm", "cldccc"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
	@Test
    public void testCmdShowListings_4(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "ncklnclw"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
	@Test
    public void testCmdShowListings_5(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"incorrecmcl;mt", "listings"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
	@Test
    public void testCmdShowListings_6(){
    	try {
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listingssss"};
	    	String input = "y\n" +  "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(getOutput().contains("Invalid"))
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
    
    @Test
    public void testCmdShowListings_7(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_8(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Google","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Puru","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_9(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("BAML","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Aditya","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_10(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Infosys","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Dhruv","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_11(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Goldman Sachs","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Karan","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_12(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("ABC Health Systems","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Kabir","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employee1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employer1,employee1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToListing(sessionManager.getListings());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
	
    @Test
    public void testCmdShowListings_13(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Fashionista Co","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Rucha","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_14(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("BioCompany","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Nikunj","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_15(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Enviroment LLC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Vipul","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_16(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Silver Sports","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Hardik","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_17(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Mylo","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Amit","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_18(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Barcelona Enterprises","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Shankar","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_19(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Kilimanjaro","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Lata","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_20(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Merakhaanadedo","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Harami","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_21(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("KediaKaLoda","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Kedia","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_22(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Konochiwa","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Mitsubishi","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_23(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Dhruvhentaidekhtahai","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Vvvtrue","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_24(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Iamthegreatest Enterprises","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Bhagat","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_25(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Cmoncmonwherever","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Cuzwhynot","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_26(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Hmmmmmm","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Mhhhhhh","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_27(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Mannequinchallenge","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Fegitsoraus","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_28(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Youtube","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Miniminter","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_29(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Vine","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Amanda","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_30(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Twitter","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Tobjizzle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_31(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Barcelona Enterprises","Developing Things","SQL C++ JAVA","Developer",7,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Shankar","BSC",7,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_32(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("CrazyYouu","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Arbaaz","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_33(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Spastic Co","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Sango","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "y\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_34(){
    	try {
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	setInput("exit\n");
	    	setOutput();
	    	
	    	
	    	try {
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success;
	    	if(slc.getFlagExit() == true)
	    		success = true;
	    	else
	    		success = false;
	    	
	    	assertEquals(true, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    @Test
    public void testCmdShowListings_35(){
    	try {
    		sessionManager.refreshSeekers();
    		sessionManager.refreshListing();
    		sessionManager.clearLikeTable();
    		sessionManager.clearMatchTable();
    		employer1 = new Listing("Mylo","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
    		employee1 = new Seeker("Amit","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
    		
    		sessionManager.setSessionUser(employer1);
    		
    		sessionManager.addListing(employer1);
    		sessionManager.addSeeker(employee1);
    		
    		like1 = new Like(employee1,employer1);
    		sessionManager.addToLikeTable(like1);
    		
    		sessionManager.setSessionListToSeeker(sessionManager.getSeekers());
    		
	    	cmdShowListings slc = new cmdShowListings();
	    	
	    	String[] cmd = {"show", "listings"};
	    	
	    	String input = "n\n";
	    	
	    	setInput(input);
	    	setOutput();
	    	
	    	
	    	try {
	    		System.out.println(getOutput());
	    		slc.execute(cmd);
	    	} catch(Exception e){
	    		System.out.println(e.toString());
	    	}
	    	
	    	boolean success = false;;
	    	ArrayList<Match> matches = sessionManager.getMatchTable();
	    	for(Match m:matches){
	    		if(m.getListing().equals(employer1) && m.getSeeker().equals(employee1)){
	    			success = true;
	    			break;
	    		}
	    	}
	    	
	    	assertEquals(false, success);
	    	
    	} catch(Exception e){
    		System.out.println(e.toString());
    	}
    }
    
    ByteArrayInputStream bis;
    
    private void setInput(String input){
    	bis = new ByteArrayInputStream(input.getBytes());
    	System.setIn(bis);
    	
    	System.setIn(System.in);
    }
    
	
    PrintStream oldPrintStream;
    ByteArrayOutputStream bos;
        
    private void setOutput() throws Exception
    {
        oldPrintStream = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    private String getOutput() 
    {
        System.setOut(oldPrintStream);
        return bos.toString();
    }
	
}
