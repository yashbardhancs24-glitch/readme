class Max{
    static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T a=x;
        if(y.compareTo(a)>0)a=y;
        if(z.compareTo(a)>0)a=z;
        return a;
    }
    public static void main(String[] p){
        System.out.println(maximum(3,9,7));
        System.out.println(maximum("a","z","m"));
    }
}
