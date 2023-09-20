package com.gray.springbootdemo.web;

import com.gray.springbootdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller + @ResponseBody
@RequestMapping("/books")
public class HelloController {

//  sefl after init
    // A. --> B.ConfigurationProperties
//    @Value("${book.name}")
//    private String book_name;
//    @Value("${book.author}")
//    private String author;
//    @Value("${book.isbn}")
//    private String isbn;
//    @Value("${book.description}")
//    private String description; // refer each properties

    @Autowired //ROC inject need @Component in Book
    private Book book;


    @GetMapping("/getBook")
    public Object getBook(){
        System.out.println("GetBook");
        return book;
    }
    //    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping("/say")
    public String hello(){
        return "Hello SpringBoot~~";

    }

//    @Controller
    // return one page (like template)
    // on class
    @GetMapping("/books")
    public String getAll(){
        return "books";
    }

    @ResponseBody
    @GetMapping("/bookMap")
    public Object getAllBody(){
        Map map = new HashMap<String, String>();

        map.put("name","abc");
        map.put("age","13");
        return map;
    }

    @ResponseBody
    @GetMapping("/allPage")
    public Object getAllPage(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        //http://127.0.0.1:8080/books/allPage?page=1&size=10
        Map book = new HashMap<String, String>();

//        book.put("name",book_name);
//        book.put("author",author);
//        book.put("isbn",isbn);
//        book.put("description",description);
        Map book1 = new HashMap<String, String>();
        book1.put("name","Name2");
        book1.put("author","Yelly");
        book1.put("isbn","66666");
        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book1);

        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("page", page);
        pageMap.put("size", size);
        pageMap.put("contents", contents);


        return pageMap;
    }


    @GetMapping("/books/{id}")
    // PathVariable parameter can pass Optional long parameter 'id' is present but cannot be translated into a null value due to being declared as a primitive typ
    public Object getOne(@PathVariable long id ){
//        public Object getOne(@PathVariable("id") long bid ){
        // System.out.println("bid === "+bid);
        // http://127.0.0.1:8080/books/books/12
        System.out.println("id === "+id);
        Map map = new HashMap<String, String>();

        map.put("name","book");
        map.put("age","13");
        return map;
    }

    @GetMapping("/books/{id}/{name}")
    // 任意位置
    // PathVariable parameter can pass Optional long parameter 'id' is present but cannot be translated into a null value due to being declared as a primitive typ
    public Object getInfo(@PathVariable long id,@PathVariable String name ){
// multi parameter
        System.out.println("id === "+id+"name"+name);
        Map map = new HashMap<String, String>();
    //http://127.0.0.1:8080/books/books/12/gum
        map.put("name",name);
        map.put("age","13");

        return map;
    }


    @GetMapping("/books/{id}/{name:[a-z_]+}")
    // 任意位置
    // PathVariable parameter can pass Optional long parameter 'id' is present but cannot be translated into a null value due to being declared as a primitive typ
    public Object getInfoRegx(@PathVariable long id,@PathVariable String name ){
// multi parameter
        System.out.println("id === "+id+"name"+name);
        Map map = new HashMap<String, String>();

        map.put("name",name);
        map.put("age","13");

        return map;
    }


@PostMapping("/books")
    public Object post (@RequestParam ("name")String name ,@RequestParam ("author")String author ,@RequestParam ("isbn")String isbn ){
        System.out.println("name=="+name);
        Map map = new HashMap<String, String>();

        map.put("name",name);
        map.put("author",author);
        map.put("isbn",isbn);
        return map;
    }

}
