package module10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class FanManager extends Application {

  // DB connection variables
  private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
  private static final String DB_USER = "student1";
  private static final String DB_PASSWORD = "pass";

  // UI components
  private TextField idField = new TextField();
  private TextField firstNameField = new TextField();
  private TextField lastNameField = new TextField();
  private TextField favoriteTeamField = new TextField();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Fan Manager");

    // Layout
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(10);

    grid.add(new Label("ID:"), 0, 0);
    grid.add(idField, 1, 0);
    grid.add(new Label("First Name:"), 0, 1);
    grid.add(firstNameField, 1, 1);
    grid.add(new Label("Last Name:"), 0, 2);
    grid.add(lastNameField, 1, 2);
    grid.add(new Label("Favorite Team:"), 0, 3);
    grid.add(favoriteTeamField, 1, 3);

    Button displayBtn = new Button("Display");
    Button updateBtn = new Button("Update");
    grid.add(displayBtn, 0, 4);
    grid.add(updateBtn, 1, 4);

    displayBtn.setOnAction(e -> displayFan());
    updateBtn.setOnAction(e -> updateFan());

    stage.setScene(new Scene(grid, 400, 250));
    stage.show();
  }

  private void displayFan() {
    String idText = idField.getText().trim();
    if (idText.isEmpty()) {
      showAlert("Error", "Please enter an ID.");
      return;
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT firstname, lastname, favoriteteam FROM fans WHERE id = ?")) {

      stmt.setInt(1, Integer.parseInt(idText));
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        firstNameField.setText(rs.getString("firstname"));
        lastNameField.setText(rs.getString("lastname"));
        favoriteTeamField.setText(rs.getString("favoriteteam"));
      } else {
        showAlert("Not Found", "No record found with ID: " + idText);
      }

    } catch (Exception ex) {
      showAlert("Database Error", ex.getMessage());
    }
  }

  private void updateFan() {
    String idText = idField.getText().trim();
    if (idText.isEmpty()) {
      showAlert("Error", "Please enter an ID.");
      return;
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?")) {

      stmt.setString(1, firstNameField.getText().trim());
      stmt.setString(2, lastNameField.getText().trim());
      stmt.setString(3, favoriteTeamField.getText().trim());
      stmt.setInt(4, Integer.parseInt(idText));

      int updated = stmt.executeUpdate();
      if (updated > 0) {
        showAlert("Success", "Record updated successfully.");
      } else {
        showAlert("Error", "No record found with that ID.");
      }

    } catch (Exception ex) {
      showAlert("Database Error", ex.getMessage());
    }
  }

  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
