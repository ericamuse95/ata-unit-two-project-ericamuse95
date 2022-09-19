package com.kenzie.unit.two.iam.service;

import com.kenzie.unit.two.employee.service.UserOrRoleNotFoundException;
import com.kenzie.unit.two.iam.lambda.models.AssignUserToRoleRequest;
import com.kenzie.unit.two.iam.lambda.models.GetUserRolesRequest;
import com.kenzie.unit.two.iam.models.Role;
import com.kenzie.unit.two.iam.models.User;
import com.kenzie.unit.two.iam.models.UserRoles;
import com.kenzie.unit.two.iam.storage.Storage;

import com.kenzie.ata.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class UserRoleService {
    private final Storage storage;

    public UserRoleService(Storage storage) {
        this.storage = storage;
    }

    public UserRoles createUserRole(AssignUserToRoleRequest request) {
        User user = storage.getUserByUsername(request.getUserName());
        Role role = storage.getRoleByRoleName(request.getRoleName());
        return storage.storeUserRole(user, role);
    }

    public UserRoles getUserRoles(GetUserRolesRequest request) {
        User user = storage.getUserByUsername(request.getUserName());
        return storage.getUserRoles(user);
    }

    public UserRoles getUserRoles(String userName) {
        User user = storage.getUserByUsername(userName);
        return storage.getUserRoles(user);
    }

    public boolean doesUserHaveRole(User user, Role role) {
        UserRoles userRoles = storage.getUserRoles(user);
        if(user == null || role == null || userRoles == null){
            throw new UserOrRoleNotFoundException("The user or role does not exist.");
    }
        if(userRoles.getRoles() != null){
        return userRoles.getRoles().contains(role);
    } else {
            return false;
        }
}
}
