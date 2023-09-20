package lk.ijse.projectmanagementapi2.util;

import lk.ijse.projectmanagementapi2.dto.ProjectDTO;
import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.entity.ProjectEntity;
import lk.ijse.projectmanagementapi2.entity.TechLeadEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    private final ModelMapper modelMapper;


    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TechLeadEntity getTechLeadEntity(TechLeadDTO techLeadDTO){
        return modelMapper.map(techLeadDTO, TechLeadEntity.class);
    }

    public  TechLeadDTO getTechLeadDTO(TechLeadEntity techLeadEntity){
        return modelMapper.map(techLeadEntity, TechLeadDTO.class);
    }

    public ProjectEntity getProjectEntity(ProjectDTO projectDTO){
        return modelMapper.map(projectDTO, ProjectEntity.class);
    }

    public ProjectDTO getProjectDTO(ProjectEntity projectEntity){
        return modelMapper.map(projectEntity, ProjectDTO.class);
    }
}
