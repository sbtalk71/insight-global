package com.demo.spring.services;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repositories.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    private EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public List<Emp> getAllEmps() {
        return this.empRepository.findAll();
    }

    public Emp getOneEmp(Integer id) {
        Optional<Emp> empOP = empRepository.findById(id);
        if (empOP.isPresent()) {
            return empOP.get();
        } else {
            throw new EmpNotFoundException("Emp with Id " + id + " Not found");
        }
    }

    public Emp save(Emp e) {
        if (empRepository.existsById(e.getEmpId())) {
            throw new EmpExistsException("Emp exists in database");
        } else {
            return empRepository.save(e);
        }
    }

    public Emp update(Emp e) {
        if (empRepository.existsById(e.getEmpId())) {
            return empRepository.save(e);
        } else {
            throw new EmpNotFoundException("Emp Not found..");
        }
    }

    public void delete(Integer id) {
        if (empRepository.existsById(id)) {
            empRepository.deleteById(id);
        } else {
            throw new EmpNotFoundException("Emp Not found..");
        }
    }

    public Emp partialUpdate(Integer id, Emp partialEmp) {

        Emp targetEmp = empRepository.findById(id).orElseThrow(() -> new EmpNotFoundException("Emp Not Found"));
        if (partialEmp.getName() != null) {
            targetEmp.setName(partialEmp.getName());
        }
        if (partialEmp.getSalary() != null) {
            targetEmp.setSalary(partialEmp.getSalary());
        }
        if(partialEmp.getCity()!=null){
            targetEmp.setCity((partialEmp.getCity()));
        }

        return empRepository.save(targetEmp);
    }
}
