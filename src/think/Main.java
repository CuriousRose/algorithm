package think;

public class Main {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 212;
        Integer c = 213;
        Integer d = 213;
        Integer e = 321;
        Integer f = 321;
        Long g = 213L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
