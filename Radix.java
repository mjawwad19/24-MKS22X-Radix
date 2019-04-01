public class Radix{
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void radixsort(int[] data) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 10; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }

    int max = maxPlaces(data);
    int currPlace = 0;
    while (currPlace != max) {
      //fill the appropriate list in buckets
      for (int num: data) {
        int dig = getDigit(num, currPlace);
        if (num < 0) buckets[9 - dig].add(num); //for negative
        else buckets[10 + dig].add(num); //for positive
      }

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
    int[] ary = {123, 1234, 12345, 123456};
    System.out.println(maxPlaces(ary)); //6
    //radixsort(ary);
  }


}
