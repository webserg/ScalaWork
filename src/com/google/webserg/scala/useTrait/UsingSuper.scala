package com.google.webserg.scala.useTrait
/**
If
you write “super.toString” in a class, you know exactly which method
implementation will be invoked. When you write the same thing in a trait,
however, the method implementation to invoke for the super call is undefined
when you define the trait. Rather, the implementation to invoke will
be determined anew each time the trait is mixed into a concrete class. This
curious behavior of super is key to allowing traits to work as stackable modifications.
**/
trait Logged {
    def log(msg: String) { 
        println(msg)
    }
}
class Account

class SavingsAccount extends Account with Logged {
    def withdraw(amount: Double) = log("some importent log " + amount)
}

trait FirstLogger extends Logged {
    override def log(msg: String) {
     super.log("first  " + msg) // you will know which method exactly will be used only when trait will be mexed in concrete class.
    }
}
trait SecondLogger extends Logged {
    override def log(msg: String) {
     super.log( "second "  + msg)
    }
}
object UsingSuper extends App{
    val acct1 = new SavingsAccount with FirstLogger with SecondLogger
    val acct2 = new SavingsAccount with SecondLogger with FirstLogger 
    acct1.withdraw(1)  
    acct2.withdraw(2) 
}