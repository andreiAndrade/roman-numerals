package coverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class IntegerToRomanConverter {

    private static Map<Integer, String> integerToRomanMap = new HashMap<>() {
        {
            put(0, "");
            put(1, "I");
            put(2, "II");
            put(3, "III");
            put(4, "IV");
            put(5, "V");
            put(6, "VI");
            put(7, "VII");
            put(8, "VIII");
            put(9, "IX");
            put(10, "X");
            put(20, "XX");
            put(30, "XXX");
            put(40, "XL");
            put(50, "L");
            put(60, "LX");
            put(70, "LXX");
            put(80, "LXXX");
            put(90, "XC");
            put(100, "C");
            put(200, "CC");
            put(300, "CCC");
            put(400, "CD");
            put(500, "D");
            put(600, "DC");
            put(700, "DCC");
            put(800, "DCCC");
            put(900, "CM");
            put(1000, "M");
            put(2000, "MM");
            put(3000, "MMM");
        }
    };

    public static String convert(String decimalNumber) {
        try {
            return convert(Integer.parseInt(decimalNumber));
        } catch (NumberFormatException | NullPointerException nfe) {
            throw new IllegalArgumentException("O valor informado não corresponde a um número inteiro na escala decimal!");
        }
    }

    public static String convert(Integer integerNumber) {

        AtomicReference<String> romanNumeral = new AtomicReference<>("");

        if (integerNumber >= 4000) {
            throw new IllegalArgumentException("Valor muito alto e não pode ser convertido em números romanos");
        }

        AtomicReference<Integer> multiplier = new AtomicReference<>(1);

        Arrays.stream(integerNumber.toString().split("")).collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(number -> {
                    romanNumeral.set(integerToRomanMap.get(Integer.parseInt(number) * multiplier.get()) + romanNumeral.get());
                    multiplier.updateAndGet(v -> v * 10);
                });

        return romanNumeral.toString();
    }
}
