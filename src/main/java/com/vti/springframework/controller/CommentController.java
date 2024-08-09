package com.vti.springframework.controller;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentFilterForm;
import com.vti.springframework.form.CommentUpdateForm;
import com.vti.springframework.service.CommentService;
import com.vti.springframework.validation.CommentIdExit;
import com.vti.springframework.validation.PostIdExist;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(
            CommentFilterForm form,
            Pageable pageable
    ) {
        return commentService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(
            @PathVariable("id") @CommentIdExit Long id
    ) {
        return commentService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PathVariable("postId") @PostIdExist Long postId,
            @RequestBody @Valid CommentCreateForm form
    ) {
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(
            @PathVariable("id") @CommentIdExit Long id,
            @RequestBody @Valid CommentUpdateForm form
    ) {
        return commentService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(
            @PathVariable("id") @CommentIdExit Long id
    ) {
        commentService.deleteById(id);
    }
}