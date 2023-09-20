package lk.ijse.projectmanagementapi2.service;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;

import java.util.List;

public interface ProjectBO {

    ProjectDTO savePriject(ProjectDTO projectDTO);

    void updateProjectDetails(String projectid,ProjectDTO projectDTO);

    void deleteProject(String projectid);

    List<ProjectDTO> getAllProjectsDetails();
}
