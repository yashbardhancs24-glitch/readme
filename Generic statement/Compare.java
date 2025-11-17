class Compare{
    static <T> boolean isEqual(T a,T b){
        return a.equals(b);
    }
    public static void main(String[] x){
        System.out.println(isEqual(5,5));
        System.out.println(isEqual("a","b"));
    }
}
