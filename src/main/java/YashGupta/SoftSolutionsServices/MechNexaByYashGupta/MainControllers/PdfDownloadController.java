package YashGupta.SoftSolutionsServices.MechNexaByYashGupta.MainControllers;

import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Entity.Receipt;
import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories.ReceiptRepository;
import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Repositories.ServiceRequestRepository;


import YashGupta.SoftSolutionsServices.MechNexaByYashGupta.Services.PdfGeneratorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/mech/nexa")
public class PdfDownloadController{


    @Autowired
    private PdfGeneratorServices pdfGeneratorService;

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping("/download/receipt/by/request/number")
    public ResponseEntity<byte[]> downloadServiceReceipt(@RequestParam String requestnumber) {
        try {
            Receipt receipt = receiptRepository.findReceiptByrequestnumber(requestnumber);

            if (receipt == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String receiptDetails = String.format(
                    "\n" +
                            "══════════════════════════════════════════════════════════════════════\n" +
                            "                        MechNexa Service Receipt                     \n" +
                            "══════════════════════════════════════════════════════════════════════\n\n" +

                            "🔧 Receipt ID             : %-35s User ID              : %s\n" +
                            "👤 Customer Name          : %-35s Vehicle Number       : %s\n" +
                            "🛠️ Service Type           : %-35s Service Provider ID  : %s\n" +
                            "🏢 Mechanic Name  : %-35s\n" +
                            "📝 Service Description     : %-35s\n" +
                            "💰 Service Cost (₹)        : %-35s Service Status              : %s\n" +
                            "📅 Request Date           : %-35s\n" +
                            "✅ Completion Date        : %-35s\n\n" +

                            "══════════════════════════════════════════════════════════════════════\n" +
                            "        Thank you for choosing MechNexa for your service needs!     \n" +
                            "══════════════════════════════════════════════════════════════════════\n\n" +

                            "🛠️  We ensure high-quality repair and maintenance work. If you have\n" +
                            "    any feedback, feel free to reach out. Safe journeys ahead! 🚗✨\n\n" +
                            "Regards,\n" +
                            "MechNexa Team – Powered by Yash Gupta Soft Solutions Services.\n",

                    receipt.getRequestnumber(),
                    receipt.getUserid(),
                    receipt.getCustomername(),
                    receipt.getVehiclenumber(),
                    receipt.getServicetype(),
                    receipt.getServiceproviderid(),
                    receipt.getMechanicname(),
                    receipt.getServicedescription(),
                    String.valueOf(receipt.getServicecost()),
                    receipt.getStatus(),
                    receipt.getServicerequestdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                    receipt.getServicecompletiondatetime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
            );


            ByteArrayOutputStream outputStream = pdfGeneratorService.generateServiceReceiptPdf(receiptDetails);
            byte[] pdfBytes = outputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "servicereceipt-" + requestnumber + ".pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
