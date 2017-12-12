package example.addten

trait Enumerated[A] {
  def enumValue(a: A): Int
}

object Enumerated {

  def apply[A](implicit enumerated: Enumerated[A]): Enumerated[A] = enumerated

  trait EnumeratedInstances {
    implicit class EnumerateInst[A](a: A)(implicit E: Enumerated[A]){
      def enumValue: Int = E.enumValue(a)
    }

    implicit val intEnumerated : Enumerated[Int] = new Enumerated[Int] {
      def enumValue(a: Int): Int = a
    }

    implicit val stringEnumerated: Enumerated[String] = new Enumerated[String] {
      override def enumValue(a: String): Int = a.length
    }
  }
}
