public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        System.out.println("List is empty: " + myList.isEmpty());
        System.out.println("Initial list capacity: " + myList.getCapacity());

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        System.out.println("List size: " + myList.size());
        System.out.println("List capacity: " + myList.getCapacity());
        System.out.println("List elements: " + myList.toString());

        myList.remove(1);
        System.out.println("After removing element at index 1: " + myList.toString());

        myList.set(2, 100);
        System.out.println("After setting element at index 2 to 100: " + myList.toString());

        System.out.println("Element at index 3: " + myList.get(3));
        System.out.println("Element at index 100 (out of range): " + myList.get(100));

        System.out.println("Index of 30: " + myList.indexOf(30));
        System.out.println("Last index of 30: " + myList.lastIndexOf(30));

        System.out.println("List contains 100: " + myList.contains(100));
        System.out.println("List contains 200: " + myList.contains(200));

        myList.clear();
        System.out.println("After clearing the list: " + myList.toString());
    }
}
