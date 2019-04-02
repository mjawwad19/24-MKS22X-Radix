import java.util.*;
public class Radix{
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    makeBuckets(buckets);
    int max = maxPlaces(data);
    for (int currPlace = 0; currPlace <= max; currPlace++) {
      sortPlace(data, currPlace, buckets);
      link(buckets);
      transfer(buckets[0], data);
      //System.out.println(Arrays.toString(data));
    }
  }
  //initializes bucket for each digit
  private static void makeBuckets(MyLinkedList<Integer>[] b) {
    for (int i = 0; i < 20; i++) {
      b[i] = new MyLinkedList<Integer>();
    }
  }
  //transfers a linked list values into data
  private static void transfer(MyLinkedList<Integer> bucket, int[] data) {
    int i = 0;
    while (bucket.size() != 0) {
      data[i] = bucket.removeFront();
      i++;
    }
  }
  //links up the filled buckets.
  private static void link(MyLinkedList<Integer>[] buckets) {
    for (int i = buckets.length - 2; i >= 0; i--) {
      buckets[i].extend(buckets[i+1]);
    }
  }
  //fill the appropriate list in buckets
  private static void sortPlace(int[] data, int place, MyLinkedList<Integer>[] buckets) {
    for (int num: data) {
      int dig = getDigit(num, place);
      //System.out.println(dig);
      if (num < 0) {
        buckets[9 - Math.abs(dig)].add(num);
      }
      else {
      buckets[10 + Math.abs(dig)].add(num);
      //System.out.println(buckets[dig]);
    }
    }
  }
  //gets the digit at a certain digit place
  private static int getDigit(int n, int place) {
    return (int)(n / Math.pow(10, place)) % 10;
  }
  //finds the longest number (most places) in an array
  private static int maxPlaces(int[] data) {
    int m = 0;
    for (int n: data) {
      /*int temp = n;
      int count = 0;
      while (temp != 0) {
        count++;
        temp = temp/10;
      }*/
      int count = ("" + Math.abs(n)).length();
      if (count > m) m = count;
    }
    return m;
  }

  /*public static void main(String[] args) {
    System.out.println(getDigit(123, 0)); //3
    System.out.println(getDigit(1234, 1)); //3
    System.out.println(getDigit(1234, 3)); //1
    int[] ary = {123, 1234, 12345, 123456, 14};
    System.out.println(maxPlaces(ary)); //6
    radixsort(ary);
    //System.out.println(Arrays.toString(ary));
    int[] aryb = {-2, 12, -24, 384, 120412, -214956, -12};
    //sorted should be -214956 -24, -12, -2, 12, 384, 120412}
    radixsort(aryb);
    System.out.println(Arrays.toString(aryb));
  }*/
}
