import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // ложим введённый текст в переменную
            String input = scanner.nextLine();

            // делаем выход из проги, чтобы цикл не ругался
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы...");
                break;
            }

            // идём в обработку
            String result = textModifier(input);
            //выводим резултат
            System.out.println(result);
        }
    }

    public static String textModifier(String inputText) {

        //создаём билдер стрингов чтоб сформировать текст
        StringBuilder itogText = new StringBuilder();

        // Выводим что ввели
        //System.out.println("Вы ввели: " + inputText);

        //тапаем в цикл для проверки всех символов
        for (int i = 0; i < inputText.length(); i++) {

            //ну тут без коментариев
            char a = inputText.charAt(i);
            if (a == '+') a = '!';

            try {
                char b = inputText.charAt(i + 1);
                //чекаем на лишние пробелы
                if (a == ' ' && b == ' ') {
                    //System.out.println("Два пробела подряд на позиции: " + i);
                } else if (a == '-') {
                    //если минус то начинаем менять местами
                    if (i > 0) {
                        itogText.deleteCharAt(itogText.length() - 1); //удаляем символ который хотим заменить
                        itogText.append(b); //заменяем его
                        itogText.append(inputText.charAt(i - 1)); //и возвращаем обратно
                        i++; // пропускаем ход, тк следующий символ будет уже тот который нам нужен
                    }
                } else {
                    itogText.append(a);//ничего не нашли, оставляем как есть
                }
            } catch (Exception e) {
                //если б уже за пределами массива
                //System.out.println("Вышли за массив " + e);
                itogText.append(a);
            }
        }


        //возвращаем результат
        return findInt(itogText);
    }

    public static String findInt(StringBuilder inputText) {

        //добавляем число которое выведем в конце
        int сhislo = 0;
        //нужен ли вывод числа в конце
        boolean сhisloNeed = false;

        for (int i = 0; i < inputText.length()-1; i++) {

            //ну тут без коментариев
            char a = inputText.charAt(i);
            //проверка на число
            if (Character.isDigit(a)) {
                //System.out.println("Это число " + a);
                сhislo += (a - '0');
                // System.out.println("Стало " + сhislo);
                сhisloNeed = true;
                inputText.deleteCharAt(i);
            }
        }

        //проверяем надо ли в конце сумму
        if (сhisloNeed) inputText.append(" " + сhislo);
        return String.valueOf(inputText);
    }

}