public class StringExercise {
    public static void main(String args[]){
        char data[] = {'R','i','n','g','o'}; // No double quotes for chars
        String drummer = new String(data);
        String drummer2 = "Rin" + "go";

        //Compare them using == vs equals method

        System.out.println("\n== Compare them using == vs equals method ==");
        System.out.println(drummer + " VS " + drummer2);

        if(drummer == drummer2) {
            System.out.println("==: Both are equal objects.");
        }
        if(drummer.equals(drummer2)) {
            System.out.println("equals(): Both are equal values.");
        }

        //Replace the R for B

        System.out.println("\n== Replace the R for B ==");
        String newdrummer = drummer.replace('R', 'B');
        System.out.println(newdrummer);

        //Find out if the string starts with “Bing”

        System.out.println("\n== If the string starts with “Bing” ==");
        System.out.println(drummer+ ": " + Boolean.toString(drummer.startsWith("Bing")));
        System.out.println(newdrummer+ ": " + Boolean.toString(newdrummer.startsWith("Bing")));

        //Get the last 4 characters as a string

        System.out.println("\n== Get the last 4 characters as a string ==");
        System.out.println(drummer.substring(drummer.length() - 4));

        //Remove trailing spaces 

        System.out.println("\n== Remove trailing spaces ==");
        System.out.println(drummer.trim());

        //Reverse the string

        System.out.println("\n== Reverse the string ==");
        String title = "Strawberry Fields Forever";
        String reverse = new StringBuffer(title).reverse().toString();
        System.out.println(reverse);
    }
}

