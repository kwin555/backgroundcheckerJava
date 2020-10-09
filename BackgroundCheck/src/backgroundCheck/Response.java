package backgroundCheck;

public class Response {                                        
  public final boolean status;
  public final String reason;

  public Response(boolean status, String reason) {
    this.reason = reason;
    this.status = status;
  }
}
