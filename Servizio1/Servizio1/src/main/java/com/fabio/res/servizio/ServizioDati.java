package com.fabio.res.servizio;

import org.springframework.stereotype.Service;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;

@Service
public class ServizioDati {
	
	
	public RispostaBean getResponse(RichiestaBean richiesta) {
		RispostaBean bean=null;
		try {
			bean=new RispostaBean();
			bean.setNome(richiesta.getNome());
			bean.setCognome(richiesta.getCognome());
			bean.setMessage(String.format("Benvenuto %s",bean.getNome()+" "+bean.getCognome()));
			bean.setEsito(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
