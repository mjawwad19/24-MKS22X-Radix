import java.util.List;

public class MyLinkedList{
  private class Node {
  private Integer data;
  private Node next, prev;
  //create a Node given a value
  public Node(Integer value) {
    data = value;
  }
  //create a Node that specifies the reference (or none) of the previous and future node
  public Node(Integer value, Node nextNode, Node prevNode) {
    data = value;
    next = nextNode;
    prev = prevNode;
  }
  //Helping to see vals (we're gonna need this for toString too)
  public Integer getData() {
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
  public Integer setData(Integer i) {
    Integer temp = data;
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
    return ""+data;
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

  /*Returns a string containing all of the Integers in this list in reverse sequence.*/
  public String reverseString(){
    String out = "[";
    if (end == null) return "[]";
    Node curr = end;
    while (curr.prev() != null) {
      out+= curr +", ";
      curr = curr.prev();
    }
    out+= curr + "]";
    return out;
    }

  /*Returns the node at the specified position.
  *@param index is the specified position*/
  private Node getNthNode(int index){
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("" + index + "is not an index of the list");
    Node curr = start;
    int i = 0;
    while (i < index) { //could be a for loop but I have plans for this for binary searching later on...
      curr = curr.next();
      i++;
    }
    return curr;
  }

  /*Appends the specified Integer to the end of this list.
  *@param value is the Integer to be added.*/
  public boolean add(Integer value){
    Node n = new Node(value, null, end);
    if (end == null) start = n;
    else end.setNext(n);
    end = n;
    length++;
    return true;
  }

  /*Returns the Integer at the specified position in this list.
  *@param index is the specified position*/
  public Integer get(int index){
    return getNthNode(index).getData();
  }

  /*Replaces the Integer at the specified position in this list
  with the specified Integer.
  *@param index is the specified position
  *@param value is the Integer that will replace */
  public Integer set(int index, Integer value){
    Node mod = getNthNode(index); //I love it when I can keep reusing getNthNode
    Integer tempData = mod.getData();
    mod.setData(value);
    //utilizing Node's setData, we can change any node in the linkedList given an integer
    return tempData; //we MUST return the data before it was changed!
  }

  /*Returns true if this list contains the specified Integer
  *@param value is the specified Integer*/
  public boolean contains(Integer value){
    for (int i = 0; i < size(); i++) {
      if (getNthNode(i).getData().equals(value)) return true;
    }
    return false;
  }

  /*Returns the index of the first occurrence of the specified Integer in this list,
    or -1 if this list does not contain the Integer.
  *@param value is the specified Integer*/
  public int indexOf(Integer value){
    for (int i = 0; i < size(); i++) {
      if (getNthNode(i).getData().equals(value)) return i;
    }
    return -1;
  }

  /*Removes and returns the Integer at the specified position in this list.
  *@param index is the specified position*/
  public Integer remove(int index){
    if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
    Node temp = getNthNode(index);
    Node nex = temp.next();
    Node pre = temp.prev();
    if (index == 0) {
      //this is how you ecome the new start
      nex.setPrev(null);
      start = nex;
    }
    if (index == size() -1) {
      //this is how you become the new end!
      pre.setNext(null);
      end = pre;
    }
    else {
      nex.setPrev(pre);
      pre.setNext(nex);
    }
    length--; //majority of body was ported over from prev commit logic!
    return temp.getData();
  }

  /*Removes the specified integer from this list.
  - Returns true if successfully removed, false otherwise.
  *@param value is the Integer to be removed.*/
  public boolean remove(Integer value){
    //screw it i'm doing the work in remove index
    if (!contains(value)) return false;
    int index = indexOf(value);
    remove(index);
    return true;
  }

  /*Inserts the specified Integer at the specified position in this list.
  *@param index is the specified position
  *@param value is the specifed Integer to be inserted.*/
  public void add (int index, Integer value){
    if (index < 0 || index > size())
       throw new IndexOutOfBoundsException();
    Node temp;
    if (index == 0) {
      temp = new Node(value, start, null);
      start.setPrev(temp);
      start = temp;
      length++;
    }
    else if (index == size()) {
      add(value);
    }
    //the earlier two cases are simple enough
    else{
      Node curr = getNthNode(index);
      //this is the node at the index that will be shifted to the right once I add in
      Node prev = getNthNode(index -1);
      //this is the node that will link to the inserted after added node! currently linked to curr
      temp = new Node(value,getNthNode(index),getNthNode(index -1));
      getNthNode(index).setPrev(temp);
      getNthNode(index -1).setNext(temp);
      length++;
    }
  }

  /*Extends one Linked list by the other.
   //in 0(1) runtime, move the elements from other onto the end of This
   // The size of other is reduced to 0
   // the size of this is now the combined sizes of both original lists
  *@param other is the other LinkedList*/
  public void extend(MyLinkedList other) {
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
