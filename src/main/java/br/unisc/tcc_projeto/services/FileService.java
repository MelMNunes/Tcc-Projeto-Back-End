package br.unisc.tcc_projeto.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public byte[] salvarArquivo(MultipartFile file) {
        try {
            return file.getBytes(); // Aqui você pode salvar os arquivos no banco ou sistema de arquivos
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo: " + e.getMessage(), e);
        }
    }
}

