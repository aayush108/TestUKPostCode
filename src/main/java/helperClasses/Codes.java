package helperClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Codes {

    @SerializedName("admin_district")
    @Expose
    private String adminDistrict;
    @SerializedName("admin_county")
    @Expose
    private String adminCounty;
    @SerializedName("admin_ward")
    @Expose
    private String adminWard;
    @SerializedName("parish")
    @Expose
    private String parish;
    @SerializedName("parliamentary_constituency")
    @Expose
    private String parliamentaryConstituency;
    @SerializedName("ccg")
    @Expose
    private String ccg;
    @SerializedName("nuts")
    @Expose
    private String nuts;

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public String getAdminCounty() {
        return adminCounty;
    }

    public void setAdminCounty(String adminCounty) {
        this.adminCounty = adminCounty;
    }

    public String getAdminWard() {
        return adminWard;
    }

    public void setAdminWard(String adminWard) {
        this.adminWard = adminWard;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getParliamentaryConstituency() {
        return parliamentaryConstituency;
    }

    public void setParliamentaryConstituency(String parliamentaryConstituency) {
        this.parliamentaryConstituency = parliamentaryConstituency;
    }

    public String getCcg() {
        return ccg;
    }

    public void setCcg(String ccg) {
        this.ccg = ccg;
    }

    public String getNuts() {
        return nuts;
    }

    public void setNuts(String nuts) {
        this.nuts = nuts;
    }

}