package lk.ijse.projectmanagementapi2.service.impl;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.entity.ProjectEntity;
import lk.ijse.projectmanagementapi2.entity.TechLeadEntity;
import lk.ijse.projectmanagementapi2.repo.ProjectRepo;
import lk.ijse.projectmanagementapi2.service.ProjectBO;
import lk.ijse.projectmanagementapi2.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectBOimpl implements ProjectBO {
    @Autowired
    ProjectRepo projectRepo;

    public ProjectBOimpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Autowired
    Converter converter;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = converter.getProjectEntity(projectDTO);
        projectRepo.save(projectEntity);
        return projectDTO;
    }

    @Override
    public void updateProjectDetails(String projectid, ProjectDTO projectDTO) {
        Optional<ProjectEntity> projectEntity = projectRepo.findById(projectid);

        if (!projectEntity.isPresent()) throw new RuntimeException("Project not found.Please try again..!");
        projectEntity.get().setName(projectDTO.getProjectname());
        projectEntity.get().setDescription(projectDTO.getDescription());
        projectEntity.get().setStartDate(projectDTO.getStartDate());
    }

    @Override
    public ProjectDTO deleteProject(String projectid) {
        if (!projectRepo.existsById(projectid)) throw new RuntimeException("Project not found.Please try again..!");
        ProjectEntity entity=projectRepo.findProjectEntityBy(projectid);
        return converter.getProjectDTO(entity);
    }

    @Override
    public ProjectDTO getAllProjectsDetails(String projectid) {
      if (!projectRepo.existsById(projectid)) throw new RuntimeException("TechLead not found.Please try again..!");
            ProjectEntity entity=projectRepo.findProjectEntityBy(projectid);
            return converter.getProjectDTO(entity);
    }
}
