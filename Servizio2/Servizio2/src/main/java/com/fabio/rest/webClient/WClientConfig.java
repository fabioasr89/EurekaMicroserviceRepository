package com.fabio.rest.webClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;

import reactor.core.publisher.Mono;

public class WClientConfig implements WClientConfigInterface{
	
	private WebClient client;
	private Mono<RispostaBean> response;
	
	private String uri;
	
	public WClientConfig(String uri) {
		this.uri=uri;
		client=WebClient.create();
	}
	
	public RispostaBean getResponse(RichiestaBean richiesta) {
		RispostaBean risposta=null;
		try {
			//effettuiamo la chiamata al servizio di benvenuto
			response=client.get().uri(uri+"SalutiService/saluti/{nome}/and/{cognome}",richiesta.getNome(),richiesta.getCognome())
					.exchange().flatMap(response->response.bodyToMono(RispostaBean.class));
			risposta=response.block();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return risposta;
	}

	

}
