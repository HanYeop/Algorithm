class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val arr = ArrayList<Pair<Int,Int>>()

        // 우선순위와 알파벳(0 == A, 1 == B..) 저장
        for(i in priorities.indices){
            arr.add(Pair(priorities[i],i))
        }

        // 큐가 다 빌때까지
        while(arr.isNotEmpty()){
            // arrayList 의 첫번째 원소를 사용함으로써 큐처럼 구현
            if(arr.any { arr[0].first < it.first }){
                // 우선순위가 아니라면 맨뒤로 뺌
                arr.add(arr[0])
            }
            else{
                // 우선순위라면 출력하고 (answer++)
                answer++
                // 그 값이 찾는 값이라면 break
                if(arr[0].second == location){
                    break
                }
            }
            // 맨 앞의 값 제거 (pop)
            arr.removeAt(0)
        }

        return answer
    }
}
