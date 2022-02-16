package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Language;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

/**
 *  TODO revisar responses dos métodos PUT and DELETE. Devem retornar 204 (NO_CONTENT) como abaixo
 *
 *        responses:
 *         "204":
 *           description: Success.
 */
@RestController
public class LanguageController implements LanguagesApi {

    public ResponseEntity<List<Language>> getAllLanguages(String name) {
        return new ResponseEntity<>(Arrays.asList(createLanguage()), HttpStatus.OK);
    }

    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        return new ResponseEntity<>(language, HttpStatus.CREATED);
    }

    public ResponseEntity<Language> getLanguageById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(createLanguage(), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateLanguage(Integer id, @RequestBody Language language) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteLanguage(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Language createLanguage() {
        Language language = new Language();

        language.setId("");
        language.languageName("English");
        language.level(Language.LevelEnum.BEGINNER);


        return language;

    }
}
