package ru.geekbrains;

public class Main {

    public static int positionInArray;

    public static void main(String[] args) {
	// write your code here

        System.out.println("Задание 1");
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] sampleArray1 = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        printArray(sampleArray1);

        for (int i = 0; i < sampleArray1.length; i++) {
            switch (sampleArray1[i]) {
                case 0:
                    sampleArray1[i] = 1;
                    break;
                case 1:
                    sampleArray1[i] = 0;
                    break;
            }
        }
        printArray(sampleArray1);
        System.out.println("===");

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание 2");
        int[] sampleArray2 = new int[8];

        for (int i = 0; i < sampleArray2.length; i++) {
            sampleArray2[i] = 3 * i;
        }
        printArray(sampleArray2);
        System.out.println("===");

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание 3");

        int[] sampleArray3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(sampleArray3);
        for (int i = 0; i < sampleArray3.length; i++) {
            if (sampleArray3[i] < 6) {
                sampleArray3[i] *= 2;
            }
        }
        printArray(sampleArray3);
        System.out.println("===");

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4");
        int lengthArray = 5;
        int[][] sampleArray4 = new int[lengthArray][lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            sampleArray4[i][i] = 1;
            sampleArray4[i][lengthArray - 1 - i] = 1;
        }
        printTwoDimentionArray(sampleArray4);
        System.out.println("===");

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание 5");
        int[] sampleArray5 = { 2, 1, 6, 9, 3, 4, 11, 7, 5};
        printArray(sampleArray5);
        int min = sampleArray5[0], max = sampleArray5[0];
        for (int i = 0; i < sampleArray5.length; i++) {
            if (min > sampleArray5[i]) {
                min = sampleArray5[i];
            }
            if (max < sampleArray5[i]) {
                max = sampleArray5[i];
            }
        }
        System.out.println(" min = " + min + "; max = " + max);
        System.out.println("===");

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        //массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
        //2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println("Задание 6");
        int[] sampleArray6 = {2, 2, 2, 1, 2, 2, 10, 1};
        //int[] sampleArray6 = {2, 2, 2, 1, 2, 2, 3, 1};
        printArray(sampleArray6);
        if (checkBalance(sampleArray6)) {
            printArray(sampleArray6, positionInArray);
            System.out.println(" -> true ");
        } else {
            System.out.println("Точку равновесия в массиве найти не удалось");
        }
        System.out.println("===");


        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("Задание 7");
        int[] sampleArray7 = {1, 2, 3, 4, 5, 6, 7, 8};
        int shiftCount = -3;
        printArray(sampleArray7);
        System.out.println("Сдвиг архива на " + shiftCount);
        shiftArray(sampleArray7, shiftCount);
        printArray(sampleArray7);

    }

    // Задание 7. Сдвиг массива
    private static void shiftArray(int[] array, int count) {
        int tempValue;
        if (count > 0) {
            for (int i = 0; i < Math.abs(count); i++) {
                tempValue = array[array.length -1];
                for (int j = array.length - 1; j >0 ; j--) {
                    array[j] = array[j -1 ];
                }
                array[0] = tempValue;
            }
        } else {
            for (int i = 0; i < Math.abs(count); i++) {
                tempValue = array[0];
                for (int j = 0; j < array.length - 1 ; j++) {
                    array[j] = array[j +1];
                }
                array[array.length - 1] = tempValue;
            }
        }
    }

    // Задание 6. Метод для проверки массива
    public static boolean checkBalance(int[] array) {
        boolean checkFlag = false;
        int i = 0, j = array.length - 1;
        int leftSum = array[i];
        int rightSum = array[j];

        while (i != j) {

            if (checkFlag) {
                positionInArray = j;
                return checkFlag;
            }

            if (leftSum < rightSum) {
                i++;
                leftSum += array[i];
            } else {
                j--;
                rightSum +=array[j];
            }
            if ((leftSum == rightSum) && (i == (j - 1))) {
                checkFlag = true;
            }
        }
        return false;
    }

    //
    private static void printArray(int[] array) {
        // Выводим массив на экран
        System.out.print("[ "+ array[0]);
        for (int i = 1; i< array.length; i++) {
            System.out.printf(", %4d", array[i], 7);
        }
        System.out.println("]");

    }

    //
    private static void printArray(int[] array, int position) {
        // Выводим массив на экран
        System.out.print("[ "+ array[0]);
        for (int i = 1; i< array.length; i++) {
            if (i != position) {
                System.out.printf(", %4d", array[i], 7);
            } else {
                System.out.printf(", || %4d", array[i], 7);
            }
        }
        System.out.println("]");

    }

    //
    private static void printTwoDimentionArray(int array[][]) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++ ) {
            System.out.print("[ " + array[i][0]);
            for (int j = 1; j < array[i].length; j++) {
                System.out.printf(", %4d", array[i][j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
