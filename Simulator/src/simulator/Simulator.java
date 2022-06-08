
package simulator;

import java.util.Scanner;

/**
 * 
 */
public class Simulator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String filename = "1.txt";
        Simulation s = new Simulation(filename);
        s.getField().print();
        // s.simulateOneStep();
        System.out.println("Δώσε τα βήματα για τα οποία θα γίνει η προσομοίωση:");
        int steps = input.nextInt();

        s.simulate(steps);

        s.getField().printStats();
        // s.reset(filename);
        // s.getField().print();
        // int steps=input.nextInt();
        // s.simulate(steps);
    }
}
