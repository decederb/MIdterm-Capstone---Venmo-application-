package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.TransferStatusNotFoundException;
import com.techelevator.tenmo.model.TransferStatus;

public interface TransferStatusDao {

    public int createTransferStatus (String transferStatusDesc);

    public TransferStatus getTransferStatus(int transferStatusId) throws TransferStatusNotFoundException;

    public TransferStatus updateTransferStatus(TransferStatus transferStatus) throws TransferStatusNotFoundException;

    public void deleteTransferStatus(int transferStatusId);
}
