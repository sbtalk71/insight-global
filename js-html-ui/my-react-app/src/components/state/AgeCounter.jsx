import { Component } from "react";

export class AgeCounter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            age: 20
        };
        //this.handleAgeChange=this.handleAgeChange.bind(this);
    }


    handleAgeChange=()=>{
        console.log("Event triggered..")
       // this.state={age:this.state.age+1}
       this.setState(prevState=>({age: prevState.age + 1 }));
    }


    render() {
        return (
            <>
            <h1>Age Now is {this.state.age}</h1>
            <button onClick={this.handleAgeChange}>Increment Age</button>
            </>
        )
    }

}