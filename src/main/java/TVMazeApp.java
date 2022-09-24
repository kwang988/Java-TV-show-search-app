import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.tvmaze.SingleShowDTO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TVMazeApp {
    public static String makeGETRequest(String url){
        //declare variables
        HttpClient client = HttpClient.newHttpClient(); //client object
        URI uri = URI.create(url); //use url to create uri
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return "No activity found";
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }
    public static void main(String[] args) {
        //1. declare variables
        final String BASE_URL = "https://api.tvmaze.com";
        final String SEARCH_PATH_URL = "/singlesearch/shows";
        String queryString; //?q=: query
        String response;

        Scanner scanner = new Scanner(System.in);
        String userInput;

        //2. read in userInput
        System.out.println("Enter a show to search: ");
        userInput = scanner.nextLine();

        //3. call the single search API
        //1st step: create URL
        queryString = "/?q=" + userInput.replaceAll(" ", "%20");
        System.out.println(queryString);
        System.out.println("Full URL: " + BASE_URL+SEARCH_PATH_URL+queryString);
        //2nd step: call HTTP GET
        response = makeGETRequest(BASE_URL+SEARCH_PATH_URL+queryString);
        //3rd step: print out response
        System.out.println(response);
        //print out results-show name and summary
        //use DTO
        //Instantiate ObjectMapper
        //call readValue
        try {
            SingleShowDTO showObj;
            ObjectMapper objectMapper = new ObjectMapper();
            showObj = objectMapper.readValue(response, SingleShowDTO.class);
            System.out.println("show name: " + showObj.getName());
            System.out.println("show summary: " + showObj.getSummary());
        }
        catch (Exception e){
            System.out.println("Error parsing Json: " + e);
        }
        //get readValue to work on a URL
        try {
        URL searchAPI = new URL("https://api.tvmaze.com/singlesearch/shows?q=girls");
        SingleShowDTO showSearchObj;
        ObjectMapper objectMapper2 = new ObjectMapper();
        showSearchObj = objectMapper2.readValue(searchAPI, SingleShowDTO.class);
            System.out.println("Direct URL example");
            System.out.println("Name: " + showSearchObj.getName());
            System.out.println("Name: " + showSearchObj.getSummary());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println("Unexpected exception " + e);
        }
    }
}
