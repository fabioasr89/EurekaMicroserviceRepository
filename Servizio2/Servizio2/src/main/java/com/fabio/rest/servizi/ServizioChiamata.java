package com.fabio.rest.servizi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;
import com.fabio.rest.webClient.WClientConfig;

@Service
public class ServizioChiamata {

	private WClientConfig config;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${servizioBenvenuto.nome}")
	private String nomeIstanza;
	
	public ServizioChiamata() {
		
	}
	
	public RispostaBean getResponse(RichiestaBean richiesta) {
		RispostaBean risposta=null;
		String uri=null;
		try {
			uri=discoveryClient.getInstances(nomeIstanza).get(0).getUri().toString();
			config=new WClientConfig(uri);
			risposta=config.getResponse(richiesta);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return risposta;
	}
}
