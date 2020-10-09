package backgroundCheck;

import java.util.function.*;
import java.util.stream.Stream;

public interface BackgroundCheck {
  @SafeVarargs
  public static Response evaluateCriteria(
    String ssn, Function<String, Response> ... criteria) {

    BiFunction<String, String, String> mergeReasons = (reason1, reason2) ->
      reason1.isEmpty() ? reason2 : reason1 + ", " + reason2;

    return Stream.of(criteria)
      .map(criterion -> criterion.apply(ssn))
      .reduce(new Response(true, ""), (evaluation, response) ->
        response.status ? evaluation :
          new Response(false,
            mergeReasons.apply(evaluation.reason, response.reason)));
  }
}
