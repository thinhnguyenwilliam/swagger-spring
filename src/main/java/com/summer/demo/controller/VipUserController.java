package com.summer.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vip")
@Tag(name = "VIP User APIs", description = "APIs available for VIP users")
public class VipUserController {

    @Operation(
            summary = "Get VIP Dashboard data",
            description = "Returns dashboard data only accessible to VIP users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful Operation"),
                    @ApiResponse(responseCode = "403", description = "Forbidden")
            },
            security = @SecurityRequirement(name = "bearerAuth") // if you use JWT security
    )
    @GetMapping("/dashboard")
    public String vipDashboard() {
        return "VIP user dashboard";
    }



}

