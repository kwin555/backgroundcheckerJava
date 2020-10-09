package backgroundCheck;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.junit.jupiter.api.Assertions.*;

class EmploymentVerificationTest {
  @Test
  void candidateApprovedBasedOnEmploymentVerification() {
    Response response = EmploymentVerification.evaluate("7254952");
    assertTrue(response.status);
  }

  @Test
  void employmentVerificationReturnsCorrectReasonForRejection() {
    Response response = new Response(false,
      "Failed to Provide Previous Employment Details");
    assertTrue(new ReflectionEquals(response)
      .matches(EmploymentVerification.evaluate("9255025")));
  }
}
