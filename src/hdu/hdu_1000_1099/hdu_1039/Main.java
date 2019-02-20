package hdu.hdu_1000_1099.hdu_1039;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String s;

    static Set<Character> v = new HashSet<>();

    static {
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');
    }

    public static void main(String[] args) {
        while (true) {
            s = scanner.next();

            if (s.equals("end")) {
                break;
            }

            run();
        }

        scanner.close();
    }

    static void run() {
        boolean m = true;
        int vc = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (v.contains(c)) {
                vc++;
            }

            if (i > 0) {
                if (c == s.charAt(i - 1)) {
                    if (c != 'e' && c != 'o') {
                        m = false;
                        break;
                    }
                }
            }

            if (i > 1) {
                if (v.contains(c) && v.contains(s.charAt(i - 1)) && v.contains(s.charAt(i - 2))) {
                    m = false;
                    break;
                }

                if (!v.contains(c) && !v.contains(s.charAt(i - 1)) && !v.contains(s.charAt(i - 2))) {
                    m = false;
                    break;
                }
            }
        }

        if (vc == 0) {
            m = false;
        }

        if (m) {
            System.out.println(String.format("<%s> is acceptable.", s));
        } else {
            System.out.println(String.format("<%s> is not acceptable.", s));
        }
    }
}
