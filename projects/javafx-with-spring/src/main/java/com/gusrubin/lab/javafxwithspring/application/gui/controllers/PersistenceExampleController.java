package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceUseCase;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;

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

@Slf4j
@Component
@FxmlView("/views/PersistenceExampleView.fxml")
@RequiredArgsConstructor
public class PersistenceExampleController {

	private final PersistenceUseCase persistenceUseCase;

	@FXML
	private AnchorPane persistenceExamplePane;

	@FXML
	private ListView<WordRecord> wordList;

	@FXML
	private Button wordNew;

	@FXML
	private Button wordEdit;

	@FXML
	private Button wordDelete;

	@FXML
	private TextField wordFilter;

	@FXML
	public void initialize() {
		log.debug("initialize PersistenceExampleController");
		this.wordNew.setOnAction(actionEvent -> showAddNewWordDialog());
		this.wordEdit.setOnAction(actionEvent -> showEditWordDialog());
		this.wordDelete.setOnAction(actionEvent -> deleteWord());
		refreshWordList();
	}

	private void refreshWordList() {
		this.persistenceUseCase.getAll().stream().forEach(this.wordList.getItems()::add);
	}

	private Stage getStage() {
		return (Stage) persistenceExamplePane.getScene().getWindow();
	}

	private void showAddNewWordDialog() {
		var newWord = showWordDialog("Add Word");

		if (newWord != null) {
			var wordRecord = this.persistenceUseCase.post(WordRecord.builder().word(newWord).build());
			this.wordList.getItems().add(wordRecord);
		}
	}

	private void showEditWordDialog() {
		var newWord = showWordDialog("Edit Word");

		if (newWord != null) {
			WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
			this.persistenceUseCase.put(selectedItem.getId(), newWord);

			var indexOfSelectedItem = this.wordList.getItems().indexOf(selectedItem);
			this.wordList.getItems().get(indexOfSelectedItem).setWord(newWord);
			this.wordList.refresh();
		}
	}

	private void deleteWord() {
		WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			this.persistenceUseCase.delete(selectedItem.getId());
			this.wordList.getItems().remove(selectedItem);
		}
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

		Optional<ButtonType> result = dialog.showAndWait();

		String newWord = null;

		if (result.isPresent() && result.get() == ButtonType.OK) {
			newWord = textField.getText();
		}

		return newWord;
	}

}
