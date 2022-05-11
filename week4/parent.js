function solution(sss) {
    let cont=0;
    let stack = [];
    console.log(sss.length);
    for(let i=0;i<sss.length;i++){

        if(sss[i] == ')' && stack.length!=0) {
            stack.pop();
            cont++;
            console.log("first");
        }
        else if(sss[i] =="("){
            stack.push("(");
            console.log("second");
        }

    }
    console.log(cont);
    console.log(stack);
    cont -= stack.length;
    return 2 * cont;
}

console.log(":hi");
console.log("answer: " + solution(")(())()(()"));
console.log("answer: " + solution("(()(()"));
console.log("answer: " + solution(")((()))()(()))") );




console.log("answer: " + solution(")(())()(()"));

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);            
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}