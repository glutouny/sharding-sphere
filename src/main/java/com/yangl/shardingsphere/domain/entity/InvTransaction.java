package com.yangl.shardingsphere.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 库存事务表
 *
 * @author li.yang01@hand-china.com 2020/9/9 11:43 上午
 */
@Data
@TableName("inv_transaction")
public class InvTransaction {

    public static final String FIELD_INV_TRANSACTIONS_ID = "invTransactionsId";
    public static final String FIELD_PROCESSING_STATUS_CODE = "processingStatusCode";
    public static final String FIELD_SKU_ID = "skuId";

    @TableId
    private Long invTransactionsId;

    private String posCode;

    private String skuCode;

    private String transactionCode;

    private String transactionTypeCode;

    private String processingStatusCode;

    private Long onHandInc;

    private Long reservedInc;

    private String message;

    private String sourceCode;

    private String sourceDetailCode;

    private String transactionSource;

    private String sourceTypeCode;

    private LocalDateTime sourceDate;

    private Long sourceTimestamp;

    private LocalDateTime creationDate;

    private Long createdBy;

    private LocalDateTime lastUpdateDate;

    private Long lastUpdatedBy;

    private Long objectVersionNumber;
}
