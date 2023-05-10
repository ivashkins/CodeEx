package com.example.codeexample.controller;

import com.example.codeexample.repository.UserRepository;
import com.example.codeexample.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ComponentScan("com.example.codeexample")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//Тесты запускаются по очереди
class MainControllerTest {

    //Можно дописать для каждого контроллера Успех и ошибку, и так же попарсить ответы что бы вытягивались нужные сущности

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    void aCreateNewUserMobileTestSuccess() throws Exception {
        var json = new JSONObject();
        json.put("telephone", "89109205658");
       mockMvc.perform(post("/newUser")
                       .content(json.toString())
                       .contentType(MediaType.APPLICATION_JSON_VALUE)
                       .accept(MediaType.APPLICATION_JSON_VALUE)
               .header("x-Source", "MOBILE"))
               .andExpect(status().isOk());
    }

    @Test
    void aCreateNewUserMobileTestFailed() throws Exception {
        var json = new JSONObject();
        json.put("bankId", "89109205658");
       mockMvc.perform(post("/newUser")
                       .content(json.toString())
                       .contentType(MediaType.APPLICATION_JSON_VALUE)
                       .accept(MediaType.APPLICATION_JSON_VALUE)
               .header("x-Source", "MOBILE"))
               .andExpect(status().is4xxClientError());
    }

    @Test
    void aCreateNewUserMailTestFailed() throws Exception {
        var json = new JSONObject();
        json.put("telephone", "89109205658");
       mockMvc.perform(post("/newUser")
                       .content(json.toString())
                       .contentType(MediaType.APPLICATION_JSON_VALUE)
                       .accept(MediaType.APPLICATION_JSON_VALUE)
               .header("x-Source", "MAIL"))
               .andExpect(status().is4xxClientError());
    }


    @Test
    void bFindUserByParametersTest() throws Exception {
        mockMvc.perform(get("/search/user")
                        .param("telephone", "89109205658")
                ).andExpect(status().isOk());
    }

    @Test
    void zSearchByIdSuccess() throws Exception {
        mockMvc.perform(get("/search/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.telephone").value("89109205658"));
    }
}