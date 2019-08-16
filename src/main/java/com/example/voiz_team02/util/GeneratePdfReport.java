package com.example.voiz_team02.util;


/*import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;*/
import com.example.voiz_team02.model.DonglePlans;
import com.example.voiz_team02.model.Order;
import com.example.voiz_team02.model.PostpaidPlan;
import com.example.voiz_team02.model.PrepaidPlans;
/*import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;*/
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class GeneratePdfReport {


    public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell();
        Paragraph p = new Paragraph(text);
        p.setAlignment(Element.ALIGN_RIGHT);
        cell.addElement(p);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        return cell;
    }


    private static final Logger logger = (Logger) LoggerFactory.getLogger(GeneratePdfReport.class);

    public static ByteArrayInputStream invoiceReport(List<Order> order, List<DonglePlans> dongle, List<PostpaidPlan> post, List<PrepaidPlans> pre) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

        /*    PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 2});
            table.addCell(createTextCell(order.get(0).getDongleId()));*/
           /* for(DonglePlans i:dongle){
                table.addCell(createTextCell(i.getId()));
                table.addCell(createTextCell(i.getBenefits()));
                table.addCell(createTextCell(i.getScheme()));

            }*/

            PdfPTable tableImg = new PdfPTable(2);
            tableImg.setWidthPercentage(90);
            tableImg.setWidths(new int[]{4,4});

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(90);
            table.setWidths(new int[]{4, 2, 2, 2});

            PdfPTable tableDongle = new PdfPTable(3);
            tableDongle.setWidthPercentage(90);
            tableDongle.setWidths(new int[]{1, 3, 3});

            PdfPTable tablePost = new PdfPTable(4);
            tablePost.setWidthPercentage(90);
            tablePost.setWidths(new int[]{1, 2, 2, 2});

            PdfPTable tablePre = new PdfPTable(2);
            tablePre.setWidthPercentage(90);
            tablePre.setWidths(new int[]{1, 4});
            String dest="src/main/resources/static/images/invoiceImg.PNG";
           /* ImageData data;
            data = ImageDataFactory.create(dest);

            // Creating an Image object
            Image image = new Image(data);
            Cell cell = new Cell();
            cell.add(image.setAutoScale(true))*/;
            tableImg.addCell(createImageCell(dest));

            Date date=new Date();
            String strDate="yyyy/MM/dd hh:mm:ss";
            DateFormat dateFormat=new SimpleDateFormat(strDate);
            String formattedDate=dateFormat.format(date);
            tableImg.addCell(formattedDate);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Email id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Dongle", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Post paid", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Pre paid", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            PdfPCell hcellDongle;

            hcellDongle = new PdfPCell(new Phrase("Dongle name", headFont));
            hcellDongle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableDongle.addCell(hcellDongle);

            hcellDongle = new PdfPCell(new Phrase("Scheme", headFont));
            hcellDongle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableDongle.addCell(hcellDongle);

            hcellDongle = new PdfPCell(new Phrase("Benefits", headFont));
            hcellDongle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableDongle.addCell(hcellDongle);

            PdfPCell hcellPost;

            hcellPost = new PdfPCell(new Phrase("Post-paid Plan id", headFont));
            hcellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePost.addCell(hcellPost);

            hcellPost = new PdfPCell(new Phrase("Scheme", headFont));
            hcellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePost.addCell(hcellPost);

            hcellPost = new PdfPCell(new Phrase("Value", headFont));
            hcellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePost.addCell(hcellPost);

            hcellPost = new PdfPCell(new Phrase("Benefits", headFont));
            hcellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePost.addCell(hcellPost);

            PdfPCell hcellPre;

            hcellPre = new PdfPCell(new Phrase("Pre-paid Plan id", headFont));
            hcellPre.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePre.addCell(hcellPre);

            hcellPre = new PdfPCell(new Phrase("Scheme", headFont));
            hcellPre.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablePre.addCell(hcellPre);


            /*PdfPCell hcellImg;

            hcellImg = new PdfPCell(new Phrase("Invoice", headFont));
            hcellImg.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableImg.addCell(hcellImg);
*/
            for(PrepaidPlans o:pre){
                PdfPCell cellPre;

                cellPre = new PdfPCell(new Phrase(o.getId()));
                cellPre.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPre.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablePre.addCell(cellPre);

                cellPre = new PdfPCell(new Phrase(o.getScheme()));
                cellPre.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPre.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablePre.addCell(cellPre);

            }


            for(PostpaidPlan m:post){

                PdfPCell cellPost;

                cellPost = new PdfPCell(new Phrase(m.getId()));
                cellPost.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablePost.addCell(cellPost);

                cellPost = new PdfPCell(new Phrase(m.getScheme()));
                cellPost.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPost.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablePost.addCell(cellPost);

                cellPost = new PdfPCell(new Phrase(m.getValue()));
                cellPost.setPaddingLeft(5);
                cellPost.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPost.setHorizontalAlignment(Element.ALIGN_LEFT);
                tablePost.addCell(cellPost);

                cellPost = new PdfPCell(new Phrase(m.getBenefits()));
                cellPost.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellPost.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellPost.setPaddingRight(5);
                tablePost.addCell(cellPost);


            }


            for(DonglePlans j:dongle){
                PdfPCell cellDongle;

                cellDongle = new PdfPCell(new Phrase(j.getId()));
                cellDongle.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellDongle.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableDongle.addCell(cellDongle);

                cellDongle = new PdfPCell(new Phrase(j.getScheme()));
                cellDongle.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellDongle.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableDongle.addCell(cellDongle);

                cellDongle = new PdfPCell(new Phrase(j.getBenefits()));
                cellDongle.setPaddingLeft(5);
                cellDongle.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellDongle.setHorizontalAlignment(Element.ALIGN_LEFT);
                tableDongle.addCell(cellDongle);
            }




            for (Order i : order) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(i.getUserId()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(i.getDongleId()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(i.getPostPaidId()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(i.getPrePaidId()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);

            }
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(tableImg);
            document.add(table);
            document.add(tableDongle);
            document.add(tablePost);
            document.add(tablePre);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}