public class MyLinkedListQueu<T> {
    private MyLinkedList<T> queu = new MyLinkedList<>();

    public void insert(T item){
        queu.insertLast(item);
    }

    public T remove(){
        return queu.removeFirst();
    }

    public int size(){
        return queu.size();
    }

    public boolean isEmpty(){
        return queu.isEmpty();
    }
}
