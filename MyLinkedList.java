import java.util.List;
import java.util.*;

public class MyLinkedList<E>{
  private class Node {
    private E data;
    private Node next, prev;
    //create a Node given a value
    public Node(E value) {
      data = value;
    }
    //create a Node that specifies the reference (or none) of the previous and future node
    public Node(E value, Node nextNode, Node prevNode) {
      data = value;
      next = nextNode;
      prev = prevNode;
    }
    //Helping to see vals (we're gonna need this for toString too)
    public E getData() {
      return data;
    }
    //this only falls into place cuz everything is private
    public Node next() {
      return next;
    }
    //same
    public Node prev() {
      return prev;
    }
    public E setData(E i) {
      E temp = data;
      data = i;
      return temp;
    }
    public void setNext(Node other) {
      next = other;
    }
    public void setPrev(Node other) {
      prev = other;
    }
    public String toString() {
      return ""+data.toString();
    }

  }
  private int length;
  private Node start,end;

  /*Constructs an empty list*/
  public MyLinkedList() {
    length = 0;

  }

  /*Returns the number of Integers in tis list.*/
  public int size() {
    return length;
  }

  /*Returns a string containing all of the Integers in this list in proper sequence
  (from first to last Integer)*/
  public String toString(){
    String out = "[";
    if (start == null) return "[]";
    Node curr = start;
    while (curr.next() != null) {
      //just so we can keep going through each node!
      out+=curr + ", ";
      curr = curr.next();
      //we needda keep updating!
    }
    out+= curr + "]";
    return out;
  }

  public void clear() {
    length = 0;
    start = null;
    end = null;
  }

  /*Appends the specified Integer to the end of this list.
  *@param value is the Integer to be added.*/
  public boolean add(E value){
    Node n = new Node(value, null, end);
    if (end == null) start = n;
    else end.setNext(n);
    end = n;
    length++;
    return true;
  }
  /* remove the 1st element of the list, and return that value.*/
  public E removeFront() {
    if (size() == 0) throw new NoSuchElementException();
    E temp = start.getData();
    if (size() ==1) {
      clear();
      return temp;
    }
    start = start.next();
    start.setPrev(null);
    length--;
    return temp;
  }

  /*Extends one Linked list by the other.
   //in 0(1) runtime, move the elements from other onto the end of This
   // The size of other is reduced to 0
   // the size of this is now the combined sizes of both original lists
  *@param other is the other LinkedList*/
  public void extend(MyLinkedList<E> other) {
    if (length == 0) start = other.start; // worse case scenario, this is empty
    else if (other.length == 0) other.end = end; // same cases
    else {
      end.setNext(other.start); // connect the two into this
      other.start.setPrev(end); // make sure to link it back!
    }
    end = other.end; //make sure this.end is now at the end of other!
    length += other.length;
    other.length = 0;
    other.start = null;
    other.end = null; //make other empty afterwards!
  }
}
