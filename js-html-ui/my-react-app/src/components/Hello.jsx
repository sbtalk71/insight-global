export function Hello(props){
    return(
        <>
        <h1>Hello to React</h1>
        <h2 style={{color:props.color}}> Welcome to react {props.name}</h2>
        </>
    );
}