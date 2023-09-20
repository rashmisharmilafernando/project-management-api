package lk.ijse.projectmanagementapi2.service.impl;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.service.TechLedBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TechLedBOimpl implements TechLedBO {


    @Override
    public TechLeadDTO saveTechlead(TechLeadDTO techLeadDTO) {
        return null;
    }

    @Override
    public void updateTechLeadDetails(String techleadid, TechLeadDTO techLeadDTO) {

    }

    @Override
    public void deleteTechLead(String techleadid) {

    }

    @Override
    public List<TechLeadDTO> getAllTechLeadDetails() {
        return null;
    }
}
