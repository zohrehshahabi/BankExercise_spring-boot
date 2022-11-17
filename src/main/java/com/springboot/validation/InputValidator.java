package com.springboot.validation;

import com.springboot.dto.AccountDto;
import com.springboot.dto.CreateAccountDto;
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

}
