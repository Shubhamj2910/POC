package sampleRouting

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp


trait ServiceRoute extends App with SimpleRoutingApp {

  implicit val system1 = ActorSystem("my-system")

  // Sample Spray Route Hello

  startServer(interface = "0.0.0.0", port = 8080) {
    path("hello") {
      get {
        complete {
          <h1>This is Mumbai Server</h1>
        }
      }
    }
  }
}