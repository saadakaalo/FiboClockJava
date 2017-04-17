/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiboclock;

/**
 *
 * @author sourav
 */
public class FiboClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FibonacciClock clock = new FibonacciClock();
		clock.createTheClock();
		clock.startRunning();
        
    }
    
}
