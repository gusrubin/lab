package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.in.gui.controllers;

import com.gusrubin.lab.javafxwithspring.application.port.in.PersistenceUseCase;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordCreateDto;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordUpdateDto;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@FxmlView("/views/PersistenceExampleView.fxml")
@RequiredArgsConstructor
public class PersistenceExampleController {

  private final PersistenceUseCase persistenceUseCase;

  @FXML private AnchorPane persistenceExamplePane;

  @FXML private ListView<WordRecord> wordList;

  @FXML private Button wordNew;

  @FXML private Button wordEdit;

  @FXML private Button wordDelete;

  @FXML private TextField wordFilter;

  @FXML
  public void initialize() {
    log.debug("initialize PersistenceExampleController");
    this.wordNew.setOnAction(actionEvent -> showAddNewWordDialog());
    this.wordEdit.setOnAction(actionEvent -> showEditWordDialog());
    this.wordDelete.setOnAction(actionEvent -> deleteWord());
    this.wordFilter.setOnKeyTyped(event -> filterWord(this.wordFilter.getText()));
    refreshWordList();
  }

  private void refreshWordList() {
    this.persistenceUseCase.getAll().forEach(this.wordList.getItems()::add);
  }

  private Stage getStage() {
    return (Stage) persistenceExamplePane.getScene().getWindow();
  }

  private void showAddNewWordDialog() {
    var newWord = showWordDialog("Add Word");

    if (newWord != null) {
      var wordRecord = this.persistenceUseCase.post(new WordRecordCreateDto(newWord));
      this.wordList.getItems().add(wordRecord);
    }
  }

  private void showEditWordDialog() {
    var newWord = showWordDialog("Edit Word");

    if (newWord != null) {
      WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
      this.persistenceUseCase.putById(selectedItem.getId(), new WordRecordUpdateDto(newWord));

      var indexOfSelectedItem = this.wordList.getItems().indexOf(selectedItem);
      this.wordList.getItems().get(indexOfSelectedItem).update(new WordRecordUpdateDto(newWord));
      this.wordList.refresh();
    }
  }

  private void deleteWord() {
    WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      this.persistenceUseCase.deleteById(selectedItem.getId());
      this.wordList.getItems().remove(selectedItem);
    }
  }

  private void filterWord(String text) {
    var filteredWordList = this.persistenceUseCase.getByFilter(text);
    this.wordList.setItems(FXCollections.observableArrayList(filteredWordList));
  }

  private String showWordDialog(String title) {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle(title);
    dialog.setHeaderText("Type the new word:");

    TextField textField = new TextField();
    dialog.getDialogPane().setContent(textField);

    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    dialog.initOwner(getStage());
    dialog.initModality(Modality.WINDOW_MODAL);

    Platform.runLater(
        () -> {
          textField.requestFocus();
          textField.positionCaret(textField.getText().length());
        });

    Optional<ButtonType> result = dialog.showAndWait();

    String newWord = null;

    if (result.isPresent() && result.get() == ButtonType.OK) {
      newWord = textField.getText();
    }

    return newWord;
  }
}
