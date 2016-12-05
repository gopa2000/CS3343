package testJobStr;

import static org.junit.Assert.*;

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
	
	@Test
	public void test_Checkmatches(){
		instance.clearLikeTable();
		instance.clearMatchTable();
		instance.refreshListing();
		instance.refreshSeekers();
		
		employer1 = new Listing("HSBC","Developing Things","SQL C++ JAVA","Developer",4,"fern@hsbc.com","dank","MSC");
		employee1 = new Seeker("Dayle","BSC",4,"MQSQL C++ JAVA","derp@gmail.com","pass");
		
		like1 = new Like(employer1,employee1);
		instance.addToLikeTable(like1);
		
		
		like2 = new Like(employee1,employer1);
		instance.addToLikeTable(like2);
		
		
	}
}
