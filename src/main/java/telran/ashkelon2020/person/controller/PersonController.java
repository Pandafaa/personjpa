package telran.ashkelon2020.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.person.dto.PeriodDto;
import telran.ashkelon2020.person.dto.PersonDto;
import telran.ashkelon2020.person.dto.UdatePersonDto;
import telran.ashkelon2020.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping
	public PersonDto addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}

	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable Integer id) {
		return personService.findPersonById(id);

	}

	@DeleteMapping("/{id}")
	public void  deletePersonById(@PathVariable Integer id) {
		
		personService.deletePersonById(id);
		
	}
	
	@PutMapping("/{id}")
	public PersonDto updatePerson(@PathVariable Integer id,@RequestBody UdatePersonDto updateDto ) {
		
		return personService.udatePerson(id, updateDto);
		
	}
	
	@GetMapping("/find/{name}")

	public List<PersonDto> getPersonByName(@PathVariable String name){
		return personService.personWtihName(name);
		
	}
	
	
	@PutMapping("/find/ageperiod")
	public  List<PersonDto> getPersonByPeriod(@RequestBody PeriodDto periodDto){
		return personService.personsInAgeInterval(periodDto);
	}
}
