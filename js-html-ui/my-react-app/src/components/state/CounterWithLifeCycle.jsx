import { Component } from "react"

export class CounterWithLifeCycle extends Component {

    constructor(props) {
        super(props);
        this.state = { count: 0 };
        console.log("Construtor executed...")
    }

    increment = () => {
        this.setState({ count: this.state.count + 1 });
    }
    decrement = () => {
        this.setState({ count: this.state.count - 1 });
    }
    reset = () => {
        this.setState({ count: 0 });
    }

    componentDidMount() {
        console.log("Componenet mounted..")
    }

    componentDidUpdate() {
        console.log("Componenet updated..")
    }

    componentWillUnmount() {
        console.log("Componenet  will unmount..")
    }

    render() {
        console.log("render executed....");
        return (
            <>
                <h2>Counter:{this.state.count}</h2>
                <button onClick={this.increment}>Increment</button>
                <button onClick={this.decrement}>Decrement</button>
                <button onClick={this.reset}>Reset</button>
            </>
        );
    }
}