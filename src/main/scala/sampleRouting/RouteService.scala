package sampleRouting

import akka.actor.{ActorSystem, Props}
import akka.routing.RandomPool

object Main extends RouteService

class RouteService extends App with ServiceRoute {

  val system = ActorSystem("Router")
  val routeActor = system.actorOf(Props[RouteActor],"RouteActor")

}

