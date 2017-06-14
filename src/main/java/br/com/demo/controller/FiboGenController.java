package br.com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.to.TaskTO;

@RestController
public class FiboGenController {
	//private static int FOO = 2;

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> status(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/task",  method = RequestMethod.POST)
	public String task(@RequestBody TaskTO task){
		StringBuilder sb = new StringBuilder();
		
		String email = task.getTask();
		
		//Register no DynamoDB
		sb.append("email:" + email);
		
		
			
		
		return "{\"result\" : \""+ sb.toString() + "\"}";
	}
	
}
