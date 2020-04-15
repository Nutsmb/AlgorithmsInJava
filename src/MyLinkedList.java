public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private int size = 0;

    class Node<T> {
        private T value;
        private Node next;
        private Node prev;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }
    }

    public MyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) last.value;
    }

    public boolean contains(T item){
        return indexOf(item) > -1;
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
            newNode.setNext(first);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
        }
        last = newNode;
        size++;
    }

    public void insert(T item, int index){
        if(index <= 0){
            insertFirst(item);
            return;
        }
        if(index > size){
            insertLast(item);
            return;
        }
        Node newNode = new Node(item);
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next.setPrev(newNode);
        current.setNext(newNode);
        newNode.setPrev(current);
        newNode.setNext(current.next);
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node temp = first;
        first = first.next;
        size--;
        if(isEmpty()){
            last = null;
        }
        else {
            first.setPrev(null);
        }
        return (T) temp.getValue();
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node temp = last;
        last = last.prev;
        size--;
        if(isEmpty()){
            first = null;
        }
        else {
            last.setNext(null);
        }
        return (T) temp.getValue();
    }

    public boolean remove(int index){
        if (isEmpty()) {
            return false;
        }
        if(index <= 0){
            removeFirst();
            return true;
        }
        if(index > size){
            removeLast();
            return true;
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.getPrev().setNext(current.next);
        current.next.setPrev(current.getPrev());
        size--;
        return true;
    }

    public boolean remove(T item){
        if (isEmpty()) {
            return false;
        }
        if(last.getValue().equals(item)){
            removeLast();
            return true;
        }
        Node current = first;
        while (current != null && !current.getValue().equals(item)){
            current = current.next;
        }
        if(current == null){
            return false;
        }
        current.getPrev().setNext(current.next);
        current.next.setPrev(current.getPrev());
        size--;
        return true;
    }

    public String toString(){
        Node temp = first;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null){
            stringBuilder.append(temp.value + ", ");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    public int indexOf(T item){
        Node temp = first;
        int index = 0;
        while (temp != null){
            if(temp.getValue().equals(item)){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
    }
}
