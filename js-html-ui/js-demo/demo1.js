function add(a,b){

    console.log(`add int ${a} and ${b}`);
    return (a+b);
}

result=add(3,8);
console.log("Result is ",result);


result2=(function(a,b){

    console.log(`add int ${a} and ${b}`);
    return (a+b);
})(4,8);

console.log("IIFE Result ",result2);

var greet=function(name){
    console.log("Welcome to JavaScript ",name);
}

greet("Shantanu");

var adder2 =(a,b)=>{
    return a+b;
}

console.log(adder2(4,8));

function multiplier(x){

    return function(y){
        return x*y;
    }
}

var doubler=multiplier(2);

console.log( typeof doubler)
console.log(doubler(4));
console.log(doubler(8));

