package hdu.hdu_1084;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n == -1) {
                return;
            }

            List<Student> students = new ArrayList<>();

            int p;
            String t;
            for (int i = 0; i < n; i++) {
                p = scanner.nextInt();
                t = scanner.next();
                students.add(new Student(i, p, t));
            }

            students.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.problem == o2.problem) {
                        return o1.time.compareTo(o2.time);
                    } else {
                        return o2.problem - o1.problem;
                    }
                }
            });

            int i = 0;
            int j = 0;

            while (j++ < n) {
                if (j == n || students.get(i).problem != students.get(j).problem) {
                    int problem = students.get(i).problem;

                    if (problem == 5) {
                        for (int k = i; k < j; k++) {
                            students.get(k).score = 100;
                        }
                    } else if (problem == 0) {
                        for (int k = i; k < j; k++) {
                            students.get(k).score = 50;
                        }
                    } else {
                        int mid = (i + j) / 2;
                        for (int k = i; k < mid; k++) {
                            students.get(k).score = problem * 10 + 50 + 5;
                        }
                        for (int k = mid; k < j; k++) {
                            students.get(k).score = problem * 10 + 50;
                        }
                    }

                    i = j;
                }
            }

            students.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.number - o2.number;
                }
            });

            for (Student student : students) {
                System.out.println(student.score);
            }

            System.out.println();
        }

        scanner.close();
    }

    static class Student {
        int number;
        int problem;
        String time;
        int score;

        Student(int number, int problem, String time) {
            this.number = number;
            this.problem = problem;
            this.time = time;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Student{");
            sb.append("number=").append(number);
            sb.append(", problem=").append(problem);
            sb.append(", time='").append(time).append('\'');
            sb.append(", score=").append(score);
            sb.append('}');
            return sb.toString();
        }
    }
}
