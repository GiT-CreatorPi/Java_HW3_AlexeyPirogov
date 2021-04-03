//Дисциплина: Java.Уровень 1
//Домашнее задание №: 3 "Java.Практика"
//Студент: Алексей Пирогов
//Дата: 02.04.2021

import java.util.Scanner;

public class HomeWorkApp_3 {

    public static int maxLen_ = 10, maxLen = 16, countShift;
    public static int[] lineMatrix;
    public static int[] defaultMatrix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    public static int[] lineWithMinMax = {1, -10, -1000, 2, 2, 55, 20, 1, 6, -5, 99, -101, 400, 40, 10, 0}; //16
    public static int[] shiftRegisterBin = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] shiftRegisterDec = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static int[] lineMatrixCheckBalance = {2, 2, 2, 1, 2, 2, 10, 1}; //8
    public static int[] lineMatrixCheckBalance_ = {1, 1, 1, 2, 1}; //5
    public static boolean print = true;
    public static String infoMessage = "\nДля использования значения по умолчанию используйте 0 или значение по умолчанию, для формирования новой строки введите целое число из интервала (0;+∞): ";
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Задача 1. Инвертирование элементов внутри массива из нулей и единиц. По умолчанию размер массива 10. ");
        maxLen_ = inputNum(infoMessage);
        if (maxLen_ <= 0) {
            maxLen_ = 10;
        }
        newLineMatrix(maxLen_);
        getRandomBinArray(lineMatrix, maxLen_, print);
        invBinMatrix(lineMatrix, maxLen_, print);
        pressEnter();

        System.out.print("Задача 2. Вывод целочисленного массива произвольной длины. По умолчанию размер массива 100. ");
        maxLen = inputNum(infoMessage);
        if (maxLen <= 0) {
            maxLen = 100;
        }
        newLineMatrix(maxLen);
        inputIntMatrix(lineMatrix, maxLen);
        pressEnter();

        System.out.println("Задача 3. Умножение линейного массива на числовую константу.");
        System.out.print("Массив по умолчанию: 1 5 3 2 11 4 5 2 4 8 9 1. Логика умножения чисел: чмсла менее 6. Множитель: 2.\n");
        int key = inputNum("Если желаете ввести новые данные, то нажмите 1. Значение: ");
        if(key == 1){
            inputLineMatrix();
            int searchItem = inputNum("Введите число мнеее которого будут умножаться числа: ");
            int constMul = inputNum("Введите множитель: ");
            mulConstAnyEnvInArray(lineMatrix, maxLen, searchItem, constMul);
            printLineMatrix(lineMatrix, maxLen);
        }
        else {
            System.out.print("\tИтоговый массив: ");
            mulConstAnyEnvInArray(defaultMatrix, 12, 6, 2);
            printLineMatrix(defaultMatrix, 12);
        }
        pressEnter();

        System.out.println("Задача 4. Вывод квадратной матрицы размерностью N с \"подсвеченными\" диагоналями.");
        String infoMessage = "Размерность матрицы определяется целым положительным числом отличным от нуля и может быть чётной и нечётной. Введите размерность матрицы: ";
        maxLen = inputNum(infoMessage);
        int squareMatrix[][] = new int[maxLen][maxLen];
        infoMessage = "Введите заполнитель - целое число длиной не более 2 разрядов, принадлежащее интервалу [0;99]: ";
        int placeholder = inputNum(infoMessage);
        infoMessage = "Введите выдилитель - целое число длиной не более 2 разрядов, принадлежащее интервалу [0;99]: ";
        int highlighter;
        do{
            highlighter = inputNum(infoMessage);
            if (highlighter == placeholder) {
                System.out.print("Заполнитель не может быть равен выдилителю.");
            }
            else {
                System.out.println();
                //break;
            }
        } while (highlighter == placeholder);

        System.out.println("Содержимое исходной матрицы в RAM: ");
        printSquareMatrix(squareMatrix, maxLen);
        diagonalHighlighter(squareMatrix, maxLen, placeholder, highlighter);
        System.out.println("Содержимое матрицы с \"подсвеченными\" диагоналями: ");
        printSquareMatrix(squareMatrix, maxLen);
        pressEnter();

        System.out.println("Задача 5. Формирование одномерно массива заданной длинны с заданным наполнением.");
        maxLen = inputNum("Введите рамезность массива: ");
        infoMessage = "Введите заполнитель - целое число, принадлежащее интервалу [0;+∞): ";
        int copyItem = inputNum(infoMessage);
        copyItemMatrix(maxLen, copyItem);
        System.out.print("\n");
        pressEnter();

        System.out.println("Задача 6. Поиск минимального и максимального элемента в линейном массиве.");
        System.out.print("Масиив по умолчанию: ");
        printLineMatrix(lineWithMinMax, 16);
        key = inputNum("Если желаете ввсести новые данные, то нажмите 1. Значение: ");
        if(key == 1){
            inputLineMatrix();
            searchExtremumInLineMatrix(lineMatrix, maxLen, print);
        }
        else {
            searchExtremumInLineMatrix(lineWithMinMax, 16, print);
        }
        pressEnter();

        System.out.println("Задача 7. Балансировка значений в массиве массиве.");
        System.out.print("Массив №1: ");
        printLineMatrix(lineMatrixCheckBalance, 8);
        System.out.print("Массив №2: ");
        printLineMatrix(lineMatrixCheckBalance_,5);

        key = inputNum("Если желаете ввсести новые данные, то нажмите 1. Значение: ");
        if(key == 1){
            inputLineMatrix();
            checkBalance(lineMatrix, maxLen);
            mirrorLineMatrix(lineMatrix,maxLen);
            checkBalance(lineMatrix, maxLen);
        }
        else {
            System.out.print("Баланс для первой матрицы:\n");
            checkBalance(lineMatrixCheckBalance, 8);
            System.out.print("Баланс для первой зеркальной матрицы:\n");
            mirrorLineMatrix(lineMatrixCheckBalance,8);
            checkBalance(lineMatrixCheckBalance, 8);
            pressEnter();

            System.out.print("Баланс для второй матрицы:\n");
            checkBalance(lineMatrixCheckBalance_, 5);
            System.out.print("Баланс для второй зеркальной матрицы:\n");
            mirrorLineMatrix(lineMatrixCheckBalance_,5);
            checkBalance(lineMatrixCheckBalance_, 5);
        }
        pressEnter();

        System.out.println("Задача 8. Сдвиговый регистр влево-вправо.");
        countShift = inputNum("Введите количество итераций сдвига и направление сдвига. Отрицательное число - сдвиг влево, положительное число - сдвиг вправо: ");
        maxLen = 16;
        shiftRegisterMagicBox(shiftRegisterBin, maxLen, countShift, true);
        shiftRegisterMath(shiftRegisterBin, maxLen, countShift, true);
        pressEnter();
        shiftRegisterMagicBox(shiftRegisterDec, maxLen, countShift, true);
        shiftRegisterMath(shiftRegisterDec, maxLen, countShift, true);
        pressEnter();
    }

    //Задача 1. Инвертирование битов в ячейках двоичного массива
    //Функция для заполнения массива нулями и единицами. Параметры: массив, размер массива, признак вывода на печать
    public static void invBinMatrix(int[] lineMatrix, int maxLenght, boolean print)
    {
        for (int i=0; i < maxLenght; i++)    //цикл по элементам массива
        {
            if (lineMatrix[i] == 1)      //проверка i-го массива на равенство 1
            {
                lineMatrix[i] = 0;      //замена 1 на 0
            }
            else
            {
                lineMatrix[i] = 1;      //замена 0 на 1
            }
            if (print == true)   //если передано услови на печать то вывод данных
            {
                System.out.print(lineMatrix[i] + " ");  //печать i-го элемента массива в инвертированном виде
            }
        }
        if (print == true)   //если передано услови на печать то вывод данных
        {
            System.out.print(" - итоговое состояние строкового массива/регистра, инвертированные данные\n");
        }
    }

    //Функция для заполнения массива нулями и единицами, выбираемых произвольным образом
    //Параметры: массив, размер массива, признак вывода на печать
    public static void getRandomBinArray(int[] lineMatrix, int maxLenght, boolean print)
    {
        for (int i=0; i < maxLenght; i++)   //цикл для перебора элементов массива
        {
            if ((float)Math.random() < (float)Math.random())    //сравнение двух чисел типа int, полученных случайным образом
            {
                lineMatrix[i] = 0; //если условие истина, то 0

                if (print == true) //проверка параметра, если требуется печать результата
                {
                    System.out.print(lineMatrix[i] + " "); //вывод на печать
                }
            }
            else
            {
                lineMatrix[i] = 1;  //если условие истина, то 1

                if (print == true)  //проверка параметра, если требуется печать результата
                {
                    System.out.print(lineMatrix[i] + " ");  //вывод на печать
                }
            }
        }
        if (print == true)  //проверка параметра, если требуется печать результата
        {
            System.out.print(" - исходное состояние массива/регистра, получено произвольным образом\n");   //вывод на печать
        }
    }

    //Задача 2. Заполнение массива последовательностью числел от 1 до N, по умолчанию передаётся 100
    //Функция для заполнения массива нулями и единицами. Параметры: массив, размер массива, признак вывода на печать
    public static void inputIntMatrix(int[] lineMatrix, int maxLenght)
    {
        for(int i=0; i < maxLenght; i++)    //цикл по элементам массива
        {
            lineMatrix[i] = i + 1;      //присвоение i-му элементу значение счётчика i + 1
            System.out.print(lineMatrix[i] + " ");      // вывод на печать
        }
        System.out.print("\n");     //перенос строки
    }

    //Задача 3. Умножение массива на число. Массив по умолчанию [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1], множитель 6
    //Функция для заполнения массива нулями и единицами
    //Параметры: массив, размер массива, признак вывода на печать
    public static void mulConstAnyEnvInArray(int[] lineMatrix, int maxLenght, int searchVar, int const_Var)
    {
        for (int i=0; i < maxLenght; i++) //цикл по элементам массива
        {
            if(lineMatrix[i] < searchVar)   //если i-й элемент меньше искомого
            {
                lineMatrix[i] *= const_Var;     //умножение i-го элемента на константу
            }
        }
    }

    //Функция для ввода вручную значений и инициализации новой строчной матрицы
    public static void inputLineMatrix()
    {
        do{
            System.out.print("Введите размер массива:");
            maxLen = in.nextInt();
            if (maxLen < 0) {
                System.out.print("Размер массива не может быть меньше нуля.");
            }
            else {
                break;
            }
        } while (maxLen >= 0);

        lineMatrix = new int[maxLen];
        System.out.print("Введите элементы массива и нажмите Enter:");
        for (int i=0; i < maxLen; i++) {
            lineMatrix[i] = in.nextInt();
        }
    }

    //Функция создания новой матрицы. Параметр: максимальная длина матрицы
    public static void newLineMatrix(int maxLen) {
        lineMatrix = new int[maxLen];
    }

    //Задача 4. Создание квадратной матрицы и заполнение её символами для выделения фона и диагоналей
    //Функция для заполнения символами фона и выделения диагоналей
    //Параметры: матрица, размер матрицы, заполнитель фона, выдилитель диагоналей
    public static void diagonalHighlighter(int[][] squareMatrix, int maxLenght, int placeholder, int highlighter)
    {
        //маркировка диагоналей матрицы символом отличным от нуля
        for (int i=0; i < maxLenght; i++) //цикл по строкам для перебора векторных массивов
        {
            for (int j=0; j < maxLenght; j++) //цикл по столбцам для перебора элементов строки
            {
                if ((i == j) || (j == ((maxLenght - 1) - i))) //маркировка главной и побочной диагонали в матрице
                {
                    squareMatrix[i][j] = highlighter;
                }
                else
                {
                    squareMatrix[i][j] = placeholder; //маркировка заполнителем ячееек, между диагоналями
                }
            }
        }
    }

    //Задача 5. Формирование одномерно массива заданной длинны с заданным наполнением
    //Функция для формирования одномерного массива заданной длинны с заданным наполнетелем
    //Параметры: размер матрицы, символ для заполнения матрицы
    public static int[] copyItemMatrix(int len, int initialValue)
    {
        int[] lineMatrix = new int[len];    //объявление нового массива длиной len
        for (int i=0; i < len; i++)     //цикл для заполнения элементов массива символами initialValue
        {
            lineMatrix[i] = initialValue;   //присвоение i-му элементу значения initialValue
            System.out.print(lineMatrix[i] + " ");   //печать i-го элемента
        }
        return lineMatrix;
    }

    //Задача 6. Поиск минимального и максимального значения в одномерном массиве
    //Функция для поиска минимального и максимального значения в одномерном массиве
    //Параметры: массив, размер массива, признак вывода на печать
    public static int[] searchExtremumInLineMatrix(int[] lineMatrix, int maxLen, boolean print)
    {
        int minItem=lineMatrix[0], maxItem=lineMatrix[0];   //объявление переменных для хранения нулей
        int[] minMaxItem = new int[2];  //формирование нового массива с целью возврата минимума и максимума

        for (int i=0; i < maxLen; i++)   //цикл по элементам массива для поиска минимального и максимального элемента
        {
            if (lineMatrix[i] <= minItem)   //если элемент меньше minItem,
            {
                minItem = lineMatrix[i];    //то запись i-го элемента массива в переменную minItem
            }
            if (lineMatrix[i] >= maxItem)   //если элемент больше maxItem,
            {
                maxItem = lineMatrix[i];    //то запись i-го элемента массива в переменную maxItem
            }
        }

        minMaxItem[0] = minItem;
        minMaxItem[1] = maxItem;

        if(print == true)
        {
            System.out.print("MinItem: " + minMaxItem[0] + "\t\t\tMaxItem: " + minMaxItem[1] + "\n");     //печать минимального и максимального значения
        }

        return minMaxItem;  //возврат минимума и максимума из массива функцией
    }

    //Задача 7. Написать метод, в который передаётся непустой одномерный целочисленный массив для проверки
    //Параметры: линейный массив, максимальная длина массива
    public static boolean checkBalance(int[] lineMatrix, int maxLen)
    {
        int leftSum, rightSum; //переменный для хранения сумм
        boolean result = false; //признак равенсва левой и правой части

        //цикл по элементам массива ддя перебора всех возможных комбинаций внутри массива и подсчёта точки баланса относительно начала строки
        for (int counterPosition=0; counterPosition < maxLen - 1; counterPosition++)
        {
            leftSum = 0; //зануление переменной на каждом шаге counterPosition
            rightSum = 0;   //зануление переменной на каждом шаге counterPosition
            //цикл для подсчёта суммы левой части до позиции counterPosition, включительно counterPosition
            for (int selectLeftItem = 0; selectLeftItem <= counterPosition; selectLeftItem++)
            {
                leftSum += lineMatrix[selectLeftItem];
            }
            //цикл для подсчёта суммы правой части от позиции counterPosition + 1 до maxLen
            for (int selectrightItem = counterPosition + 1; selectrightItem < maxLen; selectrightItem++)
            {
                rightSum += lineMatrix[selectrightItem];
            }
            //сравнение сумм
            if(leftSum == rightSum)
            {
                result = true; //установка признака равенства левой и правой части
                //System.out.print(counterPosition +"\t\t" + leftSum + "\t\t" + rightSum + "\t- true" + "\n");
                System.out.print("Сумма элементов слева = " + leftSum + " : ");
                for(int i=0; i < maxLen; i++)
                {
                    if(i == (counterPosition + 1))
                    {
                        System.out.print("||| " + lineMatrix[i] + " "); //вывод точки достижения баланса
                    }
                    else
                    {
                        System.out.print(lineMatrix[i] + " "); //вывод значения элемента массива
                    }
                }
                //Вывод информации об элементе
                System.out.print(": сумма элементов справа = " + rightSum + " - " + result + " - суммы элементов слева и справа совпадают, номер элемента: " + (counterPosition + 1) + ".\n");
            }
            else
            {
                //System.out.print(counterPosition +"\t\t" + leftSum + "\t\t" + rightSum + "\t- false" + "\n");
                result = false;
                System.out.print("Сумма элементов слева = " + leftSum + " : ");
                for(int i=0; i < maxLen; i++)
                {
                    System.out.print(lineMatrix[i] + " ");
                }
                System.out.print(": сумма элементов справа = " + rightSum + " - " + result + " - суммы элементов слева и справа не совпадают.\n");
            }
        }
        System.out.print("\n");
        return result;
    }

    //Зеркальное преобразование строковой матрицы для получения обратных последовательностей
    public static void mirrorLineMatrix(int[] lineMatrix, int maxLen)
    {
        int[] buf = new int[maxLen];    //переменная буфер для храеннения инвертированных данных

        for(int i=0; i<maxLen; i++)     //цикл для инициализация буфера
        {
            buf[i] = lineMatrix[i];
        }
        for(int i=0, j = maxLen - 1; i < maxLen; i++, j--) //цикл для перезаписи данных из буфера в исходный массив
        {
            lineMatrix[i] = buf[j];
        }
    }

    //Задача 8. Сдвиговый регистр
    //Метод сдвига битов в регистре влево-вправо с использованием промежуточной переменной. Параметры: массив, размер массива, количество сдвигов, признак вывода на печать
    public static void shiftRegisterMagicBox(int[] lineMatrix, int maxLen, int shift, boolean print)
    {
        int magicBox; //промежуточная переменная
        if (print == true)  //иллюстрация сдвига
        {
            System.out.print("Исходное состояние массива/регистра:\n" + "- " + '#' + " --- "); //вывод состояния массива до сдвига
            printLineMatrix(lineMatrix, maxLen);    //вывод элементов массива до сдвига
        }

        if (shift < 0)   //проверка условия на сдвиг влево или вправо
        {
            for (int i=1; i <= (-1 * shift); i++)    //счётчик количества итераций при сдвиге влево
            {
                magicBox = lineMatrix[0];           //сохранение первого элемента исходного массива для последующего возвращения
                for (int j = 0; j < maxLen; j++)    //цикл по элементам массива
                {
                    if ((j + 1) < maxLen)   //проверка правой границы при переборе элементов массива
                    {
                        lineMatrix[j] = lineMatrix[j + 1]; //обмен соседних элементов местами
                    }
                }
                lineMatrix[maxLen - 1] = magicBox;  //запись первого бита исходного массива в конец нового массива данных

                if ((print == true) && (i == 1))    //печать строки о типе сдвига на первой итерации цикла со сдвигами
                {
                    System.out.print("Илюстрация работы алгоритма по сдвигу влево с использованием промежуточной переменной:\n");
                }

                if (print == true)      //иллюстрация сдвига
                {
                    System.out.print("- " + i + " -\t");    //вывод номера итерации
                    printLineMatrix(lineMatrix, maxLen);    //вывод массива
                }
            }
        }
        else
        {
            for (int i = 1; i <= shift; i++)    //счётчик количества итераций при сдвиге вправо
            {
                magicBox = lineMatrix[maxLen - 1];  //сохрание последнего элемента исходного массива для последующего возвращения
                for (int j = maxLen; j > 0; j--)    //цикл по элементам массива
                {
                    if ((maxLen) > j)   //проверка левой границы при переборе элементов массива
                    {
                        lineMatrix[j] = lineMatrix[j - 1];   //обмен соседних элементов местами
                    }
                }
                lineMatrix[0] = magicBox;           //запись последнего бита исходного массива в конец нового массива данных
                if ((print == true) && (i == 1))    //печать строки о типе сдвига на первой итерации цикла со сдвигами
                {
                    System.out.print("Илюстрация работы алгоритма по сдвигу вправо с использованием промежуточной переменной:\n");
                }
                if (print == true)
                {
                    System.out.print("- " + i + " -\t");    //вывод номера итерации
                    printLineMatrix(lineMatrix, maxLen);    //вывод массива
                }
            }
        }
        System.out.print("Итоговое состояние регистра:\n" + "- " + '#' + " --- ");
        printLineMatrix(lineMatrix, maxLen);
        System.out.print("\n");
    }

    //Метод сдвига битов в регистре влево-вправо с использованием алгебраических операций
    public static void shiftRegisterMath(int[] lineMatrix, int maxLen, int shift, boolean print)
    {
        System.out.print("Исходное состояние регистра:\n" + "- " + '#' + " --- ");
        printLineMatrix(lineMatrix, maxLen);
        if(shift < 0)
        {
            for(int i=1; i <= (-1 * shift); i++) //сдвиг влево
            {
                for (int j = 0; j < maxLen; j++)
                {
                    if ((j + 1) < maxLen)
                    {
                        lineMatrix[j] = lineMatrix[j] + lineMatrix[j + 1];      //сложение соедних элементов для обмена местами, запись суммы в j-й элемент
                        lineMatrix[j + 1] = lineMatrix[j] - lineMatrix[j + 1];  //вычитание из суммы, из элемента j-го, значения соседнего элемента. Запись в соседний элемент нового значения
                        lineMatrix[j] = lineMatrix[j] - lineMatrix[j + 1];      //вычитание из суммы, из элемента j-го, разности полученной на предыдущем шаге
                    }                                                           //обмен местами двух сосдедних элементов
                }
                if ((print == true) && (i == 1))
                {
                    System.out.print("Илюстрация работы алгоритма по сдвигу влево с применением математических операций:\n");
                }
                if (print == true)
                {
                    System.out.print("- " + i + " -\t");
                    printLineMatrix(lineMatrix, maxLen);
                }
            }
        }
        else
        {
            for (int i = 1; i <= shift; i++) //сдвиг вправо
            {
                for (int j = maxLen; j > 0; j--)
                {
                    if ((maxLen) > j)
                    {
                        lineMatrix[j] = lineMatrix[j] + lineMatrix[j - 1];
                        lineMatrix[j - 1] = lineMatrix[j] - lineMatrix[j - 1];
                        lineMatrix[j] = lineMatrix[j] - lineMatrix[j - 1];
                    }
                }
                if ((print == true) && (i == 1))
                {
                    System.out.print("Илюстрация работы алгоритма по сдвигу вправо с применением математических операций:\n");
                }
                if (print == true)
                {
                    System.out.print("- " + i + " -\t");
                    printLineMatrix(lineMatrix, maxLen);
                }
            }
        }
        System.out.print("Итоговое состояние регистра:\n" + "- " + '#' + " --- ");
        printLineMatrix(lineMatrix, maxLen);
        System.out.print("\n");
    }

    //Метод для вывода одномерно массива. Параметры: матрица, длина матрицы
    public static void printLineMatrix(int [] lineMatrix, int maxLen)
    {
        for(int i=0; i < maxLen; i++)    //цикл по элементам
        {
            System.out.print(lineMatrix[i] + " ");      //печать элемента
        }
        System.out.print("\n");
    }

    //Метод для вывода двухмерного массива. Параметры: матрица, длина матрицы
    public static void printSquareMatrix(int[][] squareMatrix, int maxLen)
    {
        for(int i=0; i < maxLen; i++)   //цикл по строкам матрицы
        {
            for(int j=0; j < maxLen; j++)   //цикл по столбцам
            {
                if(j != (maxLen - 1)) //если на конец строки, то:
                {
                    System.out.print(squareMatrix[i][j] + " "); //печать элмента и пробела
                }
                else
                {
                    System.out.print(squareMatrix[i][j] + "\n"); //печать элемента и переноса строки
                }
            }
        }
        System.out.print("\n");     //печать переноса строки
    }

    //Заглушка для ожидания перехода к следующему шагу
    public static void pressEnter()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Нажмите Enter для пеехода к следующему шагу...\n");
        in.nextLine();
    }

    //Функция для ввода числовых данных
    public static int inputNum(String infoMessage)
    {
        in = new Scanner(System.in);
        System.out.print(infoMessage);
        return in.nextInt();
    }

}
