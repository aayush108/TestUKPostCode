package helperClasses;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NearestPostCode {

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("result")
    @Expose
    private List<Result> result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }


    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
