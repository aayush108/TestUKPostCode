package helperClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

    public class ResponsePostCode extends PostCode {

        public ResponsePostCode() {
        }

        public static ResponsePostCode fromJson(String json) {
            Gson gson = (new GsonBuilder()).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
            ResponsePostCode response = (ResponsePostCode) gson.fromJson(json, ResponsePostCode.class);
            return response;
        }

        public String toJson() {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
            return gson.toJson(this);
        }
}
