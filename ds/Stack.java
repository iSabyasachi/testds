package testds.ds;

import java.util.*;
public class Stack<E>{
    E ele;
    E[] elements;
    int size;

    private static final int DEFAULT_INITIAL_SIZE = 4;
    
    @SuppressWarnings("unchecked")
    public Stack(){
        elements = (E[])new Object[DEFAULT_INITIAL_SIZE];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0) throw new EmptyStackException();

        E e = elements[--size];
        elements[size] = null;
        return e;
    }
    public int size(){
        return size;
    }

    private void ensureCapacity(){
        if(size < elements.length) return;        
        elements = Arrays.copyOf(elements, 2 * size + 1);
    }
    public void print(){
        System.out.println(Arrays.toString(elements));
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print();

        stack.push(4);
        stack.push(5);

        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();

    }
}