package backgroundCheck;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackgroundCheckTest {
  @Test
  void candidateIsEvaluatedAndPasses() {
    Response actual = BackgroundCheck.evaluateCriteria("3820173",
      CitizenshipCheck::evaluate, CreditCheck::evaluate,
      CriminalRecordCheck::evaluate, EmploymentVerification::evaluate);

    assertTrue(actual.status);
    assertEquals("", actual.reason);
  }

  @Test
  void candidateIsEvaluatedAndReturnsOneReasonForRejection() {
    Response actual = BackgroundCheck.evaluateCriteria("4255024",
      CitizenshipCheck::evaluate, CreditCheck::evaluate,
      CriminalRecordCheck::evaluate, EmploymentVerification::evaluate);

    assertFalse(actual.status);
    assertEquals("Poor Credit Score", actual.reason);
  }

  @Test
  void candidateIsEvaluatedAndReturnsTwoReasonsForRejection() {
    Response actual = BackgroundCheck.evaluateCriteria("8719465",
      CitizenshipCheck::evaluate, CreditCheck::evaluate,
      CriminalRecordCheck::evaluate, EmploymentVerification::evaluate);

    assertFalse(actual.status);
    assertEquals("Has Felony on File, " +
      "Failed to Provide Previous Employment Details", actual.reason);
  }

  @Test
  void candidateIsEvaluatedAndReturnsThreeReasonsForRejection() {
    Response actual = BackgroundCheck.evaluateCriteria("3255020",
      CitizenshipCheck::evaluate, CreditCheck::evaluate,
      CriminalRecordCheck::evaluate, EmploymentVerification::evaluate);

    assertFalse(actual.status);
    assertEquals("Not a U.S. Citizen, Poor Credit Score, " +
      "Failed to Provide Previous Employment Details", actual.reason);
  }

  @Test
  void candidateIsEvaluatedAndReturnsFourReasonsForRejection() {
    Response actual = BackgroundCheck.evaluateCriteria("9255020",
      CitizenshipCheck::evaluate, CreditCheck::evaluate,
      CriminalRecordCheck::evaluate, EmploymentVerification::evaluate);

    assertFalse(actual.status);
    assertEquals("Not a U.S. Citizen, Poor Credit Score, " +
      "Has Felony on File, Failed to Provide Previous Employment Details",
      actual.reason);
  }
}
