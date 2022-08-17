package com.example.api.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Member {
    @Id
    private Long id;
    private String name;
    private String password;
    private String sex;
    private String companyName;
    @ManyToOne
    private CompanyType companyType;
    @ManyToOne
    private CompanyLocation companyLocation;
}
