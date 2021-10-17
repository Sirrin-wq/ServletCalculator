package by.tms.validation;

public class Check {

    public boolean isDouble(String input){
        return input.matches("[-+]?[0-9]{0,10}\\.?[0-9]{1,10}([eE][-+]?[0-9]{1,10})?");
    }

    public boolean isValidOperation(String operation) {
        return operation.equals("sum") || operation.equals("sub") || operation.equals("mul") || operation.equals("div");
    }

}
