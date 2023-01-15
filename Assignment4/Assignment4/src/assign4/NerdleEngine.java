package assign4;
import java.util.Scanner;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class NerdleEngine {
    
    private int guessNumber;
    private String secretWord;    

    public NerdleEngine(){
        this.guessNumber = 0;
        //catching no file errors
        try{
        this.secretWord = selectSecretWordFromFile();
        }
        catch(Exception e){
            System.out.println("no file");
        }
    }

    private String selectSecretWordFromFile(){
        String wordSelected="";
        //25 words in file
        int numWords = 25;
        //picking a random number between 1 and 25 because there are 25 words
        int randomNum = new Random().nextInt(numWords);

        try{

            //reading file and scanning through to make sure it is not empty, read about filereader on w3schools
            //I initially tried with just making a File and realized that I would constantly have a No File Found,
            //Used the FileReader and it made it work fine! 
            FileReader file = new FileReader("src/assign4/words.txt");
            Scanner scanner = new Scanner(file);
            //moving to the random number index
            for(int i = 0; i < randomNum; i++){
                scanner.nextLine();
            }
            //assigning the random word to wordSelected
            wordSelected = scanner.nextLine();
            //close scanner
            scanner.close();
        }
        catch(FileNotFoundException e){
            //if no file
            System.out.println("File not found");
        }
        //return the random word
        System.out.println(wordSelected);
        return wordSelected;

    }

    public GuessResponse makeGuess(String userGuess){
        //increment guess number because guess is made
        guessNumber++;
        //set initial win value to false
        boolean win = false;
        //array with 5 spaces
        int [] letterStatus = new int[5];
        //so I noticed a default 0 cause so assumed we did not have to catch those

        
        if (userGuess.length() != 5){
            return new GuessResponse(guessNumber, win, userGuess, letterStatus);

        //the 1 case we do two loops, one for the secret and one for guess, if the same character
        //is anywhere within the words, we will set that space as 1 in our int array
       
        }
        for(int i=0; i<5; i++){
            for(int j=0;j<5;j++){
                if(userGuess.charAt(i) == secretWord.charAt(j)){
                    letterStatus[i] = 1;
                }
              
            }
        }
        //the 2 case is easiest, just see if both words hold the same character in the same space
        for(int a=0; a<5; a++){
            if(userGuess.charAt(a) == secretWord.charAt(a)){
                letterStatus[a] = 2;
            }
        }
        
        

        if(userGuess.equals(secretWord)){
            //checking win condition, if words match, return with a true as win
            win = true;
            return new GuessResponse(guessNumber, win, userGuess, letterStatus);
        }
        else{
            //if not return with false as win
            return new GuessResponse(guessNumber, win, userGuess, letterStatus);
        }





   
    }
}