package lk.ijse.projectmanagementapi2.service.impl;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.entity.TechLeadEntity;
import lk.ijse.projectmanagementapi2.repo.TechLedRepo;
import lk.ijse.projectmanagementapi2.service.TechLedBO;
import lk.ijse.projectmanagementapi2.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TechLedBOimpl implements TechLedBO {

@Autowired
    TechLedRepo techLedRepo;

    public TechLedBOimpl(TechLedRepo techLedRepo) {
        this.techLedRepo=techLedRepo;
    }

    @Autowired
    Converter converter;
    @Override
    public TechLeadDTO saveTechlead(TechLeadDTO techLeadDTO) {
        TechLeadEntity techLeadEntity=converter.getTechLeadEntity(techLeadDTO);
        techLedRepo.save(techLeadEntity);
        return techLeadDTO;
    }

    @Override
    public void updateTechLeadDetails(String techleadid, TechLeadDTO techLeadDTO) {
        Optional<TechLeadEntity> techLeadEntity=techLedRepo.findById(techleadid);

        if (!techLeadEntity.isPresent()) throw new RuntimeException("TechLead not found.Please try again..!");
        techLeadEntity.get().setName(techLeadDTO.getName());
        techLeadEntity.get().setAddress(techLeadDTO.getAddress());
        techLeadEntity.get().setPhone(techLeadDTO.getPhone());
    }

    @Override
    public TechLeadDTO deleteTechLead(String techleadid) {
        if (!techLedRepo.existsById(techleadid)) throw new RuntimeException("TechLead not found.Please try again..!");
        TechLeadEntity entity=techLedRepo.findTechLeadEntitiesBy(techleadid);
        return converter.getTechLeadDTO(entity);

    }

    @Override
    public TechLeadDTO getAllTechLeadDetails(String techleadid) {
       if (!techLedRepo.existsById(techleadid)) throw new RuntimeException("TechLead not found.Please try again..!");
       TechLeadEntity entity=techLedRepo.findTechLeadEntitiesBy(techleadid);
       return converter.getTechLeadDTO(entity);
    }
}
