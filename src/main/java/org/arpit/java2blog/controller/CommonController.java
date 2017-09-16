package org.arpit.java2blog.controller;

import org.arpit.java2blog.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CommonController {
	
	@Autowired
	CommonService commonService;

	//http://localhost:8080/SpringRestHibernateExample/getAllValues/Country
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/getAllValues/{className}", method = RequestMethod.GET, headers = "Accept=application/json")
	public <T> List<T> getAllValues(@PathVariable String className) {
		return commonService.getAllValues(className);
	}

	//http://localhost:8080/SpringRestHibernateExample/getValueWithId/Country/1
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/getValueWithId/{className}/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public <T> T getValueById(@PathVariable String className,@PathVariable int id) throws ClassNotFoundException {
		return commonService.get(className,id);
	}

	//http://localhost:8080/SpringRestHibernateExample/findUniqueValueWithParams/Country/countryName,pak,countryName,Pak
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/findUniqueValueWithParams/{className}/{parameters}", method = RequestMethod.GET, headers = "Accept=application/json")
	public <T> T getValueByParameters(@PathVariable String className,@PathVariable String parameters) throws ClassNotFoundException, NoSuchFieldException {
		return commonService.find(className,parameters.trim().replaceAll("#","\\.").split(","));
	}

	//http://localhost:8080/SpringRestHibernateExample/findAllWithParams/Country/countryName,India,id,1
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/findAllWithParams/{className}/{parameters}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Object findAllByParameters(@PathVariable String className,@PathVariable String parameters) throws ClassNotFoundException, NoSuchFieldException {
		return  commonService.findAll(className,parameters.trim().replaceAll("#","\\.").split(","));
	}

	//http://localhost:8080/SpringRestHibernateExample/findAllAsc/Country/id
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/findAllAsc/{className}/{parameter}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Object findAllInAsc(@PathVariable String className,@PathVariable String parameter) throws ClassNotFoundException, NoSuchFieldException {
		return  commonService.findAllInAsc(className,parameter);
	}

	//http://localhost:8080/SpringRestHibernateExample/findAllWithParamsOrderBy/Country/id/false/countryName,India
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/findAllWithParamsOrderBy/{className}/{orderByProperty}/{asc}/{parameters}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Object findAllWithOrderBy(@PathVariable String className,@PathVariable String orderByProperty,@PathVariable String asc,@PathVariable String parameters) throws ClassNotFoundException, NoSuchFieldException {
		return  commonService.findAllWithOrderBy(className,orderByProperty,Boolean.valueOf(asc),parameters.trim().replaceAll("#","\\.").split(","));
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/updateValue/{className}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateValue(@PathVariable String className,@RequestBody String string) throws IOException, ClassNotFoundException {
		commonService.updateValue(className,string);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/saveValue/{className}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void saveValue(@PathVariable String className,@RequestBody String string) throws IOException, ClassNotFoundException {
		commonService.saveValue(className,string);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/deleteValueById/{className}/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteValueById(@PathVariable("className") String className,@PathVariable("id") int id) throws IOException, ClassNotFoundException {
		commonService.deleteById(className,id);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/deleteValue/{className}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteValue(@PathVariable("className") String className,@RequestBody String string) throws IOException, ClassNotFoundException {
		commonService.delete(className,string);
	}

}
