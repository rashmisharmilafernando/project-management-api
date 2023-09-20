package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.service.TechLedBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/techlead")
public class TechLedController {

    @Autowired
    TechLedBO techLedBO;

    @PostMapping
    public TechLeadDTO saveTechLead(@RequestParam String techleadID, @RequestParam String name, @RequestParam String address, @RequestParam String phonenumber) {
        if (techleadID == null || !techleadID.matches("[T][0-9]{3}")) {
            throw new RuntimeException("Please enter name again...");
        } else if (name == null || !name.matches("[A-Za-z ]")) {
            throw new RuntimeException("Please enter name again...");
        } else if (address == null) {
            throw new RuntimeException("Please enter address again...");
        } else if (phonenumber == null) {
            throw new RuntimeException("Please enter phone number again...");
        }
        TechLeadDTO techLeadDTO = new TechLeadDTO();
        techLeadDTO.setTlid(techleadID);
        techLeadDTO.setName(name);
        techLeadDTO.setAddress(address);
        techLeadDTO.setPhone(phonenumber);

        return techLedBO.saveTechlead(techLeadDTO);

    }

    @GetMapping(value = "{techleadid}",produces = MediaType.APPLICATION_JSON_VALUE)
    TechLeadDTO getAllTechLeadDetails(@PathVariable String techleadid) {
        if (!techleadid.matches("[T][0-9]{3}")) throw new RuntimeException("Invalid Id.Please enter again..!");
        return techLedBO.getAllTechLeadDetails(techleadid);
    }

    @PutMapping("tlid")
    public void updateTechLeadDetails(@RequestParam String techleadID, @RequestParam String name, @RequestParam String address, @RequestParam String phonenumber) {
        if (name == null || !name.matches("[A-Za-z ]")) {
            throw new RuntimeException("Please enter name again...");
        } else if (address == null) {
            throw new RuntimeException("Please enter address again...");
        } else if (phonenumber == null) {
            throw new RuntimeException("Please enter phone number again...");
        } else  if (techleadID == null || !techleadID.matches("[T][0-9]{3}")) {
            throw new RuntimeException("Please enter name again...");
        }

        TechLeadDTO updatetechLeadDTODetails = new TechLeadDTO();
        updatetechLeadDTODetails.setName(name);
        updatetechLeadDTODetails.setAddress(address);
        updatetechLeadDTODetails.setPhone(phonenumber);

        techLedBO.updateTechLeadDetails(techleadID,updatetechLeadDTODetails);
    }

    @DeleteMapping(params = "tlid")
    public void deleteTechLead(String tlid) {
        techLedBO.deleteTechLead(tlid);
    }


}
