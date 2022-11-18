/*
 * @Title: UNION AND INTERSECTION OF SETS
 * @Description: A set is a collection of distinct objects, 
 *               called elements of the set. Commonly sets interact; the union and 
 *               intersection are the common set operations between two sets. The union of two 
 *               sets contains all the unique elements contained in either set (or both sets) 
 *               and the intersection of two sets contains only the unique elements that are 
 *               in both sets. Develop a program that generates two sets of positive integer 
 *               numbers from 1 to 100. Then it will display the elements of the generated two 
 *               sets and the elements of the union and intersection of the two sets in sorted 
 *               order. The number of elements for each set shall be asked from the user and 
 *               the minimum number of elements for each set is 5.
 * @Author : Zeus A. Tenerife
 * @DateCreated: 11/14/2022
 */

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //Header of the Program
        out.println("UNION AND INTERSECTION OF SETS");
        out.println("------------------------------");
        Scanner input = new Scanner(System.in);

        //Variable Declaration of the size of the sets
        int set1Size, set2Size;

        //Loop Control
        do{
            //Prompt the user to enter the number of elements for each set (minimum of 5)
            do {
                out.println();
                out.print("Enter the number of elements for Set 1 (minimum of 5): ");
                set1Size = input.nextInt();
                out.print("Enter the number of elements for Set 2 (minimum of 5): ");
                set2Size = input.nextInt();

                if (set1Size < 5 || set2Size < 5) {
                    out.println("The minimum elements of each set is 5.");
                }

            } while (set1Size < 5 || set2Size < 5);

        //Generate two sets of positive integer numbers from 1 to 100
        ArrayList <Integer> set1 = generateSet(set1Size);
        ArrayList <Integer> set2 = generateSet(set2Size);
        
        //display the elements of the generated two sets
        out.println();
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        //display the elements of the union and intersection of the two sets in sorted order
        System.out.println();
        System.out.println("Union: " + union(set1, set2).toString());

        //Check if the intersection is empty
        //If the intersection is empty, display a message that there is no intersection
        //If the intersection is not empty, display the elements of the intersection
        if (intersection(set1, set2).size() == 0) {
            System.out.println("Intersection: There are no elements that intersects the two sets.");
        } else{
            System.out.println("Intersection: " + intersection(set1, set2).toString());
        }
        
        //Ask the user if he/she wants to continue
        }while(tryAgain());

        //End of Program
        out.println();
        out.println("--PROGRAM TERMINATED--");
    }

    //Method to generate a random set of positive integer numbers from 1 to 100
    public static void generateRandomNumber(ArrayList<Integer> set, int size) {
        Random rand = new Random();
        int randomNum;
        //Loop to generate random numbers
        //It will stop when the elements of the set is equal to the size of the set
        for (int i = 0; i < size; i++) {
            randomNum = rand.nextInt(100) + 1;
            //Check if the random number is already in the set
            //If the random number is not in the set, add it to the set
            if (!set.contains(randomNum)) {
                set.add(randomNum);
            }
        }
    }

    //Method to set the Random Numbers to the Set
    public static ArrayList<Integer> generateSet(int size) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        generateRandomNumber(set, size);
        return set;
    }

    //Method to get the union of two sets
    public static ArrayList<Integer> union(ArrayList<Integer> set1, ArrayList<Integer> set2) {
        ArrayList<Integer> union = new ArrayList<Integer>();

        //Check each elements of set1
        //If the element is not in the union, add it to the union Variable
        for (int i = 0; i < set1.size(); i++) {
            if (!union.contains(set1.get(i))) {
                union.add(set1.get(i));
            }
        }

        //Check each elements of set2
        //If the element is not in the union, add it to the union Variable
        for (int i = 0; i < set2.size(); i++) {
            if (!union.contains(set2.get(i))) {
                union.add(set2.get(i));
            }
        }

        //sort the union
        Collections.sort(union);

        return union;
    }

    //Method to get the intersection of two sets
    public static ArrayList <Integer> intersection (ArrayList <Integer> set1, ArrayList <Integer> set2){
        ArrayList <Integer> intersection = new ArrayList <Integer>();

        //Check if the elements of set1 is in set2
        //If the element is in set2, add it to the intersection Variable
        for (int i = 0; i < set1.size(); i++) {
            if (set2.contains(set1.get(i))) {
                intersection.add(set1.get(i));
            }
        }

        //sort the intersection
        Collections.sort(intersection);

        return intersection;
    }

    //Method to ask the user if he/she wants to continue
    public static boolean tryAgain(){
        Scanner input = new Scanner(System.in);
        char choice;
        //Ask The user if he/she wants to continue
        //If the user enters 'Y' or 'y', the program will continue
        //If the user enters 'N' or 'n', the program will terminate
        System.out.print("\nDo you want to try again? (Y/N): ");
        choice = input.next().charAt(0);
        if(choice == 'Y' || choice == 'y'){
            return true;
        }else{
            return false;
        }
    }
}
