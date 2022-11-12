package com.springboot.controller;

import com.springboot.model.Account;
import com.springboot.model.Person;
import com.springboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {
@Autowired
   private AccountService accountService;
   @GetMapping
   public Iterable<Account> getAllAccount() {
      return accountService.getAllAccount();
   }

   @PostMapping
   Account addAccount(@RequestBody Account account) {
      try {
         return accountService.saveAccount(account);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @PutMapping
   void updateAccount(@RequestBody Account account) {
      try {
         accountService.saveAccount(account);
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
