package edu.ncsu.csc.itrust.CS427_MP2;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import edu.ncsu.csc.itrust.beans.PersonnelBean;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class EditPersonnelTest extends TestCase{

	PersonnelDAO personnelDAO = TestDAOFactory.getTestInstance().getPersonnelDAO();

	@Override
	protected void setUp() throws Exception {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.uap1();
	}

	
	public void testEditPersonnel1() throws Exception {
		PersonnelBean p = personnelDAO.getPersonnel(8000000009L);
		p.setFirstName("Kelly");
		p.setLastName("Doctor");
		p.setCity("Capitol City");
		p.setZip("28700-0458");
		p.setPhone("555-877-5100");
		p.setStreetAddress1("98765 Oak Hills Drive");
		personnelDAO.editPersonnel(p);
		p = personnelDAO.getPersonnel(8000000009L);
		assertEquals("Kelly", p.getFirstName());
		assertEquals("Doctor", p.getLastName());
		assertEquals("Capitol City", p.getCity());
		assertEquals("28700-0458", p.getZip());
		assertEquals("555-877-5100", p.getPhone());
		assertEquals("98765 Oak Hills Drive", p.getStreetAddress1());
	}
	
}
