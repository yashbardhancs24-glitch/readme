class Box<T>{
    T a;
    void set(T b){a=b;}
    T get(){return a;}
    public static void main(String[] x){
        Box<Integer> p=new Box<>();
        p.set(10);
        System.out.println(p.get());
        Box<String> q=new Box<>();
        q.set("hi");
        System.out.println(q.get());
        Box<Double> r=new Box<>();
        r.set(2.5);
        System.out.println(r.get());
    }
}
