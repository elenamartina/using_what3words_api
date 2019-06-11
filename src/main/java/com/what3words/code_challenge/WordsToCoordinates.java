package com.what3words.code_challenge;

import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.response.APIResponse;
import com.what3words.javawrapper.response.ConvertToCoordinates;

public class WordsToCoordinates {

    public ConvertToCoordinates getCoordinates(What3WordsV3 api, String words) {

        // Convert a 3 word address to coordinates
        ConvertToCoordinates coordinates = api.convertToCoordinates(words).execute();


        if (coordinates.isSuccessful()) { // the request was successful
            System.out.println("" + words + " coordinates: " + coordinates);

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
