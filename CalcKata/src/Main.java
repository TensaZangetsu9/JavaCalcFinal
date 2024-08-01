import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение");
        String input = scanner.nextLine();

        try {
            String result = calc(input); // Создаем строку result и присваиваем ей значение которое возвращает метод calc
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException userError) {
            System.out.println("Ошибка: " + userError.getMessage());
        }
    }

    public static String calc(String input) { // Принимаем данные от пользователя и разбиваем их на подстроки с помощью split
        String[] tokens = input.split(" ");
        if (tokens.length != 3) { // если больше 3 строк, то выбрасываем исключение
            throw new IllegalArgumentException("Неверный формат выражения. Используйте пробелы между числами и операторами.");
        }

        int a = Integer.parseInt(tokens[0]);
        if (a > 10) {
            throw new IllegalArgumentException("Введите число до 10");
        }
        int b = Integer.parseInt(tokens[2]);
        if (b > 10) {
            throw new IllegalArgumentException("Введите число до 10");
        }

        int result;
        String operation = tokens[1];
        switch (operation) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо.");
                }
                result = a / b;
            }
            default ->
                    throw new IllegalArgumentException("Неподдерживаемая операция. Поддерживаются только +, -, *, /.");
        }
        return Integer.toString(result);
    }


    private static String convertToRoman(int number) {

        return Integer.toString(number);
    }
}
