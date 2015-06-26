package edu.ncsu.csc.itrust.CS427_MP2;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

import edu.ncsu.csc.itrust.enums.TransactionType;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;

public class ShowPersonnelTest extends iTrustHTTPTest{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.standardData();
	}
	
	public void testViewPersonnelAggain() throws Exception {
		WebConversation wc = login("9000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000001L, 0L, "");
	
		// choose Edit Personnel
		wr = wr.getLinkWith("Edit Personnel").click();		
		assertEquals("iTrust - Please Select a Personnel", wr.getTitle());
		wr.getForms()[1].setParameter("FIRST_NAME", "Kelly");
		wr.getForms()[1].setParameter("LAST_NAME", "Doctor");
		wr.getForms()[1].submit();
		wr = wc.getCurrentPage();
		wr.getForms()[2].getSubmitButtons()[0].click();
		wr = wc.getCurrentPage();
		assertEquals("iTrust - Edit Personnel", wr.getTitle());
		
		//Edit information
		wr.getForms()[0].setParameter("streetAddress1", "2956 Raven Ridgeline Drive");
		wr.getForms()[0].submit();
		
		//choose Edit Personnel again
		wr = wr.getLinkWith("Edit Personnel").click();		
		assertEquals("iTrust - Please Select a Personnel", wr.getTitle());
		
	}

}
