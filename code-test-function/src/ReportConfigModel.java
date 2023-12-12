/**
 * Proprietary information of Novatti. Copyright 2023 Novatti Pty Ltd. All rights reserved.
 */

/**
 * ReportConfigModel
 *
 * @author NhuLe
 * @since Dec, 12 2023
 */
public class ReportConfigModel {
    private String id;
    private String active;

    public ReportConfigModel(String id, String active) {
        this.id = id;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
