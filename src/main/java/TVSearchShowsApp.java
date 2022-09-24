import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.tvsearch.ShowListDTO;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TVSearchShowsApp {

    public static String makeGETRequest(String url){
        //declare variables
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        //making HTTP GET call
        try {
            //the magic happens here... client.send
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            //interprets the response
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                // String.format is fun! Worth a Google if you're interested
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        try {
            //declare variables
            final String BASE_URL = "https://api.tvmaze.com";
            final String SEARCH_PATH_URL = "/search/shows";
            String queryString; // ?q=:query
            String response;

            Scanner scanner = new Scanner(System.in);
            String userInput;

            //read in user input
            System.out.println("Enter a show to search:");
            userInput = scanner.nextLine();

            //call the shows search API
            //1. create your URL
            queryString = "?q=" + userInput.replaceAll(" ", "+");
            System.out.println(queryString);

            System.out.println("Full URL:" + BASE_URL + SEARCH_PATH_URL + queryString);

            //2. Call HTTP GET
            response = makeGETRequest(BASE_URL + SEARCH_PATH_URL + queryString);

            //print out response
            //System.out.println(response);

            //Create List of DTO and declare obj
            List<ShowListDTO> showListObj;

            //Declare ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            //Set up TypeReference
            TypeReference<List<ShowListDTO>> typeReference = new TypeReference<>() {
            };

            //readValue
            showListObj = objectMapper.readValue(response, typeReference);

            //print out new shows
            //System.out.println(showListObj);

            String currentPremierDate = "";
            for (ShowListDTO currentShow: showListObj) {
                System.out.println("Premiered Date:");
                currentPremierDate = currentShow.getShow().getPremiered();
                System.out.println(currentPremierDate);

            }


        }
        catch(Exception e){
            System.out.println("Unexpected exception " + e);
        }
    }
}
