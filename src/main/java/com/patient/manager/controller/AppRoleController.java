package com.patient.manager.controller;

import com.patient.manager.dto.AppRoleDto;
import com.patient.manager.sevices.IAppRoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AppRoleController {
    private final IAppRoleService appRolesService;

    public AppRoleController(IAppRoleService appRolesService) {
        this.appRolesService = appRolesService;
    }
    @GetMapping
    public String afficher(){
        return "helo world";
    }

    @GetMapping("list")
    public List<AppRoleDto> getAppRoles() {
        return appRolesService.getAppRoles();
    }

    @GetMapping("/{id}")
    public AppRoleDto getAppRoles(@PathVariable("id") int id) {
        return appRolesService.getAppRole(id);
    }

    @PostMapping("/create/{appRoleDto}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRoleDto createAppRoles(@RequestBody AppRoleDto appRoleDto) {
        return appRolesService.createAppRoles(appRoleDto);
    }

    @PutMapping("/{id}")
    public AppRoleDto updateAppRoles(@PathVariable("id") Integer id, @Valid @RequestBody AppRoleDto appRoleDto) {
        return appRolesService.updateAppRoles(id, appRoleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAppRoles(@PathVariable("id") int id) {
        appRolesService.deleteAppRoles(id);
    }

}
