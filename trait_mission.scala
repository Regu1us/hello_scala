trait TreeA { 
    def Tree(): Unit
}

trait TreeB extends TreeA {
    def Tree(): Unit = println("TreeB!")
}

trait TreeC extends TreeA {
    def Tree(): Unit = println("TreeC!")
} 

class ClassA extends TreeB with TreeC {
    override def Tree(): Unit = println("Over Tree!")
}

class ClassB extends TreeB with TreeC { 
    override def Tree(): Unit = super[TreeB].Tree()
}

object trait_mission {
    def main(args: Array[String]): Unit = {
        (new ClassA).Tree()
        (new ClassB).Tree()
    }
}


