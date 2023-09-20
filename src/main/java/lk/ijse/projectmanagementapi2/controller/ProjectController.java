package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.repo.ProjectRepo;
import lk.ijse.projectmanagementapi2.service.ProjectBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    ProjectBO projectBO;

    @GetMapping
    public ResponseEntity<List<ProjectRepo>> getAllProjectDetails(){
        return null;
    }
    @PostMapping
    public ProjectDTO saveProject(){
        return null;
    }
    @PutMapping
    public void updateProjectDetails(@PathVariable String projectid,@RequestBody ProjectDTO projectDTO){

    }
    @DeleteMapping
    public void deleteProject(String projectid){

    }
}
