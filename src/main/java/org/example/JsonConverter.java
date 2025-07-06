package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class JsonConverter{
    public static void main(String[] args) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("input.json"));
            JsonNode contentNode = rootNode.get("content");

            String location = contentNode.get("Location").asText();
            String code = contentNode.get("CategoryName").asText();
            String unit = contentNode.get("Uom").asText();
            int year = contentNode.get("Fyear").asInt();

            List<Petrol> petrolDataList = new ArrayList<>();

            Iterator<Map.Entry<String, JsonNode>> fields = contentNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();

                if (key.equals("Fyear") || key.equals("Srno") || key.equals("CategoryName") ||
                        key.equals("Location") || key.equals("Uom")) {
                    continue;
                }

                int monthNumber = convertMonthToNumber(key);
                if (monthNumber == -1) continue;


                double value = entry.getValue().asDouble();

                petrolDataList.add(new Petrol(location, code, monthNumber, year, value, unit));
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), petrolDataList);

            System.out.println("Data successfully written to output.json!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int convertMonthToNumber(String month) {
        switch (month.toLowerCase()) {
            case "jan": case "january": return 1;
            case "feb": case "february": return 2;
            case "mar": case "march": return 3;
            case "apr": case "april": return 4;
            case "may": return 5;
            case "jun": case "june": return 6;
            case "jul": case "july": return 7;
            case "aug": case "august": return 8;
            case "sep": case "september": return 9;
            case "oct": case "october": return 10;
            case "nov": case "november": return 11;
            case "dec": case "december": return 12;
            default: return -1;
        }
    }
}
