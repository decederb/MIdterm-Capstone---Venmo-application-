package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.TransferTypeNotFoundException;
import com.techelevator.tenmo.model.TransferStatus;
import com.techelevator.tenmo.model.TransferType;

public interface TransferTypeDao {

    public int createTransferType (String transferTypeDesc);

    public TransferType getTransferType(int transferTypeId) throws TransferTypeNotFoundException;

    public TransferType updateTransferType(TransferType transferType) throws TransferTypeNotFoundException;

    public void deleteTransferType(int transferTypeId);
}
