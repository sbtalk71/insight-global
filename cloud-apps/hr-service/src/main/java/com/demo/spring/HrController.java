package com.demo.spring;

import com.demo.spring.entity.EmpDTO;
import com.demo.spring.services.HrService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/hr")
public class HrController {

    private HrService hrService;

    public HrController(HrService hrService) {
        this.hrService = hrService;
    }


    @GetMapping(path="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpDTO> getInfo(@PathVariable Integer id){
        return ResponseEntity.ok(hrService.getEmDetails(id));
    }
}
