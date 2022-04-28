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
