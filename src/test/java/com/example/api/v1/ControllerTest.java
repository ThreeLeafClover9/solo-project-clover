package com.example.api.v1;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.api.v1.Utils.getRequestPreProcessor;
import static com.example.api.v1.Utils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(Controller.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    void getMembers() throws Exception{
        Member member1 = new Member(1L, "김코딩", "s4goodbye!", "m", "프로젝트스테이츠", new CompanyType(003, "EDUCATION"), new CompanyLocation(001, "SEOUL"));
//        Member member2 = new Member(2L, "김코딩", "s4goodbye!", "m", "프로젝트스테이츠", CompanyType.EDUCATION, CompanyLocation.SEOUL);
        List<Member> members = List.of(member1);

        given(memberService.findMembers()).willReturn(members);

        ResultActions actions =
                mockMvc.perform(
                        get("/v1/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
        );


        actions.andExpect(status().isOk())
                .andDo(document("get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
//                        fieldWithPath().optional(),
                        responseFields(
                                List.of(
                                        fieldWithPath("[]").type(JsonFieldType.ARRAY).description("결과"),
                                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("[].password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("성별"),
                                        fieldWithPath("[].companyName").type(JsonFieldType.STRING).description("회사 이름"),
                                        fieldWithPath("[].companyType").type(JsonFieldType.OBJECT).description("업종"),
                                        fieldWithPath("[].companyType.code").type(JsonFieldType.NUMBER).description("업종 코드"),
                                        fieldWithPath("[].companyType.type").type(JsonFieldType.STRING).description("업종 상세"),
                                        fieldWithPath("[].companyLocation").type(JsonFieldType.OBJECT).description("지역"),
                                        fieldWithPath("[].companyLocation.code").type(JsonFieldType.NUMBER).description("지역 코드"),
                                        fieldWithPath("[].companyLocation.location").type(JsonFieldType.STRING).description("지역 상세")
                                )
                        )
                ));


    }
}