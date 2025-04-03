package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class JsonConverter {
    public static void main(String[] args) {
        try {


            ObjectMapper objectMapper = new ObjectMapper();

            List<Petrol> petrolDataList = objectMapper.readValue(new File("input.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Petrol.class));

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), petrolDataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
