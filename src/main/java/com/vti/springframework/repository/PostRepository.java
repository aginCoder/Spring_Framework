package com.vti.springframework.repository;

import com.vti.springframework.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository
        extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    // 1. method name
    // Tiền tố: findBy, countBy, existsBy, deleteBy
    // Vd: Lấy ra tất cả post theo title
    // ... WHERE title = ?
    List<Post> findByTitle(String title);

    // Vd: Lấy ra tất cả post có minId <= id <= maxId
    // ... WHERE id BETWEEN ? AND ?
    List<Post> findByIdBetween(Long minId, Long maxId);

    // Vd: Tìm kiếm post theo title
    // ... WHERE title LIKE '%...%'
    Page<Post> findByTitleContaining(String search, Pageable pageable);  // sử dụng phân trang thì phải thêm tham số pageable

    // Vd: Xóa post theo title
    void deleteByTitle(String title);

    // Vd: Kiểm tra tồn tại theo title
    boolean existsByTitle(String title);


    // 2. @Query annotation
    // vd: Cập nhật title cho post
    @Query("UPDATE Post SET title = :title WHERE id = :id")
    @Modifying
    void updateTitle(@Param("id") Long id, @Param("title") String title);

    // VD: Cập nhật title cho post
    // @Query("UPDATE Post SET title = ?2 WHERE id = ?1")
    // void updateTitle (Long id, String title);

    // VD: Cập nhật title cho post
    // @Query(value = "UPDATE post SET title = :title WHERE id = :id", nativeQuery = true)
    // void updateTitle(@Param("id") Long id, @Param("title") String title);
}