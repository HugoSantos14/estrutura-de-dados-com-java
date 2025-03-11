package structures;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "Lista vazia";
        }

        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }

        return result.toString();
    }

    public void addFirst(E data) {
        final Node<E> temp = new Node<E>(data);
        
        if (isEmpty()) {
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
        }
        head = temp;
        size++;
    }

    public void addLast(E data) {
        Node<E> temp = new Node<E>(data);
        
        if (isEmpty()) {
            head = temp;
        } else {
            temp.setPrev(tail);
            tail.setNext(temp);
        }
        tail = temp;
        size++;
    }

    public void add(E data, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Índice não encontrado: " + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<E> current = head;
        int i = 1;
        while (current != null && i < index) {
            current = current.getNext();
            i++;
        }

        if (current == null) {
            addLast(data);
        } else {
            final Node<E> newNode = new Node<>(data);
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }

    public void printByTail() {
        Node<E> current = tail;

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
    
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node<E> temp = head;
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
        size--;
    }
    
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        
        Node<E> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        size--;
    }

    public void delete(int index) {
        if (isEmpty()) {
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node<E> current = head;
        int count = 0;
        
        //Navega até o nó na posição especificada.
        while (current != null && count != index) {
            current = current.getNext();
            count++;
        }
        
        // Verifica se a posição é válida.
        if (current == null) {
            System.err.println("Posição errada.");
            return;
        }
        
        if (current == tail) {
            deleteLast();
            return;
        }
        
        deleteNode(current);
    }
    
    private void deleteNode(Node<E> node) {
        if (node == null) {
            return;
        }

        // Ajusta os ponteiros para remover o nó da lista
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext()); // O nó anterior aponta para o próximo nó
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev()); // O próximo nó aponta para o nó anterior
        }

        // Desconecta o nó removido da lista
        node.setPrev(null);
        node.setNext(null);
        size--;
    }

    // Exercício 1
    public void deleteMonths() {
        Node<E> current = head;

        while (current != null) {
            Node<E> nextNode = current.getNext();

            if (current.getData().toString().length() < 5) {
                if (current == head) {
                    deleteFirst();
                } else if (current == tail) {
                    deleteLast();
                } else {
                    deleteNode(current);
                }
            }

            current = nextNode;
        }
    }

    // Exercício 2 (incompleto)
    public int sumElements() {
        if (head == null) {
            return 0;
        }
        if (!(head.getData() instanceof Integer)) {
            return 0;
        }

        int sum = 0;
        Node<E> current = head;

        while (current != null) {
            sum += (int) current.getData();
            current = current.getNext();
        }

        return sum;
    }

    // Exercício 3
    public void bubbleSortDates() {

    }
}
