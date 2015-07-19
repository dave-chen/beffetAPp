
package com.ge.sample.buffet;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author 212304931
 */
@RestController
@EnableSwagger
@Api(value = "sample", description = "The Predix buffet REST API document")
public class BuffetController {

    @Autowired
    private BuffetService service;

    @ApiOperation(value = "Creates/Updates the total plates you have eaten.", notes = "")
    @ApiResponses({ @com.wordnik.swagger.annotations.ApiResponse(
            code = 201,
            message = "Plates count creation/update successful. Plates count URI is returned in 'Location' header.") })
    @RequestMapping(
            method = { org.springframework.web.bind.annotation.RequestMethod.PUT },
            value = { "{customer}/plates/{totalPlatesAte}" })
    public ResponseEntity<?>
            updateTotalPlates(@PathVariable("customer") String customer, @PathVariable("totalPlatesAte") int total) {
        this.service.updateTotal(customer, total);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get the total plates you have eaten so far.", notes = "")
    @ApiResponses({ @com.wordnik.swagger.annotations.ApiResponse(
            code = 200,
            message = "Returns the total plates ate and a message based on the total plates ate so far.") })
    @RequestMapping(
            method = { org.springframework.web.bind.annotation.RequestMethod.GET },
            value = { "{customer}/plates" },
            produces = { "application/json" })
    @ResponseBody
    public ResponseEntity<Response> getTotalPlates(@PathVariable("customer") String customer) {
        String message = null;
        Response response = new Response();
        int totalPlates = this.service.getTotalPlates(customer);
        if (totalPlates < 10)
            message = String.format("Stop coding, you only had %s plates. Go get more plates!", totalPlates);
        else {
            message = String.format("Wow, you had %s plates already. Get back to code!", totalPlates);
        }
        response.setMessage(message);
        response.setTotalPlates(totalPlates);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all customers", notes = "")
    @ApiResponses({ @com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "Returns all customers.") })
    @RequestMapping(
            method = { org.springframework.web.bind.annotation.RequestMethod.GET },
            value = { "customers" },
            produces = { "application/json" })
    @ResponseBody
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomers = this.service.getAllCustomers();

        return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
    }
}
