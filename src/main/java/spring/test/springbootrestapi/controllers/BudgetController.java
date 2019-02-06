package spring.test.springbootrestapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.test.springbootrestapi.models.Budget;
import spring.test.springbootrestapi.services.BudgetService;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "http://10.0.16.239:3000")
public class BudgetController {


    RestTemplate template = new RestTemplate();
    @Autowired
    BudgetService bService;

    /*
        POST REQUEST

    */
    @RequestMapping(value = "/budgets", method = POST)
    public  Object store(@RequestBody Budget budget){
        Object result = template.postForObject("http://10.0.16.239:4000/budgets/",bService.budget(budget), Object.class);
        return  result;
    }

    /*
        GET REQUEST

    */
    @RequestMapping(value = "/budgets", method = GET)
    public Object index(){
        Object result = template.getForObject("http://10.0.16.239:4000/budgets/", Object.class);
        return result;
    }

    /*
        GET REQUEST

    */
    @RequestMapping(value = "/budgets/{id}", method = GET)
    public Object show(@PathVariable String id ){
        Object result = template.getForObject("http://10.0.16.239:4000/budgets/" + id, Object.class);
        return result;
    }


    /*
        PUT REQUEST

    */
    @RequestMapping(value = "/budgets/{id}", method = PUT)
    public Object update(@PathVariable String id, @RequestBody Budget budget){
        template.put("http://10.0.16.239:4000/budgets/" + id, bService.budget(budget));
        Object result = template.getForObject("http://10.0.16.239:4000/budgets/" + id, Object.class);
        return result;
    }

    /*
        DELETE REQUEST

    */
    @RequestMapping(value = "/budgets/{id}", method = DELETE)
    public  Boolean delete(@PathVariable String id) {
        template.delete("http://10.0.16.239:4000/budgets/" + id);
        return true;
    }


}
