package ru.urfu.homework.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.urfu.homework.Service.MaterialsService;
import ru.urfu.homework.entity.Material;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api("Рест контроллер")
public class MaterialsRestController {

    private MaterialsService materialsService;


    @Autowired
    public MaterialsRestController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/materials")
    @ApiOperation("Получаем list всех материалов")
    public List<Material> getMaterials(){
        return materialsService.findAll();
    }

    @GetMapping("/materials/{id}")
    @ApiOperation("Получаем конкретный материал по id ")
    public Material getMaterial(@PathVariable int id){
        return materialsService.findById(id);
    }

    @PostMapping("/materials")
    @ApiOperation("Добавляем материал в таблицу")
    public Material saveMaterial(@RequestBody Material material){
        materialsService.save(material);
        return material;
    }

    @PutMapping("/materials")
    @ApiOperation("Обнавляем данные о материале в таблице")
    public Material updateMaterial(@RequestBody Material material){
        materialsService.save(material);
        return material;
    }

    @DeleteMapping("/materials/{id}")
    @ApiOperation("Удаляем материал из таблицы")
    public String deleteMaterial(@PathVariable int id){
        materialsService.deleteById(id);
        return "Material with ID = " + id + " was deleted";
    }
}
