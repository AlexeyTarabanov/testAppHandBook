package com.example.regionhandbook;

import com.example.regionhandbook.model.HandBook;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MappedTypes(HandBook.class)
@SpringBootApplication
@MapperScan("com.example.regionhandbook.repository")
@EnableCaching
public class RegionHandbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionHandbookApplication.class, args);
    }

}
