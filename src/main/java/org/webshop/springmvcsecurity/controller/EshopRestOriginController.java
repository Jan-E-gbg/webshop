package org.webshop.springmvcsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.webshop.document.search.service.CompanyImgDocService;
import org.webshop.search.model.Company;
import org.webshop.search.service.SearchService;

@RequestMapping(value = "/origins/restmain")
@RestController
@EnableWebMvc
@CrossOrigin(origins= {"http://localhost:4200"} , maxAge=3600)
public class EshopRestOriginController {
	
	@Autowired
	SearchService sourceService;
	
	@Autowired
	private CompanyImgDocService companyImgDocService;
	
	@RequestMapping(value = "/listAllCompanys" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Company>> listAllCompanys() {
        List<Company> companys = sourceService.getListOfCompanys();
        
        companys.add(0,new Company("-1000" ,"Choice"));
        
        return new ResponseEntity<List<Company>>(companys, HttpStatus.OK);
	}
	
	

}
