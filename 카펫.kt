class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        
        answer = find(brown,yellow)
        return answer
    }
    
    fun find(brown: Int, yellow: Int) : IntArray{
        val sum = brown + yellow
        var y = 3 // 세로길이 (yellow 가 1 이상이려면 세로길이는 최소 3 이어야함.)
        var x = 100000 // 가로길이 임의값
        
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 김
        while(y<=x){
            // 소인수분해 되지 않으면 다음 값으로
            if(sum%y != 0){
                y++
                continue
            }
            x = sum/y
            
            val tmpBrown = x*2 + y*2 - 4  // 갈색 격자의 수
            val tmpYellow = sum - tmpBrown // 노란색 격자의 수
            
            // 찾는 값과 같다면 리턴
            if(tmpBrown == brown && tmpYellow == yellow){
                return intArrayOf(x,y)
            }
            y++
        }
        
        return intArrayOf(x,y)
    }
}
