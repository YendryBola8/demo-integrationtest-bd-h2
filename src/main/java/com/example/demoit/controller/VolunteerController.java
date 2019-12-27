package com.example.demoit.controller;

import com.example.demoit.model.Volunteer;
import com.example.demoit.repository.VolunteerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("v1/volunteer")
public class VolunteerController {

    private final VolunteerRepository volunteerRepository;

    @PostMapping
    public @ResponseBody
    Volunteer add(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @GetMapping
    public @ResponseBody
    Iterable<Volunteer> all() {
        return volunteerRepository.findAll();
    }


}
