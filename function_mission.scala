object function_mission {
    def main(args: Array[String]): Unit = {
        val plus = (x: Int, y: Int) => x + y
        val plusCurried = (x: Int) => ((y: Int) => x + y)

        println(plus(100, 200))
        println(plusCurried(200)(300))
    }
}