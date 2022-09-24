import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.single.CerealDTO;
import com.kenzie.app.single.CerealGenDTO;

import java.io.File;

public class CerealApp {
    public static void main(String[] args) {
        try {
            //1. prepare sample data
            File inputFile = new File("cereal_one.json");

            //2. instantiate ObjectMapper and DTO
            ObjectMapper objectMapper = new ObjectMapper();
            CerealDTO cerealObj;
            CerealGenDTO cerealGenObj;

            //3. call readValue

            cerealObj = objectMapper.readValue(inputFile, CerealDTO.class);


            //4. use the object--get name and calories
            System.out.println("Name: " + cerealObj.getName());
            System.out.println("Calories: " + cerealObj.getCalories());
            //4. try GeneratedGTO
            cerealGenObj = objectMapper.readValue(inputFile, CerealGenDTO.class);
            System.out.println("Name: " + cerealGenObj.getName());
            System.out.println("Marshmallows: " + cerealGenObj.getMarshmallows());
        }
        catch (Exception e){
            System.out.println("Unexpected exception: " + e);
        }
    }
}
