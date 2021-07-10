import com.bfyamada.monthlycontrol.core.domain.Expense;
import com.bfyamada.monthlycontrol.core.domain.Income;
import com.bfyamada.monthlycontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlycontrol.core.enums.Month;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SetpDefination {

    private SpreadSheet spreadSheet;
    private List<Income> incomeList = new ArrayList<>();
    private List<Expense> expenseList = new ArrayList<>();

    @Given("I want to generate a new feature")
    public void iWantToGenerateANewFeature() {
         spreadSheet = new SpreadSheet();
    }

    @When("I set the year {int} and month {int}")
    public void iSetTheYearAndMonth(int year, int month) {
        this.spreadSheet.setYear(year);
        this.spreadSheet.setMonth(month);
    }

    @Then("I validate the SpreadSheet with year {int} and month {string}")
    public void iValidateTheSpreadSheetWithYearAndMonth(int year, String month) {
        Assert.isTrue(this.spreadSheet.getYear().equals(year), "The yeat is correct: " + year);
        Assert.isTrue(Month.toEnum(this.spreadSheet.getMonth()).getName().equals(month), "The yeat is correct: " + month);
    }

    @And("I create a new Income with name {string} and {double} of value and payment {string}")
    public void iCreateANewIncomeWithNameIncomeNameAndIncomeValueOfValueAndPaymentIsPaid(String name, double value, String isReceived) {
        Income income = new Income();
        income.setName(name);
        income.setValue(new BigDecimal(value));
        income.setReceived(isReceived.equals("true")?true:false);

        this.incomeList.add(income);

    }

    @And("I add the income to the spreadsheet")
    public void iAddTheIncomeToTheSpreadsheet() {
        this.spreadSheet.setIncomes(incomeList);
    }

    @And("I create a new Expense with name {string} and value of {double} receipt {string}")
    public void iCreateANewExpenseWithNameExpenseNameAndValueOfExpenseValueReceiptIsReceived(String name, double value, String isPaid) {
        Expense expense = new Expense();
        expense.setName(name);
        expense.setValue(new BigDecimal(value));
        expense.setPaid(isPaid.equals("true")?true:false);

        this.expenseList.add(expense);
    }

    @And("I add the expense to the spreadsheet")
    public void iAddTheExpenseToTheSpreadsheet() {

        this.spreadSheet.setExpense(expenseList);
    }

    @And("I validate the Income")
    public void iValidateTheIncome() {
        Assert.notEmpty(this.spreadSheet.getIncomes(), "Income was created");
        Assert.isTrue(this.spreadSheet.getIncomes().size() == 1 , "There are only 1 Income");

    }

    @And("I Validatte The expense")
    public void iValidatteTheExpense() {
        Assert.notEmpty(this.spreadSheet.getExpense(), "Income was created");
        Assert.isTrue(this.spreadSheet.getExpense().size() == 1 , "There are only 1 Expense");
    }
}
