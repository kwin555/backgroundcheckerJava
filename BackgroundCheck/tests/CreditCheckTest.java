package backgroundCheck;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.junit.jupiter.api.Assertions.*;

class CreditCheckTest {
  @Test
  void candidateApprovedBasedOnCredit() {
    Response response = CreditCheck.evaluate("9255025");
    assertTrue(response.status);
  }

  @Test
  void creditCheckReturnsCorrectReasonForRejection() {
    Response response = new Response(false, "Poor Credit Score");
    assertTrue(new ReflectionEquals(response)
      .matches(CreditCheck.evaluate("7254952")));
  }
}
