package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.repo.ProjectRepo;
import lk.ijse.projectmanagementapi2.service.ProjectBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "{projectid}",produces = MediaType.APPLICATION_JSON_VALUE)
   ProjectDTO getAllProjectDetails(@PathVariable String projectid) {
       if (!projectid.matches("[P][0-9]{3}")) throw new RuntimeException("Project Id is invalid.Please enter again..!");
       return projectBO.getAllProjectsDetails(projectid);
    }

    @PostMapping
    public ProjectDTO saveProject(
            @RequestParam String projectId,
            @RequestParam String projectname,
            @RequestParam String projectDescription,
            @RequestParam Date projectStartDate,
            @RequestParam String projecttechLeadid

    ) {
        if (projectId == null || projectId.matches("[P][0-9]{3}")) {
            throw new RuntimeException("Invalid Project Id.Please enter the Project Id again..");
        } else if (projectname == null || projectname.matches("[A-Za-z]")) {
            throw new RuntimeException("Project name is empty...!");
        } else if (projectDescription == null) {
            throw new RuntimeException("Project description is empty...!");
        } else if (projectStartDate == null) {
            throw new RuntimeException("Project Start date is empty..!");
        } else if (projecttechLeadid ==null){
            throw new RuntimeException(("TechLead Id  date is empty..!"));
        }
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProid(projectId);
        projectDTO.setProjectname(projectname);
        projectDTO.setDescription(projectDescription);
        projectDTO.setStartDate(projectStartDate);
        projectDTO.setTlid(projecttechLeadid);
        return projectBO.saveProject(projectDTO);
    }

    @PutMapping("projectid")
    public void updateProjectDetails( @RequestParam String projectId,
                                      @RequestParam String projectname,
                                      @RequestParam String projectDescription,
                                      @RequestParam Date projectStartDate,
                                      @RequestParam String projecttechLeadid

    ) {
        if (projectname == null || projectname.matches("[A-Za-z]")) {
            throw new RuntimeException("Project name is empty...!");
        } else if (projectDescription == null) {
            throw new RuntimeException("Project description is empty...!");
        } else if (projectStartDate == null) {
            throw new RuntimeException("Project Start date is empty..1");
        } else if (projecttechLeadid ==null){
            throw new RuntimeException(("TechLead Id  date is empty..!"));
        } else if (projectId == null || projectId.matches("[P][0-9]{3}")) {
            throw new RuntimeException("Invalid Project Id.Please enter the Project Id again..");
        }

        ProjectDTO updateprojectDTODetails = new ProjectDTO();
        updateprojectDTODetails.setProjectname(projectname);
        updateprojectDTODetails.setDescription(projectDescription);
        updateprojectDTODetails.setStartDate(projectStartDate);
        updateprojectDTODetails.setTlid(projecttechLeadid);
        projectBO.updateProjectDetails(projectId,updateprojectDTODetails);
    }

    @DeleteMapping(params = "projectid")
    public void deleteProject(String projectid) {
        projectBO.deleteProject(projectid);
    }
}
