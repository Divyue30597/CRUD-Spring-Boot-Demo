package com.lti.divyue.XMLtoObject.practice;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ObjectToXml {
	public static void main(String[] args) throws Exception{
		
		JAXBContext contextObj = JAXBContext.newInstance(Employee.class);
		
		Marshaller marshallObj = contextObj.createMarshaller();
		marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Employee emp = new Employee(1, "Divyue Sharma", 33014);
		
		marshallObj.marshal(emp, new FileOutputStream("employee.xml"));
	}
}
