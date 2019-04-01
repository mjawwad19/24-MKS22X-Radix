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
    System.out.println("Positive Bucket" + bucketsPos);
    System.out.println(" Negative Bucket" + bucketsNeg);
  }

  private static int maxD(int[] data) {
    int max = 0;
    for (int i: data) {
      int temp = i;
      int count = 0;
      while (temp != 0) {
        count++;
        temp = temp/10;
      }
      if (count > max) max = count;
    }
    return max;
  }


  public static void main(String[] args) {
    int[] arya = {2, 12, -256, 2000, 4};
    int[] aryb = {2, 12, -256, 2000, 4, -1953525};
    System.out.println(maxD(arya)); //4
    System.out.println(maxD(aryb)); //7
  }
}
