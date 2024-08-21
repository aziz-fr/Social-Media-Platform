package com.aziz.ReplyService.model;
import com.aziz.ReplyService.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse
{
    private boolean error;
    private String message;
    private Reply reply;
}
