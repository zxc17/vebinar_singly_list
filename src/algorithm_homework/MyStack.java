package algorithm_homework;

public class MyStack<T> {
    private Node<T> head;
    private int size;

    public MyStack() {
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    /**
     * Добавляет элемент в стек.
     *
     * @param data Добавляемые данные.
     */
    public void push(T data) {
        if (head == null) {
            head = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
        size++;
    }

    /**
     * Возвращает первый элемент стека. Удаляет элемент из стека.
     *
     * @return Данные из первого элемента стека. null, если стек пустой.
     */
    public T pop() {
        if (head == null)
            return null;
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Возвращает первый элемент стека. Не меняет стек.
     *
     * @return Данные из первого элемента стека. null, если стек пустой.
     */
    public T peek() {
        return (head == null) ? null : head.data;
    }

    public int getSize() {
        return size;
    }

    public class Node<D> {
        Node<D> next;
        D data;

        public Node(D data, Node<D> next) {
            this.next = next;
            this.data = data;
        }
    }
}
