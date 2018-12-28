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
    public void addBooks(BooksVO books) {
        booksDao.addBooks(books);
    }

    @Override
    public List<BooksVO> selectAllBooks() {
        List<BooksVO> list =  booksDao.selectAllBooks();
        return list;
    }

    @Override
    public BooksVO selectByName(String booksName) {
        BooksVO book = booksDao.selectByName(booksName);
        return book;
    }

    @Override
    public int changeBooks(BooksVO book) {
       int a =  booksDao.changeBooks(book);
        return a;
    }

    @Override
    public void deleteBooks(String bookId) {
        booksDao.deleteBooks(bookId);
    }
}
