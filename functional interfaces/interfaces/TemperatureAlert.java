
import java.util.function.Predicate;
class TemperatureAlert {
    Predicate<Double> p = t -> t>50;
    void check(double a){if(p.test(a)) System.out.println("Alert"); else System.out.println("Normal");}
}
