
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Granma extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.granma.cu")
		.inferHtmlResources()
		.acceptHeader("image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_8 = Map(
		"Accept" -> "*/*",
		"Origin" -> "http://www.granma.cu")

    val uri2 = "http://granma.cu"

	val scn = scenario("Granma")
		.exec(http("request_0")
			.get(uri2 + "/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/static/img/list-ico.png"),
            http("request_2")
			.get("/static/img/globe-18X18.png"),
            http("request_3")
			.get("/static/img/comment-globe.png"),
            http("request_4")
			.get("/file/banner/banner%20ordenamiento"),
            http("request_5")
			.get("/file/banner/Titular%20en%20tu%20movil.jpg"),
            http("request_6")
			.get("/file/banner/Hilo%202.jpg"),
            http("request_7")
			.get("/file/banner/banner%20ciencias-01.jpg"),
            http("request_8")
			.get("/static/fonts/amplitudemedium-webfont.woff")
			.headers(headers_8),
            http("request_9")
			.get("/static/fonts/opensans-webfont.woff")
			.headers(headers_8)))
		.pause(35)
		.exec(http("request_10")
			.get("/static/ico/favicon.png"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}