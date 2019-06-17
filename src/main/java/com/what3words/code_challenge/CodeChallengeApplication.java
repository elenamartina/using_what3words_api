package com.what3words.code_challenge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication is a meta-annotation
// that pulls in component scanning, auto configuration, and property support.
@SpringBootApplication
public class CodeChallengeApplication {

 public static void main(String[] args) {
  // run Spring App
  SpringApplication.run(CodeChallengeApplication.class, args);
 }
}