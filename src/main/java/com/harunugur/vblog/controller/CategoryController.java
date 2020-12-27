package com.harunugur.vblog.controller;

import com.harunugur.vblog.dto.CategoryDto;
import com.harunugur.vblog.entity.Category;
import com.harunugur.vblog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category categoryDB = categoryService.save(category);
        categoryDto.setId(categoryDB.getId());
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        CategoryDto categoryDto = convertToDto(category);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<CategoryDto>> getByPage(@RequestParam int page,
                                                       @RequestParam int size,
                                                       @RequestParam String sortDir,
                                                       @RequestParam String sort) {
        Page<CategoryDto> pageDB = categoryService.findCategoryByPage(page, size, sortDir, sort)
                .map(this::convertToDto);

        return new ResponseEntity<Page<CategoryDto>>(pageDB, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();

        List<Category> categories = categoryService.findAll();
        for (Category category : categories) {
            categoryDtos.add(convertToDto(category));
        }

        return new ResponseEntity<List<CategoryDto>>(categoryDtos,HttpStatus.OK);
    }


    private CategoryDto convertToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
