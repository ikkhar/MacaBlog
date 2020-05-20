package fr.macademia.macablog.tool.json;

import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import fr.macademia.macablog.model.entities.Articles;


public  class ArticlesAdapterBis implements JsonDeserializer<Articles>{
	
	

	@Override
	public Articles deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext)
			throws JsonParseException {
		
		
		
		// Convertie le json en user
		final Articles articles = new GsonBuilder().setPrettyPrinting().create()
		    .fromJson(jsonElement, Articles.class);
		
		
		
		//retourne le user avec le password encodé
		return articles;

	}

}
