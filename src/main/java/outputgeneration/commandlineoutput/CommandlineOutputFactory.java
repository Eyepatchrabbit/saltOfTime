package outputgeneration.commandlineoutput;

import period.Period;

import java.text.DecimalFormat;

import static java.lang.Math.round;

public class CommandlineOutputFactory {


    public static String generateOutputAsString(Period period){
        String primaryUnderliner="=";
        String secondaryUnderliner="-";


        //basic elements indicators period
        String header="Period Summary";
        String periodType="PeriodType";
        String startOfPeriod="startOfPeriod";
        String periodLength="periodLength";

        //PeriodReportingElements
        String periodReportingElements="PeriodReportingElements";
        String totalTimeDifference="totalTimeDifference";
        String differenceType="differenceType";
        String totalDaysFilledIn="totalDaysFilledIn";
        String totalDaysFilledInPercentage="totalDaysFilledInPercentage";
        String totalNumberWeekdays="totalNumberWeekdays";
        String totalDaysInPeriod="totalDaysInPeriod";


        StringBuilder outputBuilder = new StringBuilder();

        //Main Header
        outputBuilder.append(headerInboxing(header));

        //Base info on the period
        outputBuilder.append(outputParameterAndValue(periodType, period.getPeriodType().toString()));
        outputBuilder.append(outputParameterAndValue(startOfPeriod,period.getStartOfPeriod().toString()));
        outputBuilder.append(outputParameterAndValue(periodLength,String.valueOf(period.getPeriodLength())));

        outputBuilder.append("\n");
        outputBuilder.append(underliningHeader( periodReportingElements, primaryUnderliner));
        outputBuilder.append(outputParameterAndValue(totalTimeDifference,String.valueOf(period.getPeriodReporting().getTotalTimeDifference())));
        outputBuilder.append(outputParameterAndValue(differenceType, period.getPeriodReporting().getDifferenceType().toString()));
        outputBuilder.append(outputParameterAndValue(totalDaysInPeriod,String.valueOf(period.getPeriodReporting().getTotalDaysInPeriod())));
        outputBuilder.append(outputParameterAndValue(totalDaysFilledIn,String.valueOf( period.getPeriodReporting().getTotalDaysFilledIn())));
        outputBuilder.append(outputParameterAndValue(totalDaysFilledInPercentage,String.valueOf( outputPercentage(period.getPeriodReporting().getTotalDaysFilledInPercentage()))));
        outputBuilder.append(outputParameterAndValue(totalNumberWeekdays,String.valueOf(period.getPeriodReporting().getTotalNumberWeekdays())));


        //now something to add info on the day






        return outputBuilder.toString();
    }



    private static String underliningHeader(String headline, String underline){
        return headline+"\n"+lineMaker(headline.length(),underline)+"\n";
    }

    private static String outputParameterAndValue(String parameter, String value){
        return outputParameterAndValue(parameter,value,0);
    }

    private static String outputParameterAndValue(String parameter, String value, int numberOfTabs){
        String tabsSetBefore="";
        for (int tabs=0;tabs<numberOfTabs;tabs++){
            tabsSetBefore=tabsSetBefore+"\t";
        }

        return parameter+": "+value+"\n";
    }


    private static String headerInboxing(String header){
        int lengthHeader=header.length();

        String bottumnAndTop=addingStartAndStopElemnt(lineMaker(lengthHeader+2,"#"),"#");

        return bottumnAndTop+"\n"+addingStartAndStopElemnt(header,"# ")+"\n" +bottumnAndTop+"\n";
    }


    private static String lineMaker(int lengthHeader, String underline){
        String underliningHeader="";
        for (int repeats=0;repeats < lengthHeader;repeats++){
            underliningHeader=underliningHeader+underline;
        }

        return underliningHeader;
    }

    private static String addingStartAndStopElemnt(String tobeInboxed, String inboxingElement){
        return inboxingElement+tobeInboxed+reverseStringElements(inboxingElement);
    }

    private static String reverseStringElements(String toBeReversed){
        return new StringBuilder(toBeReversed).reverse().toString();
    }

    private static String outputPercentage(double percentageInDouble){
        DecimalFormat df = new DecimalFormat("#.##");
        return String.valueOf(Double.valueOf(df.format(percentageInDouble*100)))+"%";
    }


}
