package me.wonwoo.web;

import me.wonwoo.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wonwoolee on 2017. 4. 16..
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {

  private final AccountRepository accountRepository;

  public AccountController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping
  public String accounts(Model model) {
    model.addAttribute("accounts", accountRepository.findAll());
    return "account";
  }

}
