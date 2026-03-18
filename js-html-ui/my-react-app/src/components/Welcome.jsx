import { Children } from "react";
import { Component } from "react";

export class Welcome extends Component{

    render(){
        return (
            <>
            <h2>This is from class Component</h2>
            <h2 style={{color:this.props.textColor}}>Welcome to React {this.props.name}</h2>
            {this.props.children}
            </>
        );
    }
}