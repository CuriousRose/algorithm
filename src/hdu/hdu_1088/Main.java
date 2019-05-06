package hdu.hdu_1088;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuffer line = new StringBuffer();
        String str;
        String hr = "--------------------------------------------------------------------------------";

        while (scanner.hasNext()) {
            str = scanner.next();
            if (str.equals("")) {
                continue;
            }

            if (str.equals("<br>")) {
                System.out.println(line);
                line = new StringBuffer();
                continue;
            }

            if (str.equals("<hr>")) {
                if (line.length() > 0) {
                    System.out.println(line);
                    line = new StringBuffer();
                }
                System.out.println(hr);
                continue;
            }

            if (line.length() + 1 + str.length() > 80) {
                System.out.println(line);
                line = new StringBuffer();
            }

            if (line.length() > 0) {
                line.append(" ").append(str);
            } else {
                line.append(str);
            }
        }

        if (line.length() > 0) {
            System.out.println(line);
        }

        scanner.close();
    }
}