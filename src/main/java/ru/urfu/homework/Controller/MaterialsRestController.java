package ru.urfu.homework.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.urfu.homework.Service.MaterialsService;
import ru.urfu.homework.entity.Material;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialsRestController {

    private MaterialsService materialsService;


    @Autowired
    public MaterialsRestController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/materials")
    public List<Material> getMaterials(){
        return materialsService.findAll();
    }

    @GetMapping("/materials/{id}")
    public Material getMaterial(@PathVariable int id){
        return materialsService.findById(id);
    }

    @PostMapping("/materials")
    public Material saveMaterial(@RequestBody Material material){
        materialsService.save(material);
        return material;
    }

    @PutMapping("/materials")
    public Material updateMaterial(@RequestBody Material material){
        materialsService.save(material);
        return material;
    }

    @DeleteMapping("/materials/{id}")
    public String deleteMaterial(@PathVariable int id){
        materialsService.deleteById(id);
        return "Material with ID = " + id + " was deleted";
    }
}
