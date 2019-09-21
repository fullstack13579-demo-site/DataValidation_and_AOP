package com.aspect.datavalidation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aspect.datavalidation.model.Person;
import com.aspect.datavalidation.model.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value="/data",method=RequestMethod.GET)
	public String displayInput(Person person) {	
		 return "input";
	}
	
	
	@RequestMapping(value="/data",method=RequestMethod.POST)
	public String processDataFromInput(Model model,@Valid Person person,BindingResult bindingResult,@RequestParam String name,
			                                                                                        @RequestParam String telephoneNumber) {

		if(bindingResult.hasErrors()) {		
		   return "input";   
	    }
		
		Person personObject= new Person();
		personObject.setName(name);
		personObject.setTelephoneNumber(telephoneNumber);		
		personRepository.save(personObject);
		
		model.addAttribute("personObject",personObject);
		return "output";	
		
	}
}
