import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {


    private static final TestFunction testFunction = new TestFunction(); // Example: Initialize with an instance of TestFunction



    public Main() {
    }

    public static void main(String[] args) throws IOException {
        // Generate mock data
        List<ReportConfigModel> availableReports = testFunction.createAvailableReports();
        List<ReportConfig> reportConfigList = testFunction.createReportConfigList(); // Assuming you have a method for creating ReportConfigList
        List<ReportConfigModel> list =testFunction.filterReportListByStatus(availableReports,"F");
        // Measure the time for
        System.out.println("List " + list );
        long startTime1 = System.currentTimeMillis();
        List<ReportConfigModel> mergedList111111 = testFunction.mergeReportLists(availableReports, reportConfigList);
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("Time taken by mergeReportLists11111111111: " + elapsedTime1 + " milliseconds");

        // Measure the time for mergeReportLists2222222
        long startTime2 = System.currentTimeMillis();
        List<ReportConfigModel> mergedList2 = testFunction.mergeReportLists2(availableReports, reportConfigList);
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Time taken by mergeReportLists222222222222: " + elapsedTime2 + " milliseconds");
    }





}
