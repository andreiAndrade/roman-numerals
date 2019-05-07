package coverter;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {

    private static Map<Character, Integer> romanToIntegerMap = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int convert(String romanNumber) {
        // Initialize result
        int decimalValue = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = romanToIntegerMap.getOrDefault(romanNumber.charAt(i), 0);

            // Getting value of symbol s[i+1]
            if (i + 1 < romanNumber.length()) {
                int s2 = romanToIntegerMap.getOrDefault(romanNumber.charAt(i + 1), 0);

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    decimalValue = decimalValue + s1;
                } else {
                    decimalValue = decimalValue + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            } else {
                decimalValue = decimalValue + s1;
                i++;
            }
        }

        return decimalValue;
    }
}
