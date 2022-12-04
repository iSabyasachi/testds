package testds.freq;
import java.util.*;
class Node<E>{
    E ele;
    Node<E> left;
    Node<E> right;
    Node<E> root;

    public Node(E ele){
        this.ele = ele;
        this.left = null;
        this.right = null;
    }

    public static <E> void inorderTraversal(Node<E> root){
        if(root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.ele+" ");
        inorderTraversal(root.right);
    }
    public static <E> boolean isSymmetric(Node<E> root){
        return isSymmetric(root.left, root.right);
    }
    private static <E> boolean isSymmetric(Node<E> first, Node<E> second){
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;

        return (first.ele == second.ele 
                && isSymmetric(first.left, second.right) 
                && isSymmetric(first.right, second.left));
    }
}
public class SymmetricTree{
    
    public static void main(String[] args){
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(4);
        root.right.right = new Node<>(4);
        
        Node.inorderTraversal(root);
        System.out.println("");
        boolean isSymmetric = Node.isSymmetric(root);
        System.out.println("isSymmetric "+isSymmetric);
    }
}