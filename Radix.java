import java.util.*;
public class Radix{
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }

    int max = maxPlaces(data);
    for (int currPlace = 0; currPlace < max; currPlace++) {
    //while (currPlace <= max) {
      //fill the appropriate list in buckets
      for (int num: data) {
        int dig = getDigit(num, currPlace);
        //System.out.println(dig);
        buckets[dig].add(num);
        //System.out.println(buckets[dig]);
      }
      //links up the filled buckets.
      for (int i = buckets.length - 2; i >= 0; i--) {
        buckets[i].extend(buckets[i+1]);
      }
      //System.out.println(buckets[0]); //after first pass shows: 123, 1234, 14, 12345, 123456 correctly so linking is done
      transfer(buckets[0], data);
      System.out.println(Arrays.toString(data));
    }
  }
  
  private static void transfer(MyLinkedList<Integer> bucket, int[] data) {
    int i = 0;
    while (bucket.size() != 0) {
      data[i] = bucket.removeFront();
      i++;
    }
  }
  //gets the digit at a certain digit place
  public static int getDigit(int n, int place) {
    return (int)(n / Math.pow(10, place)) % 10;
  }
  //finds the longest number (most places) in an array
  public static int maxPlaces(int[] data) {
    int m = 0;
    for (int n: data) {
      int temp = n;
      int count = 0;
      while (temp != 0) {
        count++;
        temp = temp/10;
      }
      if (count > m) m = count;
    }
    return m;
  }

  public static void main(String[] args) {
    System.out.println(getDigit(123, 0)); //3
    System.out.println(getDigit(1234, 1)); //3
    System.out.println(getDigit(1234, 3)); //1
    int[] ary = {123, 1234, 12345, 123456, 14};
    System.out.println(maxPlaces(ary)); //6
    radixsort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
