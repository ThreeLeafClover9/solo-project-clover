package com.example.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/members")
public class Controller {
    private final MemberService memberService;

    public Controller(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity getMembers(@RequestParam int type,
//                                     @RequestParam int location) {
//        List<Member> members = memberService.findMembers(type, location);
//        return new ResponseEntity<>(members, HttpStatus.OK);
//    }
}
