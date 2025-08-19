package com.cad.cadmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.io.StringWriter;
import java.io.PrintWriter;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/testdb")
    public String testDbConnection() {
        try {
            List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM CAD_USER");
            return "DB 연결 성공! 데이터 개수: " + users.size();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return "DB 연결 실패: <pre>" + sw.toString() + "</pre>";
        }
    }
}
