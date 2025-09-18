package edu.project.lernessschool.demo.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class PageSlideController {

    public TableView tableId;
    public Label lableId;
    @FXML
    private StackPane pageHolder;

    private int currentPage = 1;
    private final int totalPages = 7; // oyāta page gana wenas karanna puluwan

    @FXML
    public void initialize() {
        showPage(1, false); // first page load
    }

    @FXML
    private void handleNext() {
        if (currentPage < totalPages) {
            currentPage++;
            showPage(currentPage, true);
        }
    }

    public void handleBefor(ActionEvent actionEvent) {
        if (currentPage > 1) {
            currentPage--;
            showPage(currentPage, false);
        }
    }

    private void showPage(int pageNumber, boolean forward) {
        pageHolder.getChildren().clear();

        // label eka hadanna
        Label label = new Label("Page " + pageNumber);
        label.setStyle("-fx-font-size: 24; -fx-text-fill: white;");

        // color change karanna
        switch (pageNumber) {
            case 1 -> {
                lableId.setText("8.00");
                label.setText("8.00");
                pageHolder.setStyle("-fx-background-color: #1e3799; -fx-alignment: center;");
            }
            case 2 ->{
                lableId.setText("9.00");
                label.setText("9.00");

                pageHolder.setStyle("-fx-background-color: #38ada9; -fx-alignment: center;");
            }
            case 3 -> {
                lableId.setText("10.00");
                label.setText("10.00");

                pageHolder.setStyle("-fx-background-color: #e58e26; -fx-alignment: center;");
            }
        }

        pageHolder.getChildren().add(label);

        // Slide Animation
//        TranslateTransition slide = new TranslateTransition(Duration.millis(600), pageHolder);
//        slide.setFromX(forward ? pageHolder.getWidth() : -pageHolder.getWidth());
//        slide.setToX(0);
//        slide.play();
    }



}
