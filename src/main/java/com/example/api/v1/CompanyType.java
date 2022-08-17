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
public class CompanyType {
    @Id
    private Integer code;

    private String type;
//    CATERING(001),
//    FINANCE(002),
//    EDUCATION(003);
//
//    private int code;
//
//    CompanyType(int code) {
//        this.code = code;
//    }
}
