package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimButton);

    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dashboardPage.addEmployeeButton);

    }

    @When("user adds multiple employees from data table")
    public void user_adds_multiple_employees_from_data_table(io.cucumber.datatable.DataTable dataTable) {
// convert the data table as list of maps
        List<Map<String, String>> employeesNames = dataTable.asMaps();

        // iteration
        for (Map<String, String> map : employeesNames) {
            String firstname = map.get("firstName");
            String middlename = map.get("middleName");
            String lastname = map.get("lastName");

            // send the names to the Webelements
            sendText(addEmployeePage.firstNameLoc, firstname);
            sendText(addEmployeePage.middleNameLoc, middlename);
            sendText(addEmployeePage.lastNameLoc, lastname);

            // save the employee ID
            String empID = addEmployeePage.employeeIdLocator.getAttribute("value");
            click(addEmployeePage.saveBtn);
            // verify that the employee has actually been added
            click(dashboardPage.empListButton);

            sendText(employeeSearchPage.empSearchIdField, empID);
            click(employeeSearchPage.searchBtn);

            String addedEmpId = employeeSearchPage.addemployeeSearchResult.getText();

            Assert.assertEquals(empID, addedEmpId);

            click(dashboardPage.addEmployeeButton);
        }
    }

}