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
	private static int FOO = 2;

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> status(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/task",  method = RequestMethod.POST)
	public String task(@RequestBody TaskTO task){
		StringBuilder sb = new StringBuilder();
		
		try{
			int limit = task.getTask();
            
			//http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
            long[] series = new long[limit];
           
            //create first 2 series elements
            series[0] = 1;
            series[1] = 2;
           
            //create the Fibonacci series and store it in an array
            for(int i=2; i < limit; i++){
                    series[i] = series[i-1] + series[i-2];
            }
           
            
            for(int i=0; i< limit; i++){
                    sb.append(series[i] + " ");
            }
			
			
		}catch (NumberFormatException ex){
			System.out.println(ex);
		}
		
		return "{\"result\" : \""+ sb.toString() + "\"}";
	}
	
}
