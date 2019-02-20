package hdu.hdu_1000_1099.hdu_1075;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> map;

    public static void main(String[] args) {
        scanner.next();

        map = new HashMap<>();

        while (true) {
            String s1 = scanner.next();

            if (s1.equals("END")) {
                break;
            }

            String s2 = scanner.next();

            map.put(s2, s1);
        }


        scanner.nextLine();
        scanner.nextLine();

        while (true) {
            String s = scanner.nextLine();

            if (s.equals("END")) {
                break;
            }

            int i = 0;
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c >= 'a' && c <= 'z') {
                    continue;
                } else {
                    if (i < j) {
                        String s1 = s.substring(i, j);
                        if (map.containsKey(s1)) {
                            sb.append(map.get(s1));
                        } else {
                            sb.append(s1);
                        }
                    }

                    sb.append(s.charAt(j));
                    i = j + 1;
                }
            }

            if (i < s.length()) {
                String s1 = s.substring(i, s.length());
                if (map.containsKey(s1)) {
                    sb.append(map.get(s1));
                } else {
                    sb.append(s1);
                }
            }

            System.out.println(sb);
        }

        scanner.close();
    }
}
