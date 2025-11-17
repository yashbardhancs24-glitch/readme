class Pair<T,U>{
    T a;
    U b;
    Pair(T x,U y){a=x;b=y;}
    T getFirst(){return a;}
    U getSecond(){return b;}
    public static void main(String[] z){
        Pair<String,Integer> c=new Pair<>("Amol",20);
        System.out.println(c.getFirst());
        System.out.println(c.getSecond());
    }
}
