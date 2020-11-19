package com.fabio.rest.webClient;

import com.fabio.rest.bean.RichiestaBean;
import com.fabio.rest.bean.RispostaBean;

public interface WClientConfigInterface {
	
	RispostaBean getResponse(RichiestaBean richiesta);
}
