package singh.laksh.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import singh.laksh.safetravels.models.expense;

public interface expenserepository extends CrudRepository<expense,Long> {
    
    List<expense>findAll();

}
