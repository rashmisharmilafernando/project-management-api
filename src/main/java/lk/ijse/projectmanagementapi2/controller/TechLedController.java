package lk.ijse.projectmanagementapi2.controller;

import lk.ijse.projectmanagementapi2.dto.TechLeadDTO;
import lk.ijse.projectmanagementapi2.service.TechLedBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public TechLeadDTO saveTechLead(@RequestParam String name,@RequestParam String address,@RequestParam String phonenumber){
       if (name == null || !name.matches("[A-Za-z ]")){
           throw new RuntimeException("Please enter name again...");
       } else if (address == null){
           throw new RuntimeException("Please enter address again...");
       }else if (phonenumber==null){
           throw new RuntimeException("Please enter phone number again...");
       }
       TechLeadDTO techLeadDTO=new TechLeadDTO();
       techLeadDTO.setName(name);
       techLeadDTO.setAddress(address);
       techLeadDTO.setPhone(phonenumber);

       return techLedBO.saveTechlead(techLeadDTO);

    }
    @GetMapping
    public ResponseEntity<List<TechLeadDTO>> getAllTechLeadDetails(){
        List<TechLeadDTO> techLedRepoList=techLedBO.getAllTechLeadDetails().stream().map(tl ->
                new TechLeadDTO(
                        tl.getTlid(),
                        tl.getName(),
                        tl.getAddress(),
                        tl.getPhone()
                )).collect(Collectors.toList());
        return new ResponseEntity<>(techLedRepoList, HttpStatus.OK);
    }
    @PutMapping("tlid")
    public void updateTechLeadDetails(@PathVariable String tlid,@RequestBody TechLeadDTO techLeadDTO){
        techLedBO.updateTechLeadDetails(tlid,techLeadDTO);
    }
    @DeleteMapping(params = "tlid")
    public void deleteTechLead(String tlid){
        techLedBO.deleteTechLead(tlid);
    }





}
