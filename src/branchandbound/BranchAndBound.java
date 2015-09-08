/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package branchandbound;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author Austo89
 */
public class BranchAndBound {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //int bact = 20;
        //int steps = bacterium(bact);
        //System.out.println("Bacteria all died in " + steps + " steps.");
        BranchAndBound tom = new BranchAndBound();
        int[] test = {0,6,9,10,11,12,15};
        int[] testL = tom.genLengths(test,15);
        Arrays.sort(testL);
        for(int i = 0; i < testL.length;i++){
            System.out.println(testL[i]);
        }
    }

    //generates a list of lengths based on a number of cuts
    //passed in through numCuts
    public int[] genCutPositions(int numCuts, int length) {
        Random rand = new Random();
        int cutLength = length / numCuts;

        int[] cutPosition = new int[numCuts + 2];
        cutPosition[0] = 0;
        cutPosition[numCuts+1] = length;
        
        int curPos = 1;

        //loop over and create the cut positions
        for (int i = 1; i < numCuts; i++) {
            curPos += rand.nextInt(cutLength);
            cutPosition[i] = curPos;
        }

        return cutPosition;
    }
    
    //create the array of lengths from partial digest
    public int[] genLengths(int[] cuts, int fullLength) {
        int numLengths = 0;
        //do the sum that gives the number of generated lengths
        for (int i = 0; i < cuts.length; i++){
            numLengths += i;
        }
        
        int[] lengths = new int[numLengths];
        
        int k = 0;
        for(int i = 0; i < cuts.length - 1; i++){
            for(int j = i+1; j < cuts.length; j++){
                lengths[k] = cuts[j] - cuts[i];
                k++;
            }
        }
        
        
        return lengths;
    }
    
    public int[] branchNbound(int[] lengths){
        int numCuts = 0;
        int c = 1;
        int numSum = 0;
        while (numSum < lengths.length){
            numSum += c;
            c++;
        }
        
        int[] cutPositions = new int[numCuts];
        cutPositions[0] = 0;
        cutPositions[cutPositions.length - 1] = lengths[lengths.length - 1];
        
        for(int i = 0; i < cutPositions.length; i++){
            cutPositions[i] = -1;
        }
        
        int l = lengths[lengths.length-1];
        lengths[lengths.length - 1] = -1;
        
        Arrays.sort(cutPositions);
        bnbrec(lengths, cutPositions, l,2);
        
        return cutPositions;
    }
    
    public void bnbrec(int[] lengths, int[] cuts, int l, int cutsSolved){
        
    }

    public static int bacterium(int numBacteria) {
        int numVirus = 1;
        int numSteps = 0;
        while (numVirus < numBacteria) {
            System.out.println("Step: " + numSteps);
            System.out.println("Bacteria: " + numBacteria);
            System.out.println("Viruses: " + numVirus);
            System.out.println("");
            numBacteria = numBacteria - numVirus;
            numVirus = 2 * numVirus;
            numBacteria = 2 * numBacteria;
            numSteps++;
        }

        System.out.println("Step: " + numSteps);
        System.out.println("Bacteria: " + numBacteria);
        System.out.println("Viruses: " + numVirus);
        System.out.println("");

        return numSteps;
    }
    
    public static void matrixProblem(){
        int[][] banana = new int[8][8];
        Random rand = new Random();
        
        //fill the matrix
        for (int i = 0; i < banana.length; i++){
            for (int j = 0; j < banana[i].length; j++){
                banana[i][j] = rand.nextInt(10);
            }
        }
        
        boolean solved = false;
        int numSteps = 0;
        
        //keep working until zeroed
        while(!solved){
            //check if solved
            
        }
    }
}
