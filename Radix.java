public class Radix{
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new MyLinkedList<Integer>();
      //this via the diagram K showed me means there will be space for all @ current place that fall under the same number, i.e. 11/1/21 etc.
    }
  }
  //gets the digit at a certain digit place
  public static int getDigit(int n, int place) {
    return (int)(n / Math.pow(10, place)) % 10;
  }

  public static void main(String[] args) {
    System.out.println(getDigit(123, 0)); //3
    System.out.println(getDigit(1234, 1)); //3
    System.out.println(getDigit(1234, 3)); //1
  }


}
