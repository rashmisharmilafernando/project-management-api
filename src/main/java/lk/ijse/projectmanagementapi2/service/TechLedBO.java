package lk.ijse.projectmanagementapi2.service;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;

import java.util.List;

public interface TechLedBO {

    TechLeadDTO saveTechlead(TechLeadDTO techLeadDTO);

    void updateTechLeadDetails(String techleadid,TechLeadDTO techLeadDTO);

    TechLeadDTO deleteTechLead(String techleadid);

    public TechLeadDTO getAllTechLeadDetails(String Techleadid) ;
}
