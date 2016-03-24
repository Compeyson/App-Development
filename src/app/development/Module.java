package app.development;

/**
 *
 * @author Inez Wester
 * @since 24/03/2016
 */
public class Module {
    /* arraySpecifics[0] module ID
     * arraySpecifics[1] wrong answer counter
     * arraySpecifics[2] right answer counter
     * arraySpecifics[3] module complete 1, module incomplete 0
     * arraySpecifics[4]  - arraySpecifics[14] used for the completed counter
     * arraySpecifics[15] location of the last exercise
     */
    int[] arraySpecifics =  new int[16];
    Exercise exercise = new Exercise();
    ExerciseGeneration e = new ExerciseGeneration();
    
    public int[] initializeModule(int moduleID){
        arraySpecifics[0] = moduleID;
        //initialize module array
        for(int i = 1; i < 16; i++){
            if(i > 3 && i <15){
                arraySpecifics[i] = -1;
            }else{
                arraySpecifics[i] = 0;
            }
        }
        
        return arraySpecifics;
    }
    
    /**
     * 
     * @param module
     * @param answerCorrect check if the last answer was correct
     * @param exercise
     * @return 
     */
    public Exercise getExercise(Module module, boolean answerCorrect, 
            Exercise exercise){
        int moduleID = arraySpecifics[0];
        int nextModule;
        
        arraySpecifics = checkModuleState(arraySpecifics, answerCorrect);
        System.out.println("back in get exercise module");
        if(arraySpecifics[3] == 1){ //module is complete
            nextModule = arraySpecifics[0] + 1;
            initializeModule(nextModule);
            System.out.println("in if statement");
        }else{
            System.out.println("initializing exercise");
            exercise = exerciseSpecifics(moduleID, arraySpecifics, exercise);
        }
        
        return exercise;
    }
    
    /**
     * 
     * @param arraySpecifics
     * @param answerCorrect
     * @return 
     */
    public int[] checkModuleState(int[] arraySpecifics, boolean answerCorrect){
        int loadLocation;
        int rightcount = 0;
        
        //initialization of the module
        if(arraySpecifics[4] == -1){
            //location next exercise answer should be loaded
            arraySpecifics[15] = 4;
        }else{
            loadLocation = arraySpecifics[15];
        
            //load in new answer
            if(answerCorrect){
                arraySpecifics[loadLocation] = 1;
                arraySpecifics[2] = arraySpecifics[2] + 1;
            }else{
                arraySpecifics[loadLocation] = 0;
                arraySpecifics[1] = arraySpecifics[1] + 1;
            } 
            
            //load next location
            arraySpecifics[15] = arraySpecifics[15] + 1;
            if(arraySpecifics[15] > 14){
                arraySpecifics[15] = 4;
            }
            
            //counting the last ten questions
            for(int i = 4; i < 15; i++){
                rightcount = rightcount + arraySpecifics[i];
            }
            
            System.out.println("counted questions");
        
            //checking if module is finished
            if(rightcount > 7){
                arraySpecifics[3] = 1;
            }else{
                arraySpecifics[3] = 0;
            }
        }
                
        return arraySpecifics;
    }
    
    /**
     * 
     * @param moduleID the module the exercise is generated for
     * @param arraySpecifics
     * @param exercise
     * @return the next exercise of the module
     */
    public Exercise exerciseSpecifics(int moduleID, int[] arraySpecifics, 
            Exercise exercise){
        int progress;
      
        //making sure there are limits to early exercises
        progress = arraySpecifics[15] - 4;
        if(progress < 3){
            progress = 3;
        }
        
        switch(moduleID){
            case 1: //stableOrder
                if(arraySpecifics[4] == 2){
                   exercise = e.generateExercise(4,1,exercise); 
                }else{
                   exercise = e.generateExercise(4,9,exercise); 
                }                
                break;
            case 2: //orderIrrelevance
                if(exercise.count == 0){ //not yet been flipped
                    exercise = e.generateExercise(1,progress,exercise);
                }else{//flipped new exercise
                    exercise = e.generateExercise(2,progress,exercise);
                }
                break;
            case 3: //oneToOne
                exercise = e.generateExercise(1,progress,exercise);
                break;
            case 4: //cardinality
                exercise = e.generateExercise(3,progress,exercise);
                break;
        }
 
        return exercise;
    }
    
    /**
     * Exercise to readable input (only for verifying uses)
     * 
     * @param exercise
     * @return 
     */
    public String printExercise(Exercise exercise){
        String result;
        result = ("question: " + exercise.exerciseImages[0].object + " " +
                Integer.toString(exercise.image1.count) + " " + 
                 " correct answer location: " + 
                Integer.toString(exercise.correctAnswer));
        
        return result;
    }
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Module m = new Module();
        Exercise exercise = new Exercise();
        ExerciseGeneration e = new ExerciseGeneration();
                
        //testing
        m.initializeModule(1);
        exercise = m.getExercise(m, false, exercise);
        System.out.println(e.printExercise(exercise));
        
        m.getExercise(m, true, exercise);
        System.out.println(e.printExercise(exercise));
        
        m.getExercise(m, true, exercise);
        System.out.println(e.printExercise(exercise));
        
        m.getExercise(m, true, exercise);
        System.out.println(e.printExercise(exercise));
    } 
}
