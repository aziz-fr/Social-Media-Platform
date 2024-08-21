package com.uneebSid.tag.service.service;

import com.uneebSid.tag.service.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService
{
    Tag addTag(Tag newTag);
    Tag updateTag(Long tagId, Tag updateTag);
    void deleteTag(Long id);

    Tag getTagById(Long id);

    Optional<List<Tag>> getTagsByUserId(Long userId);
}
