package hdu.hdu_1000_1099.hdu_1048;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String value = "VWXYZABCDEFGHIJKLMNOPQRSTU";

    static Map<Character, Character> map;

    public static void main(String[] args) {
        init();

        String s;

        boolean m = false;
        while (true) {
            s = scanner.nextLine();

            if (s.equals("ENDOFINPUT")) {
                break;
            }

            if (s.equals("START")) {
                m = true;
                continue;
            }

            if (s.equals("END")) {
                m = false;
                continue;
            }

            if (m) {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);

                    if (map.containsKey(c)) {
                        System.out.print(map.get(c));
                    } else {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }

        }

        scanner.close();
    }

    static void init() {
        map = new HashMap<>();

        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), value.charAt(i));
        }
    }
}
