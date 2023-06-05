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

            Lesson l1 =  new Lesson();
            l1.setName("Introducao");
            l1.setYoutubeUrl("watch?v=1");
            l1.setCourse(c);
            c.getLessons().add(l1);

            Lesson l2 = new Lesson();
            l2.setName("Angular");
            l2.setYoutubeUrl("watch?v=2");
            l2.setCourse(c);
            c.getLessons().add(l2);

            courseRepository.save(c);
        };
    }
}
