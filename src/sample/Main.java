package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class Main extends Application {

  private Stage window;
  private TableView<Product> table;
  private TextField nameInput, priceInput, quantityInput;

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("TableView");

    // Name Column
    TableColumn<Product, String> namecolumn = new TableColumn<>("Name");
    namecolumn.setMinWidth(200);
    namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

    // Price Column
    TableColumn<Product, Double> pricecolumn = new TableColumn<>("Price");
    pricecolumn.setMinWidth(200);
    pricecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

    // Quantity Column
    TableColumn<Product, Integer> quantitycolumn = new TableColumn<>("Quantity");
    quantitycolumn.setMinWidth(200);
    quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));


    //name input
    nameInput = new TextField();
    nameInput.setPromptText("Name");
    nameInput.setMinWidth(100);

    //price input
    priceInput = new TextField();
    priceInput.setPromptText("Price");
    priceInput.setMinWidth(100);

    //quantity input
    quantityInput = new TextField();
    quantityInput.setPromptText("Quantity");
    quantityInput.setMinWidth(100);


    table = new TableView<>();
    table.setItems(getProcuct());
    table.getColumns().addAll(namecolumn, pricecolumn, quantitycolumn);


    //Button
    Button add = new Button("Add");
    Button delete = new Button("Delete");

    HBox hbox = new HBox();
    hbox.setPadding(new Insets(10,10,10,10));
    hbox.setSpacing(10);
    hbox.getChildren().addAll(nameInput, priceInput, quantityInput, add, delete);

    VBox vBox = new VBox();
    vBox.getChildren().addAll(table, hbox);

    StackPane layout = new StackPane();

    Scene scene = new Scene(vBox);
    window.setScene(scene);
    window.show();
  }

  private ObservableList<Product> getProcuct() {
    ObservableList<Product> products = FXCollections.observableArrayList();
    products.add(new Product("Laptop", 850, 5));
    products.add(new Product("Ball", 0.4, 58));
    products.add(new Product("Toilet", 99, 10));
    products.add(new Product("Cap", 50, 8));
    products.add(new Product("Server", 1000, 45));
  return products;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
