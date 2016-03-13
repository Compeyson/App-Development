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
     * @pre type > 0 && type < 6 && max => 0 && max < 11 && position > 0 
     * @return returns images at specific locations and the correct 
     *      answer button location
     * @throws IllegalArgumentException if precondition violated
     */
    public Exercise generateExercise(int type, int max) 
                    throws IllegalArgumentException{
        //throws illegal type
        if (type <= 0 || type >= 6) {
            throw new IllegalArgumentException("Type has invalid value: " 
                    + type);
        }
        
        //throws illegal maximum
        if (max < 0 || max >= 11) {
            throw new IllegalArgumentException("Maximum has invalid value: " 
                    + max);
        }
        
        //initialize return value
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
                oneToOne(max, exercise);
                break;
            case 2:
                orderIrrelevance(max, exercise);
                break;
            case 3:
                cardinality(max, exercise);
                break;
            case 4:
                stableOrder(max, exercise);
                break;
            case 5:
                tangibility(max, exercise);
                break;
        }
            
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the one-to-one principle
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max >= 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise oneToOne(int max, Exercise exercise){
        
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the order irrelevance 
     *      principle
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max >= 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise orderIrrelevance(int max, Exercise exercise){
        
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the cardinality principle
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max >= 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise cardinality(int max, Exercise exercise){
        
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the stable order 
     *      principle
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max >= 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise stableOrder(int max, Exercise exercise){
        
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the tangibility principle 
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max >= 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise tangibility(int max, Exercise exercise){
        /*
         * I have no idea how to implement this method :(
         */
        
        return exercise;
    }
    
    /**
     * returns the image names for the exercises
     * 
     * @param kinds the amount of different kinds of images are 
     *      allowed in the exercise
     * @param method indicates the method to find the images, random 
     *      or all of 1 kind
     * @param count is the amount the images need to add up to in total
     * @pre kinds > 0 && count >= 0
     * @post count = 0;
     * @return the name of the image
     */
    public String decideImages(int kinds, int method, int count) 
            throws IllegalArgumentException{
        //declaration of images
        String[] imageNames = new String[]{"apple", "strawberry",
            "banana", "pear", "orange"};
        int imageCount = 3;     //maximum amount of object on image
        
        //throws illegal kind
        if (kinds <= 0) {
            throw new IllegalArgumentException("Kinds has invalid value: " 
                    + kinds);
        }
        
        //throws illegal count
        if (count < 0) {
            throw new IllegalArgumentException("Count has invalid value: " 
                    + count);
        }
        
        /*
         * This method needs distinction between what to do and how and how 
         *  many images need to be displayed
         *
         * the kinds of images are pulled from the array imageNames, how many 
         * of each is in method than then the count need to be 0 at the end of 
         * the method
         */
        
        return "implemention required";
    }
    
    /**
     * returns images according to what the methods ask
     * 
     * @param imageName the name of the image necessary
     */
    public void locateImage(String imageName){
        //implementing this inside android studio with other code present
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
