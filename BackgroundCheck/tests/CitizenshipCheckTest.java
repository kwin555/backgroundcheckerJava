package backgroundCheck;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.junit.jupiter.api.Assertions.*;

class CitizenshipCheckTest {
  @Test
  void Canary() {
    assertTrue(true);
  }

  @Test
  void candidateApprovedBasedOnCitizenship() {
    Response response = CitizenshipCheck.evaluate("7254952");
    assertTrue(response.status);
  }

  @Test
  void citizenshipCheckReturnsCorrectReasonForRejection() {
    Response response = new Response(false, "Not a U.S. Citizen");
    assertTrue(new ReflectionEquals(response)
      .matches(CitizenshipCheck.evaluate("9255020")));
  }
}
