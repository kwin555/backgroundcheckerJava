package backgroundCheck;

public interface EmploymentVerification {
  public static Response evaluate(String ssn) {
    if (Integer.parseInt(ssn) % 5 != 0)
      return new Response(true, "");

    return new Response(false,
      "Failed to Provide Previous Employment Details");
  }
}
