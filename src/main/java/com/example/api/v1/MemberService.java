package com.example.api.v1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public List<Member> findMembers(int type, int location) {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if (member.getCompanyType().getCode() != type || member.getCompanyLocation().getCode() != location) {
                members.remove(member);
            }
        }
        return members;
    }
}
