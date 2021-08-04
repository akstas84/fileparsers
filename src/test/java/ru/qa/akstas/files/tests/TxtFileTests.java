package ru.qa.akstas.files.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;
import ru.qa.akstas.files.utils.Files;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static ru.qa.akstas.files.utils.Files.*;

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
    String cvsFilePath = "./src/test/resources/files/1.csv";
    String expectedData = "hello qa students!";
    String actualData = Files.readTextFromPath(cvsFilePath);
    assertThat(actualData, containsString(expectedData));
  }

  @Test
  void pdfTest() throws IOException {
    String pdfFilePath = "./src/test/resources/files/1.pdf";
    String expectedData = "Инженер LiveRebel в ZeroTurnaround";
    PDF pdf = getPDF(pdfFilePath);
    assertThat(pdf, containsText(expectedData));
  }

  @Test
  void xlsSimpleTest() throws IOException {
    String xlsFilePath = "./src/test/resources/files/1.xls";
    String expectedData = "40820810590480000591";
    XLS xls = getXLS(xlsFilePath);
    assertThat(xls, XLS.containsText(expectedData));
  }

  @Test
  void xlsCellTest() throws IOException {
    String xlsFilePath = "./src/test/resources/files/1.xls";
    String expectedData = "Выписка";
    XLS xls = getXLS(xlsFilePath);
    String actualData = xls.excel.getSheetAt(0).getRow(0).getCell(0).toString();
    assertThat(actualData, containsString(expectedData));
  }
}
