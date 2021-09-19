import java.sql.Array;

public class Les3_Arrays {
    public static void main(String[] args){
        changeArray();
        newArray100();
        chArray6();
        krestArray();
        intArrValue(5, 456);
        inArrMinMax();
        int[] ints = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(compareArr(ints));
        shiftArr(ints, -5);
    }

    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public static void changeArray(){
        int [] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] == 0) {
                intArray[a] = 1;
            } else {
                intArray[a] = 0;
            }
        }
    }

    /*2. Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;*/
    public static void newArray100(){
        int [] intArray100 = new int[100];
        for (int i = 0; i < intArray100.length; i++){
            intArray100[i] = i + 1;
        }
    }
    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;*/
    public static void chArray6(){
        int [] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int a = 0; a < intArray.length; a++) {
            if (intArray[a] <= 6) {
                intArray[a] = intArray[a] * 2;
            }
        }
        // check
        for (int a: intArray) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];*/
    public static void krestArray(){
        int [][] table = new int [10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(i == j || i == 9-j){
                    table[i][j] = 1;
                }
            }
        }
        // check
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;*/
    public static int[] intArrValue(int len, int initialValue){
        int[] intArr = new int[len];
        for (int i = 0; i < len; i++) {
            intArr[i] = initialValue;
        }
        // check
        for (int a: intArr) {
            System.out.print(a + ", ");
        }
        System.out.println();
        return intArr;
    }
    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static void inArrMinMax(){
        int[] intArr = {5, -3, 10, 0, 7};
        int min = intArr[0];
        int max = intArr[0];
        for (int i = 1; i < intArr.length; i++){
            if (min > intArr[i]) {
                min = intArr[i];
            }
            if (max < intArr[i]){
                max = intArr[i];
            }
        }
        // check
        System.out.println("min: " + min + " max: " + max);
    }
    /*7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.*/
    public static boolean compareArr(int[] intArr){
        int sumLeft;
        int sumRight;
        for (int i = 0; i < intArr.length; i++){
            sumLeft = 0;
            sumRight = 0;
            for (int a = i; a >=0; a--){
                sumLeft += intArr[a];
            }
            for (int b = i+1; b < intArr.length; b++){
                sumRight += intArr[b];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }
    /* Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.*/
    public static void shiftArr(int[] ints, int n){
        int intBuf;
        int intShift;
        if (n > 0) {
            for (int a = 0; a < n; a++){
                intBuf = ints[0];
                ints[0] = ints[ints.length-1];
                for (int i = 1; i < ints.length; i++){
                    intShift = ints[i];
                    ints[i] = intBuf;
                    intBuf = intShift;
                }
            }
        } else {
            int m = Math.abs(n);
            for (int a = 0; a < m; a++){
                intBuf = ints[ints.length-1];
                ints[ints.length-1] = ints[0];
                for (int i = ints.length-2; i >= 0; i--) {
                    intShift = ints[i];
                    ints[i] = intBuf;
                    intBuf = intShift;
                }
            }
        }
        // check
        for (int a: ints) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }

}

