package com.power.demo.service.impl;

import com.power.demo.dao.BooksDao;
import com.power.demo.entity.vo.BooksVO;
import com.power.demo.service.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksDao booksDao;
    @Override
    public int addBooks(BooksVO books) {
       int a =  booksDao.addBooks(books);
       return a;
    }

    @Override
    public List<BooksVO> selectAllBooks() {
        List<BooksVO> list =  booksDao.selectAllBooks();
        return list;
    }

    @Override
    public BooksVO selectByName(String booksName) {
        return booksDao.selectByName(booksName);
    }

    @Override
    public BooksVO selectById(String id) {
        return booksDao.selectById(id);
    }

    @Override
    public int changeBooks(BooksVO book) {
        return booksDao.changeBooks(book);
    }

    @Override
    public int deleteBooks(String bookId) {
       int a = booksDao.deleteBooks(bookId);
       return a;
    }
}
