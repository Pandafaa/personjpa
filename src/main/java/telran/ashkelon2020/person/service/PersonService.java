package telran.ashkelon2020.person.service;

import java.util.List;

import telran.ashkelon2020.person.dto.PeriodDto;
import telran.ashkelon2020.person.dto.PersonDto;
import telran.ashkelon2020.person.dto.UdatePersonDto;



public interface PersonService {
	
	PersonDto addPerson(PersonDto personDto);
	
	PersonDto findPersonById(Integer id);
	
	void deletePersonById(Integer id);
	
	
	PersonDto udatePerson(Integer id, UdatePersonDto updateDto);
	
	List<PersonDto> personWtihName(String name);
	
	List<PersonDto> personsInAgeInterval(PeriodDto periodDto);
	

}
