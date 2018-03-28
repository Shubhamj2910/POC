package sampleRouting

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp


trait ServiceRoute extends App with SimpleRoutingApp {

  implicit val system1 = ActorSystem("my-system")

  startServer(interface = "localhost", port = 8050) {
    path("hello") {
      get {
        complete {
          <h1>Say hello to spray</h1>
        }
      }
    }
  }
}