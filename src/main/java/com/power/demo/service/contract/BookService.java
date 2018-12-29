package com.power.demo.service.contract;

import com.power.demo.entity.vo.BooksVO;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     */
     void addBooks(BooksVO books);

    /**
     * 查询所有图书
     */
    List<BooksVO> selectAllBooks();

    /**
     * 根据书名查询图书
     */
    BooksVO selectByName(String booksName);

    /**
     * 根据id查询图书
     */
    BooksVO selectById(String id);

    /**
     * 根据id修改图书内容
     */
    int changeBooks(BooksVO book);

    /**
     * 根据id删除图书
     */
    void deleteBooks(String bookId);
}
