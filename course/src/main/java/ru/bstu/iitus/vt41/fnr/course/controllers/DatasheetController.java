package ru.bstu.iitus.vt41.fnr.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.bstu.iitus.vt41.fnr.course.models.Datasheet;
import ru.bstu.iitus.vt41.fnr.course.response.FileResponse;
import ru.bstu.iitus.vt41.fnr.course.service.DatasheetService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DatasheetController {
    @Autowired
    DatasheetService fileService;

    @PostMapping("/upload")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        Datasheet model = fileService.saveFile(file);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").
                path(model.getFileId()).toUriString();
        return new FileResponse(model.getFileName(), model.getFileType(), fileUri);
    }

    @PostMapping("/uploadmultiple")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).
                stream().
                map(file -> uploadFile(file)).
                collect(Collectors.toList());
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Datasheet model = fileService.getFile(fileName);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                body(new ByteArrayResource(model.getFileData()));


    }


    @GetMapping("/allfiles")
    public  List<Datasheet>  getListFiles(Model model) {
        List<Datasheet> fileDetails = fileService.getListOfFiles();

        return fileDetails;
    }
}
