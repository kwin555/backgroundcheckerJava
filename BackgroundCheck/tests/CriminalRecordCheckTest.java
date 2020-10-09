package backgroundCheck;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.junit.jupiter.api.Assertions.*;

class CriminalRecordCheckTest {
  @Test
  void candidateApprovedBasedOnCriminalRecord() {
    Response response = CriminalRecordCheck.evaluate("3254952");
    assertTrue(response.status);
  }

  @Test
  void criminalRecordCheckReturnsCorrectReasonForRejection() {
    Response response = new Response(false, "Has Felony on File");
    assertTrue(new ReflectionEquals(response)
      .matches(CriminalRecordCheck.evaluate("9255025")));
  }
}
