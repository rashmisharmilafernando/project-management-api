package lk.ijse.projectmanagementapi2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Project")
public class ProjectEntity implements SuperEntity{
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "TechLeadID")
    private TechLeadEntity techLead;
}
