package de.hfu.IntegrationTest;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {
	
	GregorianCalendar felix = new GregorianCalendar(1994,4,15);
	GregorianCalendar felix1 = new GregorianCalendar(1995,12,25);
	GregorianCalendar feli = new GregorianCalendar(1972,2,28);
	GregorianCalendar Erhart = new GregorianCalendar(2000,1,1);
	GregorianCalendar Ralph = new GregorianCalendar(1930,6,30);
	

	List<Resident> residentList = new ArrayList<Resident>() {{
		add(new Resident("Felix","Kuhn","Testweg","Fuwa",felix.getGregorianChange()));
		add(new Resident("Felix","Kohn","Boddinstr","Berlin",felix1.getGregorianChange()));
		add(new Resident("Feli","Mueller","Adlerweg","Stuttgart",feli.getGregorianChange()));
		add(new Resident("Erhart","Muellerchen","Testweg","Bonn",Erhart.getGregorianChange()));
		add(new Resident("Ralph","Tester","Adenauerplatz","Fuwa",Ralph.getGregorianChange()));
	}};

	
 public List<Resident> getResidents(){ 
	 return residentList;
 }
	
}