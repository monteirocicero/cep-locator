package com.cicero.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.demo.domain.CEP;
import com.cicero.demo.exception.CEPNotFoundException;
import com.cicero.demo.service.CepService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "cep", description = "Access CEP by number", produces = "application/json")
@RestController
public class CepController {
	
	@Autowired
	private CepService cepService;
	
	@ApiOperation(value = "Find CEP", notes = "Returns CEP by number")
	    @RequestMapping(method = RequestMethod.GET, path="/cep/{cepNumber}", produces = "application/json")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name = "cepNumber", value = "CEP number", required = true, dataType = "Long", paramType = "path", defaultValue="01005003")
	      })
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = CEP.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found", response = CEPNotFoundException.class),
	            @ApiResponse(code = 500, message = "Failure")}) 
	public CEP findCep(@PathVariable("cepNumber") Long cepNumber) throws CEPNotFoundException {
		return cepService.findCepByNumber(cepNumber);
	}

}
