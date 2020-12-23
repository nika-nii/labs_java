package ru.bstu.iitus.vt41.fnr.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.bstu.iitus.vt41.fnr.course.constants.FileErrors;
import ru.bstu.iitus.vt41.fnr.course.exception.FileNotFoundException;
import ru.bstu.iitus.vt41.fnr.course.exception.FileSaveException;
import ru.bstu.iitus.vt41.fnr.course.models.Datasheet;
import ru.bstu.iitus.vt41.fnr.course.repositories.DatasheetRepository;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class DatasheetService {

    @Autowired
    DatasheetRepository datasheetRepository;

    public Datasheet saveFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (filename.contains("...")) {
                throw new FileSaveException(FileErrors.INVALID_FILE + filename);
            }
            Datasheet model = new Datasheet(filename, file.getContentType(), file.getBytes());
            return datasheetRepository.save(model);

        } catch (Exception e) {
            throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
        }
    }

    public Datasheet getFile(String fileId) {
        return datasheetRepository.findById(fileId).orElseThrow(() -> new FileNotFoundException(FileErrors.FILE_NOT_FOUND + fileId));
    }

    public List<Datasheet> getListOfFiles() {
        return datasheetRepository.findAll();
    }
}