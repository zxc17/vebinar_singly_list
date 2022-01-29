package task.duplicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Удаление дубликатов.
 *
 * Удалить из строки повторные слова:
 * Пример:
 * А В А АА В ВВ А ВВ
 *
 * Результат:
 * А В АА ВВ
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class DuplicateRemoving {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<>();
		input.add("A");
		input.add("B");
		input.add("A");
		input.add("AA");
		input.add("B");
		input.add("BB");
		input.add("A");
		input.add("BB");
		for (String s : input) {
			System.out.print(s + " ");
		}
		System.out.println();

//		Collection<String> result = deduplicate(input);
//		for (String s : result) {
//			System.out.print(s + " ");
//		}
//		System.out.println();

		deduplicateNoMemory(input);
		for (String s : input) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

	private static Collection<String> deduplicate(List<String> input) {
		Set<String> set = new LinkedHashSet<>(input);// O(n)
//		Set<String> set = new LinkedHashSet<>();
//		for (String s : input) { // O(n)
//			set.add(s);
//		}
		return set; // Память O(n)
	}

	private static void deduplicateNoMemory(ArrayList<String> input) { // Память О(1)
		int pos = 0;
		final Iterator<String> iterator = input.iterator();
		while (iterator.hasNext()) { // O(n)
			final String s = iterator.next();
			// Смотрим список, левую часть, уникальную.
			// x x x pos _ _ _ _
			boolean duplicate = false;
			for (int i = 0; i < pos; i++) { // Итоговая O(n2)
				String d = input.get(i);
				if (d.equals(s)) {
					duplicate = true;
					break;
				}
			}
			if (duplicate) {
				iterator.remove();
			} else {
				pos++;
			}
		}
	}
}
