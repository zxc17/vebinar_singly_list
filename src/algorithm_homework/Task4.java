package algorithm_homework;
/*
        Задача 4: Подсчет количества повторений букв
        Найти сколько раз встречается символ в строке.
 */
public class Task4 {

    public static void main(String[] args) {
        System.out.println(countChar("Проверочная строка", 'а'));
    }
    private static int countChar(String str, char ch) {
// Вероятно, я что-то не понял в задании, поскольку это слишком просто.
// Но ничего другого в голову не приходит.
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                n++;
        }
        return n;
    }
}
