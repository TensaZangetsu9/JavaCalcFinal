package Logic;

public class Converter {
    static String[] romanNumbers = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isRoman(String input) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (input.equals(romanNumbers[i])) {
                return true;
            }
        }
        return false;

    }
}
    

