package io.accelerate.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int sum = 0;
        switch(skus) {
            case "A" : sum += 50;
            break;
            case "B" : sum += 30;
            break;
            case "C" : sum += 20;
            break;
            case "D" : sum += 15;
        }
        return sum;
    }

    private Integer getSingleItemPrice() 
}


// receive items as string ? multiple items ? how seperated ?
// assuming skus is a lsit of



