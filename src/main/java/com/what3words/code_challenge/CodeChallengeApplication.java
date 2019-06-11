package com.what3words.code_challenge;

import com.what3words.javawrapper.What3WordsV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeChallengeApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodeChallengeApplication.class, args);
		// For all requests a what3words API key is needed
		What3WordsV3 api = new What3WordsV3("what3words-api-key");
	}

}
