import org.apache.commons.collections.map.HashedMap;
import org.bson.codecs.ObjectIdGenerator;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午1:14
 * desc
 */
public class Test {
    
    
    public static void main(String[] args) throws ParseException {
        Set<String> set = new HashSet<>();
        Map<String, Object> map = new HashedMap();
        System.out.println(set);
        set.forEach(str -> {
            map.put(str, new Date());
            System.out.println("put");
        });
        System.out.println(map);
    }
}
