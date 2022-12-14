package ru.urfu.homework.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.urfu.homework.entity.Material;

@Repository
public interface MaterialsRepository extends JpaRepository<Material, Integer> {
}
