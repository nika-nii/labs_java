package ru.bstu.iitus.vt41.fnr.course.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@AllArgsConstructor
public class Datasheet {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "datasheet_id")
    private String id;
    private String fileName;
    private String fileType;
    private String manufacturer;
    @Lob
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "element", referencedColumnName = "element_id")
    private Element element;

    public Datasheet() {

    }

    public Datasheet(String fileName, String fileType, byte[] fileData) {

        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    public String getFileId() {
        return id;
    }

    public void setFileId(String fileId) {
        this.id = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}