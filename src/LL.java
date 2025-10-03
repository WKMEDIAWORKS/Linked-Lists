public class LL {

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }
    public void insertLast(int val) {
        if(tail == null)  {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 1; i  < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if(head == null) {
            tail =  null;
        }
        size--;
        return value;
    }
    public Node get(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;

    }
    public void delete(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        if(index < 1)  {
            deleteFirst();
            return;
        }
        if(index == size-1) {
            deleteLast();
            return;
        }
        Node lastNode = get(index-1);
        Node node = get(index);
        lastNode.next = node.next;
        size--;
        System.out.println("Node deleted successfully.");

    }
    public void printVal(int index) {
        Node node = get(index);
        System.out.println("The value of this Node = " + node.getValue());
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value =  value;
            this.next = next;
        }
        public int getValue(){
            return value;
        }
    }
}