package sample;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class MainTest extends ApplicationTest {
  @Override
  public  void start(Stage stage) throws Exception {
    Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
    stage.setScene(new Scene(mainNode));
    stage.show();
    stage.toFront();
  }

  @Before
  public void setUp () throws Exception {
  }

  @After
  public void tearDown () throws Exception {
    FxToolkit.hideStage();
    release(new KeyCode[]{});
    release(new MouseButton[]{});
  }

  @Test
  public void testEnglishInput () {
    Label label = (Label) GuiTest.find("#label");

    clickOn("#inputField");
    write("This is a test!");
    clickOn("#applyButton");
    assertThat(label.getText(), is("This is a test!"));
  }

  @Test
  public void testFrenchInput () {
    Label label = (Label) GuiTest.find("#label");

    clickOn("#inputField");
    write("C'est un test!");
    clickOn("#applyButton");
    assertThat(label.getText(), is("C'est un test!"));
  }

  @Test
  public void testNumericalInput () {
    Label label = (Label) GuiTest.find("#label");

    clickOn("#inputField");
    write("123456789");
    clickOn("#applyButton");
    assertThat(label.getText(), is("123456789"));
  }
}