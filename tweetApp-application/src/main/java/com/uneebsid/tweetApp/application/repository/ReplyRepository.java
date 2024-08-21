package com.uneebsid.tweetApp.application.repository;

import com.uneebsid.tweetApp.application.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
