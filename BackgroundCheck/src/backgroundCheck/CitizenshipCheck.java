package backgroundCheck;

public interface CitizenshipCheck {
  public static Response evaluate(String ssn) {
    if (Integer.parseInt(ssn) % 10 != 0)
      return new Response(true, "");

    return new Response(false, "Not a U.S. Citizen");
  }
}
