package com.example.api.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyLocation {
    @Id
    private Integer code;
    private String location;
//    SEOUL(001),
//    GYEONGGI(002),
//    GANGWON(003);
//
//    private int code;
//
//    CompanyLocation(int code) {
//        this.code = code;
//    }
}
