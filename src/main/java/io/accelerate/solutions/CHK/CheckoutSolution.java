package io.accelerate.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int sum = 0;
        for(char c: skus.toCharArray()){
            int count = skus.chars().filter(t -> t == c).count();
            sum += getSingleItemPrice(c);
        }
        return sum;
    }

    private Integer getSingleItemPrice(char item, int count) {
        return switch (item) {
            case 'A' -> 50;
            case 'B' -> 30;
            case 'C' -> 20;
            case 'D' -> 15;
            default -> 0;
        };
    }
}


// receive items as string ? multiple items ? how seperated ?
// assuming skus is a lsit of





