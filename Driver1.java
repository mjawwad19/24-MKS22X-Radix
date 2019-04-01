public class Driver1{
    public static void main(String[] args) {
        //What's poppin' everybody, welcome to my driver, we chill here in the code house
        //Let's test this class and get this bread

        //Step One: Creating a valid Instance
        System.out.println("New Instance Test:\n");
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        System.out.println(list);
        System.out.println("This should print: \"[]\"\n");

        //Step Two: Let's add some values
        System.out.println("Adding Values Test:\n");
        for(int i = 0; i < 10; i++) {
            list.add(i);
            //System.out.println(list.size()); <- Debugging
        }
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");


        //Step Seven: Testing the Size Method
        System.out.println("Size Test: \n");
        System.out.println(list.size());
        System.out.println("This should print: 10");

        //Step Ten: Testing Extend method
        MyLinkedList list2 = new MyLinkedList();
        for (int i = 0; i <5; i++) {
          list2.add(i*2);
        }
        //System.out.println(list2); //[0, 2, 4, 6, 8]
        list.extend(list2);
        System.out.println(list);
        System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 2, 4, 6, 8]\"");
        System.out.println(list.size());
        System.out.println("This should print: 15");
        System.out.println(list2);
        System.out.println("This should print: \"[]\"");
        System.out.println(list2.size());
        System.out.println("This should print: 0");
    }
}
