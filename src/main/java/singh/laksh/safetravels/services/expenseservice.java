package singh.laksh.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import singh.laksh.safetravels.models.expense;
import singh.laksh.safetravels.repositories.expenserepository;

@Service
public class expenseservice {
    @Autowired expenserepository expenserepository;

    public List<expense> getAllExpenses() {
        return expenserepository.findAll();
    }

    public expense getExpenseByID(Long id) {
        Optional <expense> expense = expenserepository.findById(id);
        return expense.orElse(null);
    }

    public void addExpense(expense expense) {
        expenserepository.save(expense);
    }

    public void editexpense(expense expense) {
        expenserepository.existsById(null);
    }

    public void deleteExpenseById(Long id) {
        expenserepository.deleteById(id);
    }
    
}
