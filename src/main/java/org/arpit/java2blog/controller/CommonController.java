package org.arpit.java2blog.controller;

import org.arpit.java2blog.model.Country;
import org.arpit.java2blog.service.CommonService;
import org.arpit.java2blog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
	/*@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}*/

	@RequestMapping(value = "/getValue/{className}/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable String className,@PathVariable int id) throws ClassNotFoundException {
		return commonService.get(className,id);
	}

	@RequestMapping(value = "/updateValue/{className}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@PathVariable String className,@RequestBody String string) throws IOException, ClassNotFoundException {
		commonService.updateValue(className,string);
	}

	@RequestMapping(value = "/findValue/{className}/{parameters}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryByParameters(@PathVariable String className,@PathVariable String parameters) throws ClassNotFoundException {
		return commonService.find(className,parameters.trim().split(","));
	}

	@RequestMapping(value = "/findAll/{className}/{parameters}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Object findAllByParameters(@PathVariable String className,@PathVariable String parameters) throws ClassNotFoundException {
		return  commonService.findAll(className,parameters.trim().split(","));
	}

	/*@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Country country) {	
		countryService.addCountry(country);
		
	}



	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);		
	}	*/
}
