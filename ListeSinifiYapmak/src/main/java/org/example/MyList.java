package org.example;

public class MyList<T> {
    private T[] array;
    private int capacity;
    private int size=0;

    public MyList(){
        this.capacity=10;
        this.array = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity){
        this.capacity=capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public int size(){
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(T data){
        if(this.size == this.capacity){
            increaseCapacity();
        }
        this.array[this.size] = data;
        size++;
    }

    private void increaseCapacity() {
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[this.capacity];
        for(int i=0; i<this.size; i++){
            newArray[i] = this.array[i];
        }
        this.array=newArray;
    }

    public T get(int index){
        if(index<0 || index>this.size){
            return null;
        }
        return array[index];
    }

    public T remove(int index){
        if(index<0 || index>this.size){
            return null;
        }
        T removedData = array[index];
        for(int i = index; i<size-1; i++ ){
            array[i] = array[i+1];
        }
        array[size-1]=null;
        size--;
        return removedData;
    }

    public T set(int index, T data){
        if(index<0 || index>this.size) {
            return null;
        }
        T oldData = array[index];
        array[index] = data;
        return array[index];
    }

    public String toString(){
        if(size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                if (data == null) return i;
            } else if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == null) {
                if (data == null) return i;
            } else if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty (){
        return size == 0 ;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for(int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public void clear() {
        this.array =(T[]) new Object[this.capacity] ;
    }

    public MyList<T> subList(int start, int finish) {
        if(start < 0 || finish >= size || start > finish) {
            return null;
        }
        MyList<T> sublist = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}
