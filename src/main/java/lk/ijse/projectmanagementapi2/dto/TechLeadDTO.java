package lk.ijse.projectmanagementapi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechLeadDTO {
    private String id;
    private String name;
    private String address;
    private String phone;
}
