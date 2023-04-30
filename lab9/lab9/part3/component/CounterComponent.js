import React, {useState} from "react";

export const CounterComponent = ({num, countNum}) => {

    let [count, setCount] = useState(countNum);

    const increment = () => {
        count += num
        setCount(count);
    }

    const decrement = () => {
        count -= num;
        setCount(count);
    }

    return (
        <>
            <h3>{count}</h3>
            <button onClick={increment}>{+num}</button> &nbsp;
            <button onClick={decrement}>{-num}</button>
        </>

    );
}

export default CounterComponent;
