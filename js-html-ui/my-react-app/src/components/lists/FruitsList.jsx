export function FruitsList({data}){

    const fruits=data;

    return(
        
        <>
        <ul>
        {
            fruits.map((fruit,index)=><li key={index}>{fruit}</li>)
        }
        </ul>
        </>
    );
} 