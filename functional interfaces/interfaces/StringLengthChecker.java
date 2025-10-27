
import java.util.function.Function;
class StringLengthChecker {
    Function<String,Integer> f = s -> s.length();
    void check(String a,int limit){if(f.apply(a)>limit) System.out.println("Too Long"); else System.out.println("OK");}
}
