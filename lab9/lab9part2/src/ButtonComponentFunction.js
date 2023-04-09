import React from 'react';

export const ButtonComponentFunction = (props) => {
    const {name} = props;

    const sayHelloFromButton1 = () => {
        window.alert("Say Hello from Button 1")
        console.log(name);
    }

    const sayWelcomeFromButton2 = () => {
        window.alert("Say Welcome From Button 2");
    }

    const sayHiFromButton3 = () => {
        window.alert("Say Hi from Button 3");
    }

    const sayGoodByeFromButton4 = () => {
        window.alert("Say Good bye from Button 4")
    }

    return (
        <table>
            <tr>
                <td><button onClick={sayHelloFromButton1}>Say Hello from Button 1</button></td>
                <td><button onClick={sayWelcomeFromButton2}>Say Welcome from Button 2</button></td>
            </tr>
            <tr>
                <td><button onClick={sayHiFromButton3}>Say Hi from Button 3</button></td>
                <td><button onClick={sayGoodByeFromButton4}>Say Good bye from Button 4</button></td>
            </tr>
        </table>

    );

}


export default ButtonComponentFunction;