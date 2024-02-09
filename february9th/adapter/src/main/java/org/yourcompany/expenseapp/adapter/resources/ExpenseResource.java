package org.yourcompany.expenseapp.adapter.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.yourcompany.expenseapp.adapter.dto.ExpenseDTO;
import org.yourcompany.domain.models.Expense;
import org.yourcompany.domain.services.ExpenseService;
import org.yourcompany.infra.orm.repository.ExpenseEntityRepository;
import org.yourcompany.infra.orm.repository.impl.ExpenseRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Path("expense")
public class ExpenseResource {

    private final ExpenseService expenseService;

    public ExpenseResource() {
        expenseService = new ExpenseService(new ExpenseRepositoryImpl(new ExpenseEntityRepository()));
    }

    @GET
    @Path("{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExpenseDTO> get(@PathParam("search") String search) {
        List<Expense> list = expenseService.searchExpense(search);
        return list
                .stream()
                .map(expense -> ExpenseDTO.
                        builder()
                        .title(expense.getTitle())
                        .amount(expense.getAmount())
                        .establishment(expense.getEstablishment())
                        .id(expense.getId())
                        .build()).collect(Collectors.toList());
    }

    @POST
    public Response post(ExpenseDTO expenseDTO) {
        try {
            expenseService.createExpense(
                    expenseDTO.getTitle(),
                    expenseDTO.getAmount(),
                    expenseDTO.getEstablishment());
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            expenseService.deleteExpense(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}

