
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class JuventudRebelde extends Simulation {

	val httpProtocol = http
		.baseUrl("http://www.juventudrebelde.cu")
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

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Cache-Control" -> "no-cache",
		"Origin" -> "http://www.juventudrebelde.cu",
		"Pragma" -> "no-cache")

	val headers_6 = Map(
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")



	val scn = scenario("JuventudRebelde")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/frontend/fonts/OpenSans-Regular-webfont.woff")
			.headers(headers_1),
            http("request_2")
			.get("/assets/frontend/fonts/OpenSans-Bold-webfont.woff")
			.headers(headers_1),
            http("request_3")
			.get("/assets/bootstrap/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_1),
            http("request_4")
			.get("/assets/font-awesome/fonts/fontawesome-webfont.woff2?v=4.7.0")
			.headers(headers_1),
            http("request_5")
			.get("/assets/frontend/fonts/OpenSans-Semibold-webfont.woff")
			.headers(headers_1),
            http("request_6")
			.get("/icons_new/frente%20al%20espejo.png")
			.headers(headers_6),
            http("request_7")
			.get("/icons_new/la%20tecla%20del%20duende.png")
			.headers(headers_6),
            http("request_8")
			.get("/icons_new/los%20que%20so%C3%B1amos%20por%20la%20oreja.png")
			.headers(headers_6),
            http("request_9")
			.get("/icons_new/l%C3%A1tigo%20y%20cascabel.png")
			.headers(headers_6),
            http("request_10")
			.get("/icons_new/tiempo%20extra.png")
			.headers(headers_6),
            http("request_11")
			.get("/icons_new/los%203%20del%20domingo.png")
			.headers(headers_6),
            http("request_12")
			.get("/icons_new/una%20foto%20una%20historia.png")
			.headers(headers_6),
            http("request_13")
			.get("/icons_new/sexo%20sentido.png")
			.headers(headers_6),
            http("request_14")
			.get("/icons_new/en%20red.png")
			.headers(headers_6),
            http("request_15")
			.get("/icons_new/c%C3%B3digo%20fuente.png")
			.headers(headers_6),
            http("request_16")
			.get("/icons_new/asi%20de%20facil.png")
			.headers(headers_6),
            http("request_17")
			.get("/icons_new/el%20tintero.png")
			.headers(headers_6),
            http("request_18")
			.get("/icons_new/de%20impacto.png")
			.headers(headers_6),
            http("request_19")
			.get("/icons_new/detr%C3%A1s%20de%20la%20ciencia.png")
			.headers(headers_6),
            http("request_20")
			.get("/icons_new/la%20tira%20del%20lente.png")
			.headers(headers_6),
            http("request_21")
			.get("/icons_new/en%20serio%20con%20la%20series.png")
			.headers(headers_6),
            http("request_22")
			.get("/icons_new/cocina%20con%20jr.png")
			.headers(headers_6),
            http("request_23")
			.get("/assets/frontend/img/plus.png")
			.headers(headers_6)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}