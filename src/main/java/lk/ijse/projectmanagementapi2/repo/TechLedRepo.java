package lk.ijse.projectmanagementapi2.repo;

import lk.ijse.projectmanagementapi2.entity.TechLeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechLedRepo extends JpaRepository<TechLeadEntity,String> {
    TechLeadEntity findTechLeadEntitiesBy(String techLeadId);

    void deleteTechLeadEntityBy(String techLeadId);
}
