package com.springboot.validation;

import com.springboot.dto.AccountDto;
import com.springboot.dto.CreateAccountDto;
import com.springboot.dto.TransactionDto;
import com.springboot.model.constants;

public class InputValidator {
    public static boolean isSearchCriteriaValid(AccountDto accountDto) {
        return constants.SORT_CODE_PATTERN.matcher(accountDto.getSortCode()).find() &&
                constants.ACCOUNT_NUMBER_PATTERN.matcher(accountDto.getAccountNumber()).find();
    }

    public static boolean isAccountNoValid(String accountNo) {
        return constants.ACCOUNT_NUMBER_PATTERN.matcher(accountNo).find();
    }
    public static boolean isCreateAccountCriteriaValid(CreateAccountDto createAccountDto) {
        return ( !createAccountDto.getOwnerName().isBlank());
    }

    public static boolean isSearchTransactionValid(TransactionDto transactionDto) {
        // TODO Add checks for large amounts; consider past history of account holder and location of transfers

        if (!isSearchCriteriaValid(transactionDto.getSourceAccount()))
            return false;

        if (!isSearchCriteriaValid(transactionDto.getTargetAccount()))
            return false;

        if (transactionDto.getSourceAccount().equals(transactionDto.getTargetAccount()))
            return false;

        return true;
    }

}
