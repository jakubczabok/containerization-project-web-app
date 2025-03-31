package com.example.demo.controller;

import com.example.demo.model.BlogPost;
import com.example.demo.service.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BlogPost> getBlogPostByTitle(@PathVariable String title) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostByTitle(title);
        return blogPost.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/author/{author}")
    public ResponseEntity<List<BlogPost>> getBlogPostsByAuthor(@PathVariable String author) {
        List<BlogPost> posts = blogPostService.getBlogPostsByAuthor(author);
        return ResponseEntity.ok(posts);
    }


    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
        return ResponseEntity.ok(createdBlogPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        try {
            BlogPost blogPost = blogPostService.updateBlogPost(id, updatedBlogPost);
            return ResponseEntity.ok(blogPost);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
