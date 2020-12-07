package com.lti.divyue.practice.JSONtoPOJO;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//Convert JSON String from file to object
			CustomerDetails customer = mapper.readValue(new File("D:\\CustomerDetails.json"), CustomerDetails.class);
			System.out.println("Customer = " + customer);
			
			String jsonInString = "{\r\n"
					+ "   \"id\" : 2,\r\n"
					+ "   \"firstName\" : \"Tomchi\",\r\n"
					+ "   \"lastName\" : \"Sharma\",\r\n"
					+ "   \"coursesCompleted\" : [ \"JAVA\", \"Spring\", \"Python\" ]\r\n"
					+ "}";
			
			CustomerDetails customer2 = mapper.readValue(jsonInString, CustomerDetails.class);
			System.out.println(customer2);
			
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer2);

            System.out.println(prettyStaff1);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
