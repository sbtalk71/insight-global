
function add(...args){
    let sum=0;
    console.log(args);
    for(let num of args){
        sum=sum+num;
    }
    return sum;
}

console.log(add(1,2,3,4,5,6,7))

//spread operator
var org="insight Global";
console.log([...org]);

var fruits=["apple","Orange","mango"];

var newFruitsList=[...fruits,"guava","peach"];
console.log(newFruitsList);

var car={
    make:"maruti Suzuki",
    year:2015,
    model: "Zen"
}

var updatedCar={...car,model:"Zen+"}

console.log(updatedCar);