/**
 * \* Created with IntelliJ IDEA.
 * \* @author: wars
 * \* Date: 1/28/19
 * \* Time: 11:05 PM
 * \* Description:
 * \
 */
public class Main {

    public static void main(String[] args) {
        Object[] res = JScanf.scanf("%5d%1s%2.1f", " 23456 2.0");
        Integer a;
        String b;
        Double c;
        a = (Integer) res[0];
        b = (String) res[1];
        c = (Double) res[2];
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
