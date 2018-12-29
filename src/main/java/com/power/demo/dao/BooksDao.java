package com.power.demo.dao;

import com.power.demo.entity.vo.BooksVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksDao {

    /**
     * 添加图书
     * @param books
     */
    int addBooks(BooksVO books);


    /**
     * 查询所有图书
     */
    List<BooksVO> selectAllBooks();

    /**
     * 根据书名查询图书
     */
    BooksVO selectByName(@Param("name") String booksName);

    /**
     * 根据Id查询图书
     */
    BooksVO selectById(@Param("id") String id);

    /**
     * 根据id修改图书内容
     */
    int changeBooks(BooksVO books);

    /**
     * 根据id删除图书
     */
    int deleteBooks(@Param("id") String bookId);
}
