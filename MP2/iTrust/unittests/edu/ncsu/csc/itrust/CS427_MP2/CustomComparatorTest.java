package edu.ncsu.csc.itrust.CS427_MP2;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.beans.CustomComparator;
import edu.ncsu.csc.itrust.beans.PersonnelBean;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class CustomComparatorTest extends TestCase {

	PersonnelDAO personnelDAO = TestDAOFactory.getTestInstance().getPersonnelDAO();
	CustomComparator custCom = new CustomComparator();
	
	protected void setUp() throws Exception {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.uap1();
	}
	
	public void testCompare() throws Exception {
		PersonnelBean p1 = personnelDAO.getPersonnel(8000000009L);
		p1.setMID(2);
		PersonnelBean p2 = personnelDAO.getPersonnel(8000000009L);
		p2.setMID(1);
		
		assertEquals(1, custCom.compare(p1, p2));
	}
	
}
