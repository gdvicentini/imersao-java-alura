package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        List<Language> languagesTest = repository.findAll();
        return languagesTest;
    }

    @PostMapping("/languages")
    public Language setLanguages(@RequestBody Language language) {
        Language saveLanguage = repository.save(language);
        return saveLanguage;
    }
}
