
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GitLab extends Simulation {

	val httpProtocol = http
		.baseUrl("http://ocsp.digicert.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.userAgentHeader("Microsoft-CryptoAPI/10.0")





	val scn = scenario("GitLab")
		.exec(http("request_0")
			.get("/MFEwTzBNMEswSTAJBgUrDgMCGgUABBTfqhLjKLEJQZPin0KCzkdAQpVYowQUsT7DaQP4v0cB1JgmGggC72NkK8MCEAKXB1YM1Knrv%2BJy8eCW2II%3D"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}