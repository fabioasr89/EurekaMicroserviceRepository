package com.fabio.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.res.servizio.ServizioDati;
import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;

@RestController
@RequestMapping(value="/SalutiService/")
public class ServizioController {
	
	@Autowired
	private ServizioDati service;
	
	@RequestMapping(value="saluti/{nome}/and/{cognome}",method=RequestMethod.GET)
	public RispostaBean getSaluti(@PathVariable String nome,@PathVariable String cognome) {
		RispostaBean bean=null;
		RichiestaBean richiesta=new RichiestaBean();
		try {
			richiesta.setNome(nome);
			richiesta.setCognome(cognome);
			bean=new RispostaBean();
			bean=service.getResponse(richiesta);
		}catch(Exception e) {
			e.printStackTrace();
			bean=new RispostaBean();
			bean.setEsito(false);
			bean.setMessage("ERRORE INTERNO");
		}
		return bean;
	}
}
