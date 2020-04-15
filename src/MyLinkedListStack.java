public class MyLinkedListStack<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public void push(T item){
        stack.insertLast(item);
    }

    public T pop(){
        return stack.removeLast();
    }

    public T peek(){
        return stack.getLast();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
