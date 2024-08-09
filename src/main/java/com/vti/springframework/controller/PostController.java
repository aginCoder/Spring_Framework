package com.vti.springframework.controller;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostFilterForm;
import com.vti.springframework.form.PostUpdateForm;
import com.vti.springframework.service.PostService;
import com.vti.springframework.validation.PostIdExist;
import com.vti.springframework.validation.PostTitleExist;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        return postService.findAll(form, pageable);
    }

    // api/v1/posts/... thì nó vẫn sẽ là 1 đường dẫn giống nhau
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(
            @PathVariable("id") @PostIdExist Long id
    ) {
        return postService.findById(id);
    }

    // api/v1/posts/search...
    @GetMapping(value = "/api/v1/posts/search", params = "title")
    List<PostDto> findByTitle(
            @RequestParam("title") String title
    ){
        return postService.findByTitle(title);
    };

    @GetMapping(value = "/api/v1/posts/search", params = {"minId", "maxId"})
    List<PostDto> findByIdBetween(
            @RequestParam("minId") Long minId,
            @RequestParam("maxId") Long maxId
    ){
        return postService.findByIdBetween(minId, maxId);
    };

    @GetMapping(value = "/api/v1/posts/search", params = "search")
    Page<PostDto> findByTitleContaining(
            @RequestParam("search") String search,
            Pageable pageable
    ){
        return postService.findByTitleContaining(search, pageable);
    };

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/posts")
    public PostDto create(
            @RequestBody @Valid PostCreateForm form
    ) {
        return postService.create(form);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(
            @PathVariable("id") @PostIdExist Long id,
            @RequestBody @Valid PostUpdateForm form
    ) {
        return postService.update(id, form);
    }

    @PatchMapping("/api/v1/posts/{id}/title")
    public void updateTitle(
            @PathVariable("id") @PostIdExist Long id,
            @RequestBody String title
    ){
        postService.updateTitle(id, title);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(
            @PathVariable("id") @PostIdExist Long id
    ) {
        postService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/api/v1/posts/delete", params = "title")
    public void deleteByTitle(
            @RequestParam("title") @PostTitleExist String title
    ){
        postService.deleteByTitle(title);
    }
}