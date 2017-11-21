import org.bson.codecs.ObjectIdGenerator;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午1:14
 * desc
 */
public class Test {
    
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println(time);
        System.out.println(sdf.parse(time));
    }
}
