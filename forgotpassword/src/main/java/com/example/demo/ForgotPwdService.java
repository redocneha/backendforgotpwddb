package com.example.demo;

import java.util.ArrayList;
import java.util.List;



public interface ForgotPwdService   {
	 boolean findByEmail(String email);
	    ArrayList<String> findQuestionsById(String email);
	    List<String> findAnswersById(String  email);
    boolean setPassword(String pass,String email);

}
