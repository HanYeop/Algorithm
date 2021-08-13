// 8911. 거북이

import java.util.*
import kotlin.math.*

fun main() = with(Scanner(System.`in`)){
    var t = nextInt()
    nextLine()

    for(i in 0 until t){
        println(move(nextLine()))
    }
}

fun move(str : String) : Int{
    var currentX = 0
    var currentY = 0
    var maxX = 0
    var maxY = 0
    var minX = 0
    var minY = 0

    var status = 0 // 0북 1동 2남 3서

    for(i in str){
        when(i){
            'F'->{
                when(status){
                    0-> {
                        currentY += 1
                    }
                    1 -> {
                        currentX += 1
                    }
                    2-> {
                        currentY -= 1
                    }
                    3 -> {
                        currentX -= 1
                    }
                }
            }
            'B'->{
                when(status){
                    0-> {
                        currentY -= 1
                    }
                    1 -> {
                        currentX -= 1
                    }
                    2-> {
                        currentY += 1
                    }
                    3 -> {
                        currentX += 1
                    }
                }
            }
            'L'->{
                // 왼쪽 90도 회전
                status--
                if(status==-1){
                    status = 3
                }
            }
            'R'->{
                // 오르쪽 90도 회전
                status++
                if(status==4){
                    status = 0
                }
            }
            else ->{
                return 0
            }
        }
        maxX = max(maxX,currentX)
        minX = min(minX,currentX)

        maxY = max(maxY,currentY)
        minY = min(minY,currentY)
    }

    currentX = abs(minX) + maxX
    currentY = abs(minY) + maxY

    return currentX * currentY
}



