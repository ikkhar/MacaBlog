package fr.macademia.macablog;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import fr.macademia.macablog.model.entities.Auteur;
import fr.macademia.macablog.model.entities.Keywords;
import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.entities.SubThematiques;
import fr.macademia.macablog.model.entities.Thematiques;
import fr.macademia.macablog.model.repositories.ArticlesRepository;
import fr.macademia.macablog.model.repositories.AuteurRepository;
import fr.macademia.macablog.model.repositories.KeywordsRepository;
import fr.macademia.macablog.model.repositories.SubThematiquesRepository;
import fr.macademia.macablog.model.repositories.ThematiquesRepository;

import fr.macademia.macablog.tool.json.ArticlesAdapter;
import fr.macademia.macablog.tool.json.ArticlesAdapterBis;
import fr.macademia.macablog.tool.json.JSONLoader;


@SpringBootApplication
@EnableAsync
public class MacablogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacablogApplication.class, args);
	}
//	@Bean
//	@Profile({"dev", "test"})
//	ApplicationRunner initArticlesRepository(ArticlesRepository articlesRepository) {
//		return args -> {
//			if (articlesRepository.findAll().isEmpty()) {
//				new JSONLoader<>("src/main/resources/data/Articles.json",Articles[].class,
//						Articles.class,
//						articlesRepository,
//						new ArticlesAdapter()
//						).load();
//			}
//		};
//	}
	
		
	
	@Bean
	@Profile({"dev", "test"})
	ApplicationRunner initThematiquesRepository(ThematiquesRepository thematiquesRepository) {
		return args -> {
			if (thematiquesRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/Thematiques.json", Thematiques[].class, thematiquesRepository).load();
			}
		};
	}
	
	
	@Bean
	@Profile({"dev", "test"})
	ApplicationRunner initAuteurRepository(AuteurRepository auteurRepository) {
		return args -> {
			if (auteurRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/Auteur.json", Auteur[].class, auteurRepository).load();
			}
		};
	}
//	
//	
	@Bean
	@Profile({"dev", "test"})
	ApplicationRunner initKeywordsRepository(KeywordsRepository keywordsRepository) {
		return args -> {
			if (keywordsRepository.findAll().isEmpty()) {
				new JSONLoader<>("src/main/resources/data/Keywords.json", Keywords[].class, keywordsRepository).load();
			}
		};
	}
	
	// Load Article.json sans ArticleAdapter
			@Bean
			@Profile({"dev", "test"})
			ApplicationRunner initLoadArticlesRepository(ArticlesRepository articlesRepository) {
				return args -> {
					if (articlesRepository.findAll().isEmpty()) {
						new JSONLoader<>("src/main/resources/data/Articles.json",Articles[].class,articlesRepository).load();

								
					}
				};
			}
	
			@Bean
			@Profile({"dev", "test"})
			ApplicationRunner initSubThematiquesRepository(SubThematiquesRepository subThematiquesRepository) {
				return args -> {
					if (subThematiquesRepository.findAll().isEmpty()) {
						new JSONLoader<>("src/main/resources/data/SubThematiques.json", SubThematiques[].class, subThematiquesRepository).load();
					}
				};
			}
	
	
	
	
	
}
