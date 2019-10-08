
package roman;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class RomanNumber extends Number {

    public static final long serialVersionUID = 1L;

    // Table des symboles
    private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
    static {
        SYMBOLS.put("M", 1000);
        SYMBOLS.put("CM", 900);
        SYMBOLS.put("D", 500);
        SYMBOLS.put("CD", 400);
        SYMBOLS.put("C", 100);
        SYMBOLS.put("XC", 90);
        SYMBOLS.put("L", 50);
        SYMBOLS.put("XL", 40);
        SYMBOLS.put("X", 10);
        SYMBOLS.put("IX", 9);
        SYMBOLS.put("V", 5);
        SYMBOLS.put("IV", 4);
        SYMBOLS.put("I", 1);
    }

    // Expression reguliere de validation
    private static final Pattern VALIDATION_RE = Pattern
            .compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    private final int value;

    public RomanNumber(String romanValue) {
        this.value = fromRoman(romanValue);
    }

    public RomanNumber(int value) {
        this.value = value;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public double doubleValue() {
        // TODO
        return 0;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public float floatValue() {
        // TODO
        return 0;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public int intValue() {
        // TODO
        return 0;
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public long longValue() {
        // TODO
        return 0;
    }

    @Override
    public String toString() {
        return toRoman(this.value);
    }

    public static RomanNumber valueOf(String roman) {
        return new RomanNumber(roman);
    }

    public static RomanNumber valueOf(int value) {
        return new RomanNumber(value);
    }

    private static int fromRoman(String romanValue) {
        if (!isUpperCase(romanValue))
            throw new IllegalArgumentException("Pas de minuscule bro");

        if (!romanValue.matches(VALIDATION_RE.pattern()))
            throw new IllegalArgumentException("regex invalide");
        if (romanValue.isEmpty())
            return 0;
        if (romanValue.startsWith("M"))
            return 1000 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("CM"))
            return 900 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("D"))
            return 500 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("CD"))
            return 400 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("C"))
            return 100 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("XC"))
            return 90 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("L"))
            return 50 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("XL"))
            return 40 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("X"))
            return 10 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("IX"))
            return 9 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("V"))
            return 5 + fromRoman(romanValue.substring(1));
        if (romanValue.startsWith("IV"))
            return 4 + fromRoman(romanValue.substring(2));
        if (romanValue.startsWith("I"))
            return 1 + fromRoman(romanValue.substring(1));
        throw new IllegalArgumentException("something bad happened");
    }

    private static String toRoman(int value) {
        if(value > 3999){
            throw new IllegalArgumentException("Pas au dessus de 3999");
        }
        
        Map<Integer, String> tab = new HashMap<Integer, String>();
        tab.put(1, "I");
        tab.put(4, "IV");
        tab.put(5, "V");
        tab.put(9, "IX");
        tab.put(10, "X");
        tab.put(40, "XL");
        tab.put(50, "L");
        tab.put(90, "XC");
        tab.put(100, "C");
        tab.put(400, "CD");
        tab.put(500, "D");
        tab.put(900, "CM");
        tab.put(1000, "M");

        String res = "";
        for (java.util.Map.Entry<Integer, String> entry : tab.entrySet()) {
            while (value >= entry.getKey()) {
                res += tab.get(entry.getKey());
                value -= entry.getKey();
            }

        }
        return res;
    }

    // Function to convert decimal to Roman Numerals
String printRoman(int n) 
{ 
    
    Map<Integer, String> tab = new HashMap<Integer,String>();
    tab.put(1, "I");
    tab.put(4, "IV");
    tab.put(5, "V");
    tab.put(9, "IX");
    tab.put(10, "X");
    tab.put(40, "XL");
    tab.put(50, "L");
    tab.put(90, "XC");
    tab.put(100, "C");
    tab.put(400, "CD");
    tab.put(500, "D");
    tab.put(900, "CM");
    tab.put(1000, "M");

    String res = "";
    for (java.util.Map.Entry<Integer,String> entry : tab.entrySet()) {
        while (n >= entry.getKey()){
            res += tab.get(entry.getKey());
            n-= entry.getKey();
        }

    }
    return res;

    } 


    private static boolean isUpperCase(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
