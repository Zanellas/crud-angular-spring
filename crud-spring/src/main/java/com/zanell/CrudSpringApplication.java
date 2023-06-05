package com.zanell;

import com.zanell.enums.Category;
import com.zanell.model.Course;
import com.zanell.model.Lesson;
import com.zanell.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.FRONT_END);

            Lesson l =  new Lesson();
            l.setName("Introducao");
            l.setYoutubeUrl("watch?v=1");
            l.setCourse(c);
            c.getLessons().add(l);
            courseRepository.save(c);
        };
    }
}
