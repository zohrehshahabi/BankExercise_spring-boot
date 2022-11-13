package com.springboot.mapper;

import com.springboot.dto.AccountDto;
import com.springboot.dto.AccountRequestDto;
import com.springboot.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {
    public Account toAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountType(accountRequestDto.getAccountType());
        account.setAccountNumber("");
        return account;
    }

    public List<AccountDto> toAccountDtos(List<Account> accounts) {
        return null;
    }
}

