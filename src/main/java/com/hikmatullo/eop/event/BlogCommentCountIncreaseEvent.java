package com.hikmatullo.eop.event;

import com.hikmatullo.eop.etity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlogCommentCountIncreaseEvent {
    private Blog blog;
}
