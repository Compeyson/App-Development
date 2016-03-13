/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.development;

/**
 *
 * @author Inez Wester
 * @since 13/03/2016
 */
public class AppDevelopment {

    /** 
     * method is the top-level of generating exercises
     *
     * @param type an integer representation of the 
     *      type of exercise that needs to be generated
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param position is the places that the images are displayed 
     *      in the application
     * @pre type > 0 && type < 6 && max => 0 && max < 11 && position > 0 
     * @return returns images at specific locations and the correct 
     *      answer button location
     * @throws IllegalArgumentException if precondition violated
     */
    public Exercise generateExercise(int type, int max, int position) 
                    throws IllegalArgumentException{
        //throws illegal type
        if (type <= 0 || type >= 6) {
            throw new IllegalArgumentException("Type has invalid value:" 
                    + type);
        }
        
        //throws illegal maximum
        if (max < 0 || max >= 11) {
            throw new IllegalArgumentException("Maximum has invalid value:" 
                    + max);
        }
        
        //throws illegal position
        if (position <= 0) {
            throw new IllegalArgumentException("Position has invalid value:" 
                    + position);
        }
        
        Exercise exercise = new Exercise();
        
        /* 
         * type distiction
         *   1: simple counting displaying images (one-to-one, cardinality)
         *   2: order irrelevance principle (order-irrelavance)
         *   3: larger than or equal to (cardinality, stable order)
         *   4: counting increase first 1,2,3,4 then 5 etc. (stable order)
         *   5: tangibility???
         */
        switch(type){
            case 1:
                simpleCounting(max);
                break;
            case 2:
                orderIrrelevance(max);
                break;
            case 3:
                cardinality(max);
                break;
            case 4:
                stableOrder(max);
                break;
            case 5:
                tangibility(max);
                break;
        }
            
        
        return exercise;
    }
    
    /**
     * This method returns simple counting principle exercises
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @pre max >= 0
     */
    public int simpleCounting(int max){
        
        
        return 1;
    }
    
    public void orderIrrelevance(int max){
        
    }
    
    public void cardinality(int max){
        
    }
    
    public void stableOrder(int max){
        
    }
    public void tangibility(int max){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
