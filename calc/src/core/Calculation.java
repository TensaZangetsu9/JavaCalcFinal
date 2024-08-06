package core;

public class Calculation {

    public static String calc(String input) {

        // Принимаем данные от пользователя и разбиваем их на подстроки с помощью split
        String[] tokens = input.split(" ");

        // если число элементов в массиве не равно 3, то выбрасываем исключение
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения. Используйте пробелы между числами и операторами.");
        }

        int a;
        int b;
        boolean isRoman;
        if ((Converter.isRoman(tokens[0]) && Converter.isRoman(tokens[2]))) {
            a = Converter.convertToArabian(tokens[0]);
            b = Converter.convertToArabian(tokens[2]);
            isRoman = true;
        } else {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
            isRoman = false;
        }

        if ((a > 10) || (b > 10) || (a <= 0) || (b <= 0)) {
            throw new IllegalArgumentException("Введите число от 0 до 10");
        }

        String operation = tokens[1];

        int result = switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default ->
                    throw new IllegalArgumentException("Неподдерживаемая операция. Поддерживаются только +, -, *, /.");
        };

        if (isRoman) {
            if (result <= 0) {
                throw new IllegalArgumentException("Результатом операции римскими числами не может быть это число");
            }
            return Converter.convertToRoman(result);
        }
        return Integer.toString(result);
    }
}