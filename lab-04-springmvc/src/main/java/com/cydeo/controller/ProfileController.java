package com.cydeo.controller;


import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String retrieveProfile(Model model) {

        Profile profile = new Profile();
        profile.setName("James");
        profile.setSurname("Bond");
        profile.setUserName("007");
        profile.setEmail("jamesbond007@gmail.com");
        profile.setPhoneNumber("007007007");
        profile.setCreatedDate(LocalDateTime.now());
        model.addAttribute("profile",profile);
        return "profile/profile-info";
    }


}