import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import org.yourcompany.domain.models.Expense;
        import org.yourcompany.domain.repository.ExpenseRepository;
        import org.yourcompany.domain.services.ExpenseService;

@ExtendWith(MockitoExtension.class)
public class ExpenseStepDefinitions {

    private ExpenseService expenseService;
    private Expense expense;

    private List<Expense> resultSearch;

    //private AutoCloseable autoCloseable;

    /*@BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }*/

    /*@AfterEach
    void close() throws Exception {
        autoCloseable.close();
    }*/
    //@Mock
    private final ExpenseRepository expenseRepository;
    public ExpenseStepDefinitions() {

        expenseRepository = Mockito.mock(ExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);
        expense = new Expense.Builder().title("test").amount(199.99D).establishment("Hippopotamus").build();
    }
    @Given("there are some expenses in the list")
    public void there_are_some_expenses_in_the_list() {
        Mockito.doAnswer(invocationOnMock -> {
            Expense b = invocationOnMock.getArgument(0);
            b.setId(1);
            return null;
        }).when(expenseRepository).create(expense);

        expenseService.createExpense("resultat de ma tristesse", 12.99D,"KFC");
    }
    @When("I search for expenses with name started with {string}")
    public void i_ask_for_all_expenses(String search) {
        Mockito.when(expenseRepository.searchExpense(search)).thenReturn(List.of(expense));
        resultSearch = expenseService.searchExpense(search);
    }
    @Then("List with {int} expense should be returned")
    public void all_expenses_should_be_returned(int size) {

        Assertions.assertEquals(size, resultSearch.size());
    }
}
