// [프로그래머스] 조이스틱 (Kotlin)

import kotlin.math.*

class Solution {
    var len = 0
    var min = Integer.MAX_VALUE
    lateinit var visit : Array<Boolean> // 변경된 값 => true
    var sum = 0 // 다 변경됐는지 체크

    fun main(){
        println(solution("JEROEN"))
    }

    fun solution(name: String): Int {
        var answer = 0 
        len = name.length
        visit = Array(len) { false }
        
        // 처음 자리는 좌우 이동 필요 X
        sum = len - 1
        visit[0] = true

        // 조이스틱 위아래 조작 합계
        for(i in 0 until len){
            var n = name[i] - 'A'

            // 14보다 큰 경우 아래로 조작
            if(n >= 14){
                n = 26 - n
            }
            answer += n

            // 조작 필요없는 곳 (A)
            if(n == 0){
                visit[i] = true
                if(i != 0) {
                    sum--
                }
            }
        }

        solve(0,0,0)
        answer += min
        return answer
    }

    fun solve(i: Int, res: Int, count: Int){

        // 다 변경 완료 시 좌우 이동 횟수 출력
        if(count == sum){
            min = min(min,res)
            return
        }
        var left = i
        var right = i
        var lCount = 0
        var rCount = 0

        while(lCount < len){
            left--
            lCount++

            // 첫 번째 위치에서 왼쪽으로 이동
            if(left < 0){
                left = len - 1
            }
            // 아직 변경되지 않은 자리 만나면 break
            if(!visit[left]){
                break
            }
        }

        while(rCount < len){
            right++
            rCount++

            // 마지막 위치에서 오른쪽으로 이동
            if(right >= len){
                right = 0
            }
            // 아직 변경되지 않은 자리 만나면 break
            if(!visit[right]){
                break
            }
        }

        visit[right] = true
        solve(right, res + rCount, count + 1)
        visit[right] = false
        visit[left] = true
        solve(left, res + lCount, count + 1)
        visit[left] = false
    }
}
