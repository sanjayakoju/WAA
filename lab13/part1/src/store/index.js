import {createStore} from "redux";

const calculatorReducer = (state = {total: 0}, action) => {
    debugger
    let payload = action.payload;
    let total = state.total
    if(action.type === "+") {
        let add = parseFloat(payload.x) + parseFloat(payload.y)
        return {total: add};
    } else if(action.type === "-") {
        let sum = parseFloat(payload.x) - parseFloat(payload.y)
        return {total: sum};
    } else if(action.type === "*") {
        let mul = parseFloat(payload.x) * parseFloat(payload.y)
        return {total: mul}
    } else if(action.type === "/") {
        let div = parseFloat(payload.x) / parseFloat(payload.y)
        return {total: div}
    }
    return state
}

export const store = createStore(calculatorReducer)

export default store;

