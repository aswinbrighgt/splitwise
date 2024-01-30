package Splitwise.Controllers;

import Splitwise.Services.ExpenceServices;

public class ExpenceController {
    private ExpenceServices expenceServices;

    public ExpenceController(ExpenceServices expenceServices) {
        this.expenceServices = expenceServices;
    }

    public void createExpense(String input){
        expenceServices.createExpense(input);
    }
}
