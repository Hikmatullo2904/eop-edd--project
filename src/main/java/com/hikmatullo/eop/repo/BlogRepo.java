package com.hikmatullo.eop.repo;

import com.hikmatullo.eop.etity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
