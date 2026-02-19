package com.example.demo.controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * 파일 업로드 및 로컬 저장을 담당하는 Controller
 *
 * - multipart/form-data 요청을 처리한다.
 * - 업로드된 파일을 서버 로컬 디스크에 저장한다.
 * - 파일명 충돌 방지를 위해 UUID를 사용한다.
 */
@Controller
public class FileSaveController {

    /**
     * 파일 업로드 요청 처리
     *
     * HTTP 요청 예시:
     * POST /upload/save
     * Content-Type: multipart/form-data
     * form-data:
     *   key = file, value = 업로드 파일
     */
    @PostMapping("/upload/save")
    @ResponseBody
    public String save(@RequestParam("file") MultipartFile file) throws IOException {


        if (file == null || file.isEmpty()) {
            return "파일이 비어 있습니다.";
        }


        String original = file.getOriginalFilename();
        if (original == null) {
            original = "unknown";
        }

        original = original.replace("\\", "_").replace("/", "_");


        String savedName = UUID.randomUUID() + "_" + original;


        Path uploadPath = Path
                .of(System.getProperty("user.dir"), "uploads")
                .toAbsolutePath();


        Files.createDirectories(uploadPath);


        Path dest = uploadPath.resolve(savedName);


        file.transferTo(dest.toFile());


        return "저장 완료: " + dest;
    }
}
