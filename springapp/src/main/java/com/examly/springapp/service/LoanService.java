package com.examly.springapp.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.DocumentModel;
import com.examly.springapp.model.LoanApplicantModel;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.LoanApplicantRepository;

@Service
public class LoanService {
    @Autowired
    LoanApplicantRepository loanRepo;
    @Autowired
    DocumentRepository docRepo;

    public LoanService(LoanApplicantRepository loanRepo, DocumentRepository docRepo) {
        super();
        this.loanRepo = loanRepo;
        this.docRepo = docRepo;
    }

    public boolean saveLoan(LoanApplicantModel loan) {
        loanRepo.save(loan);
        return true;
    }

    public boolean saveDocument(DocumentModel doc) {
        doc.setDocumentUpload(compressBytes(doc.getDocumentUpload()));
        docRepo.save(doc);
        return true;
    }

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }

        System.out.println("Compressed Image byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();

    }
}
