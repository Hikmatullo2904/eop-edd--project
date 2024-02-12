package com.hikmatullo.eop.repo;

import com.hikmatullo.eop.etity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
