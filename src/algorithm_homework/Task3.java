package algorithm_homework;

/*
        Задача 3: Поиск популярных слов
        Из списка слов надо найти 10 наиболее часто встречаемых, длинной больше 5
 */

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<String> input = makeInputData();
//        calculateWords1(input);
        calculateWords2(input);
    }

    private static void calculateWords1(List<String> input) {
        // Сложность цикл плюс вложенный цикл O(n+n2).
        // TODO. Под вопросом сложность операции добавления в середину ArrayList.
        // TODO: Довольно громоздкий получился. Продумать варианты альтернативы списка из пар.
        // Данный вариант медленнее второго, но имеет возможность вернуть полный отсортированный список.
        Map<String, Integer> countWords = new HashMap<>();
        for (String word : input) {
            if (word.length() > 5) { // По условию длина слова должна быть больше 5.
                countWords.put(word, countWords.getOrDefault(word, 0) + 1); // подсчет вхождений.
            }
        }
        var sortedCountWords = new ArrayList<Map.Entry<String, Integer>>();
        for (var entry : countWords.entrySet()) {
            if (sortedCountWords.isEmpty()) {  // Добавляем первый элемент, пока сравнивать не с чем.
                sortedCountWords.add(entry);
                continue;
            }
            for (int i = 0; i < sortedCountWords.size(); i++) {
                if (entry.getValue() >= sortedCountWords.get(i).getValue()) { //сортируем по убыванию
                    sortedCountWords.add(i, entry); // Нашли элемент не больше текущего - добавляем.
                    break;
                } else if (i == sortedCountWords.size() - 1) {
                    sortedCountWords.add(entry);    // Нет элементов меньше текущего, добавляем в конец.
                }
            }
        }
        for (int i = 0; i < 10 && i < sortedCountWords.size(); i++) {
            System.out.printf("Слово \"%s\" встречается %d раз.%n",
                    sortedCountWords.get(i).getKey(), sortedCountWords.get(i).getValue());
        }
    }

    private static void calculateWords2(List<String> input) {
        // Сложность цикл плюс десятикратный цикл O(n+10n)
        // Т.е. при n>10 алгоритм быстрее.
        Map<String, Integer> countWords = new HashMap<>();
        for (String word : input) {
            if (word.length() > 5) { // По условию длина слова должна быть больше 5.
                countWords.put(word, countWords.getOrDefault(word, 0) + 1); // подсчет вхождений.
            }
        }
        // Ищем слово с максимальным количеством повторов, затем удаляем его из списка.
        for (int i = 0; i < 10 && countWords.size() > 0; i++) { //10 слов - условие задачи
            int max = 0;
            String word = "";
            for (var entry : countWords.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    word = entry.getKey();
                }
            }
            System.out.printf("Слово \"%s\" встречается %d раз.%n", word, max);
            countWords.remove(word);
        }
    }

    private static List<String> makeInputData() {
        List<String> input = new ArrayList<>();
        input.add("s");
        input.add("s");
        input.add("a");
        input.add("Проба");
        input.add("Проба");
        input.add("Проба");
        input.add("длинное");
        input.add("длинное");
        input.add("длинное");
        input.add("длинное");
        input.add("очень длинное");
        input.add("очень длинное");
        input.add("проверка");
        input.add("проверка");
        input.add("проверка");
        input.add("проверка");
        input.add("проверка");
        input.add("проверка4");
        input.add("проверка4");
        input.add("проверка5");
        input.add("проверка5");
        input.add("проверка6");
        input.add("проверка6");
        input.add("проверка7");
        input.add("проверка7");
        input.add("проверка8");
        input.add("проверка9");
        input.add("проверка10");
        input.add("проверка11");
        input.add("проверка12");
        input.add("проверка13");
        Collections.shuffle(input);
        return input;
    }

}
