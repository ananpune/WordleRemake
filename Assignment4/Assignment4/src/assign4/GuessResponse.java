package assign4;

public class GuessResponse {
    private int guessNumber;
    private boolean winner = false;
    private String guess;
    private int [] letterStatus;
    public GuessResponse(int guessNumber, boolean winner, String guess , int [] letterStatus) {
        this.guessNumber = guessNumber;
        this.winner = winner;
        this.guess = guess;
        this.letterStatus = letterStatus;
    }
    public int getGuessNumber() {
        return guessNumber;
    }

    public boolean isWinner() {
        return winner;
    }
    
    public String getGuess() {
        return guess;
    }
   
    public int[] getLetterStatus() {
        return letterStatus;
    }
   
    
    
  
    
}
