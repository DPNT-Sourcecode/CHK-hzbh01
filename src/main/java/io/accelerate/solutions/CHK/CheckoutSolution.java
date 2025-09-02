package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int sum = 0;
        List<Character> itemsHandled = new ArrayList<>();
        for(char c: skus.toCharArray()){
            if(itemsHandled.contains(c)){
                break;
            }
            long count = skus.chars().filter(t -> t == c).count();
            sum += getSingleItemPrice(c, count);
            itemsHandled.add(c);
        }
        return sum;
    }

    private Integer getSingleItemPrice(char item, long count) {
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






