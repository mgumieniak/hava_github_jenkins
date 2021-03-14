package acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarDefinitions {
    private final String GET_CAR_ID_URL = System.getProperty("car.url") + "/api/cars";


    private final RestTemplate restTemplate = new RestTemplate();

    private String carId;
    private String result;

    @Given("^I have one car with id: (.*)$")
    public void i_have_two_numbers(String carId) {
        this.carId = carId;
    }

    @When("^the controller should find it$")
    public void the_calculator_sums_them() {
        String url = String.format("%s/%s", GET_CAR_ID_URL, carId);
        result = restTemplate.getForObject(url, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}
