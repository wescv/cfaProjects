package org.academiadecodigo.bootcamp.rest;

import org.academiadecodigo.bootcamp.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {


    @RequestMapping(method = RequestMethod.GET, value = "api/hello")
    public ResponseEntity<String>
    helloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return new ResponseEntity<String>("Hello " + str, HttpStatus.I_AM_A_TEAPOT);

    }


    @RequestMapping(method = RequestMethod.GET, value = "api/customer")
    public ResponseEntity<Customer>
    customerJson(@RequestParam(value = "name", defaultValue = "Turn it down for what?") String str) {

        Customer customer = new Customer();

        customer.setId(1);
        customer.setFirstName("Rui");
        customer.setLastName("Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone("916668877");

        return new ResponseEntity<Customer>(customer, HttpStatus.I_AM_A_TEAPOT);

    }

}
