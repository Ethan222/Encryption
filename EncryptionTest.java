import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class EncryptionTest extends Application
{
   public static void main(String args[])
   {
      launch(args);
   }

   public void start(Stage primaryStage)
   {
      Encryption e = new Encryption();

      primaryStage.setTitle("Encryption");
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));
      
      Text title = new Text("Encryption");
      title.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));
      grid.add(title, 0, 0, 2, 1);
      
      Label dataLabel = new Label("Enter data: ");
      grid.add(dataLabel, 0, 1);
      
      TextField data = new TextField("Hello there");
      grid.add(data, 1, 1);

      Button encrypt = new Button("Encrypt");
      grid.add(encrypt, 2, 1);
      encrypt.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.setData(data.getText());
         }
      });

      Button alpha = new Button("Alpha");
      Button beta = new Button("Beta");
      Button gamma = new Button("Gamma");
      Button delta = new Button("Delta");
      Button omega = new Button("Omega");

      HBox hb = new HBox(10);
      hb.setAlignment(Pos.BOTTOM_RIGHT);
      hb.getChildren().add(alpha);
      hb.getChildren().add(beta);
      hb.getChildren().add(gamma);
      hb.getChildren().add(delta);
      hb.getChildren().add(omega);
      grid.add(hb, 1, 4);

      alpha.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.alphaEncrypt();
            data.setText(e);
         }
      });

      beta.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.betaEncrypt();
            data.setText(e);
         }
      });

      gamma.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.gammaEncrypt();
            data.setText(e);
         }
      });

      delta.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.deltaEncrypt();
            data.setText(e);
         }
      });

      omega.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            e.omegaEncrypt();
            data.setText(e);
         }
      });

      Scene scene = new Scene(grid, 330, 275);
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}