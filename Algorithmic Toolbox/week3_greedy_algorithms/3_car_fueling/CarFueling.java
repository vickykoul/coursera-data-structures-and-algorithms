import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        boolean reachedFinalDestination = false;
        int refillCount = 0;
        int fuelLeft = tank; // in miles
        int distanceCoveredSoFar = 0;

        //first node check's here

        //can you reach final destination from here directly without refuelling ?
        if (fuelLeft >= dist) {
            return 0;
        }

        // Can you get to next stop?
        if (fuelLeft < stops[0]) {
            return -1;
        }

        //go to next station  fuel station
        for (int i = 0; i < stops.length; i++) {

            int distanceCoveredInLastStep = i == 0 ? stops[i] : stops[i] - stops[i - 1];
            distanceCoveredSoFar += distanceCoveredInLastStep;
            fuelLeft -= distanceCoveredInLastStep;

            //can you reach final destination from here directly without refuelling ?
            if (distanceCoveredSoFar + fuelLeft >= dist) {
                reachedFinalDestination = true;
                break;
            }

            //is this last  fuel station?
            if (i == stops.length - 1) {
                //yes - so refuel here
                refillCount += 1;
                fuelLeft = tank;

            } else {
                // Can i get to next station without refuelling here  ?
                if (fuelLeft < stops[i + 1] - stops[i]) {
                    //can i get to next station after refuelling ?
                    if(tank >= stops[i + 1] - stops[i]){
                    refillCount += 1;
                    fuelLeft = tank;
                    }
                    else {
                        break;
                    }

                }

            }

        }

        //can you reach final destination from here directly without refuelling ?
        if (distanceCoveredSoFar + fuelLeft >= dist) {
            reachedFinalDestination = true;
        }

        return reachedFinalDestination ? refillCount : -1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n ; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
