public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        //in case of a circular linked list, if the head is null, what we are going to do is assign head as node as well as tail equal to node.
        if(head == null)  {
            head = node;
            tail = node;
        }
        //if the head is not equal to null, meaning a value is already assigned. We have to follow the same approach in this case as well, the only  difference being that the tail pointer should be pointing towards the head node in this case.
        else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if(tail == null ) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }
    public Node getNode(int index){
        Node node = head;
        for(int i = 0; i < size; i++) {
            if(i == index-1) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int value, int index) {
        if(index < 0 || index >  size) {
            System.out.println("Index out of bounds!");
            return;
        }
        if(index == 0) {
            insertFirst(value);
            return;
        }
        if(index == size) {
            insertLast(value);
            return;
        }

        Node node = new Node(value);
        Node previous = getNode(index);
        Node next = previous.next;
        previous.next = node;
        node.next = next;
    }
    public void deleteFirst()  {
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }
    public void deleteLast() {
        if(tail ==  null) {
            head = null;
            tail = null;
        }
        Node prev = getNode(size-1);
        prev.next = head;
        size--;
    }
    public void delete(int index) {
        if(index == 0) {
            deleteFirst();
            return;
        }
        if(index == size) {
            deleteLast();
            return;
        }
        Node currentNode = getNode(index);
        Node previousNode = getNode(index - 1);
        previousNode.next = currentNode.next;
        size--;
    }
    public void display() {
        Node node = head;
        for(int i = 0; i < size; i++) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }
    public void getNextToTail() {
        System.out.println(tail.next.value);
    }

    //firstly we will create the node class with properties not any different than a singly linkedlist's node.
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
