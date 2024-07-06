package com.ecommerce.clothes.app.services.implementations;

import com.ecommerce.clothes.app.components.exceptions.CommonException;
import com.ecommerce.clothes.app.services.contracts.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;



@Service
public class UploadFileService extends BaseService implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileService.class.getName());
    private static final String UPLOADS_FOLDER = "D:/temp/uploads";

    public UploadFileService() {
        super(UploadFileService.class.getName());
    }

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path pathFoto = getPath(filename);
        log.info("pathFoto: {}", pathFoto);
        Resource recurso = new UrlResource(pathFoto.toUri());
        if (!recurso.exists() || !recurso.isReadable()) {
            throw new CommonException("Error: no se puede cargar la imagen: " + pathFoto);
        }
        return recurso;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        log.info("file {}", file);
        String extension = "";
        String originalFilename = file.getOriginalFilename();
        int lastIndex = originalFilename.lastIndexOf('.');
        if (lastIndex > 0) {
            extension = originalFilename.substring(lastIndex + 1);
        }

        String uniqueFilename = UUID.randomUUID() + "." + extension;
        log.info("uniqueFilename {}", uniqueFilename);
        Path rootPath = getPath(uniqueFilename);
        log.info("rootPath {}", rootPath);
        log.info("file.getInputStream() {}", file.getInputStream());

        Files.copy(file.getInputStream(), rootPath);

        return uniqueFilename;
    }

    @Override
    public boolean delete(String filename) {
        if (filename != null && !filename.isEmpty()) {
            Path rootPath = getPath(filename);
            File archivo = rootPath.toFile();

            if (archivo.exists() && archivo.canRead()) {
                if (archivo.delete()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void deleteAll() {
        log.error("delete");
        FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectory(Paths.get(UPLOADS_FOLDER));
    }

    public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
}


