package com.c_code.bate_ponto.service.report;

import com.c_code.bate_ponto.dto.response.RegisterResponse;
import com.c_code.bate_ponto.dto.response.WorkedHoursResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfService {

    public ByteArrayOutputStream gerarRelatorioPonto(List<RegisterResponse> registros, String nomeFuncionario,
            WorkedHoursResponse workedHours)
            throws DocumentException {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();

        document.add(new Paragraph("Colaborador: " + nomeFuncionario));
        document.add(new Paragraph("Relatorio de Ponto: " + workedHours.getDate()));
        
        document.add(new Paragraph("\n"));

        PdfPTable table = new PdfPTable(3);
        table.addCell("Data");
        table.addCell("Horario");
        table.addCell("Tipo");

        for (RegisterResponse r : registros) {
            table.addCell(r.getDate());
            table.addCell(r.getTime());
            table.addCell(r.getType().name());
        }

        document.add(table);

        long totalRegistros = registros.size();
        document.add(new Paragraph("\nTotal de Registros: " + totalRegistros));
        document.add(new Paragraph("Total de Horas Trabalhadas: " + workedHours.getTotalWorked()));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add (new Paragraph("Assinatura: _______________________________________________"));
        document.close();
        return out;
    }
}