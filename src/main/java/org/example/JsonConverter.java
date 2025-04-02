package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class JsonConverter {
    public static void main(String[] args) {
        try {
            List<Petrol> petrolDataList = Arrays.asList(
                    new Petrol("MYS", "Petrol", "Apr", 2023, 27.150, "KL"),
                    new Petrol("MYS", "Petrol", "May", 2023, 31.442, "KL"),
                    new Petrol("MYS", "Petrol", "Jun", 2023, 25.150, "KL"),
                    new Petrol("MYS", "Petrol", "Jul", 2023, 26.442, "KL"),
                    new Petrol("MYS", "Petrol", "Aug", 2023, 23.150, "KL"),
                    new Petrol("MYS", "Petrol", "Sep", 2023, 0.00, "KL"),
                    new Petrol("MYS", "Petrol", "Oct", 2023, 0.00, "KL"),
                    new Petrol("MYS", "Petrol", "Nov", 2023, 0.00, "KL"),
                    new Petrol("MYS", "Petrol", "Dec", 2023, 0.00, "KL"),
                    new Petrol("MYS", "Petrol", "Jan", 2024, 0.00, "KL"),
                    new Petrol("MYS", "Petrol", "Feb", 2024, 0.150, "KL"),
                    new Petrol("MYS", "Petrol", "Mar", 2024, 27.442, "KL")
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(petrolDataList);

            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
