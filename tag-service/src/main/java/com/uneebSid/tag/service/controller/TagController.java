package com.uneebSid.tag.service.controller;

import com.uneebSid.tag.service.entity.Tag;
import com.uneebSid.tag.service.service.TagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1.0/tags")
public class TagController
{
    @Autowired
    TagService tagService;

    @PostMapping
    public Tag addTag(@RequestBody Tag newTag)
    {
        return tagService.addTag(newTag);
    }

    @PutMapping("/update/{tagId}")
    public Tag updateTag(@PathVariable Long tagId, @RequestBody Tag updateTag)
    {
        return tagService.updateTag(tagId,updateTag);
    }

    @DeleteMapping
    public String deleteTag(Long tagId)
    {
        tagService.deleteTag(tagId);
        return "Tag Deleted!";
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id)
    {
        return tagService.getTagById(id);
    }

}
