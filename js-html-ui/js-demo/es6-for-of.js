var fruits=['apple','mango','guava','orange']

for(let fruit of fruits){
    console.log(fruit);
}


var car={
    make:"maruti Suzuki",
    year:2015,
    model: "Zen"
}

for(let attr in car){
    console.log(car[attr]);
}


var make1=car.make;
var model1=car.model;

const{make,model}=car;

var nums=[1,2,3,4,5,6,7];
 let [a,b]=nums;
 console.log(a,b)