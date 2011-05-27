package controllers;

import java.util.HashMap;
import java.util.Map;

import models.LotteryType;
import play.mvc.Controller;
import play.mvc.Router;
import play.mvc.Router.ActionDefinition;

public class API extends Controller {

    public static void index() {
    	LotteryType lotteryType = LotteryType.MEGA_SENA;
    	
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	parameters.put("lotteryType", lotteryType);
    	
		ActionDefinition actionDefinition = Router.reverse("API.lotteryType", parameters);
		actionDefinition.absolute();
		
		Map<String, String> api = new HashMap<String, String>();
		api.put(lotteryType.name(), actionDefinition.url);
		
    	renderJSON(api);
    }
    
    public static void lotteryType(LotteryType lotteryType) {
    	renderJSON(lotteryType.fetch());
    }
}