package de.hfu.IntegrationTest;

import static org.junit.Assert.assertEquals;


import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentTest {
	
	private ResidentRepositoryStub testData = new ResidentRepositoryStub();
	private BaseResidentService bR;
	private Resident testResident,testResidentFilter,testResidentFilter1,testResidentFilterEmpty;
	GregorianCalendar cal = new GregorianCalendar(1930,6,30);
	GregorianCalendar cal1 = new GregorianCalendar(1932,2,27);

	@Before
	public void init() {
		bR = new BaseResidentService();
		bR.setResidentRepository(testData);
		
		testResident = new Resident("Felix","Test","Testweg","Fuwa",cal.getGregorianChange());
		testResidentFilter = new Resident("Fe*","*","*","*",null);
		testResidentFilter1 = new Resident("*","*","A*","*",null);
		testResidentFilterEmpty = new Resident("Test","asdasd","asdasd","Berlon",cal1.getGregorianChange());
	}
	
	@Test
	public void testgetUniqueResident() throws ResidentServiceException {
		assertEquals(testData.getResidents().get(0).getFamilyName(), bR.getUniqueResident(testData.getResidents().get(0)).getFamilyName());
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testgetUniqueResidentException() throws ResidentServiceException {
		bR.getUniqueResident(testResident);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testgetUniqueResidentExceptionFilter() throws ResidentServiceException {
		bR.getUniqueResident(testResidentFilter);
	}
	
	@Test
	public void testgetFilteredResidentsList() {
		List<Resident> l = bR.getFilteredResidentsList(testResidentFilter);
		assertEquals("Kuhn",l.get(0).getFamilyName());
		assertEquals("Kohn",l.get(1).getFamilyName());
		assertEquals("Mueller",l.get(2).getFamilyName());
		assertEquals(3,l.size());
	}
	@Test
	public void testgetFilteredResidentsList1() {
		List<Resident> l = bR.getFilteredResidentsList(testResidentFilter1);
		assertEquals("Mueller",l.get(0).getFamilyName());
		assertEquals("Tester",l.get(1).getFamilyName());
		assertEquals(2,l.size());
	}
	@Test
	public void testgetFilteredResidentsListEmpty() {
		List<Resident> l = bR.getFilteredResidentsList(testResidentFilterEmpty);
		assertEquals(0,l.size());
	}
	
	
}