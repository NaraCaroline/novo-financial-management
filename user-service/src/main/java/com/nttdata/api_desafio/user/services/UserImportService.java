package com.nttdata.api_desafio.user.services;

import com.nttdata.api_desafio.user.domain.User;
import com.nttdata.api_desafio.user.repositories.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserImportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void importUsers(MultipartFile file) throws Exception {
        List<User> users = new ArrayList<>();

        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                User user = new User();
                String username = currentRow.getCell(0).getStringCellValue();
                String password = currentRow.getCell(1).getStringCellValue();

                user.setUsername(username);
                user.setPassword(passwordEncoder.encode(password));

                users.add(user);
            }
        }
        userRepository.saveAll(users);
    }
}
