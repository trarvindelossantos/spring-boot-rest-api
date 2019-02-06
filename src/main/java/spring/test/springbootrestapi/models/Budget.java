package spring.test.springbootrestapi.models;

public class Budget {

    private String description;
    private Double amount;

    public  Budget(String description, String amount){
        this.description = description;
        this.amount = Double.parseDouble(amount);
    }

    public  String getDescription(){
        return this.description;
    }

    public  Double getAmount(){
        return this.amount;
    }

}
