package com.project.flights.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@RestController
@OpenAPIDefinition(info = @Info(description = "Flights Information System Documentation", title = "Flights Information System API", version = "2.0.2"))
public class SwaggerLogoutController
{
    @GetMapping("/logout")
    public String logout(jakarta.servlet.http.HttpServletRequest request,jakarta.servlet.http.HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
