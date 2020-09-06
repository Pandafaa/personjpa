package telran.ashkelon2020.person.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.person.dao.PersonRepository;
import telran.ashkelon2020.person.dto.PeriodDto;
import telran.ashkelon2020.person.dto.PersonDto;
import telran.ashkelon2020.person.dto.UdatePersonDto;
import telran.ashkelon2020.person.dto.exceptions.PersonAlreadyExistsException;
import telran.ashkelon2020.person.dto.exceptions.PersonNotFoundExceprion;
import telran.ashkelon2020.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public PersonDto addPerson(PersonDto personDto) {
		Integer id = personDto.getId();
		if(personRepository.existsById(id)) {
			throw new PersonAlreadyExistsException(Integer.toString(id));
		}
		Person person = modelMapper.map(personDto, Person.class);
		personRepository.save(person);
		return personDto;
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundExceprion(Integer.toString(id)));
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public void deletePersonById(Integer id) {
		if(!personRepository.existsById(id)) {
			throw new PersonNotFoundExceprion(Integer.toString(id));
		}
		personRepository.deleteById(id);
			
	}

	@Override
	public PersonDto udatePerson(Integer id, UdatePersonDto updateDto) {
		Person person = personRepository.findById(id).orElseThrow(()->new PersonNotFoundExceprion(Integer.toString(id)));
		if(updateDto.getName()!=null) {
		person.setName(updateDto.getName());}
		if(updateDto.getBirthDate()!=null) {
			person.setBirthdate(updateDto.getBirthDate());
		}
		personRepository.save(person);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	@Transactional
	public List<PersonDto> personWtihName(String name) {
		return personRepository.findByName(name)
				.map(person->modelMapper.map(person,PersonDto.class)).collect(Collectors.toList());	
	}

	@Override
	@Transactional
	public List<PersonDto> personsInAgeInterval(PeriodDto periodDto) {
		LocalDate from = LocalDate.now().minusYears(periodDto.getAgeTo());
		LocalDate  to=LocalDate.now().minusYears(periodDto.getAgeFrom());
	
		return  personRepository.findByBirthdateBetween(from, to)
		.map(p->modelMapper.map(p,PersonDto.class)).collect(Collectors.toList());	
		
	}

	

}


