import React, {useState} from "react";

export const CounterComponent = (props) => {

    let [count, setCount] = useState(props.countNum);

    const increment = () => {
        count += props.num
        setCount(count);
        props.callCallBack(count);
    }

    const decrement = () => {
        count -= props.num
        setCount(count);
        props.callCallBack(count);
    }

    return (
        <>
            <h3>{props.countNum}</h3>
            <button onClick={increment}>{+props.num}</button> &nbsp;
            <button onClick={decrement}>{-props.num}</button>
        </>

    );
}

export default CounterComponent;