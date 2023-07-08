package com.registro.usuarios.controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.registro.usuarios.modelo.Arriendo;
import com.registro.usuarios.repositorio.ArriendoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.StyleConstants;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping({"/reportes"})
public class ReporteController {

    @Autowired
    ArriendoRepositorio arriendoRepositorio;

    //todo: Agregar método para generar una tabla con todos los arriendos

    //Método para generar una tabla con todos los arriendos
    @GetMapping
    public String listarArriendos(Model model) {
        List<Arriendo> arriendos = arriendoRepositorio.findAll();
        model.addAttribute("arriendos", arriendos);
        return "reportes";
    }

    //todo: Agregar método para generar un PDF con todos los arriendos
    @PostMapping("/generar-pdf")
    public ResponseEntity<String> generarPDF() {
        //obtener todos los arriendos
        List<Arriendo> arriendos = arriendoRepositorio.findAll();

        //generar PDF
        Document document = new Document();
        try {
            String rutaArchivoPDF = "C:/Informes/arriendos.pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaArchivoPDF));
            document.open();
            PdfPTable table = new PdfPTable(9); // 8 columnas
            //Agregar encabezados
            String[] headers = {"ID", "Fecha Inicio", "Fecha Termino", "Forma pago", "Detalle pago", "Garantia",
                    "Monto Garantia", "Usuario", "Bicicleta"};
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            //Agregar filas
            Font rowFont = FontFactory.getFont(FontFactory.HELVETICA);
            for (Arriendo arriendo : arriendos) {
                table.addCell(new PdfPCell(new Phrase(arriendo.getIdArriendo().toString(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getFechaIni(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getFechaTer(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getFormaPago(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getDetallesPago(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(arriendo.getGarantia()), rowFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(arriendo.getMontoGarantia()), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getUsuario().getNombre(), rowFont)));
                table.addCell(new PdfPCell(new Phrase(arriendo.getBicicleta().getMarca(), rowFont)));
            }
            document.add(table);
            document.close();
            writer.close();
            return ResponseEntity.ok().build();
        }catch (DocumentException | IOException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
