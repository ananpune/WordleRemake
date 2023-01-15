package assign4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {

    @FXML
    private Button guessButton;

    @FXML
    private TextField guessText;

    @FXML
    private TextFlow textflow;

    private NerdleEngine nerdle = new NerdleEngine();

    @FXML
    private void guessButtonClicked(ActionEvent event) {
        GuessResponse response = nerdle.makeGuess(guessText.getText().toUpperCase());
        guessText.setText("");
        provideGuessFeedback(response);
        checkForWinner(response);
    }

    private void provideGuessFeedback(GuessResponse response) {
        Text text1 = new Text("\nGuess #" + response.getGuessNumber() + ": ");
        text1.setFont(Font.font("Verdana", 25));
        textflow.getChildren().add(text1);
        for (int i = 0; i < 5; i++) {
            Text currentLetter = new Text("" + response.getGuess().charAt(i));
            formatGuessResponse(currentLetter, response.getLetterStatus()[i]);
            textflow.getChildren().add(currentLetter);
        }
    }

    private void checkForWinner(GuessResponse response) {
        if (response.isWinner()) {
            Text winner = new Text("\n\n   WINNER!!!\n");
            winner.setFill(Color.RED);
            winner.setFont(Font.font("Verdana", 30));
            textflow.getChildren().add(winner);
            guessButton.setDisable(true);
            guessText.setDisable(true);
        }
    }

    private void formatGuessResponse(Text text, int matchValue) {
        text.setFont(Font.font("Verdana", 25));
        switch (matchValue) {
            case 1:
                text.setFill(Color.BLUE);
                break;
            case 2:
                text.setFill(Color.GREENYELLOW);
                break;
            default:
                text.setFill(Color.DARKGRAY);
        }
        text.setFont(Font.font("Verdana", 25));
    }
}
