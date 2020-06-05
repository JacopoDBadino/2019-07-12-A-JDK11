/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */

package it.polito.tdp.food;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Food;
import it.polito.tdp.food.model.FoodPeso;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtPorzioni"
	private TextField txtPorzioni; // Value injected by FXMLLoader

	@FXML // fx:id="txtK"
	private TextField txtK; // Value injected by FXMLLoader

	@FXML // fx:id="btnAnalisi"
	private Button btnAnalisi; // Value injected by FXMLLoader

	@FXML // fx:id="btnCalorie"
	private Button btnCalorie; // Value injected by FXMLLoader

	@FXML // fx:id="btnSimula"
	private Button btnSimula; // Value injected by FXMLLoader

	@FXML // fx:id="boxFood"
	private ComboBox<String> boxFood; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCreaGrafo(ActionEvent event) {
		try {

			boxFood.getItems().clear();
			model.creaGrafo(Integer.parseInt(txtPorzioni.getText()));

			System.out.println(model.getGrafo().vertexSet().size());
			System.out.println(model.getGrafo().edgeSet().size());

			for (Food f : model.getGrafo().vertexSet())
				boxFood.getItems().add(f.getDisplay_name());

		} catch (Exception e) {
			System.out.println("ERRORE");
		}
	}

	@FXML
	void doCalorie(ActionEvent event) {
		txtResult.clear();
		txtResult.appendText("Analisi calorie...");

		List<FoodPeso> res = new ArrayList<FoodPeso>();

		for (Food fAtt : model.getGrafo().vertexSet())
			if (fAtt.getDisplay_name().equals(boxFood.getValue()))
				res.addAll(model.getCalorie(fAtt));

		System.out.print(res.size());

		for (int i = 0; i < res.size(); i++) {
			txtResult.appendText(
					"\nNome cibo: " + res.get(i).getFood().getDisplay_name() + " | Peso: " + res.get(i).getPeso());

			if (i == 4)
				i = res.size();
		}
	}

	@FXML
	void doSimula(ActionEvent event) {
		txtResult.clear();
		txtResult.appendText("Simulazione...");
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtPorzioni != null : "fx:id=\"txtPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
		assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Food.fxml'.";
		assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
		assert btnCalorie != null : "fx:id=\"btnCalorie\" was not injected: check your FXML file 'Food.fxml'.";
		assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Food.fxml'.";
		assert boxFood != null : "fx:id=\"boxFood\" was not injected: check your FXML file 'Food.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
