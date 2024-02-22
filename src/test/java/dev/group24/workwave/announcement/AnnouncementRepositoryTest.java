package dev.group24.workwave.announcement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class AnnouncementRepositoryTest {
    
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AnnouncementRepository repository;

    @Test
    @DisplayName("Find all announcements")
    void testGetAllAnnouncements() {
        List<Announcement> announcements = repository.findAll();
        assertEquals(4, announcements.size());
        assertThat(announcements.get(0).getJobName()).isEqualTo("Programador muy Junior");
    }

    @Test
    @DisplayName("Find announcement by id")
    void testGetOneAnnouncementById() {
        Announcement anun1 = repository.findById(2L).orElseThrow();
        assertEquals(2L, anun1.getId());
        assertEquals("Madrid", anun1.getProvince());
    }

    @Test
    void testDeleteAnnouncementById() {
        Date date = new GregorianCalendar(2024, Calendar.FEBRUARY, 22).getTime();

        Announcement anun1 = new Announcement("Islas Canarias", "Limpiador de ratones", "LimpiezaBoom", "Saber limpiar ratones", "Trabajo de tus sueños", 100L, date);

        entityManager.persist(anun1);

        repository.deleteById(1L);

        List<Announcement> announcements = repository.findAll();
        assertThat(announcements.size(), is(4));
        assertThat(announcements.get(0).getJobName(), containsString("Programador sin conocimientos previos"));
        assertThat(announcements.get(1).getJobName(), containsString("Especialista en todo"));
        assertThat(announcements.get(3).getJobName(), containsString("Limpiador de ratones"));
    }

    @AfterEach
    void tearDown() {
        entityManager.clear();
    }

    

}
