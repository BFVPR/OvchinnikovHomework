package ru.urfu.homework.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urfu.homework.Repository.MaterialsRepository;
import ru.urfu.homework.entity.Material;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class MaterialsService {

    private MaterialsRepository materialsRepository;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository) {
        this.materialsRepository = materialsRepository;
    }

    public List<Material> findAll() {
        return materialsRepository.findAll();
    }

    public Material findById(int id) {
        Optional<Material> materialsOptional= materialsRepository.findById(id);
        return materialsOptional.orElse(null);
    }

    @Transactional
    public void save(Material material){
        materialsRepository.save(material);
    }

    @Transactional
    public void updateById(int id, Material material){
        material.setId(id);
        materialsRepository.save(material);
    }

    @Transactional
    public void deleteById(int id){
        materialsRepository.deleteById(id);
    }
}
