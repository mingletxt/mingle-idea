import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.bson.codecs.ObjectIdGenerator;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午1:14
 * desc
 */
public class Test {
    
    
    public static void main(String[] args) throws ParseException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.subList(0, 5));
        System.out.println(list.subList(5, 10));
        System.out.println(new Date().getTime());
        System.out.println(StringUtils.isNotBlank(""));
    }
}
