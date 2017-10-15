package com.example.lab3client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordController {
	
	@Value("${wordConfig.lucky-word}") String luckyWord;
	@Value("${wordConfig.preamble}") String preamble;
	String fullStatement;

	  @GetMapping("/lucky-word")
	  public String showLuckyWord() {
	    return fullStatement;
	  }
	  
	  @PostConstruct
	  public void init(){
		  fullStatement = preamble + ": " + luckyWord;
	  }
}
