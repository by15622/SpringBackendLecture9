package com.sprint.mission.jpa.repository;

import com.sprint.mission.jpa.domain.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByName(String name);
}