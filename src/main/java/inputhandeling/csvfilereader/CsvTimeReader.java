package inputhandeling.csvfilereader;

import com.opencsv.CSVReader;
import period.Period;
import period.PeriodFactory;
import periodreporting.PeriodReportingFactory;
import timedifference.TimePlacer;

import java.io.FileReader;
import java.time.LocalDate;

public class CsvTimeReader {

    public static Period readingInput(String fileLocation){
        Period period=new Period();

        //filestructure: Year;Month;Day;Period;minutesdifferenceInDay
        try {

            // Create an object of filereader
            FileReader filereader = new FileReader(fileLocation);

            // create csvReader object passing
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            boolean hasFirstLineNotPassed=true;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord[0].contains("#")){
                    continue;
                }

                LocalDate date=LocalDate.of(
                        Integer.parseInt(nextRecord[0]),
                        Integer.parseInt(nextRecord[1]),
                        Integer.parseInt(nextRecord[2]));

                //only at first line => make period setup
                if (hasFirstLineNotPassed){
                    String periodType=nextRecord[3];

                    if ("week".equals(periodType.toLowerCase())) {
                        period = PeriodFactory.weekBuilder(date);

                    }else if ("month".equals(periodType.toLowerCase())){
                        period=PeriodFactory.monthBuilder(date);

                    }else {
                        throw new IllegalArgumentException();
                    }

                    hasFirstLineNotPassed=false;
                }

                //set the given time for the days in the inputfile
                period.setDaysInPeriod(TimePlacer.inputTimeDifference(
                        period.getDaysInPeriod(),
                        date,
                        Integer.parseInt( nextRecord[4])));



            }

            period.setPeriodReporting(PeriodReportingFactory.makeReportOfPeriod(period.getDaysInPeriod()));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return period;
    }



}
