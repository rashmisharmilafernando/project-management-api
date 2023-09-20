package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.repo.TechLedRepo;
import lk.ijse.projectmanagementapi2.service.TechLedBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/techlead")
public class TechLedController {

    @Autowired
    TechLedBO techLedBO;

    @PostMapping
    public TechLeadDTO saveTechLead(){
        return null;
    }
    @GetMapping
    public ResponseEntity<List<TechLedRepo>> getAllTechLeadDetails(){
        return null;
    }
    @PutMapping
    public void updateTechLeadDetails(String techleadid,@RequestBody TechLeadDTO techLeadDTO){}
    @DeleteMapping
    public void deleteTechLead(String id){}





}
