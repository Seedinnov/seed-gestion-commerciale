/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.web.ctrl;

import com.seed.shopping.service.contract.BuyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Controller
public class CommandCtrl {
    
    @Autowired
    private BuyingService buyingService;
    
    @GetMapping("/commande")
    public String greeting(Model model) {
        model.addAttribute("buyings", buyingService.getAllBuyings());
        return "commande";
    }
    
}
