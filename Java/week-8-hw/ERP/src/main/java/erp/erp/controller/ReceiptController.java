package erp.erp.controller;

import erp.erp.database.entity.ReceiptEntity;
import erp.erp.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @GetMapping("receipt")
    public ResponseEntity<List<ReceiptEntity>> getReceiptList() {

        return new ResponseEntity<>(receiptService.getReceiptList(), HttpStatus.OK);
    }

    @PostMapping("receipt/{order_id}")
    public ResponseEntity<ReceiptEntity> createOrder(@RequestBody ReceiptEntity receiptEntity,
                                                     @PathVariable Long order_id) throws Exception {

        ReceiptEntity receipt = receiptService.createReceipt(receiptEntity, order_id);


        return new ResponseEntity<>(receipt, HttpStatus.CREATED);
    }

}
