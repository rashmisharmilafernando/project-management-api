package lk.ijse.projectmanagementapi2.service.impl;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.service.ProjectBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectBOimpl implements ProjectBO {

    @Override
    public ProjectDTO savePriject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public void updateProjectDetails(String projectid, ProjectDTO projectDTO) {

    }

    @Override
    public void deleteProject(String projectid) {

    }

    @Override
    public List<ProjectDTO> getAllProjectsDetails() {
        return null;
    }
}
