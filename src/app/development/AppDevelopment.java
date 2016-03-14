package app.development;

/**
 *
 * @author Inez Wester
 * @since 14/03/2016
 */
public class AppDevelopment {    
    /** 
     * method is the top-level of generating exercises
     *
     * @param type an integer representation of the 
     *      type of exercise that needs to be generated
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @pre type > 0 && type < 6 && max > 0 && max < 11
     * @return returns images at specific locations and the correct 
     *      answer button location
     * @throws IllegalArgumentException if precondition violated
     */
    public Exercise generateExercise(int type, int max) 
                    throws IllegalArgumentException{
        //throws illegal type
        if (type <= 0 || type >= 6) {
            throw new IllegalArgumentException("Type in generateExercise has "
                    + "invalid value: " + type);
        }
        
        //throws illegal maximum
        if (max <= 0 || max >= 11) {
            throw new IllegalArgumentException("Maximum in generateExercise has "
                    + "invalid value: " + max);
        }
        
        //initialize return value
        Exercise exercise = new Exercise();
        
        /* 
         * type distiction
         *   1: simple counting displaying images (one-to-one, cardinality)
         *   2: order irrelevance principle (order-irrelavance)
         *   3: larger than or equal to (cardinality, stable order)
         *   4: counting increase first 1,2,3,4 then 5 etc. (stable order)
         *   5: tangibility
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
     * @pre max > 0
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise oneToOne(int max, Exercise exercise){
        /*
         * the basic exercises
         */
        
        
        
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
        /*
         * probably make exercise that are mirrors of eachother, so the first 
         * exercise is an apple + a pear and then we switch the images for the
         * second exercise
         */
        
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
        /*
         * more than or less than or equal to exercises, we should probably use 
         * the correct signs as well ">", "<" and "="
         */
        
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
        /*
         * somehow make clear that you count, 1,2,3,4 not 3,2,1,4 maybe by 
         * incrementally increasing the amount they have to count
         */
        
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
         * I have no idea how to implement this method :(. Maybe by using other 
         * things than just fruit, airplanes and ghosts. Not sure if this will 
         * then satisfy the requirements of the tangibility principle
         */
        
        return exercise;
    }
    
    /**
     * returns the image names for the exercises
     * 
     * @param kind the kind of image that is sought
     * @param count is the amount of objects that are requested in an image
     * @pre kinds > 0 && kinds < 5 && count >= 0 && count <= 3
     * @return the name of the image
     * @throws IllegalArgumentException if preconditions are violated
     */
    public Image loadImages(int kind, int count) 
            throws IllegalArgumentException{
        //declaration of images
        String[] imageNames = new String[]{"apple", "strawberry",
            "banana", "pear", "orange"};
        //image declaration
        Image returnImage = new Image();
        
        //throws illegal kind
        if (kind <= 0 || kind >= 5) {
            throw new IllegalArgumentException("Kinds in decideImages has "
                    + "invalid value: " + kind);
        }
               
        //throws illegal count
        if (count <= 0 || count > 3) {
            throw new IllegalArgumentException("Count in decideImages has "
                    + "invalid value: "  + count);
        }
        
                
        return returnImage;
    }
    
    /**
     * returns images according to what the methods ask
     * 
     * @param image the object and count of the image that needs to be located
     */
    public void locateImage(Image image){
        //implementing this inside android studio with other code present
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO code application logic here
    }
    
}
