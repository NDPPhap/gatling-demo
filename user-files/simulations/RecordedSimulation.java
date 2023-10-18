
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://petstore.octoperf.com")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("If-Modified-Since", "Thu, 17 Feb 2022 15:44:48 GMT");
    headers_0.put("If-None-Match", "W/\"1155-1645112688000\"");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "none");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Sec-Fetch-Dest", "document");
    headers_1.put("Sec-Fetch-Mode", "navigate");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("Sec-Fetch-User", "?1");
    headers_1.put("Upgrade-Insecure-Requests", "1");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Accept", "*/*");
    headers_3.put("Accept-Encoding", "gzip, deflate");
    headers_3.put("Cache-Control", "no-cache");
    headers_3.put("Content-Type", "application/ocsp-request");
    headers_3.put("Pragma", "no-cache");
    
    String uri2 = "http://ocsp.digicert.com";

    ScenarioBuilder scn = scenario("RecordedSimulation")
      .// Open Pet Store Page
      exec(
        http("request_0")
          .get("/")
          .headers(headers_0)
      )
      .pause(11)
      // Enter the Store
      .exec(
        http("request_1")
          .get("/actions/Catalog.action")
          .headers(headers_1)
      )
      .pause(12)
      // Click on Fish
      .exec(
        http("request_2")
          .get("/actions/Catalog.action?viewCategory=&categoryId=FISH")
          .headers(headers_1)
      )
      .pause(3066)
      .exec(
        http("request_3")
          .post(uri2 + "/")
          .headers(headers_3)
          .body(RawFileBody("recordedsimulation/0003_request.dat"))
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
