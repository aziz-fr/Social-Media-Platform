package com.uneebSid.tag.service.repository;

import com.uneebSid.tag.service.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long>
{

    Optional<List<Tag>> findByUserId(Long userId);
}
