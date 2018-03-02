package com.li.cn.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private Logger log = LoggerFactory.getLogger(StudentDao.class);

    public void log(){

        log.debug("user dao debug log");
        log.info("user dao info log");
        log.warn("user dao warn log");
        log.error("user dao error log");
    }
}
