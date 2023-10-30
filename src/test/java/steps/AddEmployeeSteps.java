package steps;

import io.cucumber.java.en.When;
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
        List<Map<String, String>> employeesNAmes = dataTable.asMaps();

        // iteration
        for (Map<String, String> map : employeesNAmes) {
            String firstname = map.get("firstName");
            String middlename = map.get("middleName");
            String lastname = map.get("lastName");

            // send the names to the Webelements
            sendText(addEmployeePage.firstNameLoc, firstname);
            sendText(addEmployeePage.middleNameLoc, middlename);
            sendText(addEmployeePage.lastNameLoc, lastname);
            click(addEmployeePage.saveBtn);
            click(dashboardPage.addEmployeeButton);
        }
    }

}