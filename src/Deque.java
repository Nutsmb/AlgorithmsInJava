import java.util.EmptyStackException;

public class Deque<T> {
    private T[] list;
    private int size = 0; // количество элементов в очереди
    private final int CAPACITY = 10;

    private int start;
    private int end;

    public Deque(int capacity) {
        if(capacity <= 0 ){
            throw new IllegalArgumentException("invalid queu size");
        }
        list = (T[]) new Object[capacity];
        start = 0;
        end = 0;
    }

    public Deque() {
        list = (T[]) new Object[CAPACITY];
        start = 0;
        end = 0;
    }

    public void insertFirst  (T item){
        if(start == 0) {
            T[] tempList = (T[]) new Object[list.length + 1];
            System.arraycopy(list,0,tempList,1,size);
            list = tempList;
            end = nextIndex(end);
        }
        else{
            start -= 1;
        }
        list[start] = item;
        size++;
    }

    public void insertLast  (T item){
        if(isQueuFull()){
            throw new StackOverflowError();
        }
        list[end] = item;
        end = nextIndex(end);
        size++;
    }

    public T peekLast(){
        if(isQueuEmpty()){
            throw new EmptyStackException();
        }
        return list[end - 1];
    }

    public T peekFirst(){
        if(isQueuEmpty()){
            throw new EmptyStackException();
        }
        return list[start];
    }

    public void removeFirst(){
        size--;
        list[start] = null;
        start = nextIndex(start);
    }

    public void removeLast(){
        size--;
        end--;
        list[end] = null;
    }

    private boolean isQueuFull(){
        return list.length == size; // равна ли ёмкость количеству элементов в очереди?
    }

    private boolean isQueuEmpty(){
        return size == 0;
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    public int size(){
        return size;
    }

    public T getItem(int n){
        if(isQueuEmpty()){
            throw new EmptyStackException();
        }
        return list[n];
    }
}