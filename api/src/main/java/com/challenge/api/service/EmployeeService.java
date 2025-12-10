package com.challenge.api.service;

import com.challenge.api.model.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.time.Instant;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    
    // In a real system, this service would call the existing employee management solution
    private final Map<UUID, Employee> employees = new HashMap<>();

    // Mock examples
    public EmployeeService() {
        EmployeeImpl alice =
                new EmployeeImpl(
                        UUID.randomUUID(),
                        "Alice",
                        "Smith",
                        90000,
                        30,
                        "Software Engineer",
                        "alice.smith@company.com",
                        Instant.now().minusSeconds(31536000),
                        null);

        EmployeeImpl bob =
                new EmployeeImpl(
                        UUID.randomUUID(),
                        "Bob",
                        "Johnson",
                        105000,
                        38,
                        "Senior Engineer",
                        "bob.johnson@company.com",
                        Instant.now().minusSeconds(2L * 31536000), // ~2 years ago
                        null);

        employees.put(alice.getUuid(), alice);
        employees.put(bob.getUuid(), bob);
    }

    /**
     * In a real implementation, this method would call the existing employee
     * management system.
     */
    public List<Employee> getAllEmployees() {
        return List.copyOf(employees.values());
    }

    /**
     * In a real implementation, this method would call the existing employee
     * management system to retrieve a specific employee by UUID.
     */
    public Optional<Employee> getEmployeeByUuid(UUID uuid) {
        return Optional.ofNullable(employees.get(uuid));
    }

    /**
     * In a real implementation, this method would send a request to the existing
     * employee management system to create a new employee record, and return whatever
     * that system creates.
     */
    public Employee createEmployee(CreateEmployeeRequest request) {
        UUID uuid = UUID.randomUUID();

        EmployeeImpl employee =
                new EmployeeImpl(
                        uuid,
                        request.getFirstName(),
                        request.getLastName(),
                        request.getSalary(),
                        request.getAge(),
                        request.getJobTitle(),
                        request.getEmail(),
                        Instant.now(),
                        null);

        employees.put(uuid, employee);
        return employee;
    }
}
