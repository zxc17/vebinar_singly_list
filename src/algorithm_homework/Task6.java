package algorithm_homework;

/*
        Задача 6: Найти 2 минимума и количество повторений
        Найти 2 минимальных числа в списке, и указать кол-во сколько он встречается.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
public class Task6 {
    public static void main(String[] args) {
        ArrayList<Integer> input = makeInputData();
// Алгоритмы поиска минимальных элементов взяты из задачи 5.
//        calculateMinCount1(input);
        calculateMinCount2(input);
    }

    private static void calculateMinCount1(ArrayList<Integer> input) {
/*
        Сложность:
        Cортировка O(n*log(n))
        Подсчет количества каждого из минимумов O(n), вне зависимости от их числа.
        Итого O(n + n*log(n))
        Преимущества:
        - не зависит от числа минимумов, которые надо найти;
        - с отсортированным списком можно решать и другие задачи.
        Недостатки:
        - высокая сложность при большом количестве элементов.
 */
        final int x = 3;    // Сделаем универсальный алгоритм. x - количество минимальных чисел, которые нужно найти.
        System.out.print("Исходные данные: ");
        System.out.println(input);
        // Если важны исходные данные - создать копию.
        Collections.sort(input);
        var min = new int[x];
        var count = new int[x];           // Количество каждого из минимумов.
        int i = 0;
        int index = 0;
        try {
            while (i < x) {
                count[i] = 0;
                int firstIndex = index;
                while (input.get(firstIndex) == input.get(index)) {
                    index++;
                    count[i]++;
                }
                min[i] = input.get(firstIndex);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            if (i < x - 1) { // Если количество найденных минимумов меньше требуемого.
                System.out.println("В списке нет столько минимальных значений");
                return;
            }
        }
        System.out.println("Минимальные числа:");
        for (int k = 0; k < x; k++) {
            System.out.printf("Число %d встречается %d раз%n", min[k], count[k]);
        }
    }

    private static void calculateMinCount2(ArrayList<Integer> input) {
/*
         Метод с поиском минимального по перебору, с последующим удалением.
         Сложность: для поиска 1 числа нужен 1 проход O(n)
         Для удаления дубликатов и подсчета количества нужен еще один проход.
         Итого O(2xn), где х - количество нужных нам минимумов.
         Сложность алгоритма с сортировкой O(n+n*log2(n))
         Таким образом точка "равенства сложности" n = 2^(2x-1),
         где n - число элементов списка, x - число минимумов для поиска.
         Т.е. при х=2 данный алгоритм быстрее сортировочного при количестве элементов больше 8,
         если x=3, то при количестве больше 32 элементов, х=5 - при количестве более 512;
         Т.е. если нужно найти 5 из 500 - выгоднее сортировочный способ.
 */
        System.out.print("Исходные данные: ");
        System.out.println(input);
        // Если важны исходные данные - создать копию.
        final int x = 3;    // Сделаем универсальный алгоритм. x - количество минимальных чисел, которые нужно найти.
        var min = new int[x];
        var count = new int[x];           // Количество каждого из минимумов.
        try {
            for (int k = 0; k < x; k++) {
                min[k] = input.get(0);
                int size = input.size();
                for (int i = 1; i < size; i++) { // Нулевой запомнили, начинаем с первого.
                    if (input.get(i) < min[k])
                        min[k] = input.get(i);
                }
                Iterator<Integer> iter = input.iterator();
                while (iter.hasNext()) {
                    if (iter.next() == min[k]) {
                        iter.remove();
                        count[k]++;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("В списке нет столько минимальных значений");
            return;
        }
        System.out.println("Минимальные числа:");
        for (int k = 0; k < x; k++) {
            System.out.printf("Число %d встречается %d раз%n", min[k], count[k]);
        }
    }

    private static ArrayList<Integer> makeInputData() {
        ArrayList<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            input.add(random.nextInt(5));
        }
//        input.add(4);
//        input.add(1);
//        input.add(3);
//        input.add(1);
//        input.add(4);
        return input;
    }
}
