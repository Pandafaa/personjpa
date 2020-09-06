package telran.ashkelon2020.person.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExceprion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6365012120623177111L;

	public PersonNotFoundExceprion(String id) {
		super("Person with id = " + id+" not found");
		// TODO Auto-generated constructor stub
	}
	
	

}
