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
            if (c < 'A' || c > 'Z') {
                return -1;
            }
        }

        StringBuilder skusBuilder = new StringBuilder(skus);
        sum += getBundledItemsPrice(skusBuilder);
        skus = skusBuilder.toString();

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

    private Integer getBundledItemsPrice(StringBuilder skus) {
        List<Character> groupOrder = new ArrayList<>(List.of('Z', 'S', 'T', 'Y', 'X'));
        int totBundledItems = 0;
        for(char target: groupOrder) {
            totBundledItems += (int) skus.chars().filter(t -> t == target).count();
        }
        int groupLength =  totBundledItems / 3;
        int toConsume = groupLength * 3;

        int count = 0;
        while (count < toConsume && !groupOrder.isEmpty()) {
            int idx = skus.indexOf(groupOrder.getFirst().toString());
            if(idx >= 0) {
                skus.deleteCharAt(idx);
                count++;
            } else {
                groupOrder.removeFirst();
            }
        }
        return groupLength * 45;
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
            case 'H' -> getHPrice(count);
            case 'I' -> 35 * count;
            case 'J' -> 60 * count;
            case 'K' -> getKPrice(count);
            case 'L' -> 90 * count;
            case 'M' -> getMPrice(count, skus);
            case 'N' -> 40 * count;
            case 'O' -> 10 * count;
            case 'P' -> getPPrice(count);
            case 'Q' -> getQPrice(count, skus);
            case 'R' -> 50 * count;
            case 'S' -> 20 * count;
            case 'T' -> 20 * count;
            case 'U' -> getUPrice(count);
            case 'V' -> getVPrice(count);
            case 'W' -> 20 * count;
            case 'X' -> 17 * count;
            case 'Y' -> 20 * count;
            case 'Z' -> 21 * count;
            default -> 0;
        };
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

    private Integer getKPrice(int count) {
        int total = 0;
        if (count >= 2) {
            total += (count / 2) * 120;
            count = count % 2;
        }
        total += count * 70;
        return total;
    }

    private Integer getMPrice(int count, String skus) {
        int free = getCountOfFreeItems('N', skus, 3);
        int payable = count - free;
        return payable * 15;
    }

    private Integer getPPrice(int count) {
        int total = 0;
        if (count >= 5) {
            total += (count / 5) * 200;
            count = count % 5;
        }
        total += count * 50;
        return total;
    }

    private Integer getQPrice(int count, String skus) {
        int total = 0;
        int free = getCountOfFreeItems('R', skus, 3);
        int payable = count - free;
        if (payable >= 3) {
            total += (payable / 3) * 80;
            payable = payable % 3;
        }
        total += payable * 30;
        return total;
    }

    private Integer getUPrice(int count) {
        int free = 0;
        if (count >= 4) {
            free = (count / 4);
        }
        return (count - free) * 40;
    }

    private Integer getVPrice(int count) {
        int total = 0;
        if (count >= 3) {
            total += (count / 3) * 130;
            count = count % 3;
        }
        if (count == 2) {
            total += (count / 2) * 90;
            count = 0;
        }
        total += count * 50;
        return total;
    }

}