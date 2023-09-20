package lk.ijse.projectmanagementapi2.service;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;

import java.util.List;

public interface ProjectBO {

    ProjectDTO saveProject(ProjectDTO projectDTO);

    void updateProjectDetails(String projectid,ProjectDTO projectDTO);

    ProjectDTO deleteProject(String projectid);

    ProjectDTO getAllProjectsDetails(String projectid);
}
