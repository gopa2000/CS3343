package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class testcmdShowSuggestions {
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
    
    private Listing job1;
	private Listing job2;
	private Listing job3;
	private Listing job4;
	
	private Seeker seeker1;
	private Seeker seeker2;
	private Seeker seeker3;
	private Seeker seeker4;
	
	private SessionManager instance = SessionManager.getInstance();
	
	private ArrayList<Listing> joblist;
	private ArrayList<Seeker> jobsearch;
	
	@Test
	public void testcmdShowSuggestion_01(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		instance.setSessionUser(seeker1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("HSBC")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_02(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		instance.setSessionUser(seeker1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("DB")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_03(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		instance.setSessionUser(seeker1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("BAML")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_04(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		job2 = new Listing("BAML","Scripting","PHP MYSQL","Scripter",10,"fern@baml.com","dank","PHD");
		job3 = new Listing("DB","Analyst","JS HTML CSS","Analyst",4,"fern@db.com","dank","BSC");
		job4 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","MSC");
		
		instance.addListing(job1);
		instance.addListing(job2);
		instance.addListing(job3);
		instance.addListing(job4);
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		instance.setSessionUser(seeker1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("HDFC")){
			flag = true;
		}
		
		assertEquals(false,flag);
	}
    
	
	@Test
	public void testcmdShowSuggestion_06(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		
		
		instance.addListing(job1);
		
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","NA",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		instance.setSessionUser(job1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("Dayle")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_07(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		
		
		instance.addListing(job1);
		
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","NA",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		instance.setSessionUser(job1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("Puru")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_08(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		
		
		instance.addListing(job1);
		
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","NA",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		instance.setSessionUser(job1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("Kaids")){
			flag = true;
		}
		
		assertEquals(true,flag);
	}
	
	@Test
	public void testcmdShowSuggestion_09(){
		instance.refreshListing();
		instance.refreshSeekers();
		job1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		
		
		instance.addListing(job1);
		
		
		boolean flag = false;
		
		seeker1 = new Seeker("Dayle","NA",6,"MQSQL C++ JSS","derp@gmail.com","pass");
		seeker2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		seeker3 = new Seeker("Kaids","PHD",3,"MQSQL JAVA JSS","merp@gmail.com","pass");
		seeker4 = new Seeker("Dhruv","BSC",1,"MQSQL HTML JS","lerp@gmail.com","pass");
		
		instance.addSeeker(seeker1);
		instance.addSeeker(seeker2);
		instance.addSeeker(seeker3);
		instance.addSeeker(seeker4);
		
		instance.setSessionUser(job1);
		
		cmdShowSuggestions mtc = new cmdShowSuggestions();
		String[] cmd = {""};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
			mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if(getOutput().contains("Tushar")){
			flag = true;
		}
		
		assertEquals(false,flag);
	}
    
}
