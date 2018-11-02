import scala.collection.mutable.ArrayBuffer

object Factorization { 
    def main(args: Array[String]): Unit = {
        val random = scala.util.Random
        val numbers =
            if (args.isEmpty) {
                (1 to 10).map(i => random.nextInt(Int.MaxValue))
            } else {
                args.map(i => i.toInt).to[collection.immutable.Seq]
            }
        logProcessingTime("Serial ", numbers.map(i => factorize(i)))
        logProcessingTime("Parallel", numbers.par.map(i => factorize(i)))
    }

    private def factorize(number : Int) : List[Int] = {
        val list = new ArrayBuffer[Int]
        var n = number
        var f = 2

        while (n != 1) {
            if (n % f == 0) {
                list += f
                n /= f
            } else {
                f += 1
            }
        }
        println("Thread:%3d factorize %10d to %s".format(Thread.currentThread.getId, number, list.mkString(", ")))
        list.toList
    }

    private def logProcessingTime(label: String, process: => Unit) = {
        val start = System.currentTimeMillis
        process
        println(label + ": " + (System.currentTimeMillis - start) + "ms")
    }
}