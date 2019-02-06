package spring.test.springbootrestapi.services;

import org.springframework.stereotype.Service;
import spring.test.springbootrestapi.models.Budget;

@Service
public class BudgetService {


    public  Object budget(Budget budget){
        return  budget;
    }


}
