package com.example.demofirstspring.controller;

import com.example.demofirstspring.model.Author;
import com.example.demofirstspring.service.AuthorService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Value("${image.upload.dir}")
    private String imageUploadDir;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        map.addAttribute("name", "Armen");
        map.addAttribute("authors", authorService.findAll());
        return "index";
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String authors(ModelMap map) {
        map.addAttribute("authors", authorService.findAll());
        return "allAuthors";
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public String addAuthorView(ModelMap map) {
        map.addAttribute("author", new Author());
        return "addAuthor";
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute(name = "author") Author author,
                            @RequestParam(name = "picture") MultipartFile multipartFile) throws IOException {
        File file = new File(imageUploadDir);
        if (!file.exists()) {
            file.mkdirs() ;
        }

        String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File(imageUploadDir + fileName));
        author.setPicUrl(fileName);
        authorService.saveAuthor(author);
        return "redirect:/addAuthor";
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
    public String deleteAuthor(@RequestParam(name = "id") int id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response,
                                    @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadDir + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in,response.getOutputStream());
    }
}
