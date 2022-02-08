package algorithm_homework;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.add(5);
        System.out.println(queue.pop());
        queue.add(6);
        queue.add(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }

    /**
     * Добавляет элемент в хвост очереди.
     *
     * @param data Добавляемые данные.
     */
    public void add(T data) {
        if (tail == null) {
            tail = new Node<>(null, data, null);
            head = tail;
        } else {
            Node<T> newNode = new Node<>(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Возвращает первый элемент очереди. Удаляет элемент из очереди.
     *
     * @return Данные из первого элемента в очереди. null, если очередь пустая.
     */
    public T pop() {
        if (head == null)
            return null;
        T data = head.data;
        size--;
        head = head.next;
        if (head != null)
            head.prev = null;
        return data;
    }

    /**
     * Возвращает первый элемент очереди. Не меняет очередь.
     *
     * @return Данные из первого элемента в очереди. null, если очередь пустая.
     */
    public T peek() {
        return (head == null) ? null : head.data;
    }

    public int getSize() {
        return size;
    }

    public class Node<D> {
        Node<D> prev;
        Node<D> next;
        D data;

        public Node(Node<D> prev, D data, Node<D> next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }
}
