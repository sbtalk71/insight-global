
counter=function(){
    let count=0;

    return function(){
        return count++;
    }
};

var increment=counter();

console.log(increment());
console.log(increment());
console.log(increment());
console.log(increment());

