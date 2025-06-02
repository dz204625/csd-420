package module1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Card extends Application {

    private static final int CARD_COUNT = 52;
    private static final int DISPLAY_COUNT = 4;
    private static final String IMAGE_PATH = "src/module1/cards/";

    private final ArrayList<Image> deck = new ArrayList<>();
    private final HBox cardBox = new HBox(10); // Horizontal layout with spacing

    @Override
    public void start(Stage primaryStage) {
        loadCardImages();

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        BorderPane root = new BorderPane();
        root.setCenter(cardBox);
        root.setBottom(refreshButton);
        BorderPane.setMargin(refreshButton, new javafx.geometry.Insets(10));

        displayRandomCards();

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCardImages() {
        for (int i = 1; i <= CARD_COUNT; i++) {
            File file = new File(IMAGE_PATH + i + ".png");
            Image cardImage = new Image(file.toURI().toString());
            deck.add(cardImage);
        }
    }

    private void displayRandomCards() {
        cardBox.getChildren().clear();
        Collections.shuffle(deck);

        deck.stream()
                .limit(DISPLAY_COUNT)
                .map(image -> {
                    ImageView view = new ImageView(image);
                    view.setFitWidth(100);
                    view.setPreserveRatio(true);
                    return view;
                })
                .forEach(cardBox.getChildren()::add);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
