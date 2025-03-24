import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells, int[] initialState)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        // Seed the automaton with a single 'on' cell in the middle.
        //Q27
        for (int i = 0; i < Math.min(initialState.length, numberOfCells); i++) {
            state[i] = initialState[i];
        }
    }
    
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array.
        /*int[] nextState = new int[state.length]; 
         * this code when its not there in Q 29 
         * makes changes in the pattern.its only one line that goes down.
         */
        // Naively update the state of each cell
        // based on the state of its two neighbors.
        //Q30 
        for (int i = state.length - 1; i >= 0; i--) {
           int left, center, right;
        
           // Handle left, center, right values using ternary operators
           left = (i == 0) ? 0 : state[i - 1]; // Left neighbor or 0 if it's the first cell
           center = state[i]; // Current cell
           right = (i + 1 < state.length) ? state[i + 1] : 0; // Right neighbor or 0 if it's the last cell
        
           // Update the current cell in place
           state[i] = (left + center + right) % 2;
        }
        
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
}
