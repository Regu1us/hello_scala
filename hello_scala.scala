import scala.collection.mutable.ArrayBuffer

class APoint(val x: Int, val y:  Int) {
    def +(ap: APoint): APoint = {
        new APoint(x + ap.x, y + ap.y)
    }
    override def toString(): String = "(" + x + ", " + y + ")"
}

object hello_scala { 
    def main(args: Array[String]): Unit = {
        myPrint("Hello Scala!")
        args.foreach(whilePrint)       
        val lst = List("A", "BC", "C")
        matchList(lst)
        
        val ap1 = new APoint(1, 1)
        val ap2 = new APoint(2, 3)
        println(ap1 + ap2)
    }

    private def myPrint(str: String): Unit = {
        println(str)
    }

    private def whilePrint(number: String): Unit = {
        val max = number.toInt
        var i = 0
        while (i <= max) {
            if (i != 0)
                println(" ")
            println(i)
            i += 1
        }
    }

    private def matchList(lst: List[String]): Unit = {
        lst match { 
            case List("A", b, c) if b != "B" =>
                println("b = " + b)
                println("c = " + c)
            case _ =>
                println("nothing")
        }
    }
}