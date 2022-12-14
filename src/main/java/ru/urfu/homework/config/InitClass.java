package ru.urfu.homework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.urfu.homework.Service.MaterialsService;
import ru.urfu.homework.entity.Material;

import javax.annotation.PostConstruct;

@Component
public class InitClass {

    private MaterialsService materialsService;

    @Autowired
    public InitClass(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @PostConstruct
    public void addMaterialsInDB(){
        materialsService.save(new Material("Bricks", 228.88, 200));
        materialsService.save(new Material("Logs", 144.50, 100));
        materialsService.save(new Material("Coal", 15.05, 300));

    }
}
