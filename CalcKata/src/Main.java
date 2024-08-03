import java.util.Scanner;

public class Main {
    // не забывай про отступы
    public static void main(String[] args) {
        //добавил цикл, посмотри как теперь программа работает :) НО! это только на время тестирования и отладки, потом надо убрать будет
        while (true) {
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
    }

    //TODO вынести этот функционал в отдельный класс
    public static String calc(String input) { // Принимаем данные от пользователя и разбиваем их на подстроки с помощью split
        String[] tokens = input.split(" ");
        if (tokens.length != 3) { // если число элементов в массиве не равно 3, то выбрасываем исключение
            throw new IllegalArgumentException("Неверный формат выражения. Используйте пробелы между числами и операторами.");
        }

        int a = Integer.parseInt(tokens[0]);

        //TODO проверки объединить в одну, подсказка - &&
        if (a > 10) {
            throw new IllegalArgumentException("Введите число до 10");
        }
        int b = Integer.parseInt(tokens[2]);
        if (b > 10) {
            throw new IllegalArgumentException("Введите число до 10");
        }

        String operation = tokens[1];

        //так думаю будет красивее, создаем переменную и сразу в нее записываем результат свитча
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


    //TODO converter тоже в отдельный класс
    private static String convertToRoman(int number) {

        return Integer.toString(number);
    }
}
