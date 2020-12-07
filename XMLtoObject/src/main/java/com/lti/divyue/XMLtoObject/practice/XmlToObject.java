package com.lti.divyue.XMLtoObject.practice;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToObject {
	public static void main(String[] args) {
		try {
			File file = new File("employee.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			
			Unmarshaller jaxbUnmarshal = jaxbContext.createUnmarshaller();
			Employee emp = (Employee) jaxbUnmarshal.unmarshal(file);
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
