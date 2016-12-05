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

public class testCheckMatches {
	Like like1;
	Like like2;
	
	Listing employer1;
	Listing employer2;
	
	
	Seeker employee1;
	Seeker employee2;
	
	SessionManager instance = SessionManager.getInstance();
	
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
	
	@Test
	public void test_Checkmatches_01(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		instance.setSessionUser(employer1);
		
		instance.addMatch(new Match(employee1,employer1));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("1")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_02(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		instance.setSessionUser(employee1);
		
		instance.addMatch(new Match(employee1,employer1));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("1")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_03(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		
		like1 = new Like(employer1,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		instance.setSessionUser(employee1);
		
		instance.addMatch(new Match(employee2,employer1));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("1")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(false,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_04(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		instance.addToLikeTable(new Like(employee1,employer2));
		instance.addToLikeTable(new Like(employer2,employee1));
		
		instance.setSessionUser(employee1);
		
		instance.addMatch(new Match(employee1,employer1));
		instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("2")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_05(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		instance.addToLikeTable(new Like(employee1,employer2));
		instance.addToLikeTable(new Like(employer2,employee1));
		
		instance.setSessionUser(employee1);
		
		instance.addMatch(new Match(employee1,employer1));
		//instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("2")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(false,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_06(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dhruv","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer2);
		instance.addToLikeTable(like2);
		
		instance.addToLikeTable(new Like(employee2,employer2));
		instance.addToLikeTable(new Like(employer2,employee2));
		
		instance.setSessionUser(employee2);
		
		instance.addMatch(new Match(employee1,employer1));
		instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("0")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_07(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dhruv","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer2);
		instance.addToLikeTable(like2);
		
		instance.addToLikeTable(new Like(employee2,employer2));
		//nstance.addToLikeTable(new Like(employer2,employee2));
		
		instance.setSessionUser(employee2);
		
		instance.addMatch(new Match(employee2,employer2));
		//instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("1")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_08(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dhruv","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer2);
		instance.addToLikeTable(like2);
		
		//instance.addToLikeTable(new Like(employee2,employer2));
		instance.addToLikeTable(new Like(employer2,employee2));
		
		instance.setSessionUser(employee2);
		
		//instance.addMatch(new Match(employee1,employer1));
		instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("0")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
	
	@Test
	public void test_Checkmatches_09(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		boolean suc = false;
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dhruv","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		employee2 = new Seeker("Puru","BSC",2,"SQL JAVA JSS HTML","herp@gmail.com","pass");
		employer2 = new Listing("SC","B-Analyst","JSS JQUERY CSS","Smart Analyst",2,"fern@sc.com","dank","NA");
		
		like1 = new Like(employer2,employee2);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee2,employer2);
		instance.addToLikeTable(like2);
		
		instance.addToLikeTable(new Like(employee2,employer2));
		//instance.addToLikeTable(new Like(employer2,employee2));
		
		instance.setSessionUser(employee2);
		
		//instance.addMatch(new Match(employee1,employer1));
		instance.addMatch(new Match(employee1,employer2));
		
		cmdCheckMatches mtc = new cmdCheckMatches();
		String[] cmd = {"trying"};
		String input = "\n";
		try{
			setInput(input);
			setOutput();
		mtc.execute(cmd);
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		if(getOutput().contains("0")){
			suc = true;
		}
		System.out.println(getOutput().toString());
		
		assertEquals(true,suc);
		
		
		
		
	}
}
