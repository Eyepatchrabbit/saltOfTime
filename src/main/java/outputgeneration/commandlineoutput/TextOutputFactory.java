package outputgeneration.commandlineoutput;

import day.Day;
import period.Period;
import periodreporting.PeriodReporting;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.round;

public class TextOutputFactory {
    private final static String primaryUnderliner="=";
    private final static String secondaryUnderliner="-";

    public static String generateOutputAsString(Period period){

        //basic elements indicators period
        String header="Period Summary";
        String periodType="PeriodType";
        String startOfPeriod="startOfPeriod";
        String periodLength="periodLength";


        StringBuilder outputBuilder = new StringBuilder();

        //Main Header
        outputBuilder.append(headerInboxing(header));

        //Base info on the period
        outputBuilder.append(outputParameterAndValue(periodType, period.getPeriodType().toString()));
        outputBuilder.append(outputParameterAndValue(startOfPeriod,period.getStartOfPeriod().toString()));
        outputBuilder.append(outputParameterAndValue(periodLength,String.valueOf(period.getPeriodLength())));

        //info from periodReporting
        outputBuilder.append("\n");
        outputBuilder.append(outputReportingInfo(period.getPeriodReporting()));


        //now something to add info on the day
        outputBuilder.append("\n");
        outputBuilder.append(outputDay(period.getDaysInPeriod()));


        return outputBuilder.toString();
    }

    private static String outputReportingInfo(PeriodReporting periodReportingInfo){
        //PeriodReportingElements
        String periodReportingElements="PeriodReportingElements";
        String totalTimeDifference="totalTimeDifference";
        String differenceType="differenceType";
        String totalDaysFilledIn="totalDaysFilledIn";
        String totalDaysFilledInPercentage="totalDaysFilledInPercentage";
        String totalNumberWeekdays="totalNumberWeekdays";
        String totalDaysInPeriod="totalDaysInPeriod";
        String totalWeekDaysFilledIn="totalWeekDaysFilledIn";
        String totalWeekDaysFilledInPercentage="totalWeekDaysFilledInPercentage";

        StringBuilder builderReprtingInfo=new StringBuilder();
        builderReprtingInfo.append(underliningHeader(periodReportingElements, primaryUnderliner));
        builderReprtingInfo.append(outputParameterAndValue(totalTimeDifference,String.valueOf(periodReportingInfo.getTotalTimeDifference())));
        builderReprtingInfo.append(outputParameterAndValue(differenceType, periodReportingInfo.getDifferenceType().toString()));
        builderReprtingInfo.append(outputParameterAndValue(totalDaysInPeriod,String.valueOf(periodReportingInfo.getTotalDaysInPeriod())));
        builderReprtingInfo.append(outputParameterAndValue(totalDaysFilledIn,String.valueOf( periodReportingInfo.getTotalDaysFilledIn())));
        builderReprtingInfo.append(outputParameterAndValue(totalDaysFilledInPercentage,String.valueOf(outputPercentage(periodReportingInfo.getTotalDaysFilledInPercentage()))));
        builderReprtingInfo.append(outputParameterAndValue(totalNumberWeekdays,String.valueOf(periodReportingInfo.getTotalNumberWeekdays())));
        builderReprtingInfo.append(outputParameterAndValue(totalWeekDaysFilledIn,String.valueOf(periodReportingInfo.getTotalWeekDaysFilledIn())));
        builderReprtingInfo.append(outputParameterAndValue(totalWeekDaysFilledInPercentage,String.valueOf( outputPercentage(periodReportingInfo.getTotalWeekDaysFilledInPercentage()))));



        return builderReprtingInfo.toString();
    }



    private static String outputDay(List<Day> daylistInPeriod){
        String headerForDays="DaysInPeriod";
        String timeDifference="TimeDifference";
        String differenceType="DifferenceType";

        StringBuilder dayInfoBuilder=new StringBuilder();

        dayInfoBuilder.append(underliningHeader(headerForDays,primaryUnderliner));

        for (Day dayInPeriod:daylistInPeriod) {
            dayInfoBuilder.append(dayHeader(dayInPeriod));
            if (dayInPeriod.getTimeDifference()!=null){
            dayInfoBuilder.append(outputParameterAndValue(timeDifference, String.valueOf(dayInPeriod.getTimeDifference().getTimeDifferenceInputted()), 1));
            dayInfoBuilder.append(outputParameterAndValue(differenceType, String.valueOf(dayInPeriod.getTimeDifference().getDifferenceType()), 1));
            }
        }

        return dayInfoBuilder.toString();
    }


    private static String dayHeader(Day day){
        return " * "+day.getDate()+"("+day.getDayElements().getWeekName()+")\n";

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

        return tabsSetBefore+parameter+": "+value+"\n";
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
