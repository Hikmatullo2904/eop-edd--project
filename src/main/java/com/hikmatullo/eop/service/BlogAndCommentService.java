package com.hikmatullo.eop.service;

import com.hikmatullo.eop.etity.Blog;
import com.hikmatullo.eop.etity.Comment;
import com.hikmatullo.eop.event.BlogCommentCountIncreaseEvent;
import com.hikmatullo.eop.listener.BlogCommentCountIncreaseEventHandler;
import com.hikmatullo.eop.repo.BlogRepo;
import com.hikmatullo.eop.repo.CommentRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogAndCommentService {
    private final BlogRepo blogRepo;
    private final CommentRepo commentRepo;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void saveBlog(Blog blog) {
        blogRepo.save(blog);
    }

    public void saveComment(Integer blogId, Comment comment) {
        Blog blog = blogRepo.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found"));
        comment.setBlog(blog);
        applicationEventPublisher.publishEvent(new BlogCommentCountIncreaseEvent(blog));
        commentRepo.save(comment);
    }
}
