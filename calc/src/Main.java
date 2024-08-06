import java.util.Scanner;

import static core.Calculation.calc;

public class Main {

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
}
