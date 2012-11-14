package com.google.webserg.scala.actors.auction

import java.util.Date
import actors.{Actor, TIMEOUT}

/**
 * Created by sergiy.doroshenko
 * Date: 5/19/11
 *
 * electronic auction service
 * For every traded item there is an auctioneer actor that publishes information about
   the traded item, that accepts offers from clients and that communicates with the
   seller and winning bidder to close the transaction.
 */

class Auction(seller: Actor, minBid: Int, closing: Date) extends Actor {
  val timeToShutdown = 36000000 //msec
  val bidIncrement = 10

  def act() {
    var maxBid = minBid - bidIncrement
    var maxBidder: Actor = null
    var running = true
    while (running) {
      /*
      * The receiveWithin method of class Actor takes as parameters a time span
      given in milliseconds and a function that processes messages in the mailbox.
      The function is given by a sequence of cases that each specify a pattern and
      an action to perform for messages matching the pattern. The receiveWithin
      method selects the first message in the mailbox which matches one of these
      patterns and applies the corresponding action to it.
      * */
      receiveWithin((closing.getTime() - new Date().getTime())) {
        case Offer(bid, client) =>
          if (bid >= maxBid + bidIncrement) {
            if (maxBid >= minBid) maxBidder ! BeatenOffer(bid)
            maxBid = bid;
            maxBidder = client;
            client ! BestOffer
          } else {
            client ! BeatenOffer(maxBid)
          }
        case Inquire(client) =>
          client ! Status(maxBid, closing)
        case TIMEOUT =>
          /*
          * If no other
          messages are received in the meantime, this pattern is triggered after the time
          span which is passed as argument to the enclosing receiveWithin method.
          TIMEOUT is a special message, which is triggered by the Actor implementation
           itself.
          * */
          if (maxBid >= minBid) {
            val reply = AuctionConcluded(seller, maxBidder)
            maxBidder ! reply;
            seller ! reply
          } else {
            seller ! AuctionFailed
          }
          receiveWithin(timeToShutdown) {
            case Offer(_, client) => client ! AuctionOver
            case TIMEOUT => running = false
          }
      }
    }
  }
}