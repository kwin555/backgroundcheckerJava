package backgroundCheck;

public interface CriminalRecordCheck {
  public static Response evaluate(String ssn) {
    if (Integer.parseInt(String.valueOf(ssn.charAt(0))) < 5)
      return new Response(true, "");

    return new Response(false, "Has Felony on File");
  }
}
