
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Cubadebate extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.cubadebate.cu")
		.inferHtmlResources()
		.acceptHeader("image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")

    val uri1 = "http://media.cubadebate.cu/wp-content"
    val uri3 = "http://cartel.cubadebate.cu/cartel300.php"

	val scn = scenario("Cubadebate")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri3 + "?alb=12")
			.headers(headers_0),
            http("request_2")
			.get(uri1 + "/uploads/2021/01/podcast_cd.png")
			.headers(headers_2),
            http("request_3")
			.get(uri1 + "/uploads/2020/03/coronavirus-banner-300px.png")
			.headers(headers_2),
            http("request_4")
			.get(uri1 + "/themes/cd2.1/images/cubadebate-css-sprite.png?v=2.4")
			.headers(headers_2),
            http("request_5")
			.get(uri1 + "/uploads/2021/03/La-hija-del-rey-drag%C3%B3n-copia-150x125.png")
			.headers(headers_2)))
		.pause(1)
		.exec(http("request_6")
			.get("/favicon.ico")
			.headers(headers_2))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}