package hdu.hdu_1000_1099.hdu_1073;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final String START = "START";
    static final String END = "END";

    static StringBuffer input;
    static StringBuffer output;


    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            input = new StringBuffer();
            output = new StringBuffer();

            int l1 = 0;
            int l2 = 0;

            scanner.nextLine();

            while (true) {
                String line = scanner.nextLine();
                if (line.equals(END)) {
                    break;
                }

                input.append(line);
                l1++;
            }

            scanner.nextLine();

            while (true) {
                String line = scanner.nextLine();
                if (line.equals(END)) {
                    break;
                }

                output.append(line);
                l2++;
            }

            if (input.toString().equals(output.toString()) && l1 == l2) {
                System.out.println("Accepted");
                continue;
            }

            String inputStr = input.toString()
                    .replace(" ", "")
                    .replace("\t", "")
                    .replace("\n", "");
            String outputStr = output.toString()
                    .replace(" ", "")
                    .replace("\t", "")
                    .replace("\n", "");

            if (inputStr.equals(outputStr)) {
                System.out.println("Presentation Error");
                continue;
            }

            System.out.println("Wrong Answer");
        }

        scanner.close();
    }
}
