//У Пети 10 яблок, у Васи X яблок. Всего 15 яблок. Пункты выполнять по порядку, модифицируя предыдущий. Написать программу, которая:
//        1. В методе main считает и выводит результат;
//        2. В отдельном методе int calculate() считает значение и возвращает его в метод main (а там печатает);
//        3. В отдельном методе void print(int apples) печатает результат. В этом случае метод main вызывает методы calculate и print;
//        4. Объявить 10 яблок и 15 яблок (Япетя и Явсего) в области видимости всего класса как переменные applesPete и applesTotal.
//        Заменить все цифры (10 и 15) в методе calculate на переменные, объявленные в классе;
//        5. Изменить метод int calculate() на int calculate(applesPete, applesTotal). Переменные из класса перенести в метод main.

//public class Part1 {


//    public static void main(String[] args) {
//        int applesPete=10;
//        int applesTotal=15;
//        print(calculate(applesTotal,applesPete));
//
//        }
//
//    private static void print(int apples) {
//        System.out.println("У Васи было "+apples+" яблок");
//    }
//
//    public static int calculate(int total, int pete) {
//        int result=total-pete;
//        return result;
//    }
//
//}
