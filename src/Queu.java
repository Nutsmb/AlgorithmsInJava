import java.util.EmptyStackException;

public class Queu<T> {
    private T[] list;
    private int size = 0; // количество элементов в очереди
    private final int CAPACITY = 10;

    private int start;
    private int end;

    public Queu(int capacity) {
        if(capacity <= 0 ){
            throw new IllegalArgumentException("invalid queu size");
        }
        list = (T[]) new Object[capacity];
        start = 0;
        end = 0;
    }

    public Queu() {
        list = (T[]) new Object[CAPACITY];
        start = 0;
        end = 0;
    }

    public void insert  (T item){
        if(isQueuFull()){
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove(){
        T temp = peekFront();
        size--;
        list[start] = null;
        start = nextIndex(start);
        return temp;
    }

    public T peekFront(){
        if(isQueuEmpty()){
            throw new EmptyStackException();
        }
        return list[start];
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
}
