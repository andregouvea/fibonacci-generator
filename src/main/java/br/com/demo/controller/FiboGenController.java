package br.com.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

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
	
	@RequestMapping(value = "/instanceid", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> instanceId(){
		try{
			
			StringBuilder result = new StringBuilder();
			URL url = new URL("http://169.254.169.254/latest/meta-data/instance-id");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(1000);
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();

			return new ResponseEntity<String>(new Date().toString() + " ID do servidor: " + result.toString(), HttpStatus.OK);
			
		}catch (Exception ex){
		}
		
		return new ResponseEntity<String>("Localhost", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/task",  method = RequestMethod.POST)
	public String task(@RequestBody TaskTO task){
		StringBuilder sb = new StringBuilder();
		
		try{
			int limit = task.getTask();
            
			//http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
            BigInteger[] series = new BigInteger[limit];
           
            //create first 2 series elements
            series[0] = BigInteger.valueOf(1L);
            series[1] = BigInteger.valueOf(2L);
           
            //create the Fibonacci series and store it in an array
            for(int i=2; i < limit; i++){
                    series[i] = series[i-1].add(series[i-2]);
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
