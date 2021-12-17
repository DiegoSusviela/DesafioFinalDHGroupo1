package Travel.TripReservations.models.engine;
/* File storage class to read from json files */


import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileStorage {

    public static List hotelQuery() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = ResourceUtils.getFile("src/main/resources/hotels.json");

        TypeReference<List<Hotels>> typeref = new TypeReference<List<Hotels>>() {};

        List<Hotels> personal = null;

        try {
            personal = mapper.readValue(file, typeref);
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return personal;
    }

    public static List flightQuery() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = ResourceUtils.getFile("src/main/resources/vuelos.json");

        TypeReference<List<Flights>> typeref = new TypeReference<List<Flights>>() {};

        List<Flights> personal = null;

        try {
            personal = mapper.readValue(file, typeref);
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return personal;
    }
}
