/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class PdfFiller {
    
    private Map<String, Object> reservationDetails;
    
    public PdfFiller(Map<String, Object> reservationDetails) {
        this.reservationDetails = reservationDetails;
    }
    
    public void fillPdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
        PdfContentByte canvas = stamper.getOverContent(1);
        
        canvas.setColorFill(new GrayColor(0f));
        canvas.setFontAndSize(bf, 10);
        canvas.beginText();
        
        // Remplir le PDF avec les détails de la réservation
        fillDetails(canvas);
        
        canvas.endText();
        stamper.close();
        reader.close();
    }
    
    private void fillDetails(PdfContentByte canvas) {
        for (Map.Entry<String, Object> entry : reservationDetails.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            // Associer chaque clé à une position spécifique dans le PDF
            switch (key) {
                case "Date" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 120, 769, 0);
                case "GareDepart" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 80, 754, 0);
                case "GareArrivee" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 80, 739, 0);
                case "numeroPlace" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 90, 724, 0);
                case "HeureDepart" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 120, 709, 0);
                case "Classe" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 375, 760, 0);
                case "Prix" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 350, 679, 0);
                case "NumTrain" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 120, 605, 0);
                case "IDvoyage" -> canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, value, 390, 605, 0);
            
            }
        }
    }
}