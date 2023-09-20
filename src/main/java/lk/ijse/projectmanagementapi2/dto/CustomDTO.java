package lk.ijse.projectmanagementapi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDTO {
    private String tlid;
    private String techleadname;
    private String address;
    private String phone;
    private String proid;
    private String projectname;
    private String description;
    private Date startDate;
}
