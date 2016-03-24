package app.development;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Inez Wester
 * @since 21/03/2016
 */
public class ExerciseGeneration {   
    //declaration of fruit images
    String[] imageNames = new String[]{"apple", "strawberry",
        "banana", "pear", "orange"};
    //declaration of number images
    String[] numberImages = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "10"};
    //yes, no and signs array
    String[] signsImages = new String[]{"correct", "incorrect", "=", ">", "<", "clear"};
    //declation question array
    private int[] question = {0,0,0,0,0,0,0,0,0}; 
    //initialize return value
    Exercise exercise = new Exercise();
            
    /** 
     * method is the top-level of generating exercises
     *
     * @param type an integer representation of the 
     *      type of exercise that needs to be generated
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is mainly for type two to implement the previous exercise
     * @pre type > 0 && type < 6 && max > 0 && max < 11
     * @return returns images at specific locations and the correct 
     *      answer button location
     * @throws IllegalArgumentException if precondition violated
     */
    public Exercise generateExercise(int type, int max, Exercise exercise) 
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
            
        System.out.println("In top-level method after case distinction");
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
        int random;
        int[] fakeAnswers;
      
        System.out.println("Whoohoo in oneToOne method");
        
        //generate question
        answer = (int)(Math.random()* max  + 1);
        System.out.println("answer is " + answer);
        i = answer;
        while(i > 0){
            while(j < 9){
                random = (int)(Math.random()* 3 + 1);
                System.out.println("random number is " + random);
                if(random <= i){
                    question[j] = random;
                    i = i - random;
                    System.out.println("i " + i);
                    if(i == 0){
                        break;
                    }
                    j++;
                }
            }
            if(i == 0){
                break;
            }else{
                System.out.println("Error: not enough question images to implement "
                    + "answer");
                j = 0;
            }
        }   
        
        //generate "fake" answers maximum
        fakeAnswers = generateAnswers(answer, max);
        possibleAnswer1 = fakeAnswers[0];
        possibleAnswer2 = fakeAnswers[1];
                                
        //load question images
        //this might be better to actually implement in loadImages
        question = randomizeImageLocation(question);
        exercise.image1 = loadImages(0,question[0]);
        exercise.image2 = loadImages(0,question[1]);
        exercise.image3 = loadImages(0,question[2]);
        exercise.image4 = loadImages(0,question[3]);
        exercise.image5 = loadImages(0,question[4]);
        exercise.image6 = loadImages(0,question[5]);
        exercise.image7 = loadImages(0,question[6]);
        exercise.image8 = loadImages(0,question[7]);
        exercise.image9 = loadImages(0,question[8]);
        
        System.out.println("question images loaded");
        
        //assign answers to answer slots
        exercise = assignAnswerSlots(exercise, answer, possibleAnswer1, 
                possibleAnswer2);
        
        //assign question
        exercise.question = ("How many pieces of fruit do you see?");
        
        System.out.println("answer images loaded");
        
        return exercise;
    }
    
    /**
     * This method returns the exercise given mirrored. Thus in a module first 
     *  method oneToOne must be called and then for the next exercise 
     *  this method has to be called
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
        Image saveLocation1 = exercise.image1;
        Image saveLocation4 = exercise.image4;
        Image saveLocation7 = exercise.image7;
        int answer = -1;
        int possibleAnswer1;
        int possibleAnswer2;
        int[] fakeAnswers;
        
        //mirror the exercise
        //1 and 3
        exercise.image1 = exercise.image3;
        exercise.image3 = saveLocation1;
        //4 and 6
        exercise.image4 = exercise.image6;
        exercise.image6 = saveLocation4;
        //7 and 9
        exercise.image7 =  exercise.image9;
        exercise.image9 = saveLocation7;
        
        //initialize correct answer
        switch (exercise.correctAnswer) {
            case 1:
                answer = exercise.answer1.count;
                break;
            case 2:
                answer = exercise.answer2.count;
                break;
            case 3:
                answer = exercise.answer3.count;
                break;
        }
        
        //assign new possible answers
        //generate "fake" answers maximum
        fakeAnswers = generateAnswers(answer, max);
        possibleAnswer1 = fakeAnswers[0];
        possibleAnswer2 = fakeAnswers[1];
        
        //assign answers to answer slots
        exercise = assignAnswerSlots(exercise, answer, possibleAnswer1, 
                possibleAnswer2);
        
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
        int type;
        int leftanswer;
        int rightanswer;
        int i;
        int j = 0;
        int n;
        int m = 0;
        int random;
                
        //random int decides between ">", "<" and "="
        type = (int)(Math.random()*3 + 1);
        System.out.println(type + " 1 = equal to "+ "2 greater than " + 
                "3 smaller than");
        switch(type){
            case 1:
                //"=" selection
                exercise.question = ("are number of pieces of fruit on the left "
                        + "side equal to the number of pieces of fruit on the "
                        + "right side");
                exercise.image5 = loadImages(2,2);
                break;
            case 2:
                //">" selection
                exercise.question = ("Is number of pieces of fruit on the left "
                        + "side of the screen greater than to the number of "
                        + "pieces of fruit on the right side");
                exercise.image5 = loadImages(2,3);
                break;
            case 3:
                //"<" selection
                exercise.question = ("Is number of pieces of fruit on the left "
                        + "side of the screen smaller than to the number of "
                        + "pieces of fruit on the right side");
                exercise.image5 = loadImages(2,4);
                break;
        }
        
        //yes
        exercise.answer1 = loadImages(2,0);
        //blank
        exercise.answer2 = loadImages(2,5);
        //no
        exercise.answer3 = loadImages(2,1);
        //load images 2 and 8 to blank
        exercise.image2 = loadImages(2,5);
        exercise.image8 = loadImages(2,5);
        
        //generate left side
        leftanswer = (int)(Math.random()* max  + 1);
        System.out.println("leftanswer is " + leftanswer);
        i = leftanswer;
        while(i > 0){
            while(j < 3){
                random = (int)(Math.random()* 3 + 1);
                //System.out.println("random number is " + random);
                if(random <= i){
                    question[j] = random;
                    i = i - random;
                    //System.out.println("i " + i);
                    if(i == 0){
                        break;
                    }
                    j++;
                }
            }
            if(i == 0){
                break;
            }else{
                System.out.println("Error: not enough question images to "
                        + "implement answer");
                j = 0;
            }
        }
        
        //generate right side
        rightanswer = (int)(Math.random()* max  + 1);
        System.out.println("rightanswer is " + rightanswer);
        n = rightanswer;
        while(n > 0){
            while(m < 3){
                random = (int)(Math.random()* 3 + 1);
                //System.out.println("random2 number is " + random);
                if(random <= n){
                    question[m + 3] = random;
                    n = n - random;
                    //System.out.println("n " + n);
                    if(n == 0){
                        break;
                    }
                    m++;
                }
            }
            if(n == 0){
                break;
            }else{
                System.out.println("Error: not enough question images to "
                        + "implement answer");
                m = 0;
            }
        }
        
        //load images left
        exercise.image1 = loadImages(0,question[0]);
        exercise.image4 = loadImages(0,question[1]);
        exercise.image7 = loadImages(0,question[2]);
        
        //load images right
        exercise.image3 = loadImages(0,question[3]);
        exercise.image6 = loadImages(0,question[4]);
        exercise.image9 = loadImages(0,question[5]);
        
        //calculate correct answer
        switch(type){
            case 1:
                if(leftanswer == rightanswer){
                    exercise.correctAnswer = 1;
                }else{
                    exercise.correctAnswer = 3;
                }
                break;
            case 2:
                if(leftanswer > rightanswer){
                    exercise.correctAnswer = 1;
                }else{
                    exercise.correctAnswer = 3;
                }
                break;
            case 3:
                if(leftanswer < rightanswer){
                    exercise.correctAnswer = 1;
                }else{
                    exercise.correctAnswer = 3;
                }
                break;
        }
        
        
        return exercise;
    }
    
    /**
     * This method returns exercises aimed to explain the stable order 
     *      principle increments of 1 for counting
     * 
     * @param max is the highest count that one has to 
     *      make to complete the exercise
     * @param exercise is the exercise the top-level provides for the 
     *      method to work in
     * @pre max > 0 && max <10
     * @modifies exercise
     * @return returns the exercise with correct values
     */
    public Exercise stableOrder(int max, Exercise exercise){
        int previous = 0;
        int answer;
        int possibleAnswer1;
        int possibleAnswer2;
        int i;
        int[] fakeAnswers;
        
        //throws illegal maximum
        if (max <= 0 || max >= 10) {
            throw new IllegalArgumentException("Maximum in generateExercise has "
                    + "invalid value: " + max);
        }
        
        //initialize question
        exercise.question = ("How many apples do you see?");
        
        //check if this is the first exercise in module
        if(max > 1){
            //get count of previous exercise
            switch (exercise.correctAnswer) {
                case 1:
                    previous = exercise.answer1.count;
                    break;
                case 2:
                    previous = exercise.answer2.count;
                    break;
                case 3:
                    previous = exercise.answer3.count;
                    break;
            }
            //check to not exceed given maximum
            if(previous == max){
                question[4] = 1;
                question[3] = 0;
                question[5] = 0;
                answer = 1;
            }else{ //loading images in middle row
                //loads central image
                answer = previous + 1;
                if(answer <= 3){
                    question[4] = answer;
                }else{
                    question[4] = 3;
                    i = answer - 3;
                    if(i <= 3){
                        //loads middle left image
                        question[3] = i;
                    }else{
                        //loads middle left image
                        question[3] = 3;
                        i = i - 3;
                        //loads middle right image
                        question[5] = i;
                    }
                }
            }
        }else{
            //set first exercise to one
            question[4] = 1;
            answer = 1;
        }
        
        //assign new possible answers
        //generate "fake" answers maximum
        fakeAnswers = generateAnswers(answer, max);
        possibleAnswer1 = fakeAnswers[0];
        possibleAnswer2 = fakeAnswers[1];
        
               
        exercise.image1 = loadImages(3,question[0]);
        exercise.image2 = loadImages(3,question[1]);
        exercise.image3 = loadImages(3,question[2]);
        exercise.image4 = loadImages(3,question[3]);
        exercise.image5 = loadImages(3,question[4]);
        exercise.image6 = loadImages(3,question[5]);
        exercise.image7 = loadImages(3,question[6]);
        exercise.image8 = loadImages(3,question[7]);
        exercise.image9 = loadImages(3,question[8]);
        
        //assign answers to answer slots
        exercise = assignAnswerSlots(exercise, answer, possibleAnswer1, 
                possibleAnswer2);
        
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
//if this suffices then a simple addition of an array would suffice for now
        
        return exercise;
    }
    
    /**
     * this method makes two fake answers to implement in the exercise
     * 
     * @param answer is the actual answer of the question
     * @param max the allowed maximum of the exercise
     * @return array fakeAnswers with two distinct fake answers
     */
    public int[] generateAnswers(int answer, int max){
        int[] fakeAnswers =  new int[2];
        int answermax;
        
        switch(answer){
            case 1:
                fakeAnswers[0] = 2;
                fakeAnswers[1] = 3;
                break;
            case 2:
                fakeAnswers[0] = 1;
                fakeAnswers[1] = 3;
                break;
            default:
                if(max < 7){
                    answermax = max + (int)(.5 * max);
                }else{
                    answermax = max;
                }
                //fakeanswer1
                fakeAnswers[0] = generateProxyAnswer(answermax, answer, 0);
                //fakeanswer2
                fakeAnswers[1] = generateProxyAnswer(answermax, answer, 
                        fakeAnswers[0]);
                break;              
        }
        
        return fakeAnswers;
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
        if (correctAnswer < 1 || correctAnswer >= 11) {
            throw new IllegalArgumentException("Correct answer in "
                   + "generateProxyAnswer has invalid value: " + correctAnswer);
        }
        
        System.out.println("Whoohoo in generateProxyAnswers method");
            
        //while loop to make fake answer with given parameters
        while(proxyAnswer == -1){
            proxyAnswer = (int)(Math.random()*answerMax + 1);
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
        //System.out.println("Whoohoo in assignAnswerSlots method");
        int count;
        int[] workingArray = {answer, 
                possibleAnswer1, possibleAnswer2};
        List<Integer> result = new ArrayList();
        
        for(int i : workingArray){
            result.add(i);
        }
        
        //shuffle answers
        Collections.shuffle(result);
        
        //load answer images calls
        count = result.get(0);
        exercise.answer1 = loadImages(1,count);
        
        count = result.get(1);
        exercise.answer2 = loadImages(1,count);
        
        count = result.get(2);
        exercise.answer3 = loadImages(1,count);
        
        
        //load correct answer
        if(exercise.answer1.count == answer){
            exercise.correctAnswer = 1;
        }else if(exercise.answer2.count == answer){
            exercise.correctAnswer = 2;
        }else{
            exercise.correctAnswer = 3;
        }
         
        return exercise;
    }
    
    
    /**
     * returns the image names for the exercises
     * 
     * @param kind the kind of image that is sought (either an number or a 
     *      picture 0 stands for fruit images and 1 stands for numbers
     * @param count is the amount of objects that are requested in an image
     * @pre kinds >= 0 && kinds <= 3 && count >= 0 && count <= 10
     * @return the name of the image
     * @throws IllegalArgumentException if preconditions are violated
     */
    public Image loadImages(int kind, int count) 
            throws IllegalArgumentException{
        //image declaration
        Image returnImage = new Image();
        int image;
        
        //throws illegal kind
        if (kind < 0 || kind > 3) {
            throw new IllegalArgumentException("Kinds in loadImages has "
                    + "invalid value: " + kind);
        }
               
        //throws illegal count
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Count in loadImages has "
                    + "invalid value: "  + count);
        }
        
        switch(kind){
            case 0:
                //more than 3 pieces of fruit on image requested
                if (count > 3) {
                    throw new IllegalArgumentException("Count in load (fruit) "
                            + "Images has invalid value: "  + count);
                }
                if(count == 0){
                    returnImage.object = signsImages[5];
                    returnImage.count = 0;
                }else{
                    //decide fruit kind
                    image = (int)(Math.random() * (imageNames.length));
                    returnImage.object = imageNames[image];
                    returnImage.count = count;
                }
                break;
            case 1:
                returnImage.object = numberImages[count];
                returnImage.count = count;
                break;  
            case 2:
                returnImage.object = signsImages[count];
                returnImage.count = 0;
                break;    
            case 3:
                if(count == 0){
                    returnImage.object = signsImages[5];
                    returnImage.count = 0;
                }else{
                    returnImage.object = imageNames[0];
                    returnImage.count = count;
                }
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
     * This method randomizes the array question to prevent all the images 
     *  always loading in the same three slots
     * 
     * @param question array of numbers that represent the question filled in 
     *  order
     * @modifies question to randomized array
     * @return returns an array of numbers that represent the question
     */
    public int[] randomizeImageLocation(int[] question){
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i : question){
            result.add(i);
        }

        Collections.shuffle(result);
        
        for(int j = 0; j < result.size(); j++){
            question[j]= result.get(j);
        }
        
        //System.out.println("randomized question image locations");
        
        return question;
    }
    
    /**
     * Exercise to readable input (only for verifying uses)
     * 
     */
    private String printExercise(Exercise exercise){
        String result;
        result = ("question: " + exercise.image1.object + " " +
                Integer.toString(exercise.image1.count) + " " + 
                exercise.image2.object + " " +
                Integer.toString(exercise.image2.count) + " " + 
                exercise.image3.object + " " +
                Integer.toString(exercise.image3.count) + " " + 
                exercise.image4.object + " " +
                Integer.toString(exercise.image4.count) + " " + 
                exercise.image5.object + " " +
                Integer.toString(exercise.image5.count) + " " + 
                exercise.image6.object + " " +
                Integer.toString(exercise.image6.count) + " " + 
                exercise.image7.object + " " +
                Integer.toString(exercise.image7.count) + " " + 
                exercise.image8.object + " " +
                Integer.toString(exercise.image8.count) + " " + 
                exercise.image9.object + " " +
                Integer.toString(exercise.image9.count) + " answers: " + 
                exercise.answer1.object + " " + exercise.answer2.object + " " + 
                exercise.answer3.object + " correct answer location: " + 
                Integer.toString(exercise.correctAnswer));
        
        return result;
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //initiating classes
        ExerciseGeneration e = new ExerciseGeneration(); 
        Exercise exercise = new Exercise();
        
        //testing
        exercise = e.generateExercise(1, 9, exercise);
        System.out.println(e.printExercise(exercise));
        
        
    }
    
}
