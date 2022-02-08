package algorithm_homework;

/*
        Задача 5: Найти 3 максимума
        В списке чисел найти 3 максимальных
 */

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        // По постановке задачи неясно, надо ли исключать повторения из найденных чисел.
        // В данной задаче сделано без исключения, в следующей с исключениями.
        ArrayList<Integer> input = makeInputData();
//        calculateMax1(input);
        calculateMax2(input);
    }

    private static void calculateMax1(ArrayList<Integer> input) {
        // Сложность: сортировка O(n*log(n))
        // Преимущества - с отсортированным списком можно решать и другие задачи.
        System.out.print("Исходные данные: ");
        System.out.println(input);
        Collections.sort(input);
        System.out.println("Максимальные числа:");
        int size = input.size();
        for (int i = 1; i < 4 && i <= size; i++) { // нумерация массива с нуля, добавляем единицу.
            System.out.println(input.get(size - i));
        }
    }

    private static void calculateMax2(ArrayList<Integer> input) {
        // Сложность: для поиска 3 чисел нужны 3 прохода O(3n)
        System.out.print("Исходные данные: ");
        System.out.println(input);
        System.out.println("Максимальные числа:");
        // Если важны исходные данные - создать копию.
        for (int n = 0; n < 3; n++) {  // Нам нужны три числа.
            int size = input.size();
            int max = input.get(0);
            int indexOfMax = 0;
            for (int i = 1; i < size; i++) { // Нулевой запомнили, начинаем с первого.
                if (input.get(i) > max) {
                    max = input.get(i);
                    indexOfMax = i;
                }
            }
            System.out.println(max);
            input.remove(indexOfMax);
        }
    }

    private static ArrayList<Integer> makeInputData() {
        ArrayList<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            input.add(random.nextInt(10));
        }
        return input;
    }
}
