package com.softwareone.skillMatrix.repository;

import com.softwareone.skillMatrix.model.Skill;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SkillMemoryRepository implements SkillRepository {
    private static Map<String, Skill> map = new HashMap<>();

    @Override
    public List<Skill> getAllSkills(String name) {
        return new ArrayList(map.values());
    }

    @Override
    public Skill addSkills(Skill skill) {
        skill.setId(UUID.randomUUID().toString());
        map.put(skill.getId(), skill);
        return skill;
    }

    @Override
    public Skill getSkillsById(String skillId) {
        return map.get(skillId);
    }

    @Override
    public void updateSkills(String id, Skill skill) {
        map.put(id, skill);

    }

    @Override
    public void deleteSkill(String id) {
        map.remove(id);
    }
}