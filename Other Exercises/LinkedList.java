public class LinkedList {
    private String name;
    private LinkedList next;

    public LinkedList(String n) {
        this.name = n;
    }


//add(String new_word): Adds a linkedlist item at the end of the linkedlist
    public void add(String new_word) {
        LinkedList i = this;

        while (i.next != null) {
            i = i.next;
        }
        i.next = new LinkedList(new_word);
    }


//print(): Prints all the words inside of the linkedlist
    public void print() {
        LinkedList i = this;

        System.out.print("LinkedList: ");
        while (i.next != null) {
            System.out.print(i.name + ' ');
            i = i.next;
        }
        System.out.print(i.name);
    }


//length(): Returns an int with the length of items in the linkedlist
    public int length() {
        int ret_val = 1;
        LinkedList i = this;

        while (i.next != null) {
            i = i.next;
            ret_val++;
        }
        return ret_val;
    }


//itemAt(int index): returns LinkedList item at the index in the linkedlist
    public String itemAt(int index) {
        int counter = 1;
        LinkedList i = this;

        while (i.next != null && counter < index) {
            i = i.next;
            counter++;
        }
        return i.name;
    }


//remove(int index): removes item at specified index
    public void remove(int index) {
        int counter = 1;
        LinkedList i = this;

        if (index == 1) {
            i.name = "" ;
            i = i.next;
            return;
        }

        while (i.next != null && counter < index-1) {
            i = i.next;
            counter++;
        }
        if (i == null || i.next == null) {
            return;
        }
        i.next = i.next.next;
    }


//Test methods
    public static void main(String[] args) {
        LinkedList student_list = new LinkedList("12");
        //adds a linked list item at the end of the linked list
        student_list.add("7");
        student_list.add("20");
        student_list.add("40");
        student_list.add("9");

        //Print out the linked list
        student_list.print();

        //the length of items in the linked list
        System.out.println("\nLength: " + student_list.length());

        //returns the first item of the linked list
        System.out.println("Item 1: " + student_list.itemAt(1));
        //returns the third item of the linked list
        System.out.println("Item 3: " + student_list.itemAt(3));

        //remove the second item of the linked list
        student_list.remove(2);

        //Print out the linked list after removing
        System.out.print("After removing: ");
        student_list.print();

        //the length of items in the removed linked list
        System.out.println("\nLength: " + student_list.length());
        //returns the second item of the removed linked list
        System.out.println("Item 2: " + student_list.itemAt(2));

    }

}
