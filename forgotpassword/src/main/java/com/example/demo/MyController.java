package com.example.demo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/forgotpassword")
public class MyController {
	@Autowired
	private ForgotPwdService fgps;
	@Autowired
	private ObjectMapper mapper;
	@CrossOrigin(origins= {"http://10.150.176.241:3003","http://localhost:3000"})
	@PostMapping("/uic")
	
	public String getValidation( @RequestBody Person p) {
		
		String p1=p.getEmail();
		ObjectNode jsonObject = mapper.createObjectNode();
		
		// don't forget to change return type to support this
		if(fgps.findByEmail(p1))
		{
			
			jsonObject.put("status", "true");
			
		}
		else
			jsonObject.put("status", "false");
		String str=jsonObject.toString();
		 System.out.println(str);
		return str;
   
     
                   }
	@RequestMapping("/")
	public String demo()
	{
		return "hi";
	}
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.176.241:3003"})
	@PostMapping("/otp")
	public String validateOTP( @RequestBody Person p) {
		ObjectNode jsonObject = mapper.createObjectNode();
	if(p.getOtp().equals("1620"))
	{
		jsonObject.put("status", "true");
	}
	else
		jsonObject.put("status", "false");
	String str=jsonObject.toString();
	return str;
	}
	
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.176.241:3003"})
	@PostMapping("/mts")
	public String  methodToSet( @RequestBody Person p) {
	String email=p.getEmail();
	ObjectNode jsonObject = mapper.createObjectNode();
	String  c=p.getChoice();
	if(c.equals("2")) {
		jsonObject.put("otp", "1620");
		  
	}
	
   if(c.equals("3")) {
	  
	   ArrayList<String>al=fgps.findQuestionsById(email);
	   jsonObject.put("question1", al.get(1));
	   jsonObject.put("question2", al.get(2));
	   
	  
	  

    
	        
	}
   String str=jsonObject.toString();
   System.out.println(str);
	return str;

	}
	
 
	
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.176.241:3003"})
	@PostMapping("/sec")
	public String security( @RequestBody Person p) {
		
		System.out.println("hi");
			ObjectNode jsonObject = mapper.createObjectNode();
	    if(securityQuestionsCheck(p))
	    {
	    	
	    	  jsonObject.put("status", "true");
	    	 
	    }
		
		else
		{
			 jsonObject.put("status", "false");
		      
	    	  
		}
	    String str=jsonObject.toString();
		return str;
		}
		
	
	private boolean securityQuestionsCheck(Person p) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		
		ArrayList<String> al2=new ArrayList<String>();
		
		
	if(al2.get(1).equals(p.getAns1())&&al2.get(2).equals(p.getAns2()))
		
		return true;
	else
		return false;
	}
	
	@CrossOrigin(origins= {"http://localhost:3000","http://10.150.176.241:3003"})
	@PostMapping("/set")
	public String setPassword( @RequestBody Person p) {
		
		ObjectNode jsonObject = mapper.createObjectNode();
		System.out.println("hi from set");
		
		String pass=p.getPassword();
		String email=p.getEmail();
		System.out.println(pass);
		if(fgps.setPassword(pass, email))
			jsonObject.put("status", "true");
		else
	    	  jsonObject.put("status", "false");
	    	  String str=jsonObject.toString();
	  		return str;
	      
	    }
}
