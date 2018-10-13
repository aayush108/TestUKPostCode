package helperClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class ResponseNearestPostCode extends NearestPostCode {

    public ResponseNearestPostCode() {
    }

    public static ResponseNearestPostCode fromJson(String json) {
        Gson gson = (new GsonBuilder()).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        ResponseNearestPostCode response = (ResponseNearestPostCode) gson.fromJson(json, ResponseNearestPostCode.class);
        return response;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        return gson.toJson(this);
    }
}
