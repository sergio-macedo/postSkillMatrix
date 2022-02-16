package com.softwareone.skillMatrix.repository;

import com.softwareone.skillMatrix.model.Skill;

import java.util.List;

public interface SkillRepository {


     List<Skill> getAllSkills(String name);

     Skill addSkills(Skill skill);

     Skill getSkillsById(String skillId);

     void updateSkills(String skillId, Skill skill);

     void deleteSkill(String skillId);

}
