package lk.ijse.projectmanagementapi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String proid;
    private String name;
    private String description;
    private Date startDate;
}
