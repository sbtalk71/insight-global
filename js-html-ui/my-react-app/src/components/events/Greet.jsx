export function Greet(){

function handleClickEvent(){
    console.log("Event handled...");
}

function handleClickEvent2(){
    console.log("Handle event 2 called...");
}

function clickEventHandlerWithEvent(evt){
console.log(evt.target.name);
}

let btnName="button 3";

return(
    <>
    <h2>Event Handler Sample</h2>
    <button onClick={handleClickEvent}>Click Me!</button>
    <button onClick={()=>handleClickEvent2()}>Click me More!</button>
    <button onClick={clickEventHandlerWithEvent} name={btnName}>Click me With Event!</button>
    </>
)
}