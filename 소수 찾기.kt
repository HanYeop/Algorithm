class Solution {
    val arr = arrayListOf<String>()
    val numberArr = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        var answer = 0
        
        // 전체 수 조합 구하기
        for(i in 0 until arr.size){
            val visit = Array<Int>(100){0}
            visit[i] = 1
            find(visit,numbers[i].toString(),numbers.length,1)
        }
        
        // 소수 판별
        for(i in numberArr){
            var count = 0
            for(j in 2 .. i){
                if(i%j == 0) count++
            }
            if(count==1){
                answer++
            }
        }
        
        return answer
    }
    
    fun find(visit: Array<Int>, str: String, size: Int, count: Int){
        // 탐색 할 때마다 결과값 add
        numberArr.add(str.toInt())
        
        // 최대 길이일 때 리턴
        if(count == size){
            return
        }
        
        // DFS
        for(j in 0 until size){
            if(visit[j] == 0){
                visit[j] = 1
                find(visit,str+arr[j],size,count+1)
                visit[j] = 0
            }
        }
    }
}
