package com.cicero.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.demo.domain.Address;
import com.cicero.demo.exception.AddressNotFoundException;
import com.cicero.demo.exception.CEPNotFoundException;
import com.cicero.demo.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "address", description = "Everything about your Addresses", produces = "application/json")
@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new Address", notes = "Creates new Address")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 404, message = "Not Found", response = CEPNotFoundException.class),
            @ApiResponse(code = 201, message = "Resource created") })
	@RequestMapping(method = RequestMethod.POST, path="/address", consumes = "application/json")
	public @ResponseBody Address saveAddress(@RequestBody(required = true) @Valid Address address) throws CEPNotFoundException {
    	return addressService.save(address);
	}
	
    @ApiOperation(value = "Find Address by ID", notes = "Returns Address by Identifier")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ID of address to return", required = true, dataType = "Long", paramType = "path", defaultValue="1")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Address.class),
            @ApiResponse(code = 404, message = "Not Found", response = CEPNotFoundException.class),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(method = RequestMethod.GET, path="/address/{id}", produces = "application/json")
	public @ResponseBody Address searchById(@PathVariable("id") Long identifier) throws AddressNotFoundException {
		return addressService.findById(identifier);
	}
	
    @ApiOperation(value = "Deletes a Address", notes = "Returns Address by Identifier")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ID of address to return", required = true, dataType = "Long", paramType = "path", defaultValue="1")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Address.class),
            @ApiResponse(code = 404, message = "Not Found", response = CEPNotFoundException.class),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(method = RequestMethod.DELETE, path="/address/{id}", produces = "application/json")
	public void remove(@PathVariable("id") Long identifier) {
		addressService.remove(identifier);
	}
	
    @ApiOperation(value = "Update an existing address", notes = "Update an existenting address by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 404, message = "Not Found", response = AddressNotFoundException.class),
            @ApiResponse(code = 201, message = "Resource created") })
    @RequestMapping(method = RequestMethod.PUT, path="/address", consumes = "application/json")
	public @ResponseBody Address updateAddress(@RequestBody(required=true) @Valid Address address) throws AddressNotFoundException, CEPNotFoundException {
		return this.addressService.update(address);
	}

}
