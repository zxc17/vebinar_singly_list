package task.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Подсчет количества повторений слов.
 * <p>
 * Пример:
 * А В АА ВВ А ВВ А
 * <p>
 * Результат:
 * А - 3
 * В - 1
 * АА - 1
 * ВВ - 2
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class CountWords {
	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("A");
		input.add("B");
		input.add("AA");
		input.add("BB");
		input.add("A");
		input.add("BB");
		input.add("A");
		for (String s : input) {
			System.out.print(s + " ");
		}
		System.out.println();

		Map<String, Integer> result = repeatCounter(input);

		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println();
	}

	private static Map<String, Integer> repeatCounter(List<String> input) {
		final Map<String, Integer> map = new HashMap<>();
		for (String s : input) { // O(n)
			int count = map.getOrDefault(s, 0); // O(1)
			count++;
			map.put(s, count); // O(1)
		}
		return map; // O(n) - сложность алгоритма
		// Память (хеш-таблица) - O(n)

		// 2 вложенных цикла  - О(n2)
//		for (String s : input) {
//			for (String v : input) {
// if s == v count++
//			}
//		}
	}
}
