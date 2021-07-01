import java.util.*
import kotlin.collections.HashSet


var n = 0
var k = 0
var count = 0
lateinit var queue : Queue<Int>
lateinit var visit : HashSet<Int>

fun main() = with(Scanner(System.`in`)){
    n = nextInt()
    k = nextInt()
    queue = LinkedList()
    visit = HashSet()

    if(n>=k){
        return println(n-k)
    }
    find(n)
}

fun find(n : Int){
    var tmp = n
    queue.add(tmp)

    while(queue.isNotEmpty()){
        for(i in 1..queue.size){
            tmp = queue.poll()

            if(tmp == k) return println(count)

            for(j in 0..2){
                when(j){
                    0 -> {
                        if(tmp*2 > 100000 || visit.contains(tmp*2)) continue
                        queue.add(tmp*2)
                        visit.add(tmp*2)
                    }
                    1 -> {
                        if(tmp+1 > 100000|| visit.contains(tmp+1)) continue
                        queue.add(tmp+1)
                        visit.add(tmp+1)
                    }
                    2 -> {
                        if(tmp-1 < 0|| visit.contains(tmp-1)) continue
                        queue.add(tmp-1)
                        visit.add(tmp-1)
                    }
                }
            }
        }
        count++
    }
}

