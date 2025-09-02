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
            if (c != 'A' && c != 'B' && c != 'C' && c != 'D' && c != 'E' && c != 'F'){
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
            case 'A' -> getAPrice(count);
            case 'B' -> getBPrice(count, skus);
            case 'C' -> 20 * count;
            case 'D' -> 15 * count;
            case 'E' -> 40 * count;
            case 'F' -> getFPrice(count);
            case 'G' -> 20 * count;
            case 'H' -> 15 * count;
            default -> 0;
        };
    }

    private Integer getNumberOfFreeBItems(String skus)  {
        int count = (int) skus.chars().filter(t -> t == 'E').count();
        return count / 2;
    }

    private Integer getCountOfFreeItems(char target, String skus, int divisor) {
        int count = (int) skus.chars().filter(t -> t == target).count();
        return count / divisor;
    }

    private Integer getAPrice(int count) {
        int total = 0;
        if (count >= 5) {
            total += (count / 5) * 200;
            count = count % 5;
        }
        if (count >= 3) {
            total += (count / 3) * 130;
            count = count % 3;
        }
        total += count * 50;
        return total;
    }

    private Integer getBPrice(int count, String skus) {
        int total = 0;
        int free = getCountOfFreeItems('E', skus, 2);
        int payable = count - free;
        if (payable >= 2) {
            total += (payable / 2) * 45;
            payable = payable % 2;
        }
        total += payable * 30;
        return total;
    }

    private Integer getFPrice(int count) {
        int free = 0;
        if (count >= 3) {
            free = (count / 3);
        }
        return (count - free) * 10;
    }

    private Integer getHPrice(int count) {
        int total = 0;
        if (count >= 10) {
            total += (count / 10) * 80;
            count = count % 10;
        }
        if (count >= 5) {
            total += (count / 5) * 45;
            count = count % 5;
        }
        total += count * 10;
        return total;
    }

}