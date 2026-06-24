package com.projects147.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentController {

    private final Map<Integer, String> departments;

    public DepartmentController() {
        departments = Map.of(1, "CSE", 2, "ECE", 3, "MECH");
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllDepartments() {
        log.info("Fetch all departments");
        return ResponseEntity.ok(departments.values().stream().toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable("id") Integer id) {
        log.info("Fetch department by id: {}", id);
        return ResponseEntity.ok(departments.get(id));
    }
}
