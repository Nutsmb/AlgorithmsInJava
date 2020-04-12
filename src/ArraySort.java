public class ArraySort {

    private double array[];

    public ArraySort(int n){
        this.array = new double[n];
    }

    public void printArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", array[i]);
        }
    }

    public void arrayRandom(int r){
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random()*r;
        }
    }

    public void addArrayItem(int position, double volume){
        double[] arr = new double[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        array = new double[array.length + 1];
        System.arraycopy(arr,0,array,0,position);
        array[position] = volume;
        System.arraycopy(arr,position,array,position+1,arr.length-position);
    }

    public void add(double volume){
        addArrayItem(this.array.length,volume);
    }

    public void deleteArrayItem(int position){
        double[] arr = new double[array.length];
        System.arraycopy(array, 0, arr, 0, arr.length);
        array = new double[array.length - 1];
        System.arraycopy(arr,0,array,0,position);
        System.arraycopy(arr,position+1,array,position,array.length-position);
    }

    public void deleteArrayItem(double vol){
        int i = 0;
        for (; i < array.length; i++) {
            if(array[i] == vol){
                deleteArrayItem(i);
                i--;
                //break; //закомментировать строку, если надо удалять дубликаты, иначе удаляем первое совпадение
            }
        }
    }

    public int searchArrayItem(double vol){
        int i = 0;
        for (; i < array.length; i++) {
            if(array[i] == vol){
                break;
            }
        }
        return i;
    }

    public void bubbleSort(){
        double tmp;
        boolean isSorted = false;

        while (!isSorted){
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if(array[i] < array[i-1]){
                    tmp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = tmp;
                    isSorted = false;
                }
            }
        }
    }

    public void selectionSort(){

        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                double tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    public void insertSort(){
        for (int i = 1; i < array.length; i++) {
            double current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        int pos = 3;
        double vol = 4.32;
        ArraySort mass = new ArraySort(n);
        mass.arrayRandom(15);
        mass.printArray();
        System.out.println();

        mass.add(vol);
        mass.printArray();
        System.out.println();

        mass.addArrayItem(pos,vol);
        mass.printArray();
        System.out.println();

        System.out.println(mass.searchArrayItem(vol));

        mass.deleteArrayItem(pos-1);
        mass.printArray();
        System.out.println();

        mass.deleteArrayItem(vol);
        mass.printArray();
        System.out.println();

        long start = System.currentTimeMillis();
        //mass.bubbleSort();
        //mass.selectionSort();
        mass.insertSort();
        long finish = System.currentTimeMillis();
        System.out.println();
        System.out.println(finish - start);
    }
}
