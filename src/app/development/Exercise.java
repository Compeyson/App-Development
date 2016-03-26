/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.development;

/**
 *
 * @author Inez wester
 * @since 24/03/2016
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
    
    /* slot 0-8 are the question images for above the screen
     * slot 9-11 are the answer images
     * an image object consists of the file name of the image and a 0 if the
     * image is not a button 1 if it is a button
     */
    Image[] exerciseImages;
    
    //the position where the correct answer is located
    int correctAnswer;
    
    //Question
    String question;
    
    //for order irrelevance method
    int count;
    
    //need to play video
    boolean playVideo;
       
}