/**
 * \* Created with IntelliJ IDEA.
 * \* @author: wars
 * \* Date: 1/28/19
 * \* Time: 11:04 PM
 * \* Description:
 * \
 */
public class JScanf {

    public static Object[] scanf(String format, String input) {
        Object[] res = new Object[255];
        int resIndex = 0;
        // Format mode switch
        boolean fm = false;
        // Format bit
        int bit = 0;
        int f_bit = 0;
        // Input index
        int ii = 0;

        // Convert to char array 111111%5d%2s
        char[] fChars = format.toCharArray();

        for (char ic : fChars) {
            // Index char
            if (fm) {
                // Is number, append to format bit
                if (48 <= ic && 57 >= ic) {
                    bit = bit * 10 + ic - '0';
                } else {
                    switch (ic) {
                        case 'd':
                            res[resIndex] = tryParseInt(input.substring(ii, ii += bit));
                            fm = false;
                            resIndex++;
                            break;
                        case 's':
                            res[resIndex] = input.substring(ii, ii += bit);
                            fm = false;
                            resIndex++;
                            break;
                        case 'f':
                            res[resIndex] = tryParseDouble(input.substring(ii, ii += (f_bit + 1 + bit)));
                            fm = false;
                            resIndex++;
                            break;
                        case '.':
                            f_bit = bit;
                            bit = 0;
                            break;
                    }
                }

            } else {
                // Is %, open format mode
                if ('%' == ic) {
                    fm = true;
                    bit = 0;
                    continue;
                } else {
                    res[resIndex] =
                            null == res[resIndex] ? "" : res[resIndex];
                    res[resIndex] = "" + res[resIndex] + ic;
                }
            }
        }
        return res;
    }

    public static Integer tryParseInt(String s) {
        try {
            return new Integer(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double tryParseDouble(String s) {
        try {
            return new Double(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
