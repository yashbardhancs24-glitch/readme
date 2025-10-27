
import java.text.SimpleDateFormat;
import java.util.Date;
interface DateFormatUtility {
    static String format(Date d,String pattern){return new SimpleDateFormat(pattern).format(d);}
}
