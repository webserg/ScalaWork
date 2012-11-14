package com.google.webserg.scala.actors.auction

import actors.Actor
import java.util.Date

/**
 * Created by sergiy.doroshenko
 * Date: 5/19/11 
 */

abstract class AuctionMessage
case class Offer(bid: Int, client: Actor) extends AuctionMessage
case class Inquire(client: Actor) extends AuctionMessage