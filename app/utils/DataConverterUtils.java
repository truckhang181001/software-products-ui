package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;

import java.util.List;
import java.util.Map;

public class DataConverterUtils {
    public static <T> T jsonToList(String json, TypeReference<T> typeReference) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            T companies = mapper.readValue(json, typeReference);
            return companies;
        } catch (Exception ex) {
            Logger.of("application").error("Fail to convert jsonToList: ", ex);
            return null;
        }
    }
}
