import java.util.*;
class Fruit{}
class Apple extends Fruit{}
class Mango extends Fruit{}
class FruitBox<T extends Fruit>{
    ArrayList<T> a=new ArrayList<>();
    void add(T x){a.add(x);}
    void show(){for(T y:a)System.out.println(y.getClass().getSimpleName());}
    public static void main(String[] z){
        FruitBox<Apple> b=new FruitBox<>();
        b.add(new Apple());
        b.add(new Apple());
        b.show();
    }
}
