import java.util.EmptyStackException;

public class Stack<T> {
    private T[] list;
    private int size; // количество элементов в стеке
    private final int CAPACITY = 10;

    public Stack(int capacity) {
        if(capacity <= 0 ){
            throw new IllegalArgumentException("invalid stack size");
        }
        list = (T[]) new Object[capacity];
    }

    public Stack() {
        list = (T[]) new Object[CAPACITY];
    }

    public void push(T item){
        if(isStackFull()){
            throw new StackOverflowError();
        }
        list[size] = item;
        size++;
    }

    public T pop(){
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek(){
        if(isStackEmpty()){
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    private boolean isStackFull(){
        return list.length == size; // равна ли ёмкость количеству элементов в стеке?
    }

    private boolean isStackEmpty(){
        return size == 0;
    }

    private void reCapacity(int _capacity){
        T[] tempList = (T[]) new Object[_capacity];
        System.arraycopy(list,0,tempList,0,size);
        list = tempList;
    }
}
