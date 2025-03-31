package com.example.demo.repository;

import com.example.demo.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    // Wyszukiwanie po tytule bloga
    BlogPost findByTitle(String title);

    // Wyszukiwanie wszystkich postów opublikowanych w określonym przedziale dat
    List<BlogPost> findByPublishedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Wyszukiwanie postów zawierających dany fragment w treści
    List<BlogPost> findByContentContaining(String contentFragment);

    // Wyszukiwanie postów po autorze
    List<BlogPost> findByAuthor(String author);

    // Wyszukiwanie postów po tagach (np. 'rehabilitacja', 'profilaktyka')
    List<BlogPost> findByTagsContaining(String tag);

    // Wyszukiwanie postów po statusie (np. 'opublikowany', 'roboczy')
    List<BlogPost> findByStatus(String status);
}
