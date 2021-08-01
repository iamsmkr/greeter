package com.shivamkapoor.sonatype

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class GreeterSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Greeter should be able to return expected greet message") {
    val results =
      Table(
        ("name", "result"),
        ("iamsmkr", "Hello iamsmkr!")
      )

    forAll(results) { (name, result) =>
      Greeter.greet(name) should equal(result)
    }
  }
}
