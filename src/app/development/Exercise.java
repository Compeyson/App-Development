/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.development;

/**
 *
 * @author Inez wester
 * @since 15/03/2016
 */
public class Exercise {
    /*
     * variables in this class will probably be defined differently later 
     *      on however it is now about the names
     */
    
    Image answer1;         //possible answer 1
    Image answer2;         //possible answer 2
    Image answer3;         //possible ansewr 3
    
    //image slots 1-9, can be empty or filled with an image
    Image image1;
    Image image2;
    Image image3;
    Image image4;
    Image image5;
    Image image6;
    Image image7;
    Image image8;
    Image image9;
    
    //the position where the correct answer is located
    int correctAnswer;
    
    public String ToString(Exercise exercise){
        return "question: " + image1.object + " " + image2.object + " " + 
                image3.object + image4.object + " " + image5.object + " " + 
                image6.object + " " + image7.object + " " + image8.object + " " 
                + image9.object + " answers: " + answer1.object + " " + 
                answer2.object + " " + answer3.object + "correct answer: " + 
                Integer.toString(correctAnswer);
    }
    
}