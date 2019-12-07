package pl.edu.pjwstk.jaz.user.product.add;

import liquibase.util.file.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.servlet.http.Part;

@ManagedBean
@ViewScoped
public class Fileupload2 {

    private Part uploadedFile;
//    private String folder = "images";

//    private UploadedFile uploadedFile;
//
String fileSavePath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/images";

    private Path folder = Paths.get(fileSavePath);
    private String filename = FilenameUtils.getBaseName(uploadedFile.getName());
    private String extension = FilenameUtils.getExtension(uploadedFile.getName());
    private Path file = Files.createTempFile(folder, filename + "-", "." + extension);

    public Fileupload2() throws IOException {
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }


    public void saveFile(){

//        try (InputStream input = uploadedFile.getInputStream()) {
//            String fileName = uploadedFile.getSubmittedFileName();
//            Files.copy(input, new File(folder, fileName).toPath());
//        }
        try (InputStream input = uploadedFile.getInputStream()) {
            Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("Uploaded file successfully saved in " + file);
    }
}
