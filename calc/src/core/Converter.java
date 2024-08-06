package core;

public class Converter {

    static String[] romanNumbers = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static boolean isRoman(String input) {
        for (String romanNumber : romanNumbers) {
            if (input.equals(romanNumber)) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String romanInput) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (romanInput.equals(romanNumbers[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanNumbers[arabian];
    }
}
