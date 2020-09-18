package com.yangl.shardingsphere.api.controller;

import com.yangl.shardingsphere.domain.entity.InvTransaction;
import com.yangl.shardingsphere.domain.service.InvTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author li.yang01@hand-china.com 2020/9/9 1:07 下午
 */
@RestController
public class InvTransactionController {

    @Autowired
    private InvTransactionService invTransactionService;

    @PostMapping("save-inv")
    public Object insertInv() {
        List<InvTransaction> invTransactionList = new ArrayList<>();
        install(invTransactionList);
        for (InvTransaction invTransaction : invTransactionList) {
            invTransactionService.save(invTransaction);
        }
//        invTransactionService.saveBatch(invTransactionList);
        return "success";
    }

    @GetMapping("query-inv")
    public List<InvTransaction> queryInv() {
        List<InvTransaction> list = invTransactionService.list();
        return list;
    }

    private void install(List<InvTransaction> invTransactionList) {
        for (int i = 1; i < 10; i++) {
            InvTransaction invTransaction = new InvTransaction();
//            invTransaction.setInvTransactionsId((long)i);
            invTransaction.setTransactionCode("123456789"+i);
            invTransaction.setOnHandInc((long)i);
            invTransaction.setPosCode("LFL_KS");
            invTransaction.setSkuCode("123123");
            invTransaction.setTransactionTypeCode("123456");
            invTransaction.setProcessingStatusCode("PENDING");
            invTransaction.setReservedInc(0L);
            invTransaction.setSourceTypeCode("123");
            invTransaction.setSourceDate(new Date());
            invTransactionList.add(invTransaction);
        }

    }

}
