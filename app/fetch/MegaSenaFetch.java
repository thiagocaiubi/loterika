package fetch;

import java.util.HashMap;
import java.util.Map;

import models.Lottery;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import translators.MegaSenaTranslator;

public class MegaSenaFetch implements Fetch {

	private static final String URL = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp";
	private static final Map<String, Object> PARAMETERS = new HashMap<String, Object>();
	
	static {
		PARAMETERS.put("submeteu", "sim");
		PARAMETERS.put("opcao", "concurso");
	}

	public MegaSenaFetch(int number) {
		PARAMETERS.put("txtConcurso", number);
	}
	
	public Lottery fetch() {
		HttpResponse reponse = WS.url(URL).params(PARAMETERS).get();
		String raw = reponse.getString();
		return new MegaSenaTranslator(raw).translate();
	}
}