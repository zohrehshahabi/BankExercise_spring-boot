package com.springboot.controller;

import com.springboot.dto.AccountDto;
import com.springboot.dto.AccountRequestDto;
import com.springboot.dto.CreateAccountDto;
import com.springboot.mapper.AccountMapper;
import com.springboot.model.Account;
import com.springboot.model.Person;
import com.springboot.model.constants;
import com.springboot.services.AccountService;
import com.springboot.validation.InputValidator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("accounts")
public class AccountController {
@Autowired

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Iterable<Account> getAllAccount() {
        return accountService.getAllAccount();
    }
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkAccountBalance(

            @Valid @RequestBody AccountDto accountDto) {
        LOGGER.debug("Triggered AccountRestController.accountInput");

        // Validate input
        if (InputValidator.isSearchCriteriaValid(accountDto)) {
            // Attempt to retrieve the account information
            Account account = accountService.getAccount(
                    accountDto.getSortCode(), accountDto.getAccountNumber());

            // Return the account details, or warn that no account was found for given input
            if (account == null) {
                return new ResponseEntity<>(constants.NO_ACCOUNT_FOUND, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(constants.INVALID_SEARCH_CRITERIA, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccount(
            @Valid @RequestBody CreateAccountDto createAccountDto) {
        LOGGER.debug("Triggered AccountRestController.createAccountInput");

        // Validate input
        if (InputValidator.isCreateAccountCriteriaValid(createAccountDto)) {
            // Attempt to retrieve the account information
            Account account = accountService.createAccount(
                    createAccountDto.getOwnerName());

            // Return the account details, or warn that no account was found for given input
            if (account == null) {
                return new ResponseEntity<>(constants.CREATE_ACCOUNT_FAILED, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(constants.INVALID_SEARCH_CRITERIA, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

  /* private AccountMapper accountMapper;
  @PostMapping
    public ResponseEntity<Void>addAccount (@RequestBody AccountRequestDto accountRequestDto) {
       Account account = accountMapper.toAccount(accountRequestDto);
       accountService.saveAccount(account);
       return ResponseEntity.ok().build();
   }

   @GetMapping
   public ResponseEntity<List<AccountDto>> getAllAccount() {
      return ResponseEntity.ok (accountMapper.toAccountDtos((List<Account>) accountService.getAllAccount()));
   }*/

  /* @PostMapping
   Account addAccount(@RequestBody Account account) {
      try {
         return accountService.saveAccount(account);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }*/

   /*@PutMapping
   public ResponseEntity<Void> updateAccount(@RequestBody AccountRequestDto accountRequestDto) {
      Account account = accountMapper.toAccount(accountRequestDto);
      accountService.saveAccount(account);
      return ResponseEntity.ok().build();
   }
*/
   @PutMapping
   void updateAccount(@RequestBody Account account) {
      try {
         accountService.saveAccount(account);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
  @GetMapping("/{id}")
  public void findById(@PathVariable(name = "id") Long id) {
      try {
          accountService.findById(id);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

   @DeleteMapping("/{id}")
   void deleteAccount(@PathVariable Long id) {
      try {
         accountService.deleteById(id);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
