package com.example.demo.service;

import com.example.demo.model.BlogPost;
import com.example.demo.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    // Tworzenie nowego postu na blogu
    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    // Pobieranie wszystkich postów
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    // Wyszukiwanie postów na blogu po tytule
    public Optional<BlogPost> getBlogPostByTitle(String title) {
        return Optional.ofNullable(blogPostRepository.findByTitle(title));
    }

    // Wyszukiwanie postów na blogu po autorze
    public List<BlogPost> getBlogPostsByAuthor(String author) {
        return blogPostRepository.findByAuthor(author);
    }

    // Wyszukiwanie postów na blogu zawierających dany fragment treści
    public List<BlogPost> getBlogPostsByContentFragment(String contentFragment) {
        return blogPostRepository.findByContentContaining(contentFragment);
    }

    // Wyszukiwanie postów w określonym przedziale czasowym
    public List<BlogPost> getBlogPostsByPublishedDate(LocalDateTime startDate, LocalDateTime endDate) {
        return blogPostRepository.findByPublishedDateBetween(startDate, endDate);
    }

    // Wyszukiwanie postów według tagu
    public List<BlogPost> getBlogPostsByTag(String tag) {
        return blogPostRepository.findByTagsContaining(tag);
    }

    // Wyszukiwanie postów według statusu (np. "opublikowany", "roboczy")
    public List<BlogPost> getBlogPostsByStatus(String status) {
        return blogPostRepository.findByStatus(status);
    }

    // Aktualizacja postu na blogu
    public BlogPost updateBlogPost(Long blogPostId, BlogPost updatedBlogPost) {
        Optional<BlogPost> existingPost = blogPostRepository.findById(blogPostId);
        if (existingPost.isPresent()) {
            BlogPost blogPost = existingPost.get();
            blogPost.setTitle(updatedBlogPost.getTitle());
            blogPost.setContent(updatedBlogPost.getContent());
            blogPost.setUpdatedAt(LocalDateTime.now());
            blogPost.setPublishedDate(updatedBlogPost.getPublishedDate());
            blogPost.setTags(updatedBlogPost.getTags());
            blogPost.setStatus(updatedBlogPost.getStatus());
            return blogPostRepository.save(blogPost);
        } else {
            throw new RuntimeException("Blog post not found");
        }
    }

    // Usuwanie postu na blogu
    public void deleteBlogPost(Long blogPostId) {
        blogPostRepository.deleteById(blogPostId);
    }
}
