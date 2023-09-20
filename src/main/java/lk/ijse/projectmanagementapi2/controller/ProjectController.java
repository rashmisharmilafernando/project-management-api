package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.repo.ProjectRepo;
import lk.ijse.projectmanagementapi2.service.ProjectBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    ProjectBO projectBO;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjectDetails() {
        List<ProjectDTO> projectDTOList = projectBO.getAllProjectsDetails().stream().map(project ->
                new ProjectDTO(
                        project.getProid(),
                        project.getName(),
                        project.getDescription(),
                        project.getStartDate()
                )
        ).collect(Collectors.toList());
        return new ResponseEntity<>(projectDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ProjectDTO saveProject(
            @RequestParam String projectId,
            @RequestParam String projectname,
            @RequestParam String projectDescription,
            @RequestParam Date projectStartDate
    ) {
        if (projectId == null || projectId.matches("[P][0-9]{3}")) {
            throw new RuntimeException("Invalid Project Id.Please enter the Project Id again..");
        } else if (projectname == null || projectname.matches("[A-Za-z]")) {
            throw new RuntimeException("Project name is empty...!");
        } else if (projectDescription == null) {
            throw new RuntimeException("Project description is empty...!");
        } else if (projectStartDate == null) {
            throw new RuntimeException("Project Start date is empty..1");
        }
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProid(projectId);
        projectDTO.setName(projectname);
        projectDTO.setDescription(projectDescription);
        projectDTO.setStartDate(projectStartDate);
        return projectBO.savePriject(projectDTO);
    }

    @PutMapping("projectid")
    public void updateProjectDetails(@PathVariable String projectid, @RequestBody ProjectDTO projectDTO) {
        projectBO.updateProjectDetails(projectid, projectDTO);
    }

    @DeleteMapping(params = "projectid")
    public void deleteProject(String projectid) {
        projectBO.deleteProject(projectid);
    }
}
