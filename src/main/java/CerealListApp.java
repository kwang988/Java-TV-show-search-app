import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.namedlist.CerealNamedListDTO;
import com.kenzie.app.unnamedlist.CerealUnNamedListDTO;

import java.io.File;
import java.util.List;

public class CerealListApp {
    public static void main(String[] args) {
        try {
        //declare variables
        File inputFile = new File("cereal_list.json");
        //1.instantiate DTO object
        //2. objectMapper
        //3. TypeReference object
            //Example 1: Parsing an unnamed list
        List<CerealUnNamedListDTO> cerealListObj;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CerealUnNamedListDTO>> typeRefList = new TypeReference<>(){};
        //use ObjectMapper and readValue to parse json to DTO
            cerealListObj = objectMapper.readValue(inputFile, typeRefList);
            System.out.println("Example 1: ");
            System.out.println(cerealListObj.get(0).getName());
            System.out.println(cerealListObj.get(1).getName());
            System.out.println(cerealListObj.get(2).getName());
            System.out.println(cerealListObj.get(0).getMarshmallows().get(0));

            //Example 2: Parsing a named list
            //1. instantiate the DTO object
            //2. use same object mapper
            //3. use .class reference
            File inputNamedFile = new File("cereal_named_list.json");
            CerealNamedListDTO cerealNamedListObj;
            //use ObjectMapper and readValue
            cerealNamedListObj = objectMapper.readValue(inputNamedFile, CerealNamedListDTO.class);
            System.out.println("Example 2: ");
            System.out.println(cerealNamedListObj.getCereals().get(0).getName());
            System.out.println(cerealNamedListObj.getCereals().get(1).getName());
            System.out.println(cerealNamedListObj.getCereals().get(2).getName());

        } catch (Exception e) {
            System.out.println("unexpected exception: " + e);;
        }
    }
}
