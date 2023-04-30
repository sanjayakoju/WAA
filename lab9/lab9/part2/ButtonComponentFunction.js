import React from 'react';

export const ButtonComponentFunction = (props) => {
    const {name} = props;

    const sayHelloFromButton1 = () => {
        alert(name)
        console.log(name);
    }

    return (
        <>
            <button onClick={sayHelloFromButton1}>{name}</button>
        </>
    );

}


export default ButtonComponentFunction;