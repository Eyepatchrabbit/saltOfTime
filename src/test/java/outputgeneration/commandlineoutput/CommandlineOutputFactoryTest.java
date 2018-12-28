package outputgeneration.commandlineoutput;

import inputhandeling.csvfilereader.CsvTimeReader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import period.Period;
import utils.FindFolder;

public class CommandlineOutputFactoryTest {

    @Disabled
    @DisplayName("commandlineOutputGenerationTest")
    @Test
    public void commandlineOutputGenerationTest(){
        String finalLocationTestFile= FindFolder.projectRootFolderLocation()+"/src/test/java/outputgeneration/commandlineoutput/testoutputGeneration.csv";

        Period period = CsvTimeReader.readingInput(finalLocationTestFile);

        String stringgenerated= CommandlineOutputFactory.generateOutputAsString(period);

        //System.out.println( period.getStartOfPeriod());

        System.out.println(stringgenerated);

        //System.out.println("\n\ntest ok");


    }
}
