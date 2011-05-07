package fetch;

import models.Lottery;

import org.junit.Test;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.test.UnitTest;
import translators.MegaSenaTranslator;


public class MegaSenaFetchTest extends UnitTest {

	private static final String URL = "http://www1.caixa.gov.br/loterias/loterias/megasena/megasena_pesquisa_new.asp?submeteu=sim&opcao=concurso&txtConcurso=1280";

	@Test
	public void testFetch() {
		HttpResponse response = WS.url(URL).get();
		String raw = response.getString();
		Lottery expected = new MegaSenaTranslator(raw).translate();
		
		assertEquals(expected, new MegaSenaFetch(1280).fetch());
	}
}
