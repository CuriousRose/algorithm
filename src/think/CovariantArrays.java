package think;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        try {
            fruits[2] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fruits[3] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        List<Fruit> list = new ArrayList<Apple>();

        List<? extends Fruit> list = new ArrayList<Apple>();
//        List<? extends Fruit> list = new ArrayList<>();
//        list.add(new Apple());
//        list.add(new Fruit());
        list.add(null);
//        Apple apple = list.get(0);
        Fruit fruit = list.get(0);

        list = Arrays.asList(new Apple());
        Apple apple = (Apple) list.get(0);

        List<? super Apple> apples = new ArrayList<Fruit>();
//        List<? super Apple> apples = new ArrayList<Jonathan>();
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}