package fr.macademia.macablog.tool.json;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.*;
import fr.macademia.macablog.model.entities.Articles;



public class ArticlesAdapter implements JsonDeserializer<ArrayList<Articles>>{

	
	private final static String PACKAGE_ENTITIES_IMP="fr.macademia.macablog.model.entities.";

	@Override
	public ArrayList<Articles> deserialize(JsonElement jsonElement,Type type,JsonDeserializationContext jsonDeserializationContext)
			throws JsonParseException {
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		//String type2 = jsonObject.getType().toString();
		System.out.println("OK");
        /*return jsonDeserializationContext.deserialize(
		        jsonElement,
		        Class.forName(PACKAGE_ENTITIES_IMP + jsonObject.get("type").getAsString())
		);*/
		ArrayList<Articles> myList = new ArrayList<Articles>();

		for (JsonElement e : jsonObject.getAsJsonArray())
		{
		    myList.add((Articles)jsonDeserializationContext.deserialize(e, Articles.class));
		}

		return myList;
    }
}
