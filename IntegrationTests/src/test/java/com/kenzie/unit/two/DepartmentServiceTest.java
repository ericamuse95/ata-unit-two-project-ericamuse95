package com.kenzie.unit.two;

import com.kenzie.unit.two.iam.lambda.models.CreateDepartmentRequest;
import com.kenzie.unit.two.iam.models.Department;
import com.kenzie.unit.two.iam.service.DepartmentService;
import com.kenzie.unit.two.iam.service.RoleService;
import com.kenzie.unit.two.iam.service.UserRoleService;
import com.kenzie.unit.two.iam.service.UserService;
import com.kenzie.unit.two.iam.storage.Storage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class DepartmentServiceTest {

    @InjectMocks
    Storage storage;

    @BeforeEach
    public void setUp(){
        System.out.println(":)");
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void afterEach() {
        System.out.println(":)");
    }

    @Test
    void createNewDepartment_TASK_7() {
        //GIVEN
        DepartmentService departmentService = new DepartmentService(storage);

        //WHEN
        String departmentName = RandomStringUtils.random(20);
        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        createDepartmentRequest.setDepartmentName(departmentName);

        //THEN
        Department department = departmentService.createDepartment(createDepartmentRequest);
        assertTrue(department.getId() != null);
    }

    @Test
    void throwExceptionDepartmentNameAlreadyExists_TASK_7() {
        //GIVEN
        DepartmentService departmentService = new DepartmentService(storage);

        //WHEN
        String departmentName = RandomStringUtils.random(20);

        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        createDepartmentRequest.setDepartmentName(departmentName);

        departmentService.createDepartment(createDepartmentRequest);


        //THEN
        assertThrows(IllegalArgumentException.class,
                () -> departmentService.createDepartment(createDepartmentRequest));
    }

    @Test
    void getDepartmentByName_TASK_7(){
        //GIVEN
        DepartmentService departmentService = new DepartmentService(storage);

        //WHEN
        String departmentName = RandomStringUtils.random(20);

        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        createDepartmentRequest.setDepartmentName(departmentName);

        Department department = departmentService.createDepartment(createDepartmentRequest);


        //THEN
        Department queriedDepartment = departmentService.getDepartmentByName(departmentName);
        assertTrue(department.getId().equals(queriedDepartment.getId()));
    }

    @Test
    void getAllDepartments(){
        //GIVEN
        DepartmentService departmentService = new DepartmentService(storage);

        //WHEN
        String departmentName = RandomStringUtils.random(20);

        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
        createDepartmentRequest.setDepartmentName(departmentName);

        Department department = departmentService.createDepartment(createDepartmentRequest);

        //THEN
        List<Department> departments = departmentService.getDepartments();
        assertTrue(departments.contains(department));
    }
}