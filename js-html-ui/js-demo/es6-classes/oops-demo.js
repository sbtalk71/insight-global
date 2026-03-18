class Person{
    constructor(id,name){
        this.id=id;
        this.name=name;
    }

    getDetails(){
        return this.id+" "+this.name;
    }
}

class Employee extends Person{
    constructor(id,name,salary){
        super(id,name);
        this.salary=salary;
    }

    getDetails(){
        return super.getDetails()+" "+this.salary;
    }
}


const person=new Person(100,"Shantanu");
console.log(person.getDetails());

const emp=new Employee(102,"Naveen",67000);
console.log(emp.getDetails());