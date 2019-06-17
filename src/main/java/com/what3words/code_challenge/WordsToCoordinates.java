package com.what3words.code_challenge;
import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.response.APIResponse;
import com.what3words.javawrapper.response.ConvertToCoordinates;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

// @Component is used to denote a class as a Spring Bean.
// It means that Spring framework will autodetect the class
// for dependency injection.
@Component
public class WordsToCoordinates {
 private String APIkey = "RRLW7T7I";
 private What3WordsV3 api;

 WordsToCoordinates() {
  // set the API key for the requests
  this.api = new What3WordsV3(this.APIkey);
 }

 public JSONArray getAllCoordinates(List<String> wordsList) {
  /*
  Returns a json array of coordinates corresponding to
  the list of What3Words given as the parameter "wordsList".
  */
  JSONArray coordinatesList = new JSONArray();

  wordsList.forEach(words -> {
   JSONObject object = new JSONObject();
   object.put(words, this.getCoordinates(words));
   coordinatesList.add(object);
  });
 return coordinatesList;
 }

 public ConvertToCoordinates getCoordinates(String words) {
  /*
  Returns the coordinates corresponding to a single, specific what3Words.
  */

  // Convert a 3 word address to coordinates
  ConvertToCoordinates coordinates = this.api.convertToCoordinates(words).execute();

  if (coordinates.isSuccessful()) { // the request was successful
   //System.out.println("\n" + words + " coordinates: " + coordinates);

  } else { // the request was not successful
   APIResponse.What3WordsError error = coordinates.getError();

   if (error == APIResponse.What3WordsError.BAD_WORDS) { // The three word address provided is invalid
    System.out.println("BadWords: " + error.getMessage());

   } else if (error == APIResponse.What3WordsError.INTERNAL_SERVER_ERROR) { // Server Error
    System.out.println("InternalServerError: " + error.getMessage());

   } else if (error == APIResponse.What3WordsError.NETWORK_ERROR) { // Network Error
       System.out.println("NetworkError: " + error.getMessage());

   } else { // Unknown Error
   System.out.println(error + ": " + error.getMessage());
   }
  }
  return coordinates;
 }
}
