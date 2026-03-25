package com.demo.spring;

import com.demo.spring.model.Emp;
import org.springframework.batch.item.ItemProcessor;

import java.util.logging.Logger;

public class EmpItemProcessor implements ItemProcessor<Emp, Emp> {
    Logger logger= Logger.getLogger(this.getClass().getName());

    @Override
    public Emp process(Emp item) throws Exception {
        logger.info("Processed Emp with empId "+item.getEmpId());
        return item;
    }
}
