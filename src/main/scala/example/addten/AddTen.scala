package example.addten

import implicits._

trait AddTen[A] {

  def addTen(a: A)(implicit E: Enumerated[A]): Option[Int] = {
    val intValue = a.enumValue
    if (intValue <= Int.MaxValue - 10) Some(intValue + 10)
    else None
  }

}

object AddTen {

  def apply[A]: AddTen[A] = new AddTen[A]{}

  trait AddTenInstances {
    implicit def addTenInst[A]: AddTen[A] = AddTen[A]
    implicit class AddTenInst[A](a: A)(implicit A: AddTen[A]){
      def addTen(implicit E: Enumerated[A]): Option[Int] = A.addTen(a)
    }
  }


}

// For All A -> Int if Int <= Int.MaxValue - 10 => Some(intValue + 10) else None
