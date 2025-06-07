package com.summer.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/super")
@Tag(name = "Super User APIs", description = "APIs available for Super users")
public class SuperUserController {

    @GetMapping("/dashboard")
    public String superDashboard() {
        return "Super user dashboard";
    }
}
