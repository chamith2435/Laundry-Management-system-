package com.laundrypro.controller;

import com.laundrypro.model.Staff;
import com.laundrypro.service.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Staff create(@RequestBody Staff staff) {
        return service.create(staff);
    }

    @GetMapping("/{id}")
    public Staff get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/by-email")
    public Staff getByEmail(@RequestParam String email) {
        return service.getByEmail(email);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Integer id, @RequestBody Staff staff) {
        return service.update(id, staff);
    }

    @PatchMapping("/{id}/password")
    public Staff updatePassword(@PathVariable Integer id, @RequestParam String password) {
        return service.updatePassword(id, password);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping
    public Page<Staff> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "staffId,DESC") String sort, // e.g., "staffId,DESC" or "email,ASC"
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String q
    ) {
        String[] sortParts = sort.split(",", 2);
        Sort.Direction dir = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortParts[0]));

        if (role != null && !role.isBlank()) {
            return service.filterByRole(role, pageable);
        }
        if (q != null && !q.isBlank()) {
            return service.search(q.trim(), pageable);
        }
        return service.list(pageable);
    }
}
