public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        if(tail == null) {
            tail = node;
        }
        if(head != null) {
            head.previous = node;
        }
        node.previous = null;
        head = node;
        size++;
    }
    public Node getNode(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void insertLast(int value) {
        if(tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        node.previous = tail;
        tail = node;
        tail.next = null;
        size++;
    }
    public void insert(int index, int value) {
        if(index < 0 || index > size) {
            System.out.println("Index out of bounds.");
        }
        if(index ==  0) {
            insertFirst(value);
            return;
        }
        if(index == size) {
            insertLast(value);
            return;
        }
        Node node = new Node(value);
        Node nextNode = getNode(index);
        node.previous = nextNode.previous;
        nextNode.previous.next =  node;
        node.next = nextNode;
        nextNode.previous =  node;
        size++;
    }
    public void deleteFirst() {
        int value = head.value;
        if(head == null) {
            System.out.println("Nothing to delete, insert elements first.");
        }
        else {
            head = head.next;
            head.previous = null;
            size--;
            System.out.println("Node with the value of " + value + " has been successfully deleted!");
        }
    }
    public void deleteLast() {
        int value = tail.value;
        tail =  tail.previous;
        tail.next = null;
        size--;
        System.out.println("Node with the value of " + value + " has been successfully deleted");
    }
    public void delete(int index) {
        if(index < 0 || index > size-1) {
            System.out.println("Index out of bounds. Please enter a valid index");
            return;
        }
        if(index == 0) {
            deleteFirst();
            return;
        }
        if(index == size-1) {
            deleteLast();
            return;
        }
        Node node = getNode(index);
        int value = node.value;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
        System.out.println("Node with the value of " + value + " has been successfully deleted");
    }
    public void display() {
        Node node = head;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }
    public int previousNode(int value) {
        Node node = head;
        while(node != null) {
            if(node.value == value) {
                return node.previous.value;
            }
            node = node.next;
        }
        return -1;
    }
    private class Node {
        private int value;
        private Node previous;
        private Node next;

        public Node(int value) {
            this.value =  value;
        }
        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
