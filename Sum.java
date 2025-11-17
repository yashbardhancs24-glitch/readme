import java.util.*;
class Sum{
    static double sumNumbers(List<? extends Number> a){
        double b=0;
        for(Number x:a)b+=x.doubleValue();
        return b;
    }
    public static void main(String[] y){
        List<Integer> p=Arrays.asList(1,2,3);
        List<Double> q=Arrays.asList(1.5,2.5,3.5);
        System.out.println(sumNumbers(p));
        System.out.println(sumNumbers(q));
    }
}
