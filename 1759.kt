import java.util.*

var l = 0
var c = 0
val array = arrayListOf<String>()
var arr = arrayListOf<String>()

fun main() = with(Scanner(System.`in`)){
    l = nextInt()
    c = nextInt()

    // 첫자리 체크 (두 수의 차보다 높은 자리수는 뒤에 알파벳이 모자라므로 안해도 됨)
    val sul = c-l

    for(i in 0 until c){
        array.add(next())
    }

    // 정렬
    array.sort()

    for(i in 0 .. sul){
        find(i,"",0,0)
    }

    arr.distinct().forEach { println(it) } // 결과물 출력
}

fun find(position: Int, sum: String, vowel: Int, consonant: Int){

    // 결과물이 조건이 맞지 않으면 넣지않음
    if(sum.length == l){
        if(vowel >=1 && consonant >= 2){
            arr.add(sum)
        }
        return
    }

    for(i in position until c){

        // 자음 모음 판별
        if(array[i] == "a" || array[i] == "e" ||
            array[i] == "i" || array[i] == "o" ||
            array[i] == "u"){
            find(i+1,sum+array[i],vowel+1,consonant)
        }
        else{
            find(i+1,sum+array[i],vowel,consonant+1)
        }
    }
}

