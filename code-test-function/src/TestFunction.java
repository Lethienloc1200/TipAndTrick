/**
 * Proprietary information of Novatti. Copyright 2023 Novatti Pty Ltd. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TestFunction
 *
 * @author NhuLe
 * @since Dec, 12 2023
 */
public class TestFunction {
    private final String STATUS_ACTIVE = "T";
    private final String STATUS_INACTIVE = "F";
    public  List<ReportConfigModel> mergeReportLists2(List<ReportConfigModel> availableReports, List<ReportConfig> reportConfigList) {

        List<ReportConfigModel> mergedReportConfigs = new ArrayList<ReportConfigModel>();
        Map<String, String> mapReportIdStatus = new HashMap<String, String>();
        for (ReportConfig reportConfig : reportConfigList) {
            mapReportIdStatus.put(reportConfig.getId(), reportConfig.getActive());
        }
        for (ReportConfigModel availableReport : availableReports) {
            availableReport.setActive(mapReportIdStatus.getOrDefault(availableReport.getId(), "T"));
            mergedReportConfigs.add(availableReport);
        }
        return mergedReportConfigs;
    }


    public  List<ReportConfigModel> mergeReportLists(List<ReportConfigModel> availableReports, List<ReportConfig> reportConfigList) {


        List<ReportConfigModel> mergedReportConfigs = new ArrayList<ReportConfigModel>();

        for (ReportConfigModel availableReport : availableReports) {
            boolean matchFound = false;

            for (ReportConfig reportConfig : reportConfigList) {
                if (availableReport.getId().equals(reportConfig.getId())){
                    if (reportConfig.getId().equals(availableReport.getId())) {
                        availableReport.setActive(reportConfig.getActive());
                    }
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                availableReport.setActive("T");
            }
            mergedReportConfigs.add(availableReport);
        }
        return mergedReportConfigs;
    }

    public  List<ReportConfigModel> createAvailableReports() {
        List<ReportConfigModel> availableReports = new ArrayList<>();

        // Generate 1000 records with unique IDs
        for (int i = 1; i <= 50; i++) {
            String id = String.valueOf(i);
            String active = (i % 2 == 0) ? "T" : "F"; // Alternating "T" and "F" for demonstration
            availableReports.add(new ReportConfigModel(id, active));
        }

        return availableReports;
    }

    public  List<ReportConfig> createReportConfigList() {
        List<ReportConfig> availableReports = new ArrayList<>();

        // Generate 1000 records with unique IDs
        for (int i = 1; i <= 1000; i++) {
            String id = String.valueOf(i);
            String active ="T";
            availableReports.add(new ReportConfig(id, active));
        }

        return availableReports;
    }
    public List<ReportConfigModel> filterReportListByStatus(List<ReportConfigModel> reportConfigList, String status) {
        if (!STATUS_INACTIVE.equalsIgnoreCase(status) && !STATUS_ACTIVE.equalsIgnoreCase(status)) {
            return reportConfigList;
        }
        List<ReportConfigModel> filteredList = new ArrayList<ReportConfigModel>();
        for (ReportConfigModel reportConfig : reportConfigList) {
            if (reportConfig.getActive().equalsIgnoreCase(status)) {
                filteredList.add(reportConfig);
            }
        }

        return filteredList;
    }
}
