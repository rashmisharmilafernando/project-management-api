package lk.ijse.projectmanagementapi2.repo;

import lk.ijse.projectmanagementapi2.entity.ProjectEntity;
import lk.ijse.projectmanagementapi2.entity.TechLeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectEntity,String> {

    ProjectEntity findProjectEntityBy(String projectId);

    void deleteProjectEntityBy(String projectId);
}
