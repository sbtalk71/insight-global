package com.demo.spring.controllers;

import com.demo.spring.entity.Emp;
import com.demo.spring.services.EmpService;
import com.demo.spring.util.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin()
public class EmpRestController {

    private EmpService empService;

    public EmpRestController(){}
    public EmpRestController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Emp>> findAllEmps() {
        return ResponseEntity.ok(empService.getAllEmps());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> getOneEmp(@PathVariable Integer id) {
        return ResponseEntity.ok(empService.getOneEmp(id));
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> storeEmp(@RequestBody Emp e) {
        return ResponseEntity.ok(empService.save(e));
    }

    @PutMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> updateEmp(@RequestBody Emp e){
        return ResponseEntity.ok(empService.update(e));
    }

    @DeleteMapping(path="/")
    public ResponseEntity<ResponseMessage> remove(@RequestParam(name="empId",required = true) Integer id){
        empService.delete(id);
        return ResponseEntity.ok(new ResponseMessage("Emp deleted"));
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> updateEmpPartially(@PathVariable Integer id, @RequestBody Emp emp){
        return ResponseEntity.ok(empService.partialUpdate(id, emp));

    }
}
