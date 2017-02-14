package com.google.webserg.scala.oop
import scala.beans.BeanProperty
/*
In Scala, the getter and setter methods are called age and age_=.

val firstName:String means private field, public get set.

@BeanProperty val id:Long means private field, public Scala and JavaBeans getters/setters
*/
class Person(val firstName:String,val lastName:String,@BeanProperty val id:Long){
    println("Just constructed another person")
    override def toString = firstName + " " + lastName + " " + id + " " + sex

    def this(firstName:String,lastName:String,id:Long,sex:String){
    	this(firstName,lastName,id)
    	this.sex = sex
    }
    private var sex:String=""
    private var name:String=""
	
	private var privateAge: Int = 0; // Make private and rename
	//you must always init class fields
	//var age: Int = 0 default is always public 
	//scala generate getter method themself age() and age_=(int)

	//anytime you can redefine getters and setters yourself 

	def age = privateAge; // getter
	
	def age_=(newValue: Int) {
		if (newValue > privateAge) privateAge = newValue + 1; //Can't get younger
	}

	def comesBefore(otherPerson : Person) = name < otherPerson.name; //The access otherPerson.name is 
	//legal because otherPerson is also a Person object

	private[this] var secreteName:String=""; //access someObject.name is not allowed

	println("Just constructed another person" + name);
	 
}

//class Student extends Person{
//	override def toString = "Student" + super.toString
//}