package hdu.hdu_1082;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Map<String, Matrix> matrixMap;
    static int n;

    public static void main(String[] args) {
        n = scanner.nextInt();
        matrixMap = new HashMap<>();

        String key;
        int height;
        int width;
        for (int i = 0; i < n; i++) {
            key = scanner.next();
            height = scanner.nextInt();
            width = scanner.nextInt();

            matrixMap.put(key, new Matrix(key, height, width));
        }

        scanner.nextLine();

        String expression;
        while (scanner.hasNextLine()) {
            expression = scanner.nextLine();
            run(expression);
        }

        scanner.close();
    }

    static void run(String expression) {
        int sum = 0;
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            String pushStr = String.valueOf(expression.charAt(i));
            if (pushStr.equals(")")) {
                Matrix matrix1 = null, matrix2 = null;
                String popStr = linkedList.pop();

                while (!popStr.equals("(")) {
                    if (matrix2 == null) {
                        matrix2 = matrixMap.get(popStr);
                    } else {
                        matrix1 = matrixMap.get(popStr);
                    }
                    popStr = linkedList.pop();
                }

                if (matrix1.width != matrix2.height) {
                    System.out.println("error");
                    return;
                }

                sum += matrix1.height * matrix1.width * matrix2.width;

                Matrix matrix = new Matrix(matrix1.name + matrix2.name, matrix1.height, matrix2.width);
                matrixMap.put(matrix.name, matrix);

                linkedList.push(matrix.name);
            } else {
                linkedList.push(pushStr);
            }
        }

        System.out.println(sum);
    }

    static class Matrix {
        String name;
        int height;
        int width;

        Matrix(String name, int height, int width) {
            this.name = name;
            this.height = height;
            this.width = width;
        }
    }
}
