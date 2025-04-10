package datastructures;

public class Stack<E> {

    private Node<E> head;
    private int size;
    private final int capacity;

    public Stack() {
        capacity = Integer.MAX_VALUE;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha vazia";
        }

        StringBuilder result = new StringBuilder();
        final Stack<E> temp = new Stack<>(capacity);
        while (!isEmpty()) {
            result.append(peek());
            if (head.getNext() != null) {
                result.append(", ");
            }
            temp.push(pop());
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }

        return result.toString();
    }

    public void push(E data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("A pilha está cheia");
        }

        final Node<E> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("A pilha está vazia");
        }

        final Node<E> removedData = head;
        head = head.getNext();
        removedData.setNext(null);
        size--;
        return removedData.getData();
    }

    public E pop(E data) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("A pilha está vazia");
        }

        final Stack<E> temp = new Stack<>(capacity);
        while (!isEmpty() && !head.getData().equals(data)) {
            temp.push(pop());
        }

        if (isEmpty()) {
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            throw new IndexOutOfBoundsException("Elemento não encontrado na pilha");
        }

        E removedData = pop();

        while (!temp.isEmpty()) {
            push(temp.pop());
        }

        return removedData;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }
}
