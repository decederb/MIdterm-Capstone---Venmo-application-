package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//copied imports from 'Transfer.java'

public class TransferStatus {

    //From Sql SELECT * FROM transfer.
    private int transferStatusId;
    private String transferStatusDesc;

    public int getTransferStatusId() {
        return transferStatusId;
    }
    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public String getTransferStatusDesc() {
        return transferStatusDesc;
    }

    public void setTransferStatusDesc(String transferStatusDesc) {
        this.transferStatusDesc = transferStatusDesc;
    }
}



    /*
    // ")\n"  Insert a newline in the text here
    @Override
    public String toString() {
        return  "ID: " + transferId + "\n" +
                "Type: Send (" + transferType + ")\n" +
                "Status: Approved (" + transferStatus + ")\n" +
                "From: " + userFrom + "\n" +
                "To account: " + userTo + "\n" +
                "Amount: $ " + amount;
    }
     */
