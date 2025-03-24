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
    //Q31
    public void update() {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
    
        // Initialize the left and center variables for the first iteration
        int left = 0;
        int center = state[0];
    
        // Loop through each cell in the state array
        for (int i = 0; i < state.length; i++) {
          // Determine the right neighbor (handle the last cell by setting right to 0)
          int right = (i + 1 < state.length) ? state[i + 1] : 0;
        
          // Calculate the next state of the current cell based on its neighbors
          nextState[i] = (left + center + right) % 2;
        
          // Update the left and center for the next iteration
          left = center;
          center = right;
        }
    
         // Assign the nextState array to the state array
         state = nextState;
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
