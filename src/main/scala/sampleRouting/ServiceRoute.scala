package sampleRouting

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._


trait ServiceRoute extends SprayJsonSupport with DefaultJsonProtocol  {

  implicit val system1 = ActorSystem("my-system")

  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system1.dispatcher

  final case class Person(name : String)

  implicit val personFormat = jsonFormat1(Person)

  val route =
    path("hello") {  // Basic Get Request
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    } ~ // Accepting Input as JSON Object
      post {
        path("addPerson") {
          entity(as[Person]) { person =>
            complete(s"Person Name is ${person.name}")
          }
        }
      } ~ // Accepting Input as Form Data
      post {
        path("asFormData") {
          entity(as[FormData]) { per =>
            formFields('name,'password){
              (name,password) =>
                complete(s"Person Name is $name, password is $password ")
            }
          }
        }
      }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")


}