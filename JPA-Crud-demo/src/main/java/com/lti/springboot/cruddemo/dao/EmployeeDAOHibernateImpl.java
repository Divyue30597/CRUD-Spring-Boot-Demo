package com.lti.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.springboot.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	//Define field for entityManager
	private EntityManager entityManager;

	//Setup Constructor injection
		public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create the query 
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		//execute the query and get result list
		List<Employee> employees = theQuery.getResultList();
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//Save employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deletebyId(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// delete object with the primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		// set the parameter
		theQuery.setParameter("employeeId", theId);
		//execute the query
		theQuery.executeUpdate(); 
	}

}
