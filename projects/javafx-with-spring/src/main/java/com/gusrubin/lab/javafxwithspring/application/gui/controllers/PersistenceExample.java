package com.gusrubin.lab.javafxwithspring.application.gui.controllers;

import org.springframework.stereotype.Component;

import com.gusrubin.lab.javafxwithspring.domain.persistence.PersistenceUseCase;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord;

import javafx.collections.ObservableList;
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
@FxmlView("/views/PersistenceExample.fxml")
@RequiredArgsConstructor
public class PersistenceExample {

	private final PersistenceUseCase persistenceUseCase;

	@FXML
	private AnchorPane pane;

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
		log.debug("initialize PersistenceExample");
		this.wordNew.setOnAction(actionEvent -> addWord("bla"));
		this.wordDelete.setOnAction(actionEvent -> deleteWord());
	}

	private void addWord(String word) {
		this.persistenceUseCase.post(WordRecord.builder().word(word).build());

		var wordRecordList = this.persistenceUseCase.getAll();

		ObservableList<WordRecord> items = wordList.getItems();
		items.clear();

		wordRecordList.stream().forEach(items::add);
	}

	private void deleteWord() {
		WordRecord selectedItem = this.wordList.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			this.persistenceUseCase.delete(selectedItem.getId());
			this.wordList.getItems().remove(selectedItem);
		}
	}

	private Stage getStage() {
		return (Stage) pane.getScene().getWindow();
	}

	private void showCustomDialog(Stage parentStage) {
		Dialog<String> dialog = new Dialog<>();
		dialog.setTitle("Diálogo Personalizado");
		dialog.setHeaderText("Digite alguma coisa:");

		// Crie um campo de texto no diálogo
		TextField textField = new TextField();
		dialog.getDialogPane().setContent(textField);

		// Adicione botões padrão (OK e Cancelar)
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// Bloqueie o pai enquanto o diálogo estiver aberto
		dialog.initOwner(parentStage);
		dialog.initModality(Modality.WINDOW_MODAL);

		// Mostre o diálogo e aguarde que o usuário o feche
//		Optional<ButtonType> result = dialog.show();
		dialog.show();

//		if (result.isPresent() && result.get() == ButtonType.OK) {
//			String input = textField.getText();
//		}
	}

}
