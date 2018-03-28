package sampleRouting

import akka.actor.{Actor, ActorLogging}

class RouteActor extends Actor with ActorLogging {

  def receive: Receive = {
    case message:String =>
      println(s"$message")
  }

}