package Control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by quangminhtran94 on 4/13/15.
 */
public class Utility {
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

//    public static int getMaxInput(int max){
//        Scanner input = new Scanner(System.in);
//        int output;
//        while(true){
//            try{
//                output = input.nextInt();
//                if (output>max){
//                    System.out.print("Your input is larger than the valid maximum, please re-enter: ");
//                    continue;
//                }else
//                    break;
//            }catch(Exception e){
//                input.nextLine();
//                System.out.print("Enter number please: ");
//            }
//        }
//        input.nextLine();
//        return output;
//    }

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
     * for input integer >= 0  and <= 100
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
