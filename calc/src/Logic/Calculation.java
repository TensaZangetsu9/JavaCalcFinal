package Logic;
import static Logic.Converter.isRoman;
public class Calculation {

    public static String calc(String input) { // Принимаем данные от пользователя и разбиваем их на подстроки с помощью split
        String[] tokens = input.split(" ");
        if (tokens.length != 3) { // если число элементов в массиве не равно 3, то выбрасываем исключение
            throw new IllegalArgumentException("Неверный формат выражения. Используйте пробелы между числами и операторами.");
        }
        boolean isRoman;
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[2]);
        if (Converter.isRoman(tokens[0]) && !Converter.isRoman(tokens[2])){

        }
        if ((a > 10) | (b > 10)) {
            throw new IllegalArgumentException("Введите число до 10");
        }

        String operation = tokens[1];

        int result = switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо.");
                }
                yield a / b;
            }
            default ->
                    throw new IllegalArgumentException("Неподдерживаемая операция. Поддерживаются только +, -, *, /.");
        };
        return Integer.toString(result);
    }
}
