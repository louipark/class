package edu.ncsu.csc.itrust.CS427_MP2;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

import edu.ncsu.csc.itrust.enums.TransactionType;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;

public class FindExpertTest  extends iTrustHTTPTest{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.standardData();
	}
	
	public void testFindExpert() throws Exception {
		WebConversation wc = login("9000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000001L, 0L, "");
		
		//add HCP first
		wr = wr.getLinkWith("Add HCP").click();
		assertEquals("iTrust - Add HCP", wr.getTitle());
		wr.getForms()[0].setParameter("firstName", "Kathryn");
		wr.getForms()[0].setParameter("lastName", "Evans");
		wr.getForms()[0].setParameter("email", "evans@itrust.com");
		wr.getForms()[0].setParameter("specialty", "ob/gyn");
		wr.getForms()[0].submit();
		wr = wc.getCurrentPage();
		wr = wr.getLinkWith("Continue to personnel information.").click();
		wr.getForms()[0].setParameter("streetAddress1", "10078 Avent Ferry Road");
		wr.getForms()[0].setParameter("city", "Capital City");
		wr.getForms()[0].setParameter("state", "NC");
		wr.getForms()[0].setParameter("zip", "28700-0458");
		wr.getForms()[0].setParameter("phone", "555-877-5100");
		wr.getForms()[0].submit();
		
		//admin logout
		wr.getLinkWith("Logout").click();
		
		//random patient logged in 
		wc = login("1", "pw");
		wr = wc.getCurrentPage();
		assertEquals("iTrust - Patient Home", wr.getTitle());
		
		//find expert
		wr.getLinkWith("Find an Expert").click();
		wr = wc.getCurrentPage();
		assertEquals("iTrust - Find an Expert", wr.getTitle());
		wr.getForms()[0].setParameter("specialty", "OB/GYN");
		wr.getForms()[0].setParameter("zipCode", "27606");
		wr.getForms()[0].submit();
		wr = wc.getCurrentPage();
		wr.getLinkWith("Kathryn Evans").click();
		
	}
}
