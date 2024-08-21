package com.uneebSid.tag.service.service.impl;

import com.uneebSid.tag.service.entity.Tag;
import com.uneebSid.tag.service.repository.TagRepository;
import com.uneebSid.tag.service.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TagServiceImp implements TagService
{
    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag addTag(Tag newTag) {
        return tagRepository.save(newTag);
    }

    @Override
    public Tag updateTag(Long tagId, Tag updateTag) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(()-> new RuntimeException("tag not found with id: " +tagId));
            tag.setName(updateTag.getName());
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElseThrow(()->new RuntimeException("tag not found with id: " +id));
    }

    @Override
    public void deleteTag(Long id)
    {
        tagRepository.deleteById(id);
    }

    @Override
    public Optional<List<Tag>> getTagsByUserId(Long userId) {
        return tagRepository.findByUserId(userId);
    }
}
