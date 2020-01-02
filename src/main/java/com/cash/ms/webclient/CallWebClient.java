package com.cash.ms.webclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.cash.ms.model.InfoResponse;

import reactor.core.publisher.Mono;

@Component
@Qualifier("webClient")
public class CallWebClient {

	 WebClient client = WebClient.builder().baseUrl("http://localhost:8881")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	 
	
	 public Mono<InfoResponse> responde (List<String> numDoc){
		 return client.post().uri("/bank/api/getDeudas").syncBody(numDoc)
			.retrieve().bodyToMono(InfoResponse.class).flatMap(rs -> {	
					return Mono.just(rs);
			});
	 }
}
