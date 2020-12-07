package com.lti.divyue.practice.JSONtoPOJO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JSONWriter {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		CustomerDetails customer = createDummyCustomer();
		
		try {
			//Convert the object to JSON string and save into a file directly
			mapper.writeValue(new File("D:\\CustomerDetails.json"), customer);
			
			//Convert object to JSON String
			String jsonInString = mapper.writeValueAsString(customer);
			System.out.println(jsonInString);
			
			//Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
			System.out.println(jsonInString);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static CustomerDetails createDummyCustomer() {
		CustomerDetails customer = new CustomerDetails();
		
		customer.setId(1);
		customer.setFirstName("Divyue");
		customer.setLastName("Sharma");
		
		List<String> courses = new ArrayList<>();
		courses.add("JAVA");
		courses.add("Spring");
		courses.add("Python");
		
		customer.setCoursesCompleted(courses);
		
		return customer;
		
	}

}
