package org.nbki.task.three;

public class TaskThree {
    
    public static final int QUANTITY = 100;
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";

    public void fizzBuzz(){

        for (int i = 1; i <= QUANTITY; i++){

            if (multiplicity(i,3) && multiplicity(i,5)){
                System.out.println(FIZZ_BUZZ);
                continue;
            }

            if (multiplicity(i,3)){
                System.out.println(FIZZ);
                continue;
            }

            if (multiplicity(i,5)){
                System.out.println(BUZZ);
                continue;
            }
            System.out.println(i);
        }
    }

    private boolean multiplicity(int number, int verifyNumber){
        if (number % verifyNumber == 0){
            return true;
        }
        return false;
    }
}
