package com.what3words.code_challenge;

import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.response.ConvertToCoordinates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeChallengeApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodeChallengeApplication.class, args);

		// For all requests a what3words API key is needed
		What3WordsV3 api = new What3WordsV3("RRLW7T7I");

		String words = "silk.slap.soils";
		WordsToCoordinates converter = new WordsToCoordinates();

		ConvertToCoordinates coordinates = converter.getCoordinates(api, words);
		//System.out.println(coordinates);
	}

}
