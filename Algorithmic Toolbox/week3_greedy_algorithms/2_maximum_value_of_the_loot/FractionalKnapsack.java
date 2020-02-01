import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

        Item[] items = new Item[values.length];

        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, Collections.reverseOrder()); // sort in descending

        for (Item i : items) {
            double portionOfItemUsed = 1; // use whole item by default
            if (i.getWeight() > capacity) {
                portionOfItemUsed = (double) capacity / i.getWeight(); // only use portion
            }
            capacity -= i.getWeight() * portionOfItemUsed; // new capacity
            value += i.getValue() * portionOfItemUsed; // total value so far
            if (capacity == 0) break;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

    static class Item implements Comparable<Item> {
        int value;

        int weight;

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public double getValuePerWeight() {
            return (double) value / (double) weight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(this.getValuePerWeight(), o.getValuePerWeight());
        }
    }
} 
