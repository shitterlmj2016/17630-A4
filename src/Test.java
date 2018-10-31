import java.util.Scanner;

public class Test {

    static Heap print(Heap heap) {
        Heap clone = new Heap();
        int index = 0;
        while (heap.size() != 0) {
            index++;
            Job t = heap.pop();
            System.out.println(index + ": " + t.getName() + " Priority: " + t.getPriority());
            clone.addItem(t);
        }
        return clone;
    }

    static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

//    static boolean isSpace(String str) {
//        for (int i = str.length(); --i >= 0; ) {
//            if (str.charAt(i) != ' ') {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String argv[]) {
        Heap heap = new Heap();             // Heap Object
        Termio UserInput = new Termio();    // Termio IO Object
        boolean Done = false;                // Main loop flag
        String Option = null;                // Menu choice from user


        while (!Done) {
            // Here we present the main menu

            System.out.println("\n\n\n\n");
            System.out.println("Priority Queue Console: \n");
            System.out.println("1: Create a priority queue from a file");
            System.out.println("2: Add an item to the queue");
            System.out.println("3: Remove the next priority item to process from the queue");
            System.out.println("4: Delete a job from the queue by job name");
            System.out.println("5: Print the contents of the queue from highest to least to highest priority");
            System.out.println("6: Print the number of elements in the queue");
            System.out.println("X: Exit\n");
            System.out.print("\n>>>> ");
            Option = UserInput.KeyboardReadString();

            //////////// option 1 ////////////

            if (Option.equals("1")) {
                System.out.print("Option 1");
            }

            //////////// option 2 ////////////

            // Just print the list

            if (Option.equals("2")) {
//                    Job item=new Job();
                Scanner sc = new Scanner(System.in);
                System.out.println("Please input the job's name:");
                String name = sc.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Empty input!");
                    continue;
                }

//                    item.setName(name);
                System.out.println("The name is " + name);

                System.out.println("Please input the job's priority:");
                String priority = UserInput.KeyboardReadString();
                if (!isNumeric(priority)) {
                    System.out.println("Illegal input!");
                    continue;
                }
                int numPriority = Integer.valueOf(priority).intValue();
                System.out.println("The number is" + numPriority);
                if (numPriority < 0 || numPriority > 20) {
                    System.out.println("Illegal priority!");
                    continue;
                }
                System.out.println("Legal input!");

            } // if

            //////////// option 3 ////////////

            // Delete a node from the list by name

            if (Option.equals("3")) {

                System.out.println("Option 3");


            } // if

            //////////// option X ////////////

            // Exit

            if (Option.equalsIgnoreCase("X")) {
                Done = true;

            } // if

        } // while

    } // main
}
