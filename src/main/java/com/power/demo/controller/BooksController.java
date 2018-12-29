package com.power.demo.controller;


import com.power.demo.entity.vo.BooksVO;
import com.power.demo.service.contract.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
@Api("图书api")
public class BooksController {

    @Autowired
    private BookService bookService;
//    @RequestMapping(value = "/addBooks", method = RequestMethod.POST)
    @PostMapping("/addBooks") // 等同于上一行,简写
    @ApiOperation("添加图书")
    public String addBooks(@RequestBody BooksVO books){
        bookService.addBooks(books);
        return "成功";
    }

//    @RequestMapping(value = "/selectBooks", method = RequestMethod.GET)
    @GetMapping("/selectBooks") // 等同于上一行,简写
    @ApiOperation("查询所有图书")
    public List<BooksVO> selectAllBooks(){
       List<BooksVO> books =  bookService.selectAllBooks();
       return books;
    }

//    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    @GetMapping("/selectByName") // 等同于上一行,简写
    @ApiOperation("根据书名查询图书")
    public BooksVO selectByName(@RequestParam String booksName){
        BooksVO books = bookService.selectByName(booksName);
        return books;
    }

//    @RequestMapping(value = "/changeBooks", method = RequestMethod.PUT)
    @PutMapping("/changeBooks") // 等同于上一行,简写
    @ApiOperation("根据id修改图书内容")
    public int changeBooks(@RequestBody BooksVO book){
        int a = bookService.changeBooks(book);
        return a;
    }

//    @RequestMapping(value = "/deleteBooks", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteBooks") // 等同于上一行,简写
    @ApiOperation("根据id删除图书")
    public String deleteBooks(@RequestParam String bookId){
        bookService.deleteBooks(bookId);
        return "删除成功";
    }
}
