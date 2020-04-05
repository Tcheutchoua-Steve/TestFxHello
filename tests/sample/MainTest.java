package sample;

import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTest extends ApplicationTest {
  @Override
  public  void start(Stage stage) throws Exception {
    Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
    stage.setScene(new Scene(mainNode));
    stage.show();
    stage.toFront();
  }
}