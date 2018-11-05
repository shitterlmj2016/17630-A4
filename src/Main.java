
//17630-A4 Priority Queue
//Andrew ID: xinchenh
//Name: Xincheng Huang
//Main Class
//This class provides the user interface
import java.io.*;
import java.util.Scanner;
public class Main {

    //Print the given heap
    static Heap print(Heap heap) {
        if (heap.isEmpty()) {
            System.out.println("The queue is empty!");
            return heap;
        }
        Heap clone = new Heap();
        System.out.println("There are " + heap.size() + " jobs(s) in the queue:");
        int index = 0;
        while (!heap.isEmpty()) {
            index++;
            Job t = heap.pop();
            System.out.println(index + ": Name: " + t.getName() + ", Priority: " + t.getPriority());
            clone.addItem(t);
        }
        return clone;
    }
//This function checks if a string is a integer number
    static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String argv[]) {
        Heap heap = new Heap();             // Heap Object
        Termio UserInput = new Termio();    // Termio IO Object
        boolean Done = false;                // Test loop flag
        String Option = null;                // Menu choice from user

        //Modify from the provided demo code
        while (!Done) {
            // Here we present the main menu

            System.out.println("\n\n");
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
                Job item = new Job();
                System.out.println("Please input the file path: ");
                System.out.println("Example: C:\\Users\\xchuang1995\\Desktop\\jobs.txt");
                //Scan the input string
                Scanner sc = new Scanner(System.in);
                System.out.print("\n>>>> ");
                String address = sc.nextLine();
                if (address.isEmpty()) {
                    System.out.println("Empty input! Please try again!");
                    continue;
                }


                //IO section
                FileInputStream fis = null;
                InputStreamReader isr = null;
                BufferedReader br = null; //Buffer
                try {
                    String str = "";
                    fis = new FileInputStream(address);// FileInputStream
                    isr = new InputStreamReader(fis);// InputStreamReader
                    br = new BufferedReader(isr);// BufferedReader
                    int count = 0;
                    //Check if user's input is legal
                    while ((str = br.readLine()) != null) {

                        String temp[] = str.split(":");
                        if (temp.length != 2) {
                            System.out.println("Illegal input!");
                            break;
                        }

                        if (!isNumeric(temp[1])) {
                            System.out.println("Illegal input!");
                            break;
                        }
                        count++;
                        System.out.println(count + ": " + "Name: " + temp[0] + " Priority: " + temp[1]);
                        item.setName(temp[0]);
                        //Convert from string to integer
                        item.setPriority(Integer.valueOf(temp[1]).intValue());
                        heap.addItem(item);
                    }
                    System.out.println(count + " job(s) added to the queue, there are " + heap.size() + " jobs in total.");
                } catch (FileNotFoundException e) {
                    System.out.println("File is not found!");
                    continue;
                } catch (IOException e) {
                    System.out.println("Reading Errors!");
                }
                try {
                    br.close();
                    isr.close();
                    fis.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }


            }

            //////////// option 2 ////////////

            // Just print the list

            if (Option.equals("2")) {
                Job item = new Job();
                Scanner sc = new Scanner(System.in);
                //Getting input from the keyboard
                System.out.println("Please input the job's name:");
                System.out.print("\n>>>> ");
                String name = sc.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Empty input! Please try again!");
                    continue;
                }

                item.setName(name);
                System.out.println("The name is " + name + ".");
                System.out.println("Please input the job's priority (0-20):");
                System.out.print("\n>>>> ");
                String priority = UserInput.KeyboardReadString();
                //Check if the input number is legal
                if (!isNumeric(priority)) {
                    System.out.println("Illegal input!");
                    continue;
                }
                int numPriority = Integer.valueOf(priority).intValue();
                System.out.println("The priority is " + numPriority + ".");
                if (numPriority < 0 || numPriority > 20) {
                    System.out.println("Illegal priority! The priority should be between 0 and 20");
                    continue;
                }
                item.setPriority(numPriority);
                heap.addItem(item);
                System.out.println("Job is added to the queue successfully!");

            } // if

            //////////// option 3 ////////////

            // Remove the next priority item to process from the queue
            if (Option.equals("3")) {

                if (heap.isEmpty()) {
                    System.out.println("The queue is empty!");
                    continue;
                }

                heap.popInfo();

            } // if


            //////////// option 4 ////////////

            // Delete a job from the queue by name

            if (Option.equals("4")) {
                if (heap.isEmpty()) {
                    System.out.println("The queue is empty!");
                    continue;
                }
                Scanner sc = new Scanner(System.in);
                System.out.println("Please input the job's name:");
                System.out.print("\n>>>> ");
                String name = sc.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Empty input! Please try again!");
                    continue;
                }
                heap.delete(name);


            }

            //Print the heap based on priority
            if (Option.equals("5")) {
                heap = print(heap);
            }

            //Print the heap's size
            if (Option.equals("6")) {
                System.out.println("There are " + heap.size() + " jobs in the queue.");
            }


            //////////// option X ////////////

            // Exit

            if (Option.equalsIgnoreCase("X")) {
                Done = true;

            } // if

        } // while

    } // main
}
