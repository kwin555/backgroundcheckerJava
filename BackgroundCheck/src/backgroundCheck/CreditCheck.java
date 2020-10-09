package backgroundCheck;

public interface CreditCheck {
  public static Response evaluate(String ssn) {
    if (Integer.parseInt(ssn) % 2 != 0)
      return new Response(true, "");

    return new Response(false, "Poor Credit Score");
  }
}
