package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ForgotPwdServiceImpl implements ForgotPwdService{


	@Autowired
	private PersonDAO employeeDAO;

	public PersonDAO getPersonDAO() {
		return employeeDAO;
	}

	public void setPersonDAO(PersonDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public ForgotPwdServiceImpl(PersonDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	@Override
	public boolean findByEmail(String email) {
		// TODO Auto-generated method stub
		if(employeeDAO.findByEmail(email)==1)
			return true;
		return false;
	}

	@Override
	public ArrayList<String> findQuestionsById(String email) {
		// TODO Auto-generated method stub
		return employeeDAO.findQuestionsById(email);
	}

	@Override
	public List<String> findAnswersById(String email) {
		// TODO Auto-generated method stub
		return employeeDAO.findAnswersById(email);
	}

	@Override
	public boolean setPassword(String pass, String email) {
		// TODO Auto-generated method stub
	   if(employeeDAO.setPassword(pass,email)==1)
		   return true;
	   return false;
				
	}

}
