package edu.ncsu.csc.coffeemaker.http;
import java.io.IOException;

import junit.framework.TestCase;

import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class AddInventoryHTTPTest extends TestCase{
	
	public static final String ADDRESS = "http://localhost:8080/CoffeeMaker_WebTest";
	
	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddRecipe1() throws Exception {
		//Go to add_inventory.jsp
		WebConversation webConversation = new WebConversation();
		WebResponse menuResponse = webConversation.getResponse(ADDRESS);
		WebResponse addInventoryPage = menuResponse.getLinkWith("Add inventory").click();
		
		//Fill out form and submit
		addInventoryPage.getForms()[0].setParameter("amtCoffee", "5");
		addInventoryPage.getForms()[0].setParameter("amtMilk", "3");
		addInventoryPage.getForms()[0].setParameter("amtSugar", "7");
		addInventoryPage.getForms()[0].setParameter("amtChocolate", "2");
		addInventoryPage = addInventoryPage.getForms()[0].submit();
		
		//Test that Recipe added
		assertTrue(addInventoryPage.getText().contains("Inventory successfully added."));
		
		//Go to main menu
		menuResponse = addInventoryPage.getLinkWith("Back to CoffeeMaker Menu").click();
	}

}
