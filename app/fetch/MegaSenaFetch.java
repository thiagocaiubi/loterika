package fetch;

import java.util.HashMap;
import java.util.Map;

import models.Lottery;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import translators.MegaSenaTranslator;

public class MegaSenaFetch implements Fetch {

	private static final String URL = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp";
	
	private Map<String, Object> parameters = new HashMap<String, Object>();
	
	public MegaSenaFetch() {}
	
	public MegaSenaFetch(int number) {
		parameters.put("submeteu", "sim");
		parameters.put("opcao", "concurso");
		parameters.put("txtConcurso", number);
	}
	
	public Lottery fetch() {
		HttpResponse reponse = WS.url(URL).params(parameters).get();
		String raw = reponse.getString();
		return new MegaSenaTranslator(raw).translate();
	}
}