package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int sum = 0;
        List<Character> itemsHandled = new ArrayList<>();

        if (skus == null) {
            return -1;
        }

        for(char c: skus.toCharArray()){
            if (c != 'A' && c != 'B' && c != 'C' && c != 'D' && c != 'E'){
                return -1;
            }
        }

        for(char c: skus.toCharArray()){
            if(itemsHandled.contains(c)){
                continue;
            }
            long count = skus.chars().filter(t -> t == c).count();
            sum += getItemsPrice(c, (int) count, skus);
            itemsHandled.add(c);
        }
        return sum;
    }

    private Integer getItemsPrice(char item, int count, String skus) {
        return switch (item) {
            case 'A' -> {
                if (count >= 3) {
                    int remain = count % 3;
                    int discounted = count / 3;
                    yield discounted * 130 + remain * 50;
                }
                yield 50 * count;
            }
            case 'B' -> {
                int free = getNumberOfFreeBItems('E', skus);
                if (count >= 2) {
                    int remain = count % 2;
                    int discounted = count / 2;
                    yield discounted * 45 + remain * 30 - (free * 30);
                }
                yield 30 * count - (free * 30);
            }
            case 'C' -> 20 * count;
            case 'D' -> 15 * count;
            case 'E' -> 40 * count;
            default -> 0;
        };
    }

    private Integer getNumberOfFreeBItems(char item, String skus)  {
        int count = (int) skus.chars().filter(t -> t == item).count();
        return count / 2;
    }

}