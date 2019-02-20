package hdu.hdu_1000_1099.hdu_1004;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求最多出现
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int total;

        while ((total = Integer.parseInt(scanner.nextLine())) != 0) {
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < total; i++) {
                String color = scanner.nextLine();
                if (map.containsKey(color)) {
                    map.put(color, map.get(color) + 1);
                } else {
                    map.put(color, 1);
                }
            }

            String maxColor = "";
            int max = -1;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String color = entry.getKey();
                int count = entry.getValue();

                if (count > max) {
                    maxColor = color;
                    max = count;
                }
            }

            System.out.println(maxColor);
        }

        scanner.close();
    }
}
