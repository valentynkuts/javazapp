package pl.edu.pjwstk.jaz.user.product.add;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.servlet.http.Part;
@ManagedBean
@ViewScoped
//@RequestScoped
public class Fileupload implements Serializable {
    private Part uploadedFile;
    private String folder = "images";
    private String fileSavePath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/images";

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }


    public void saveFile(){

        try {
            InputStream input = uploadedFile.getInputStream();
            System.out.println(fileSavePath);
            String fileName = uploadedFile.getSubmittedFileName();
            //Files.copy(input, new File(fileSavePath, fileName).toPath()); //TODO
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
