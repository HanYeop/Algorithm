// [프로그래머스] 신규 아이디 추천 (Java)

class Solution {
    
    static String id;
    public String solution(String new_id) {
        String answer = "";
        id = new_id;
        
        one();
        two();
        three();
        four();
        five();
        six();
        seven();
        
        answer = id;
        return answer;
    }
    
    static void one(){
        id = id.toLowerCase(); // 소문자 치환
    }
    
    static void two(){
        String tmp = "";
        for(int i = 0; i < id.length(); i++){
            
            // 소문자
            if((id.charAt(i) - 'a') >= 0 && (id.charAt(i) - 'a') <= 25){
                tmp += id.charAt(i);
            }
            
            // 숫자
            if((id.charAt(i) - '0') >= 0 && (id.charAt(i) - '0') <= 9){
                tmp += id.charAt(i);
            }
            
            // 허용하는 특수문자
            if(id.charAt(i) == '-' || id.charAt(i) == '_' || id.charAt(i) == '.'){
                tmp += id.charAt(i);
            }
        }
        
        id = tmp;
    }
    
    static void three(){
        String tmp = "";
        boolean check = false; // 마침표가 이어지는가?
        
        for(int i = 0; i < id.length(); i++){
            // 마침표 체크
            if(id.charAt(i) == '.'){
                // 처음 마침표
                if(!check){
                    tmp += id.charAt(i);
                    check = true;
                }
            } else{
                tmp += id.charAt(i);
                check = false;
            }
        }
        
        id = tmp;
    }
    
    static void four(){
        String tmp = "";
        
        for(int i = 0; i < id.length(); i++){
            // 처음, 마지막 마침표인가
            if(id.charAt(i) == '.' && (i == 0 || i == id.length() - 1)){
                continue;
            }
            else{
                tmp += id.charAt(i);
            }
        }
        
        id = tmp;
    }
    
    static void five(){
        if(id.length() == 0){
            id = "a";
        }
    }
    
    static void six(){
        String tmp = "";

        if(id.length() >= 16){
            for(int i = 0; i < 15; i++){
                if(i == 14 && id.charAt(i) == '.'){
                    continue;
                }
                tmp += id.charAt(i);
            }
            
            id = tmp;
        }
    }
    
    static void seven(){
        int len = 0;

        if(id.length() <= 2){
            len = id.length();
            
            while(id.length() <= 2){
                id += id.charAt(len - 1);
            }
        }
    }
}
