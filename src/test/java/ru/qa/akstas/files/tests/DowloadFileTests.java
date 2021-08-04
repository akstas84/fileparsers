package ru.qa.akstas.files.tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.qa.akstas.files.utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

public class DowloadFileTests {

  @Test
  void selenideDowloadReadmeTest() throws IOException {
    Configuration.downloadsFolder = "downloads";
    open("https://github.com/selenide/selenide/blob/master/README.md");
    File dowloadedFile = $("#raw-url").download();
    String fileContent = Files.readTextFromFile(dowloadedFile);
    assertThat(fileContent, fileContent.contains("Selenide = UI Testing Framework powered by Selenium WebDriver"));
  }

  @Test
  @Disabled
  void selenideDowloadReadmeWithTryTest() {
    open("https://github.com/selenide/selenide/blob/master/README.md");
    try {
      $("#raw-url").download();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
