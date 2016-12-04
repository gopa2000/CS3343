package testJobStr;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import JobStr.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testGetSkillScore {
	private Listing job;
	private Seeker person;
	private SessionManager instance = SessionManager.getInstance();
	
	@Test
	public void testGetSkillScore_01(){
		job = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		ArrayList<Listing> arr = new ArrayList<Listing>();
		instance.setListings(arr);
	}
}
