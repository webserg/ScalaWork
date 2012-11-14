package com.google.webserg.scala.actors.auction

import java.util.Date
import actors.Actor

/**
 * Created by sergiy.doroshenko
 * Date: 5/19/11 
 */

abstract class AuctionReply
case class Status(asked: Int, expire: Date) extends AuctionReply
case object BestOffer extends AuctionReply
case class BeatenOffer(maxBid: Int) extends AuctionReply
case class AuctionConcluded(seller: Actor, client: Actor) extends AuctionReply
case object AuctionFailed extends AuctionReply
case object AuctionOver extends AuctionReply