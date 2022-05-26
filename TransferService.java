
import com.techelevator.tenmo.dao.*;
import com.techelevator.tenmo.exception.AccountNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*@Component
public class TransferService {
    private final JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;

    public TransferService(JdbcTemplate jdbcTemplate, AccountDao accountDao, UserDao userDao, TransferDao transferDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    public boolean isBalanceSufficient(int fromId, BigDecimal amountToTransfer) throws AccountNotFoundException {
        return (accountDao.getBalance(fromId).compareTo(amountToTransfer)) >= 0;
    }

    public void adjustBalances(int fromId, int toId, BigDecimal amountToTransfer) throws AccountNotFoundException {
        Account oldFromAccount = accountDao.findAccountByAccountId(fromId);
        Account newFromAccount = new Account();
        newFromAccount.setAccountId(fromId);
        newFromAccount.setBalance(oldFromAccount.getBalance().subtract(amountToTransfer));
        newFromAccount.setUserId(oldFromAccount.getUserId());
        accountDao.updateAccount(newFromAccount);
        Account oldToAccount = accountDao.findAccountByAccountId(toId);
        Account newToAccount = new Account();
        newToAccount.setAccountId(toId);
        newToAccount.setBalance(oldToAccount.getBalance().add(amountToTransfer));
        newToAccount.setUserId(oldToAccount.getUserId());
        accountDao.updateAccount(newToAccount);
    }

    public Transfer recordTransfer(int fromId, int toId, BigDecimal amountToTransfer) {
        int transferTypeId = 2;
        int transferStatusId = 2;
        Transfer transfer = new Transfer();
        transfer.setTransferTypeId(transferTypeId);
        transfer.setTransferStatusId(transferStatusId);
        transfer.setAccountFrom(fromId);
        transfer.setAccountTo(toId);
        transfer.setTransferAmount(amountToTransfer);
        Transfer newTransfer = transferDao.createTransfer(transfer);
        return newTransfer;
    }

    public Transfer completeTransfer(int fromId, int toId, BigDecimal amountToTransfer) throws AccountNotFoundException {
        Transfer newTransfer = null;
        if (isBalanceSufficient(fromId, amountToTransfer)) {
            adjustBalances(fromId, toId, amountToTransfer);
            newTransfer = recordTransfer(fromId, toId, amountToTransfer);
        }
        return newTransfer;
    }
}*/