package com.hikmatullo.eop.listener;

import com.hikmatullo.eop.etity.Blog;
import com.hikmatullo.eop.event.BlogCommentCountIncreaseEvent;
import com.hikmatullo.eop.repo.BlogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogCommentCountIncreaseEventHandler {
    private final BlogRepo blogRepo;


    @EventListener(BlogCommentCountIncreaseEvent.class)
    public void handle(BlogCommentCountIncreaseEvent event) {
        System.out.println("BlogDeleteEventHandler: " + event);
        Blog blog = event.getBlog();
        blog.setNumberOfComments(blog.getNumberOfComments() + 1);
        blogRepo.save(blog);

    }
}
