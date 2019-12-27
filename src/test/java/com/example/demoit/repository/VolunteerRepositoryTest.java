package com.example.demoit.repository;

import com.example.demoit.model.Volunteer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VolunteerRepositoryTest {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Test
    public void shouldSaveAVolunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setName("David");
        volunteer.setLastName("Herrera");
        Volunteer volunteerSaved = volunteerRepository.save(volunteer);
        assertThat(volunteerSaved.getId(), equalTo(3L));
    }

    @Test
    public void shouldGetAllVolunteers() {
        List<Volunteer> volunteers = (List<Volunteer>) volunteerRepository.findAll();
        assertThat(volunteers.size(), equalTo(2));
    }

    @Test
    public void shouldFindVolunteerById() {
        Volunteer volunteer = volunteerRepository.findById(100L).orElse(null);
        assertThat(volunteer, is(nullValue()));
    }

    @Test
    public void shouldUpdateVolunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(2L);
        volunteer.setName("Mary Jane");
        volunteer.setLastName("Doe");
        Volunteer volunteerSaved = volunteerRepository.save(volunteer);
        assertThat(volunteerSaved.getLastName(), equalTo("Doe"));
        assertThat(volunteerSaved.getName(), equalTo("Mary Jane"));
        assertThat(volunteerSaved.getId(), equalTo(2L));
    }

    @Test
    public void shouldRemoveVolunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteerRepository.delete(volunteer);
        Volunteer volunteerDeleted = volunteerRepository.findById(volunteer.getId()).orElse(null);
        assertThat(volunteerDeleted, is(nullValue()));
    }
}
