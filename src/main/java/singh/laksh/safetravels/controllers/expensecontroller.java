package singh.laksh.safetravels.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import singh.laksh.safetravels.models.expense;
import singh.laksh.safetravels.services.expenseservice;

@Controller
public class expensecontroller {

    @Autowired expenseservice expenseservice;

    @GetMapping("/expenses")
    public String expenses(@ModelAttribute expense expense, Model model){
        List<expense> expenses= expenseservice.getAllExpenses();
        System.out.println(expenses);
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    @PostMapping("/expenses")
    public String createExpense(@ModelAttribute expense expense){
        expenseservice.addExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/{id}")
    public String show(@PathVariable Long id, Model model){
        expense expense = expenseservice.getExpenseByID(id);
        System.out.println(expense);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }

    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        expense expense = expenseservice.getExpenseByID(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @GetMapping("/expneses/{id}")
    public String update(@ModelAttribute expense expense){
        expenseservice.editexpense(expense);
        return "redirect:/expenses";
    }

    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable Long id){
        expenseservice.deleteExpenseById(id);
        return"redirect:/expenses";
    }
}
