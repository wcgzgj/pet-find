package petfind.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    /**
     * 文件上传
     * @param file
     * @param req
     * @return
     */
    String upload(MultipartFile file, HttpServletRequest req);
}
