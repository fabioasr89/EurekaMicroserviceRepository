package com.fabio.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;
import com.fabio.rest.servizi.ServizioChiamata;

@RestController
@RequestMapping(value="/CallService/")
public class CallSericeRestController {
	
	@Autowired
	private ServizioChiamata service;
	
	public CallSericeRestController() {
		
	}
	@RequestMapping(value="call/{nome}/{cognome}",method=RequestMethod.GET)
	public RispostaBean getCall(@PathVariable String nome,@PathVariable String cognome) {
		RispostaBean risposta=null;
		RichiestaBean richiesta=null;
		boolean esito=false;
		try {
			if(nome!=null && cognome!=null) {
				esito=true;
				richiesta=new RichiestaBean();
				richiesta.setNome(nome);
				richiesta.setCognome(cognome);
				risposta=service.getResponse(richiesta);
			}
		}catch(Exception e) {
			esito=false;
			e.printStackTrace();
		}finally {
			if(!esito && risposta==null) {
				risposta=new RispostaBean();
				risposta.setEsito(esito);
				risposta.setMessage("ERRORE INTERNO DURANTE LA CHIAMATA DEL SERVIZIO");
			}
		}
		return risposta;
	}
}
