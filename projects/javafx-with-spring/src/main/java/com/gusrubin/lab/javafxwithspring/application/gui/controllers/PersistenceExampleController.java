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
		this.wordDelete.setOnAction(actionEvent -> deleteWord());
		refreshWordList();
	}

	private void refreshWordList() {
		this.persistenceUseCase.getAll().stream().forEach(this.wordList.getItems()::add);
	}

	private void deleteWord() {
		WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			this.persistenceUseCase.delete(selectedItem.getId());
			this.wordList.getItems().remove(selectedItem);
		}
	}

	private Stage getStage() {
		return (Stage) persistenceExamplePane.getScene().getWindow();
	}

	private void showAddNewWordDialog() {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("New Word");
		dialog.setHeaderText("Type the new word:");

		// Crie um campo de texto no diálogo
		TextField textField = new TextField();
		dialog.getDialogPane().setContent(textField);

		// Adicione botões padrão (OK e Cancelar)
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// Bloqueie o pai enquanto o diálogo estiver aberto
		dialog.initOwner(getStage());
		dialog.initModality(Modality.WINDOW_MODAL);

		// Mostre o diálogo e aguarde que o usuário o feche
		Optional<ButtonType> result = dialog.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			String newWord = textField.getText();

			var wordRecord = this.persistenceUseCase.post(WordRecord.builder().word(newWord).build());
			this.wordList.getItems().add(wordRecord);
		}
	}

}
