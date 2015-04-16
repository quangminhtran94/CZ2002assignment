package Control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * contain input methods
 */
public class Utility {
    /**
     * validate and get integer input
     * @return return integer input
     */
    public static int getIntInput(){
        Scanner input = new Scanner(System.in);
        int output;
        while(true){
            try{
                output = input.nextInt();
                break;
            }catch(Exception e){
                input.nextLine();
                System.out.print("Enter number please: ");
            }
        }
        input.nextLine();
        return output;
    }

    /**
     * validate and get an array of integer that has specific sum
     * @param sum the value of desired sum
     * @return arraylist of integers
     */
    public static ArrayList<Integer> getSumInput(int sum){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> output = new ArrayList<Integer>();
        int weight = 0;
        int tempSum = 0;

        while(true){
            weight = getIntInput();
            while(true){
                output.add(weight);
                tempSum+= weight;
                if (tempSum >= 100)
                    break;
                weight = getIntervalInput(1,100);
            }
            if (tempSum > 100) {
                output.clear();
                tempSum = 0;
                System.out.print("Please enter various numbers that have sum equal to " + sum +": ");
            }else
                break;
        }
        return output;
    }

    /**
     * get and validate an integer input that smaller than max and larger than min
     * @param min minimum value
     * @param max maximum value
     * @return the int input
     */
    public static int getIntervalInput(int min, int max){
        Scanner input = new Scanner(System.in);
        int output;
        while(true){
            try{
                output = input.nextInt();
                if(output < min || output > max){
                    System.out.print("Input needs to be >= " + min + " and <= " + max + ", please re-enter: ");
                    continue;
                }
                break;
            }catch(Exception e){
                input.nextLine();
                System.out.print("Enter number please: ");
            }
        }
        input.nextLine();
        return output;
    }
}
