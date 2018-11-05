import java.util.Arrays;
import java.util.Scanner;

public class Part2 {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("1)массив из нечетных чисел от 1 до 99. Вывести в строку, вывести в обратном порядке" + "\n" +
                "2)массив из 15 случайных чисел (0;9). Вывести на экран, посчитать кол-во чётных" + "\n" +
                "3)массив из 8 случайных чисел (1;10). Вывести на экран, заменить элементы с нечётными индексами на 0, повторный вывод" + "\n" +
                "4)2 массива по 5 случайных чисел (0;5). Вывести на экран, найти среднее арифметическое элементов каждого, у какого массива оно больше" + "\n" +
                "5)массив из 4 случайных чисел (10;99). Вывести на экран, является ли массив строго возрастающей последовательностью" + "\n" +
                "6)20 первых чисел Фибоначчи. Вывести на экран" + "\n" +
                "7)массив из 12 случайных чисел (-15;15). Найти максимальный элемент и индекс его последнего вхождения" + "\n" +
                "8)2 массива из 10 случайных чисел (1;9), третий массив: каждый его элемент = отношению i-го элемента 1 массива к i-ому элементу 2 массива. вывод всех массивов. Количество целых элементов 3-го массива" + "\n" +
                "9)массив из 11 случайных чисел (-1;1). Вывести на экран, какое число встречается чаще" + "\n" +
                "10)Пользователь вводит чётное число N, создаётся массив с размером N из (-5;5). Вывести на экран, найти сумму модулей левой/правой частей, какая из них больше" + "\n" +
                "11)массив из 12 случайных чисел (-10;10). Отрицательных и положительных долно быть поровну и не долэно быть нулей + случайный порядок следования элементов" + "\n" +
                "12)Пользователь вводит число больше 3 в переменнцю N. Создаётся массив длинной N (0;N). Вывести на экран, создать второй массив из чётных элементов первого." + "\n" +
                "13)Создать массив из чётных элементов от 2 до 20. Вывести в строку и столбик");

        int choice;
        while (true){
            choice=getNumber(scanner, "ВЫБЕРИТЕ НОМЕР ЗАДАНИЯ");
            if (choice>0 && choice<=13) {
                break;
            }
        }
        switch (choice){
            case 1:
                Task1();
                break;
            case 2:
                Task2();
                break;
            case 3:
                Task3();
                break;
            case 4:
                Task4();
                break;
            case 5:
                System.out.println(Task5());
                break;
            case 6:
                Task6();
                break;
            case 7:
                Task7();
                break;
            case 8:
                Task8();
                break;
            case 9:
                Task9();
                break;
            case 10:
                Task10();
                break;
            case 11:
                Task11();
                break;
            case 12:
                Task12();
                break;
            case 13:
                Task13();
                break;
            default: break;
        }
    }





//создание массивов случайных чисел для всех заданий, с вариантами наличия элементов меньше нуля и буз таковых
    static int[] getMassive(int n, int min, int max, boolean overZero) {
        int[] array= new int[n];
        min=Math.abs(min);
        int diap=min+max;
        if (overZero) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int)Math.abs(Math.round((Math.random() * diap - min)));
                if(array[i]<min){
                    array[i]=min;
                }
            }
        }else{
            for (int i = 0; i < array.length; i++) {
                array[i] = (int)(Math.round((Math.random() * diap - min)));
            }
        }
        return array;
    }

//получение числа с клавиатуры от пользователя с проверкой на ИНТовое значение.
//проверка на диапозон значений осуществляется в каждом методе задания индивидуально.
    public static int getNumber(Scanner scanner, String msg){
        int number;
            System.out.println(msg);
            while (!scanner.hasNextInt()) {
                System.out.println(msg);
                scanner.next();
            }
            number = scanner.nextInt();
        return number;
    }



    //массив из нечетных чисел от 1 до 99. Вывести в строку, вывести в обратном порядке
    static void Task1(){
        int[]arr1=new int[50];
        int boost=1;
        for (int i = 0; i < arr1.length ; i++) {
            arr1[i]+=boost;
            boost+=2;
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        for (int i = arr1.length-1; i>=0; i--) {
            System.out.print(arr1[i]+" ");
        }

    }


    //массив из 15 случайных чисел (0;9). Вывести на экран, посчитать кол-во чётных
    static void Task2(){
        int count=0;
        int[] arr2 = getMassive(15,0,9,true);

        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i <arr2.length ; i++) {
            if (arr2[i]%2==0){
                count++;
            }
        }
        System.out.println("Количество четных чисел: "+count);
    }


    //массив из 8 случайных чисел (1;10). Вывести на экран,
    // заменить элементы с нечётными индексами на 0, повторный вывод
    static void Task3(){
        int[] arr3 = getMassive(8,1,10, true);
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (i%2!=0){
                arr3[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }


    //2 массива по 5 случайных чисел (0;5). Вывести на экран,
    // найти среднее арифметическое элементов каждого, у какого массива оно больше
    static void Task4(){
        double srArr4;
        double srArr4V2;
        double sumArr4=0;
        double sumArr4V2=0;
        int[] arr4 = getMassive(5,0,5,true);
        int[] arr4V2 = getMassive(5,0,5,true);
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr4V2));
        for (int i = 0; i <arr4.length ; i++) {
            sumArr4+=arr4[i];
        }
        srArr4=sumArr4/arr4.length;

        for (int i = 0; i <arr4V2.length ; i++) {
            sumArr4V2+=arr4V2[i];
        }
        srArr4V2=sumArr4V2/arr4.length;

        if (srArr4>srArr4V2){
            System.out.println("среднее арифметическое у первого массива ("+srArr4+") больше чем у второго ("+srArr4V2+")");
        }else if(srArr4<srArr4V2){
            System.out.println("среднее арифметическое у первого массива ("+srArr4+") меньше чем у второго ("+srArr4V2+")");
        }else {
            System.out.println("Средние арифметические двух массивов равны ("+srArr4+", "+srArr4V2+")");
        }

    }


    //массив из 4 случайных чисел (10;99). Вывести на экран,
    // является ли массив строго возрастающей последовательностью
    static String Task5(){
        int[] arr5=getMassive(4,10,99,true);
        System.out.println(Arrays.toString(arr5));
        for (int i = 0; i <arr5.length-1 ; i++) {
            if (arr5[i]>arr5[i+1]){
                return "массив не является строго возрастающей последовательностью";
            }
        }
        return "массив строго возрастающая последовательность";
    }


    //20 первых чисел Фибоначчи. Вывести на экран
    static void Task6(){
        int[] arr6=new int[20];
        for (int i = 0; i <arr6.length ; i++) {
            if (i<2){
                arr6[i]=1;
            }else{
                arr6[i]=arr6[i-1]+arr6[i-2];
            }
        }
        System.out.println(Arrays.toString(arr6));
    }


    //массив из 12 случайных чисел (-15;15). Найти максимальный элемент и индекс его последнего вхождения
    static void Task7(){
        int[] arr7=getMassive(12,-15,15,false);
        int max=arr7[0];
        int indMax=0;
        System.out.println(Arrays.toString(arr7));
        for (int i = 1; i <arr7.length ; i++) {
            if(arr7[i]>=max){
                max=arr7[i];
                indMax=i;
            }
        }
        System.out.println("максимальный элемент массива: "+max+". Индекс последнего вхождения: "+indMax);
    }


    //2 массива из 10 случайных чисел (1;9), третий массив:
    // каждый его элемент = отношению i-го элемента 1 массива к i-ому элементу 2 массива.
    // вывод всех массивов
    // определить количество целых элементов 3-го массива
    static void Task8(){
        int count=0;
        int[] arr8=getMassive(10,1,9,true);
        int[] arr8V2=getMassive(10,1,9,true);
        double[] arr8RES=new double[10];
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.toString(arr8V2));

        for (int i = 0; i <arr8.length ; i++) {
            arr8RES[i]=(double)arr8[i]/(double)arr8V2[i];
        }
        System.out.println(Arrays.toString(arr8RES));

        for (int i = 0; i <arr8RES.length ; i++) {
            if(arr8RES[i]-(int)arr8RES[i]==0){
                count++;
            }
        }
        System.out.println("количестов целых чисел в третьем массиве равно: "+count);
    }


    //массив из 11 случайных чисел (-1;1). Вывести на экра, какое число встречается чаще
    static void Task9(){
        int zero=0;
        int one=0;
        int minusOne=0;
        int[] arr9=getMassive(11,-1,1,false);
        System.out.println(Arrays.toString(arr9));

        for (int i = 0; i <arr9.length ; i++) {
            switch (arr9[i]){
                case -1:
                    minusOne++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;

                    default: break;
            }
        }

        if (minusOne>zero && minusOne>one){
            System.out.println("-1 встречается чаще всех остальных");
        }else if(zero>minusOne && zero>one){
            System.out.println("0 встречается чаще всех остальных");
        }else if (one>minusOne && one>zero){
            System.out.println("1 встречается чаще всех остальных");
        }else{
            System.out.println("нет числа, которое встречалось бы строго больще остальных");
        }

    }


    //Пользователь вводит чётное число N, создаётся массив с размером N из (-5;5).
    // Вывести на экран, найти сумму модулей левой/правой частей, какая из них больше
    public static void Task10(){
        String msg10= "введите чётное положительное число";
        int num;

        while (true){
        num=getNumber(scanner, msg10);
            if (num>0 && num%2==0) {
                break;
            }
        }

        int left=0;
        int right=0;
        int[] arr10=getMassive(num,-5,5,false);
        System.out.println(Arrays.toString(arr10));

        for (int i = 0; i <arr10.length ; i++) {
            if (i<(num/2)){
                left+=Math.abs(arr10[i]);
            }else{
                right+=Math.abs(arr10[i]);
            }
        }

        if (left>right){
            System.out.println("Сумма модулей левой части больше суммы модулей правой части");
        }else if(right>left){
            System.out.println("Сумма модулей правой части больше суммы модулей левой части");
        }else{
            System.out.println("Сумма модулей левой и правой частей равны");
        }

    }


    //массив из 12 случайных чисел (-10;10).
    // Отрицательных и положительных долно быть поровну и не долэно быть нулей
    // + случайный порядок следования элементов
    static void Task11() {
        int zero;
        int lessZero;
        int aboveZero;
        int[] arr11;
        int unReachShift;
        int unReachPos;
        int unReachNeg;


            while (true) {
                zero=0;
                lessZero=0;
                aboveZero=0;
                unReachNeg=0;
                unReachPos=0;
                unReachShift=0;


                arr11 = getMassive(12, -10, 10, false);

                //проверяем массив на наличие положительных, отрицательных элемениов и нолей
                for (int i = 0; i < arr11.length; i++) {
                    if (arr11[i] == 0) {
                        zero++;
                    } else if (arr11[i] > 0) {
                        aboveZero++;
                    } else {
                        lessZero++;
                    }
                }

                //для проверки чередования + и - элементов, значение должно быть 11 для повтора цикла
                for (int i = 0; i <arr11.length-1; i++) {
                    if ((arr11[i] > 0 && arr11[i + 1] < 0) || (arr11[i] < 0 && arr11[i + 1] > 0)) {
                        unReachShift++;
                    }
                }

                //для проверки кол-ва положительных и отрицательных элементов, значение должно быть =6 для повтора цикла
                for (int i = 0; i <(arr11.length/2) ; i++) {
                    if (arr11[i]>0){
                        unReachPos++;
                    }else{
                        unReachNeg++;
                    }
                }
                //условия проверки по трём факторам
                if (zero == 0 && lessZero == aboveZero && unReachShift<(arr11.length-1) && unReachPos!=(arr11.length/2) && unReachNeg!=(arr11.length/2)) {
                        break;
                    }
        }
        System.out.println(Arrays.toString(arr11));
    }


    //Пользователь вводит число больше 3 в переменнцю N. Создаётся массив длинной N (0;N).
    // Вывести на экран, создать второй массив из чётных элементов первого
    public static void Task12(){
        int n;
        int secondArrLength=0;
        String msg12="введите целое число больше 3";

        while (true){
            n=getNumber(scanner, msg12);
            if (n>3) {
                break;
            }
        }

        int[] arr12=getMassive(n,0,n,true);

        System.out.println(Arrays.toString(arr12));

        for (int i = 0; i <arr12.length ; i++) {
            if (arr12[i]%2==0){
                secondArrLength++;
            }
        }
        int[] arr12Second = new int[secondArrLength];

        if (secondArrLength>0){
            int j=0;
            for (int i = 0; i <arr12.length ; i++) {
                if (arr12[i]%2==0){
                    arr12Second[j]=arr12[i];
                    j++;
                }
            }
        }else{
            System.out.println("в начальном массиве нет чётных чисел");
        }
        System.out.println(Arrays.toString(arr12Second));
    }


    //Создать массив из чётных элементов от 2 до 20. Вывести в строку и столбик
    public static void Task13(){
        int[] arr13=new int[10];
        int grad=2;

        for (int i = 0; i <arr13.length ; i++) {
            arr13[i]+=grad;
            grad+=2;
        }

        for (int i = 0; i <arr13.length ; i++) {
            System.out.print(arr13[i]+" ");
        }

        System.out.println();

        for (int i = 0; i <arr13.length ; i++) {
            System.out.println(arr13[i]);
        }

    }


}
