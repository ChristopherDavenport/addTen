package example.addten

import org.specs2._
import implicits._
import org.scalacheck._

object MainSpec extends Spec with ScalaCheck {

  override def is =
    s2"""
  AddTen Int ${lawsForAddTen[Int]}
  AddTen String ${lawsForAddTen[String]}
      """



  def lawsForAddTen[A](implicit A: AddTen[A], E: Enumerated[A], Arb: Arbitrary[A]): Prop =
    Prop.forAll {a: A =>
     val result : Option[Int] =
       if ((a.enumValue.toLong + 10.toLong) > Int.MaxValue.toLong) None
       else Option(a.enumValue + 10)

      a.addTen must_=== result
    }



}