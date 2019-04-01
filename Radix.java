@SuppressWarnings({"unchecked", "rawtypes"})
public class Radix{
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] bucketsPos = new MyLinkedList[10];
    MyLinkedList<Integer>[] bucketsNeg = new MyLinkedList[10];
    for (int i = 0; i < 10; i++) {
      bucketsPos[i] = new MyLinkedList<Integer>();
      bucketsNeg[i] = new MyLinkedList<Integer>();
      //this via the diagram K showed me means there will be space for all @ current place that fall under the same number, i.e. 11/1/21 etc.
    }
  }


}
