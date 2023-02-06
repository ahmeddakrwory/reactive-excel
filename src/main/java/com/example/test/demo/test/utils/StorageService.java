package com.example.test.demo.test.utils;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class StorageService {
    public StorageService() {
    }

    public boolean delete(String filename) {
        try {

            Path file = Paths.get(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
