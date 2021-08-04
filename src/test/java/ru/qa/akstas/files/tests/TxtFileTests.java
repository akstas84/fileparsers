package ru.qa.akstas.files.tests;

import org.junit.jupiter.api.Test;
import ru.qa.akstas.files.utils.Files;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class TxtFileTests {

  @Test
  void txtTest() throws IOException {
    String txtFilePath = "./src/test/resources/files/1.txt";
    String expectedData = "hello!";
    String actualData = Files.readTextFromPath(txtFilePath);
    assertThat(actualData, containsString(expectedData));
  }

  @Test
  void csvTest() throws IOException {
    String txtFilePath = "./src/test/resources/files/1.csv";
    String expectedData = "hello qa students!";
    String actualData = Files.readTextFromPath(txtFilePath);
    assertThat(actualData, containsString(expectedData));
  }
}
