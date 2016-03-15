package app.development;

/**
 *
 * @author Inez Wester
 * @since 14/03/2016
 */
public class AppDevelopment {   
    
    //declaration of fruit images
    String[] imageNames = new String[]{"apple", "strawberry",
        "banana", "pear", "orange"};
    //declaration of number images
    String[] numberImages = new String[]{"1", "2", "3", "4", "5", "6", "7",
        "8", "9"};
        
    /** 
     * method is the top-level of generating exercises
     *
     * @param type an integer representation of the 
     *      type of exercise that needs to be generated
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @pre type > 0 && type < 6 && max > 1 && max < 11
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
        if (max <= 1 || max >= 11) {
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
     * @pre max > 1
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise oneToOne(int max, Exercise exercise){
        int i;          //answer variable that can be modified
        int j = 0;      //array counter
        int answer;
        int possibleAnswer1;
        int possibleAnswer2;
        int answermax;
        int[] question = {0,0,0,0,0,0,0,0,0};
        int random;
                
        //generate question
        answer = (int)(Math.random()*(max - 1) + 1);
        i = answer;
        while(i > 0){
            while(j < 9){
                random = (int)(Math.random()* 2 + 1);
                if(i >= random){
                    question[j] = random;
                    i = answer - random;
                    j++;
                }
            }
            System.out.println("Error: not enough question images to implement "
                    + "answer");
        }   
        
        //generate "fake" answers maximum
        if(max < 7){
            answermax = max + (int)(.5 * max);
        }else{
            answermax = max;
        }
        //fakeanswer1
        possibleAnswer1 = generateProxyAnswer(answermax, answer, 0);
        //fakeanswer2
        possibleAnswer2 = generateProxyAnswer(answermax, answer, 
                possibleAnswer1);
                        
        //load question images
        //this might be better to actually implement in loadImages
        exercise.image1 = loadImages(0,question[0]);
        exercise.image2 = loadImages(0,question[1]);
        exercise.image3 = loadImages(0,question[2]);
        exercise.image4 = loadImages(0,question[3]);
        exercise.image5 = loadImages(0,question[4]);
        exercise.image6 = loadImages(0,question[5]);
        exercise.image7 = loadImages(0,question[6]);
        exercise.image8 = loadImages(0,question[7]);
        exercise.image9 = loadImages(0,question[8]);
        
        //assign answers to answer slots
        exercise = assignAnswerSlots(exercise, answer, possibleAnswer1, 
                possibleAnswer2);
                
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
     * Method generates fake answers
     * 
     * @param answerMax is the maximum value that an answer may have
     * @param correctAnswer is the actual answer of the question
     * @param fakeAnswer1 is an already generated "fake" answer
     * @pre answerMax > 1 && answerMax < 11 && correctAnswer > 0 && 
     *  correctAnswer < 11
     * @return fakeanswer <= answerMax && fakeanswer != correctAnswer
     * @throws IllegalArgumentException
     */
    public int generateProxyAnswer(int answerMax, int correctAnswer, 
            int fakeAnswer1) throws IllegalArgumentException{
        int proxyAnswer = -1;       //initialization "fake" answer
        
        //throws illegal maximum
        if (answerMax <= 1 || answerMax >= 11) {
            throw new IllegalArgumentException("Maximum in generateProxyAnswer"
                    + " has invalid value: " + answerMax);
        }
        
        //throws illegal answer
        if (correctAnswer <= 1 || correctAnswer >= 11) {
            throw new IllegalArgumentException("Correct answer in "
                   + "generateProxyAnswer has invalid value: " + correctAnswer);
        }
                
        //while loop to make fake answer with given parameters
        while(proxyAnswer == -1){
            proxyAnswer = (int)(Math.random()*(answerMax - 1) + 1);
            if(proxyAnswer == correctAnswer || proxyAnswer == fakeAnswer1){
                proxyAnswer = -1;
            }
        }
        
        return proxyAnswer;
    }
    /**
     * Assign the answer and the possible answers to slot in the application
     * 
     * @param exercise is the exercise that will be returned, with no answer 
     *      images assigned
     * @param answer is the correct answer to the question
     * @param possibleAnswer1 is a "fake" answer to the question
     * @param possibleAnswer2 is a "fake" answer to the question
     * @pre answer > 0 && possibleAnswer1 > 0 && possibleAnswer2 > 0
     * @modifies exercise
     * @return exercise with answers assigned and the location of the correct 
     *      answer assigned
     */
    public Exercise assignAnswerSlots(Exercise exercise, int answer, 
            int possibleAnswer1, int possibleAnswer2){
        int k;
        int i = -1;
        int j = -1;
        int p = -1;
        
        //load answer images
        while(p == -1){
            k = (int)(Math.random()*2 + 1);
            switch(k){
                case 1:
                    exercise.answer1 = loadImages(1,answer);
                    exercise.correctAnswer = 1;
                    break;
                case 2:
                    exercise.answer2 = loadImages(1,answer);
                    exercise.correctAnswer = 2;
                    break;
                case 3:
                    exercise.answer3 = loadImages(1,answer);
                    exercise.correctAnswer = 3;
                    break;
            }
                        
            //same for possibleAnswer1, making sure not to load in same spot
            while(i == -1){
               i = (int)(Math.random()*2 + 1); 
               if(i == k){
                   i = -1;
            }
               switch(i){
                case 1:
                    exercise.answer1 = loadImages(1,possibleAnswer1);
                    break;
                case 2:
                    exercise.answer2 = loadImages(1,possibleAnswer1);
                    break;
                case 3:
                    exercise.answer3 = loadImages(1,possibleAnswer1);
                    break;
                }
            }
            
            //same for possibleAnswer2, making sure not to load in same spot
            while(j == -1){
               j = (int)(Math.random()*2 + 1); 
               if(j == k || j == i){
                   j = -1;
            }
               switch(j){
                case 1:
                    exercise.answer1 = loadImages(1,possibleAnswer2);
                    break;
                case 2:
                    exercise.answer2 = loadImages(1,possibleAnswer2);
                    break;
                case 3:
                    exercise.answer3 = loadImages(1,possibleAnswer2);
                    break;
                }
            }
        }
        return exercise;
    }
    
    
    /**
     * returns the image names for the exercises
     * 
     * @param kind the kind of image that is sought (either an number or a 
     *      picture 0 stands for fruit images and 1 stands for numbers
     * @param count is the amount of objects that are requested in an image
     * @pre kinds >= 0 && kinds <= 1 && count >= 0 && count <= 3
     * @return the name of the image
     * @throws IllegalArgumentException if preconditions are violated
     */
    public Image loadImages(int kind, int count) 
            throws IllegalArgumentException{
        //image declaration
        Image returnImage = new Image();
        int image;
        
        //throws illegal kind
        if (kind < 0 || kind >= 2) {
            throw new IllegalArgumentException("Kinds in decideImages has "
                    + "invalid value: " + kind);
        }
               
        //throws illegal count
        if (count <= 0 || count > 3) {
            throw new IllegalArgumentException("Count in decideImages has "
                    + "invalid value: "  + count);
        }
        
        switch(kind){
            case 0:
                //decide fruit kind
                image = (int)(Math.random() * (imageNames.length - 1));
                returnImage.object = imageNames[image];
                returnImage.count = count;
                break;
            case 1:
                image = count - 1;
                returnImage.object = imageNames[image];
                returnImage.count = count;
                break;                
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
