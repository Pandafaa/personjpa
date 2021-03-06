package telran.ashkelon2020.person.dao;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.person.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> //repository for work with relational Databases
{
	Stream<Person> findByName(String name);
	Stream<Person>  findByBirthdateBetween(LocalDate from, LocalDate to);
	

}
