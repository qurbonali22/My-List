public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyArrayList<Integer>  myArray = new MyArrayList<>();
        myArray.add(10);
        myArray.add(89);
        myArray.add(41);
        myArray.add(55);
        myArray.add(15);
        myArray.printAll();
        System.out.println("-----------");
//        myArray.add(1, 12);
//        myArray.add(1, 12);
//        myArray.printAll();
//        System.out.println("-----------");
//        myArray.add(0, 1);
//        myArray.add(0, 1);
//        myArray.addLast(45);
//        myArray.addLast(45);
//        myArray.printAll();
//        myArray.set(12,4);
//        myArray.printAll();
        System.out.println("myArray.remove(1) = " + myArray.remove(3));
        myArray.printAll();
        System.out.println("----------");
        myArray.add(120);
        myArray.printAll();
        Integer integer = 15;
        myArray.removeLast();
        myArray.remove(integer);
        myArray.printAll();

        System.out.println("7777777777777777777");
        for (Integer integer1:myArray){
            System.out.println(integer1);

        }
        System.out.println(myArray);
    }
}