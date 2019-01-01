package outputgeneration.commandlineoutput;

import inputhandeling.csvfilereader.CsvTimeReader;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import period.Period;
import utils.FindFolder;
import utils.testhelpmethods.HardComarisonFileReader;

public class TextOutputFactoryTest {


    @DisplayName("commandlineOutputGenerationTest")
    @ParameterizedTest
    @CsvSource(value = {
            "testOutputGenerationWeek.csv,expectedOutPutWeek.txt",
            "testOutputGenerationMonth.csv,expectedOutPutMonth.txt"
    })
    public void commandlineOutputGenerationTest(String inputMockFile,String expectedOutputFile){
        String StartFolderTestFilesToUse=FindFolder.projectRootFolderLocation()+"/src/test/java/outputgeneration/commandlineoutput/";

        Period period = CsvTimeReader.readingInput(StartFolderTestFilesToUse+inputMockFile);

        String stringGeneratedForOutput= TextOutputFactory.generateOutputAsString(period);

        String expectedOUtput= HardComarisonFileReader.readFileForComparison(StartFolderTestFilesToUse+expectedOutputFile);

        Assert.assertEquals(expectedOUtput,stringGeneratedForOutput);

    }
}
