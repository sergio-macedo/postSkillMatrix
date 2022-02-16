package com.softwareone.skillMatrix.api;

import com.softwareone.skillMatrix.model.Skill;
import com.softwareone.skillMatrix.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  TODO revisar responses dos métodos PUT and DELETE. Devem retornar 204 (NO_CONTENT) como abaixo
 *
 *        responses:
 *         "204":
 *           description: Success.
 */
@RestController
public class SkillController implements SkillsApi {

    private SkillRepository skillRepository;
    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public ResponseEntity<List<Skill>> getAllSkills(String name) {
        return new ResponseEntity<>(skillRepository.getAllSkills(name), HttpStatus.OK);
    }

    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillRepository.addSkills(skill), HttpStatus.CREATED);
    }

    public ResponseEntity<Skill> getSkillById(@PathVariable("id") String id) {
        return new ResponseEntity<>(skillRepository.getSkillsById(id), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateSkill(@PathVariable("id") String id, @RequestBody Skill skill) {
        skillRepository.updateSkills(id, skill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteSkill(@PathVariable("id") String skillId) {
        skillRepository.deleteSkill(skillId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    private Skill createSkill() {
//        Skill skill = new Skill();
//
//        skill.setId("");
//        skill.setSkillName("Java");
//        skill.category(Skill.CategoryEnum.HARD_SKILLS);
//        skill.proficiency(Skill.ProficiencyEnum.BEGINNER);
//
//
//        return skill;
//    }
}
