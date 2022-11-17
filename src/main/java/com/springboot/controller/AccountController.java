package com.springboot.controller;

import com.springboot.dto.AccountDto;
import com.springboot.dto.AccountRequestDto;
import com.springboot.mapper.AccountMapper;
import com.springboot.model.Account;
import com.springboot.model.Person;
import com.springboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
@Autowired
   private AccountService accountService;
    @GetMapping
    public Iterable<Account> getAllAccount() {
        return accountService.getAllAccount();
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

   @PostMapping
   Account addAccount(@RequestBody Account account) {
      try {
         return accountService.saveAccount(account);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

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
