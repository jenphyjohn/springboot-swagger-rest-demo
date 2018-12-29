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
        // TODO 所有方法增加try catch处理
        // TODO 所有方法增加统一返回体设计
        bookService.addBooks(books);
        return "成功";
    }

//    @RequestMapping(value = "/selectBooks", method = RequestMethod.GET)
    @GetMapping("/selectBooks") // 等同于上一行,简写
    @ApiOperation("查询所有图书")
    public List<BooksVO> selectAllBooks(){
        // TODO 增加分页功能
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
    public String changeBooks(@RequestBody BooksVO book){
        BooksVO booksVO = bookService.selectById(book.getId());
        if (booksVO == null) {
            return "未找到资源";
        }
        int a = bookService.changeBooks(book);
        if (a > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

//    @RequestMapping(value = "/deleteBooks", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteBooks") // 等同于上一行,简写
    @ApiOperation("根据id删除图书")
    public String deleteBooks(@RequestParam String bookId){
        bookService.deleteBooks(bookId);
        // TODO 按照changeBooks增加判断
        return "删除成功";
    }
}
